package com.example.ratemydoctorregina.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonUtils 
{
	private static String readAll(Reader rd) throws IOException 
	{
		StringBuilder sb = new StringBuilder();
		int cp;

		while ((cp = rd.read()) != -1) 
		{
			sb.append((char) cp);
		}

		return sb.toString();
	}


	/**
	 * Attempts to retrieve data from a specified URL and return a JSON representation of it.
	 * 
	 * @param url The URL to retrieve the data from
	 * 
	 * @return A JSONObject representing the JSON from the response with the specified URL
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONObject readJsonGetFromUrl(String url)
	{
		JsonUtils.trustEveryone(); // HACK TO BYPASS SSL NEEDS FIX.
		
		Log.i("DEBUG", "Retrieving JSON from URL: " + url);

		InputStream is = null;
		
		try 
		{	
			//url = "http://108.174.164.162:8080/Doctor.json";
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(url));
			
			HttpResponse response = client.execute(request);
			
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} 
		catch(IOException ioException)
		{
			ioException.printStackTrace();
			return null;
		}
		catch (JSONException jsonException) 
		{
			jsonException.printStackTrace();
			return null;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(is != null)
			{
				try 
				{
					is.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Send an Http POST request and return the response string from the server
	 * @param url : the location to send the request 
	 * @return the response back from the server
	 */
	public static String readPostFromUrl(String url, ArrayList<NameValuePair> params)
	{
		HttpClient client_connection = new DefaultHttpClient();
		
		try
		{
			HttpPost request = new HttpPost(url);
			request.setEntity(new UrlEncodedFormEntity(params));
			request.addHeader("content-type", "application/x-www-form-urlencoded");
			
			HttpResponse response = client_connection.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String response_string = "";
			
			String line = rd.readLine();
			while(line != null)
			{
				response_string += line;
				line = rd.readLine();
			}
			
			
			return response_string;
		}
		catch (ClientProtocolException e) 
		{
			return null;
		}
		catch (IOException e) 
		{
			return null;
		} 
		finally
		{
			client_connection.getConnectionManager().shutdown();
		}
	}
	
	
	/**
	 * //TODO:  FIX THIS.
	 * 
	 * Temporary hack to trust any certificate when going to retrieve data from www.flaman.com.
	 * 
	 * We need a proper way to deal with this.
	 */
	public static void trustEveryone() {
		try {
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){

					@Override
					public boolean verify(String arg0, SSLSession arg1) {
						// TODO Auto-generated method stub
						return true;
					}});
			
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[]{new X509TrustManager(){
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {}
				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {}
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}}}, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(
					context.getSocketFactory());
		} catch (Exception e) { // should never happen
			e.printStackTrace();
		}
	}
}

