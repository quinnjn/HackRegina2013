package com.example.ratemydoctorregina.physiciansscreen;

import java.util.ArrayList;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.model.Doctor;
import com.example.ratemydoctorregina.physiciandetailsscreen.PhysicianDetailsActivity;
import com.example.ratemydoctorregina.physiciansscreen.PhysiciansAdapter.SortBy;
import com.example.ratemydoctorregina.server.AllDoctorsAsyncTask;
import com.example.ratemydoctorregina.server.AllDoctorsAsyncTaskDelegate;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PhysicianActivity extends Activity implements OnClickListener, AllDoctorsAsyncTaskDelegate
{
	ListView _physicians;
	ProgressDialog _progress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physicians);
		
		_physicians = ((ListView)findViewById(R.id.physicians_list));
		_physicians.setOnItemClickListener(physician_listener);
		_physicians.setAdapter(new PhysiciansAdapter(this));
		
		AllDoctorsAsyncTask task = new AllDoctorsAsyncTask(this);
		task.execute();
	}
	
	OnItemClickListener physician_listener = new OnItemClickListener() 
	{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) 
		{
			Intent intent = new Intent(PhysicianActivity.this, PhysicianDetailsActivity.class);
			intent.putExtra("doctor", (Doctor)_physicians.getAdapter().getItem(position));
			startActivity(intent);
		}
	};

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.default_sort_btn:
				handleNoneSortPress();
				break;
			case R.id.best_sort_btn:
				handleBestSortPress();
				break;
			case R.id.worst_sort_btn:
				handleWorstSortPress();
				break;
			case R.id.specialty_sort_btn:
				handleSpecialtySortPress();
				break;
		}
	}
	
	/* Sort Press Handlers */
	private void handleNoneSortPress()
	{
		((PhysiciansAdapter)_physicians.getAdapter()).sortBy(SortBy.NAME);
	}
	
	private void handleBestSortPress()
	{
		((PhysiciansAdapter)_physicians.getAdapter()).sortBy(SortBy.BEST);
	}
	
	private void handleWorstSortPress()
	{
		((PhysiciansAdapter)_physicians.getAdapter()).sortBy(SortBy.WORST);
	}
	
	private void handleSpecialtySortPress()
	{
		((PhysiciansAdapter)_physicians.getAdapter()).sortBy(SortBy.SPECIALTY);
	}

	@Override
	public void AllDoctorsFetcherWillStartToFetchUpdate() 
	{
		_progress = new ProgressDialog(this);
		_progress.setTitle("Loading Doctors");
		_progress.setCanceledOnTouchOutside(false);
		_progress.show();
	}

	@Override
	public void AllDoctorsFetcherDidFinishFetchingUpdate(ArrayList<Doctor> doctors) 
	{
		((PhysiciansAdapter)_physicians.getAdapter()).setData(doctors);
		_progress.dismiss();
	}

	@Override
	public void AllDoctorsFetcherDidFailToFetchUpdate() 
	{
		Log.d("RateMyDoctor", "Failed to fetch doctors");
	}
}
