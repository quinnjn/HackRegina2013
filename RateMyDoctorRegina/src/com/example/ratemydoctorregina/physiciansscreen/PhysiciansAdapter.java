package com.example.ratemydoctorregina.physiciansscreen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ratemydoctorregina.R;
import com.example.ratemydoctorregina.model.Doctor;

public class PhysiciansAdapter extends BaseAdapter 
{
	
	public enum SortBy { NAME, SPECIALTY, BEST, WORST }
	
	ArrayList<Doctor> _master;
	ArrayList<Doctor> _physicians;
	
	ArrayList<Doctor> _specialty_sorted;
	ArrayList<Doctor> _best_sorted;
	ArrayList<Doctor> _worst_sorted;
	
	Activity _context;
	
	public PhysiciansAdapter(Activity context)
	{
		_context = context;
		_physicians = new ArrayList<Doctor>();
	}
	
	public void setData(ArrayList<Doctor> physicians)
	{
		_physicians = physicians;
		
		_master = new ArrayList<Doctor>();
		_master.addAll(_physicians);
		
		_specialty_sorted = null;
		_best_sorted = null;
		_worst_sorted = null;
		
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

	public void sortBy(SortBy type)
	{
		if(type == SortBy.BEST)
		{
//			if(_best_sorted == null)
//			{
				Collections.sort(_physicians, new Comparator<Doctor>() 
						{
							@Override
							public int compare(Doctor lhs, Doctor rhs) 
							{
								return (int)((rhs.get_rating() - lhs.get_rating()) * 100);
							}
						});
				_best_sorted = new ArrayList<Doctor>();
				_best_sorted.addAll(_physicians);
//			}
			
			_physicians = _best_sorted;			
		}
		else if(type == SortBy.WORST)
		{
//			if(_worst_sorted == null)
//			{
				Collections.sort(_physicians, new Comparator<Doctor>() 
						{
							@Override
							public int compare(Doctor lhs, Doctor rhs) 
							{
								return (int)((lhs.get_rating() - rhs.get_rating()) * 100);
							}
						});
				_worst_sorted = new ArrayList<Doctor>();
				_worst_sorted.addAll(_physicians);
//			}
			
			_physicians = _worst_sorted;
		}
		else if(type == SortBy.SPECIALTY)
		{
//			if(_specialty_sorted == null)
//			{
				Collections.sort(_physicians, new Comparator<Doctor>() 
						{
							@Override
							public int compare(Doctor lhs, Doctor rhs) 
							{
								return lhs.get_specialties().compareTo(rhs.get_specialties());
							}
						});
				_specialty_sorted = new ArrayList<Doctor>();
				_specialty_sorted.addAll(_physicians);
//			}
			
			_physicians = _specialty_sorted;
		}
		else
		{
			_physicians = _master;
		}
		
		notifyDataSetChanged();
	}
	
}
