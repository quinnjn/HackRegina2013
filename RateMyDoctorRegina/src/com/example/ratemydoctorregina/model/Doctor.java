package com.example.ratemydoctorregina.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Doctor implements Serializable
{
	private int _provider_id;
	
	private String _name;
	
	private String _specialty;
	
	private float _rating;
	
	private ArrayList<Facility> _facilities;
	
	public Doctor()
	{
		
	}

	public void init(JSONObject json) throws JSONException
	{
		if (json.has("doctor_name"))
		{
			_name = json.getString("doctor_name");
		}
		
		if (json.has("specialty"))
		{
			_specialty = json.getString("specialty");
		}
		
		if (json.has("provider_id"))
		{
			_provider_id = json.getInt("provider_id");
		}
	}
	
	public int get_id()
	{
		return _provider_id;
	}
	
	public String get_name() 
	{
		return _name;
	}

	public void set_name(String _name) 
	{
		this._name = _name;
	}

	public String get_specialties() 
	{
		return _specialty;
	}

	public void set_specialties(String specialty) 
	{
		this._specialty = specialty;
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
