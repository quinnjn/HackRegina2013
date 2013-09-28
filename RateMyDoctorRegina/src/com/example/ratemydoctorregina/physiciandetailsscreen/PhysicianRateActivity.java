package com.example.ratemydoctorregina.physiciandetailsscreen;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.model.Doctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class PhysicianRateActivity extends Activity 
{
	private Doctor _doctor;
	private TextView _rating_text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate_physician);
		
		Intent intent = getIntent();
		_doctor = (Doctor)intent.getSerializableExtra("doctor");
		setTitle("Rating " + _doctor.get_name());
		
		
		_rating_text = (TextView)findViewById(R.id.rating_txt);
		_rating_text.setText("My Rating: " + 0);
		
		SeekBar ratingBar = (SeekBar)findViewById(R.id.rating_bar);
		ratingBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) { }
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) { }
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			{
				
				Log.d("Rating Scale", "Progress: " + progress);
				_rating_text.setText("My Rating: " + progress/20);
			}
		});
		
		((Button)findViewById(R.id.submit_btn)).setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				
			}
		});
	}
}
