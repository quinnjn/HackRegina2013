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
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() 
	{
		return _physicians.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return _physicians.get(position);
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
		
		Doctor doctor = _physicians.get(position);
		
		((TextView)view.findViewById(R.id.facility_name_txt)).setText(doctor.get_name());
		((TextView)view.findViewById(R.id.location_txt)).setText(doctor.get_specialties());
		((TextView)view.findViewById(R.id.rating_txt)).setText("Rating: " + doctor.get_rating());
		
		return view;
	}

	
}
