package com.ness.parcial2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Mostrar extends Activity {
	TextView ts, tr, tm, td;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar);
		
		ts = (TextView) findViewById(R.id.ts);
		tr = (TextView) findViewById(R.id.tr);
		tm = (TextView) findViewById(R.id.tm);
		td = (TextView) findViewById(R.id.td);
		
		Bundle bl = this.getIntent().getExtras();
		
		ts.setText(""+bl.getDouble("suma"));
		tr.setText(""+bl.getDouble("resta"));
		tm.setText(""+bl.getDouble("multi"));
		td.setText(""+bl.getDouble("divi"));
	}

	public void regresar(View v){
		this.finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mostrar, menu);
		return true;
	}

}
