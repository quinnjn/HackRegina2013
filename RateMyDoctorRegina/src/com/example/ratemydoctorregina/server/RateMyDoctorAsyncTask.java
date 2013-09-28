package com.example.ratemydoctorregina.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.ratemydoctorregina.model.Doctor;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class RateMyDoctorAsyncTask extends AsyncTask<Void, Void, Boolean> 
{
	String url = "http://108.174.164.162:8080/Doctor/submitRating";
	Activity _context;
	
	public RateMyDoctorAsyncTask(Doctor doctor, Activity context)
	{
		url += "/" + doctor.get_id() + "/" + doctor.get_rating() + "/" + doctor.get_name();
		_context = context;
	}
	
	@Override
	protected Boolean doInBackground(Void... params) 
	{
		HttpClient client = new DefaultHttpClient();
		try 
		{
			HttpGet request = new HttpGet(new URI(url));
			client.execute(request);
		}
		catch (URISyntaxException e) 
		{
			e.printStackTrace();
		}
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
	protected void onPostExecute(Boolean result)
	{
		if(result)
		{
			Toast.makeText(_context, "Your rating has been submitted!", Toast.LENGTH_SHORT);
			_context.finish();
		}
		else
		{
			Log.d("Task Fail", "Oh Noes...");
		}
	}

}
