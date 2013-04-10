package com.demo.shakedetectordemo;

import com.demo.shakedetectordemo.ShakeDetector.OnShakeListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView;
	private static int count;
	ShakeDetector shakeDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
		shakeDetector = new ShakeDetector(this);
		shakeDetector.registerOnShakeListener(new OnShakeListener() {
			
			@Override
			public void onShake() {
				// TODO Auto-generated method stub
				textView.setText("shake = " + count++);
			}
		});
		shakeDetector.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		shakeDetector.stop();
	}
}
