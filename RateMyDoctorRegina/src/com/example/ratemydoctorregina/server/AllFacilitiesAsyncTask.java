package com.example.ratemydoctorregina.server;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;

import com.example.ratemydoctorregina.model.Facility;
import com.example.ratemydoctorregina.util.JsonUtils;

public class AllFacilitiesAsyncTask extends AsyncTask<Void, Void, ArrayList<Facility>>
{
	private AllFacilitiesAsyncTaskDelegate _delegate;

	public AllFacilitiesAsyncTask(AllFacilitiesAsyncTaskDelegate delegate)
	{
		_delegate = delegate;
	}

	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		_delegate.AllFacilitiesFetcherWillStartToFetchUpdate();
	}

	@Override
	protected ArrayList<Facility> doInBackground(Void... params) 
	{
		ArrayList<Facility> facilities = new ArrayList<Facility>();

		try 
		{
			String url = "http://home.neumiiller.com:8080/Facility.json";
			
			JSONObject json = JsonUtils.readJsonGetFromUrl(url);
			
			JSONArray facilityArray = json.getJSONArray("Facility");
			
			for (int i = 0; i < facilityArray.length(); i++)
			{
				JSONObject facilityJSON = facilityArray.getJSONObject(i);
				
				Facility facility = new Facility();
				facility.init(facilityJSON);
				
				facilities.add(facility);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return facilities;		
	}

	@Override
	protected void onPostExecute(ArrayList<Facility> facilities) 
	{
		super.onPostExecute(facilities);

		if (facilities.size() == 0) 
		{
			_delegate.AllFacilitiesFetcherDidFailToFetchUpdate();
		}
		else 
		{
			_delegate.AllFacilitiesFetcherDidFinishFetchingUpdate(facilities);
		}
	}
}

