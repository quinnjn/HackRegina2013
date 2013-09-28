package com.example.ratemydoctorregina.homescreen;

import java.util.HashMap;
import java.util.Map;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.R.id;
import com.example.ratemydoctorregina.R.layout;
import com.example.ratemydoctorregina.R.menu;
import com.example.ratemydoctorregina.facilitiesscreen.FacilitiesActivity;
import com.example.ratemydoctorregina.physiciansscreen.PhysicianActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends Activity implements OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("logo", R.drawable.medical);
        
        ImageView imageView = (ImageView)findViewById(R.id.home_screen_logo);
        imageView.setImageResource(map.get("logo"));
        
        
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
				startActivity(new Intent(this, PhysicianActivity.class));
				break;
			case R.id.map_btn:
				
				break;
		}
		
	}
    
    
}
