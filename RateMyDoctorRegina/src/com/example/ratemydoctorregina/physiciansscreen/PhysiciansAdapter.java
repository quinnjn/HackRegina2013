package com.example.ratemydoctorregina.physiciansscreen;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.model.Doctor;

public class PhysiciansAdapter extends BaseAdapter 
{
	ArrayList<Doctor> _physicians;
	Activity _context;
	
	public PhysiciansAdapter(Activity context)
	{
		_context = context;
		_physicians = new ArrayList<Doctor>();
	}
	
	public void setData(ArrayList<Doctor> physicians)
	{
		_physicians = physicians;
	}
	
	@Override
	public int getCount() 
	{
		return 2;//_facilities.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return null; //_facilities.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		
		View view = convertView;
		
		if (view == null)
		{
			view = _context.getLayoutInflater().inflate(R.layout.cell_facility, null);
		}
		
		((TextView)view.findViewById(R.id.facility_name_txt)).setText("Name");
		((TextView)view.findViewById(R.id.location_txt)).setText("Location");
		((TextView)view.findViewById(R.id.rating_txt)).setText("Rating: .5");
		
		return view;
	}

	
}
