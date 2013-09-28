package com.example.ratemydoctorregina.server;

import java.util.ArrayList;

import com.example.ratemydoctorregina.model.Facility;

public interface AllFacilitiesAsyncTaskDelegate 
{
	public void AllFacilitiesFetcherWillStartToFetchUpdate();
    public void AllFacilitiesFetcherDidFinishFetchingUpdate(ArrayList<Facility> facilities);
    public void AllFacilitiesFetcherDidFailToFetchUpdate();
}
