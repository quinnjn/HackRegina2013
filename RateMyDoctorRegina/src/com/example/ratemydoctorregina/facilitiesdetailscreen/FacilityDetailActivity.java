package com.example.ratemydoctorregina.facilitiesdetailscreen;

import com.example.ratemydoctorregina.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FacilityDetailActivity extends Activity
{
	public final static String HEALTH_REGION_NAME = "HEALTH_REGION_NAME";
	
	public final static String ADDRESS_INFO = "ADDRESS_INFO";
	
	public final static String RATING_INFO = "RATING_INFO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facility_details);
		
		Intent intent = getIntent();
		
		TextView healthRegionName = (TextView)findViewById(R.id.facility_detail_region_name);
		healthRegionName.setText(intent.getStringExtra(FacilityDetailActivity.HEALTH_REGION_NAME));
		
		TextView addressInfo = (TextView)findViewById(R.id.facility_detail_address_info);
		addressInfo.setText(intent.getStringExtra(FacilityDetailActivity.ADDRESS_INFO));
		
		TextView ratingInfo = (TextView)findViewById(R.id.facility_detail_rating_info);
		ratingInfo.setText(intent.getStringExtra(FacilityDetailActivity.RATING_INFO));
	}
}
