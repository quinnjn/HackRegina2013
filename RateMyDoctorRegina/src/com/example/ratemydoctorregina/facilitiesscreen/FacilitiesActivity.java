package com.example.ratemydoctorregina.facilitiesscreen;


import java.util.ArrayList;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.facilitiesdetailscreen.FacilityDetailActivity;
import com.example.ratemydoctorregina.model.Doctor;
import com.example.ratemydoctorregina.model.Facility;
import com.example.ratemydoctorregina.physiciandetailsscreen.PhysicianDetailsActivity;
import com.example.ratemydoctorregina.physiciansscreen.PhysicianActivity;
import com.example.ratemydoctorregina.physiciansscreen.PhysiciansAdapter;
import com.example.ratemydoctorregina.server.AllDoctorsAsyncTask;
import com.example.ratemydoctorregina.server.AllFacilitiesAsyncTask;
import com.example.ratemydoctorregina.server.AllFacilitiesAsyncTaskDelegate;

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

public class FacilitiesActivity extends Activity implements OnClickListener, AllFacilitiesAsyncTaskDelegate
{
	ListView _facilities;
	ProgressDialog _progress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facilities);
		
		((ListView)findViewById(R.id.facilities_list)).setAdapter(new FacilitiesAdapter(this));
		
		_facilities = ((ListView)findViewById(R.id.facilities_list));
		_facilities.setOnItemClickListener(facilities_listener);
		_facilities.setAdapter(new FacilitiesAdapter(this));
		
		AllFacilitiesAsyncTask task = new AllFacilitiesAsyncTask(this);
		task.execute();
	}
	
	OnItemClickListener facilities_listener = new OnItemClickListener() 
	{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) 
		{
			Intent intent = new Intent(FacilitiesActivity.this, FacilityDetailActivity.class);
			
			Facility facility = (Facility)_facilities.getAdapter().getItem(position);
			
			String health_region_name = facility.get_name();
			String address_info = facility.get_addressInfo();
			String rating_info = String.valueOf(facility.get_rating());
			
			intent.putExtra(FacilityDetailActivity.HEALTH_REGION_NAME, health_region_name);
			intent.putExtra(FacilityDetailActivity.ADDRESS_INFO, address_info);
			intent.putExtra(FacilityDetailActivity.RATING_INFO, rating_info);
						
			startActivity(intent);
		}
	};
	
	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.all_filter_btn:
				handleAllFilterPress();
				break;
			case R.id.clinic_filter_btn:
				handleClinicFilterPress();
				break;
			case R.id.hospital_filter_btn:
				handleHospitalFilterPress();
				break;
			case R.id.default_sort_btn:
				handleNoneSortPress();
				break;
			case R.id.best_sort_btn:
				handleBestSortPress();
				break;
			case R.id.worst_sort_btn:
				handleWorstSortPress();
				break;
			case R.id.nearby_sort_btn:
				handleNearbySortPress();
				break;
		}
	}
	
	/* Filter Press Handlers */
	private void handleAllFilterPress()
	{
		
	}
	
	private void handleClinicFilterPress()
	{
		
	}
	
	private void handleHospitalFilterPress()
	{
		
	}
	
	/* Sort Press Handlers */
	private void handleNoneSortPress()
	{
		
	}
	
	private void handleBestSortPress()
	{
		
	}
	
	private void handleWorstSortPress()
	{
		
	}
	
	private void handleNearbySortPress()
	{
		
	}

	@Override
	public void AllFacilitiesFetcherWillStartToFetchUpdate() 
	{
		_progress = new ProgressDialog(this);
		_progress.setTitle("Loading Facilities");
		_progress.setCanceledOnTouchOutside(false);
		_progress.show();
	}

	@Override
	public void AllFacilitiesFetcherDidFinishFetchingUpdate(ArrayList<Facility> facilities) 
	{
		((FacilitiesAdapter)_facilities.getAdapter()).setData(facilities);
		_facilities.postInvalidate();
		_progress.dismiss();
		
	}

	@Override
	public void AllFacilitiesFetcherDidFailToFetchUpdate() 
	{
		Log.d("RateMyDoctor", "Failed to fetch facilities");
	}
	
}
