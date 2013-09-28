package com.example.ratemydoctorregina.physiciansscreen;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.facilitiesscreen.FacilitiesAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class PhysicianActivity extends Activity implements OnClickListener 
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physicians);
		
		((ListView)findViewById(R.id.physicians_list)).setAdapter(new FacilitiesAdapter(this));
	}

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
		
	}
	
	private void handleBestSortPress()
	{
		
	}
	
	private void handleWorstSortPress()
	{
		
	}
	
	private void handleSpecialtySortPress()
	{
		
	}
}
