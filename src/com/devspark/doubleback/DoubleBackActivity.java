package com.devspark.doubleback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * @author e.shishkin
 *
 */
public class DoubleBackActivity extends Activity {
	private static final String LOG_TAG = DoubleBackActivity.class.getSimpleName();
	
	private long lastPressTime;
	private static final long DOUBLE_PRESS_INTERVAL = 3000000000l; // value in ns. (3 sek.)
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
	public void onBackPressed() {
		Log.v(LOG_TAG, "onBackPressed() called");
		long pressTime = System.nanoTime();
		if (pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
			// this is a double click event
			super.onBackPressed();
		} else {
			Toast.makeText(this, getString(R.string.toast_press_back), Toast.LENGTH_SHORT).show();
		}
		lastPressTime = pressTime;
	}
}