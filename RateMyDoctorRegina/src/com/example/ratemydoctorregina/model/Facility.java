package com.example.ratemydoctorregina.model;

import java.util.ArrayList;

import org.json.JSONObject;

import android.location.Location;

public class Facility 
{
	private String _name;
	
	private Location _location;
	
	private float _rating;
	
	private ArrayList<Doctor> _doctors;
	
	public Facility()
	{
		
	}

	public void init(JSONObject json)
	{
		// TODO:  Implement this method
	}
	
	public String get_name() 
	{
		return _name;
	}

	public void set_name(String _name) 
	{
		this._name = _name;
	}

	public Location get_location() 
	{
		return _location;
	}

	public void set_location(Location _location) 
	{
		this._location = _location;
	}

	public float get_rating() {
		return _rating;
	}

	public void set_rating(float _rating) 
	{
		this._rating = _rating;
	}

	public ArrayList<Doctor> get_doctors() 
	{
		return _doctors;
	}

	public void set_doctors(ArrayList<Doctor> _doctors) 
	{
		this._doctors = _doctors;
	}
	
	
}
