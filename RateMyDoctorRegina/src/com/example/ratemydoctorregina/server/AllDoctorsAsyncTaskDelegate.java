package com.example.ratemydoctorregina.server;

import java.util.ArrayList;

import com.example.ratemydoctorregina.model.Doctor;

public interface AllDoctorsAsyncTaskDelegate 
{
	 public void AllDoctorsFetcherWillStartToFetchUpdate();
     public void AllDoctorsFetcherDidFinishFetchingUpdate(ArrayList<Doctor> doctors);
     public void AllDoctorsFetcherDidFailToFetchUpdate();
}
