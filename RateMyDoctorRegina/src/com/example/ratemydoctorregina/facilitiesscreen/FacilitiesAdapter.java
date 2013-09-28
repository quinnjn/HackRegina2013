package com.example.ratemydoctorregina.facilitiesscreen;

import java.util.ArrayList;

import com.example.ratemydoctorregina.R;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FacilitiesAdapter extends BaseAdapter 
{

	ArrayList<Object> _facilities;
	Activity _context;
	
	public FacilitiesAdapter(Activity context)
	{
		_context = context;
		_facilities = new ArrayList<Object>();
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
