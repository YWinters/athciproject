package uh.ahci.wallet.browser;

import uh.ahci.R;
import uh.ahci.wallet.Wallet;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class CardBrowser extends Activity {
	
	private ListView mainListView ;
	private CardAdapter listAdapter ;
	  
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_cardbrowser_class);
	    
	    // Find the ListView resource. 
	    mainListView = (ListView) findViewById( R.id.cardBrowser);
	    
	    // Create ArrayAdapter using the planet list.
	    listAdapter = new CardAdapter(this, Wallet.instance().getLoyaltyCards());
	    
	    // Set the ArrayAdapter as the ListView's adapter.
	    mainListView.setAdapter( listAdapter );      
	  }
	
	
}
