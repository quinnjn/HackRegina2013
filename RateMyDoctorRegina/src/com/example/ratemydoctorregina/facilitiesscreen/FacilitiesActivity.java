package com.example.ratemydoctorregina.facilitiesscreen;


import com.example.ratemydoctorregina.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class FacilitiesActivity extends Activity implements OnClickListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facilities);
		
		
	}

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
	
}
