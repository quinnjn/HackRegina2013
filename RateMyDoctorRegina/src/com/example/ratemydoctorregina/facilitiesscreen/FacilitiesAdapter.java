package com.example.ratemydoctorregina.facilitiesscreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.model.Doctor;
import com.example.ratemydoctorregina.model.Facility;
import com.example.ratemydoctorregina.physiciansscreen.PhysiciansAdapter.SortBy;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FacilitiesAdapter extends BaseAdapter 
{
	public enum SortBy { NAME, BEST, WORST }
	
	ArrayList<Facility> _master;
	ArrayList<Facility> _facilities;
	
	Activity _context;
	
	ArrayList<Facility> _specialty_sorted;
	ArrayList<Facility> _best_sorted;
	ArrayList<Facility> _worst_sorted;
		
	public FacilitiesAdapter(Activity context)
	{
		_context = context;
		_facilities = new ArrayList<Facility>();
	}
	
	public void setData(ArrayList<Facility> facilities)
	{
		_facilities = facilities;
		
		_master = new ArrayList<Facility>();
		_master.addAll(_facilities);
		
		_specialty_sorted = null;
		_best_sorted = null;
		_worst_sorted = null;
		
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() 
	{
		return _facilities.size();//_facilities.size();
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
			view = _context.getLayoutInflater().inflate(R.layout.cell_facility, null);
		}
		
		Facility facility = _facilities.get(position);
		
		((TextView)view.findViewById(R.id.facility_name_txt)).setText(facility.get_name());
		((TextView)view.findViewById(R.id.location_txt)).setText(facility.get_addressInfo());
		
		float value = facility.get_rating();
		
		((TextView)view.findViewById(R.id.rating_txt)).setText(String.valueOf(value));
		
		return view;
	}
	
	public void sortBy(SortBy type)
	{
		if(type == SortBy.BEST)
		{
			if(_best_sorted == null)
			{
				Collections.sort(_facilities, new Comparator<Facility>() 
						{
							@Override
							public int compare(Facility lhs, Facility rhs) 
							{
								return (int)((lhs.get_rating() - rhs.get_rating()) * 100);
							}
						});
				_best_sorted = new ArrayList<Facility>();
				_best_sorted.addAll(_facilities);
			}
			
			_facilities = _best_sorted;			
		}
		else if(type == SortBy.WORST)
		{
			if(_worst_sorted == null)
			{
				Collections.sort(_facilities, new Comparator<Facility>() 
						{
							@Override
							public int compare(Facility lhs, Facility rhs) 
							{
								return (int)((rhs.get_rating() - lhs.get_rating()) * 100);
							}
						});
				_worst_sorted = new ArrayList<Facility>();
				_worst_sorted.addAll(_facilities);
			}
			
			_facilities = _worst_sorted;
		}
		else
		{
			_facilities = _master;
		}
		
		notifyDataSetChanged();
	}

}
