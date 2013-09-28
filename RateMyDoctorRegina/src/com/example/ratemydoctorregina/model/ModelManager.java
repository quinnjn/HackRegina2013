package com.example.ratemydoctorregina.model;

import java.util.ArrayList;

public class ModelManager 
{
	private ArrayList<Facility> _facilities;
	
	private ArrayList<Doctor> _doctors;
	
	private ModelManager()
    {
		
    }
    
    private static class ModelManagerHolder
    {
            public static final ModelManager INSTANCE = new ModelManager();
    }
    
    public static ModelManager getInstance()
    {
            return ModelManagerHolder.INSTANCE;
    }

	public ArrayList<Facility> get_facilities() 
	{
		return _facilities;
	}

	public void set_facilities(ArrayList<Facility> _facilities) 
	{
		this._facilities = _facilities;
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
