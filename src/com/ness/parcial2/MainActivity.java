package com.ness.parcial2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	CheckBox c1, c2, c3, c4;
	Button bc, bs;
	EditText n1, n2;
	Intent i;
	double num1, num2;
	String a1, a2;
	boolean ve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);
        c4 = (CheckBox) findViewById(R.id.checkBox4);
        
        bc = (Button) findViewById(R.id.button1);
        bs = (Button) findViewById(R.id.button2);
        
        n1 = (EditText) findViewById(R.id.editText1);
        n2 = (EditText) findViewById(R.id.editText2);
    }

    public void calcular(View v){
    	
    	a1= n1.getText().toString();
    	a2 = n2.getText().toString();
    	if(a1.equals("") | a2.equals("")){
    		mensaje("Debe ingresar dos valores para poder usar estas operaciones", 2);
    	} else{
    		
    		i = new Intent(this, Mostrar.class);
    		num1 = Double.parseDouble(a1);
    		num2 = Double.parseDouble(a2);
    		if(c1.isChecked()){
    			ve =true;
    			i.putExtra("suma", sumar(num1, num2));
    		}else {
    			i.putExtra("suma", 0);
    		}
    		
        	if(c2.isChecked()){
        		ve =true;
        	i.putExtra("resta", resta(num1, num2));
			}else {
			i.putExtra("resta", 0);
			}
        	
        	if(c3.isChecked()){
        		ve =true;
            	i.putExtra("multi", multi(num1, num2));
    		}else {
    			i.putExtra("multi", 0);
    		}
        	
        	if(c4.isChecked()){
        		ve =true;
            	i.putExtra("divi", divi(num1, num2));
    			}else {
    			i.putExtra("divi", 0);
    			}
        	
        	if(ve == true){
        		startActivity(i);
        	}else{
        		mensaje("tiene que seleccionar una opcion",1);
        	}
        	
    	}
    	
    }
    
    private double divi(double num12, double num22) {
		// TODO Auto-generated method stub
		return num12/ num22;
	}

	private double multi(double num12, double num22) {
		// TODO Auto-generated method stub
		return num12*num22;
	}

	private double resta(double num12, double num22) {
		// TODO Auto-generated method stub
		return num12-num22;
	}

    private double sumar(double num12, double num22) {
		// TODO Auto-generated method stub
		return num12+num22;
	}
    private void mensaje(String a, int arg){
    	if(arg >1){
    		Toast.makeText(this, a, Toast.LENGTH_LONG).show();
    	}else {
    		Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
    	}
    	
    }
	public void salir(View v){
    	this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
