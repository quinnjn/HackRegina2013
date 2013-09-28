package com.example.ratemydoctorregina.server;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.ratemydoctorregina.model.Doctor;
import com.example.ratemydoctorregina.util.JsonUtils;

import android.os.AsyncTask;

public class AllDoctorsAsyncTask extends AsyncTask<Void, Void, ArrayList<Doctor>>
{
	private AllDoctorsAsyncTaskDelegate _delegate;

	public AllDoctorsAsyncTask(AllDoctorsAsyncTaskDelegate delegate)
	{
		_delegate = delegate;
	}

	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		_delegate.AllDoctorsFetcherWillStartToFetchUpdate();
	}

	@Override
	protected ArrayList<Doctor> doInBackground(Void... params) 
	{
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();

		try 
		{
			String url = "http://108.174.164.162:8080/Doctor.json";
			
			JSONObject json = JsonUtils.readJsonGetFromUrl(url);
			
			JSONArray doctorArray = json.getJSONArray("Doctor");
			
			for (int i = 0; i < doctorArray.length(); i++)
			{
				JSONObject doctorJSON = doctorArray.getJSONObject(i);
				
				Doctor doctor = new Doctor();
				doctor.init(doctorJSON);
				
				doctors.add(doctor);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return doctors;		
	}

	@Override
	protected void onPostExecute(ArrayList<Doctor> doctors) 
	{
		super.onPostExecute(doctors);

		if (doctors.size() == 0) 
		{
			_delegate.AllDoctorsFetcherDidFailToFetchUpdate();
		}
		else 
		{
			_delegate.AllDoctorsFetcherDidFinishFetchingUpdate(doctors);
		}
	}
}
