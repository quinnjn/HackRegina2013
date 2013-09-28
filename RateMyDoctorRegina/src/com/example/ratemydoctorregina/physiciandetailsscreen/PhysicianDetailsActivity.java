package com.example.ratemydoctorregina.physiciandetailsscreen;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.model.Doctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PhysicianDetailsActivity extends Activity implements OnClickListener
{

	Doctor _doctor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physician_details);
		
		Intent intent = getIntent();
		_doctor = (Doctor)intent.getSerializableExtra("doctor");
		setTitle(_doctor.get_name());
		
		initTextFields();
	}
	
	private void initTextFields()
	{
		((TextView)findViewById(R.id.specialty_txt)).setText(_doctor.get_specialties());
		((TextView)findViewById(R.id.rating_txt)).setText("Rating: " + _doctor.get_rating());
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.rate_btn:
				Intent intent = new Intent(this, PhysicianRateActivity.class);
				intent.putExtra("doctor", _doctor);
				startActivity(intent);
				
				break;
		}
	}
}
