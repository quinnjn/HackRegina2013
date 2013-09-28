package com.example.ratemydoctorregina.mapscreen;

import com.example.ratemydoctorregina.R;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends SupportMapFragment implements
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener, OnInfoWindowClickListener 
{

		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		GoogleMap googleMap = getMap();
		googleMap.setMyLocationEnabled(true);
		googleMap.setOnInfoWindowClickListener(this);

		/*ArrayList<Facility> facilities = ModelManager.getInstance().get_facilities();
		for (Facility facility : facilities) 
		{
			LatLng latLng = new LatLng(facility.get_location().getLatitude(),
					facility.get_location().getLongitude());
			
			Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng)
					.title(facility.get_name()).snippet(facility.get_address()));			
		}*/
		
		super.onActivityCreated(savedInstanceState);
	}


	@Override
	public void onInfoWindowClick(Marker arg0) 
	{
		/*Facility facility = someList;
		
		if (facility == null) 
		{
			Toast.makeText(getActivity(), "ERROR OCCURED", Toast.LENGTH_LONG).show();
		}
		else 
		{
			Intent intent = new Intent(getActivity(), FacilityDetailActivity.class);
			intent.putExtra(FacilityDetailActivity.SOME_KEY, facility.hashCode());
			startActivity(intent);
		}*/
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

}
