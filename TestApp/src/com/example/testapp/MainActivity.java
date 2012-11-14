package com.example.testapp;

import java.util.Iterator;
import java.util.LinkedList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.mirasense.scanditsdk.ScanditSDKBarcodePicker;
import com.mirasense.scanditsdk.interfaces.ScanditSDKListener;

@SuppressLint("ShowToast")
public class MainActivity extends Activity implements ScanditSDKListener, LocationListener {
	// The main object for scanning barcodes.
	private ScanditSDKBarcodePicker mBarcodePicker;
	static final int ADD_CARD_REQUEST = 1;
	private static final String sScanditSdkAppKey = "+E/mzCaBEeKWKCTnJIqVmWcurnyArbCd5p/artq8YP8";
	
	//linked list with all scanned codes
	private LinkedList<String> lstCodes = new LinkedList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        startLocationGathering();
        setContentView(R.layout.activity_main);
		//RelativeLayout rootView = new RelativeLayout(this);
        lstCodes.add("test");
		// Create the buttons to start scanner examples.
		createActivityButton();
		//
		createGenerateCardButton();
		 
		//setContentView(rootView);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void didCancel() {
		// TODO Auto-generated method stub
		
	}

	public void didManualSearch(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void didScanBarcode(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void createGenerateCardButton(){
		 Button button = new Button(this);
	        button = (Button)this.findViewById(R.id.btnGenerateCard);
	        //if (button == null)
	        //Log.w("myApp", "gets here 2");
	        button.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	Intent i = new Intent(MainActivity.this, ShowCardActivity.class);
	            	i.putExtra("data", lstCodes.getLast());
	            	
	                startActivity(i);
	                Log.w("myApp", "gets here 2");
	            }
	        });
	}
	
    /**
     * Creates a button that shows how to start a new Activity that implements 
     * the Scandit SDK as a full screen scanner. The Activity can be found in 
     * the ScanditSDKSampleBarcodeActivity in this demo project. The old and
     * new GUIs can both be easily opened this way, which is also shown in the 
     * aforementioned activity.
     * 
     * @param rootView The view this button should be added to.
     * @return Button that starts a scanning Activity on click.
     */
	private void createActivityButton() {
        Button button = new Button(this);
        button = (Button)this.findViewById(R.id.btnAdd);
        //if (button == null)
        //Log.w("myApp", "gets here 2");
        button.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
            	Intent i = new Intent(MainActivity.this, ScannerClass.class);
                startActivityForResult(i,ADD_CARD_REQUEST);
            }
        });
        //button.setId(1234);
       
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // Check which request we're responding to
	    if (requestCode == ADD_CARD_REQUEST) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	            String newBarcode = data.getStringExtra("barcode");
	            lstCodes.add(newBarcode);
	            Toast.makeText(this, newBarcode, 10000).show();
	            updateLabel();
	        }
	        
	    }
	    
	}
	
	protected void updateLabel(){
		 TextView t=new TextView(this); 
		 t=(TextView)findViewById(R.id.txtLinkedList); 
		 t.setText("");
		 Iterator<String> it = lstCodes.iterator();
		 while(it.hasNext()){
			 t.append(it.next().toString() + "\n");		 
		 }
		 //t.setText(lstCodes.getLast().toString());	
	}
	
	
	@Override
	protected void onPause() {
        LocationManager locationManager = 
            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);
	    super.onPause();
	}
	
	@Override
	protected void onResume() {
	    super.onResume();
	}

	@Override
	public void onBackPressed() {
	    finish();
	}
	
	/**
	 * Starts to gather location data from the finest allowed location provider.
	 * For this to work either one of the following permissions has to be set:
	 * ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION.
	 */
	private void startLocationGathering() {
        LocationManager locationManager = 
            (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String provider = locationManager.getBestProvider(criteria, true);
        if (provider != null) {
            locationManager.requestLocationUpdates(provider, 5, 5, this);
        }
	}
	
	
	public void onLocationChanged(Location arg0) {
        LocationManager locationManager = 
            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);
	}
	
	
	public void onProviderDisabled(String arg0) {}
	
	
	public void onProviderEnabled(String arg0) {}
	
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}
}
