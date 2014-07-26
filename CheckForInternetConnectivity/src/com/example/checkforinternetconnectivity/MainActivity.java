package com.example.checkforinternetconnectivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	//Declare the References
	Button buttonId;
	TextView textViewId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Find the references
		buttonId=(Button) findViewById(R.id.buttonId);
		textViewId=(TextView) findViewById(R.id.textViewId);

		textViewId.setVisibility(View.GONE);

		buttonId.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Call the functions in asynchronous task
				new LongOperation().execute("");
			}
		});
	}
	
	private class LongOperation extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
        	
        	if((hasActiveInternetConnection()==true)&&(isDataPacketsEnabled(MainActivity.this)==true)){
        		//Connectivity Available
        		publishProgress(1);
        	}else{
        		//Connectivity not available
    			publishProgress(2);
        	}
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
           
        }
        
        @Override
        protected void onProgressUpdate(Integer... msg) {
        	if(msg[0]==1){
    			textViewId.setVisibility(View.VISIBLE);
				textViewId.setText("Connected to Internet");
    		}
    		else if(msg[0]==2){
    			textViewId.setVisibility(View.VISIBLE);
				textViewId.setText("Not connected to Internet");
    		}
        }
    }


	
	public boolean isDataPacketsEnabled(Context context) {
		//Check whether data packets are enabled
		ConnectivityManager connectivity = (ConnectivityManager)
				context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {

						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean hasActiveInternetConnection() {
			//Check whether we are able to connect to a webservice
			try {
				HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
				urlc.setRequestProperty("User-Agent", "Test");
				urlc.setRequestProperty("Connection", "close");
				urlc.setConnectTimeout(500); 
				urlc.connect();
				return true;
			} catch (IOException e) {
				Log.e("Log", "Error checking internet connection", e);
			}
		return false;
	}
}
