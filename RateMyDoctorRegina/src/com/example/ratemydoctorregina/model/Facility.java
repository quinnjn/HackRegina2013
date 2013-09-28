package com.example.ratemydoctorregina.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;

public class Facility implements Serializable
{
	private String _name;
		
	private float _rating;
		
	private String _addressInfo;
	
	private String _healthRegionName;
	
	private String _facilityType;
	
	private ArrayList<Doctor> _doctors;
	
	public Facility()
	{
		
	}

	public void init(JSONObject json) throws JSONException
	{
		if (json.has("facility_name"))
		{
			_name = json.getString("facility_name");
		}
		
		if (json.has("facility_type"))
		{
			_facilityType = json.getString("facility_type");
		}
		
		if (json.has("location"))
		{
			_addressInfo = json.getString("location");
		}
		
		if (json.has("street_address"))
		{
			_addressInfo += json.getString("street_address");
		}
		
		if (json.has("rha_name"))
		{
			_healthRegionName = json.getString("rha_name");
		}
	}
	
	public String get_addressInfo() {
		return _addressInfo;
	}

	public void set_addressInfo(String _addressInfo) {
		this._addressInfo = _addressInfo;
	}

	public String get_healthRegionName() {
		return _healthRegionName;
	}

	public void set_healthRegionName(String _healthRegionName) {
		this._healthRegionName = _healthRegionName;
	}

	public String get_facilityType() {
		return _facilityType;
	}

	public void set_facilityType(String _facilityType) {
		this._facilityType = _facilityType;
	}

	public String get_name() 
	{
		return _name;
	}

	public void set_name(String _name) 
	{
		this._name = _name;
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
