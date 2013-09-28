package com.example.ratemydoctorregina.facilitiesscreen;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FacilitiesAdapter extends BaseAdapter 
{

	ArrayList<Object> _facilities;
	Context _context;
	
	public FacilitiesAdapter(Context _context)
	{
		
	}
	
	@Override
	public int getCount() 
	{
		return _facilities.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return _facilities.get(position);
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
		//	view = _context.LayoutInflater.Inflate(Android.Resource.Layout.SimpleListItem1, null);
		}
		
		return view;
	}

}
