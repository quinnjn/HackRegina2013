package com.example.ratemydoctorregina.model;

import java.util.ArrayList;

public class Doctor 
{
	private String _name;
	
	private ArrayList<String> _specialties;
	
	private float _rating;
	
	private ArrayList<Facility> _facilities;
	
	public Doctor()
	{
		
	}

	public String get_name() 
	{
		return _name;
	}

	public void set_name(String _name) 
	{
		this._name = _name;
	}

	public ArrayList<String> get_specialties() 
	{
		return _specialties;
	}

	public void set_specialties(ArrayList<String> _specialties) 
	{
		this._specialties = _specialties;
	}

	public float get_rating() 
	{
		return _rating;
	}

	public void set_rating(float _rating) 
	{
		this._rating = _rating;
	}

	public ArrayList<Facility> get_facilities() 
	{
		return _facilities;
	}

	public void set_facilities(ArrayList<Facility> _facilities)
	{
		this._facilities = _facilities;
	}
	
	
}
