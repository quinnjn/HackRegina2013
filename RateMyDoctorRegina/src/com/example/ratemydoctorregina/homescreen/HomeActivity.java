package com.example.ratemydoctorregina.homescreen;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.R.id;
import com.example.ratemydoctorregina.R.layout;
import com.example.ratemydoctorregina.R.menu;
import com.example.ratemydoctorregina.facilitiesscreen.FacilitiesActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        
        initListeners();
    }
    
    private void initListeners()
    {
    	((Button)findViewById(R.id.facilities_btn)).setOnClickListener(this);
    	((Button)findViewById(R.id.physician_btn)).setOnClickListener(this);
    	((Button)findViewById(R.id.map_btn)).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.facilities_btn:
				startActivity(new Intent(this, FacilitiesActivity.class));
				break;
			case R.id.physician_btn:
				
				break;
			case R.id.map_btn:
				
				break;
		}
		
	}
    
    
}
