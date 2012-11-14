package uh.ahci;

import uh.ahci.camera.ScannerClass;
import uh.ahci.wallet.browser.CardBrowser;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;


import com.mirasense.scanditsdk.ScanditSDKBarcodePicker;
import com.mirasense.scanditsdk.interfaces.ScanditSDKListener;

public class MainActivity extends Activity implements ScanditSDKListener, LocationListener {
	// The main object for scanning barcodes.
	private ScanditSDKBarcodePicker mBarcodePicker;
		
	// Enter your Scandit SDK App key here.
	// Your Scandit SDK App key is available via your Scandit SDK web account.
	private static final String sScanditSdkAppKey = "+E/mzCaBEeKWKCTnJIqVmWcurnyArbCd5p/artq8YP8";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        startLocationGathering();

		RelativeLayout rootView = new RelativeLayout(this);
		
		// Create the buttons to start scanner examples.
		// And button to go to card list
		Button button = createActivityButton(rootView);
       
		setContentView(rootView);
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
	
    /**
     * Creates a button that shows how to start a new Activity that implements 
     * the Scandit SDK as a full screen scanner. The Activity can be found in 
     * the ScanditSDKSampleBarcodeActivity in this demo project. The old and
     * new GUIs can both be easily opened this way, which is also shown in the 
     * aforementioned activity.
     * 
     * @param rootView The view this button should be added to.
     */
	private Button createActivityButton(RelativeLayout rootView) {
		/*Button button = new Button(this);
        button.setText("Full Screen Scan View");
        RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rParams.bottomMargin = 100;
        rootView.addView(button, rParams);
        button.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, 
                        ScannerClass.class));
            }
        });
        button.setId(1234);*/

        Button button = new Button(this);
        button.setText("Card Browser");
        RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rParams.bottomMargin = 100;
        rootView.addView(button, rParams);
        button.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardBrowser.class));
            }
        });
        button.setId(1234);
        return button;
	}
	
	@Override
	protected void onPause() {
	    // When the activity is in the background immediately stop the 
	    // scanning to save resources and free the camera.
	    /*if (mBarcodePicker != null) {
	        mBarcodePicker.stopScanning();
	    }
        LocationManager locationManager = 
            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);*/
	    super.onPause();
	}
	
	@Override
	protected void onResume() {
	    /*// Once the activity is in the foreground again, restart scanning.
        if (mBarcodePicker != null) {
            mBarcodePicker.startScanning();
        }*/
	    super.onResume();
	}

		

	
	@Override
	public void onBackPressed() {
	    if (mBarcodePicker != null) {
	        mBarcodePicker.stopScanning();
	    }
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
