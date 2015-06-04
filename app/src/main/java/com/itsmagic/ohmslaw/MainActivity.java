package com.itsmagic.ohmslaw;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//if(TextUtils.isEmpty(textP.getText())){
//float P = 0;
//
 //       P = V * I
 //       }


public class MainActivity extends ActionBarActivity {
    EditText textV, textI, textR, textP;
    Button boton;
    TextView resultado, potencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textV = (EditText) findViewById(R.id.editTextV);
        textI = (EditText) findViewById(R.id.editText3I);
        textR = (EditText) findViewById(R.id.editText2R);
        textP = (EditText) findViewById(R.id.editTextP);
        boton = (Button) findViewById(R.id.button);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declarar valores:
                float R = 0;
                float V = 0;
                float I = 0;
                float P = 0;

                float r = 0;
                //Declarar TOASTS
                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                "sacá algún valor...", Toast.LENGTH_LONG);

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "poné algún valor...", Toast.LENGTH_LONG);

                //leer R
                try {
                    R = Float.parseFloat(textR.getText().toString());
                }
                catch(NumberFormatException ex) {
                    R = 0; // default ??
                }

                //Leer V
                try {
                    V = Float.parseFloat(textV.getText().toString());
                }
                catch(NumberFormatException ex) {
                    V = 0; // default ??
                }

                //Leer I :
                try {
                    I = Float.parseFloat(textI.getText().toString());
                }
                catch(NumberFormatException ex) {
                    I = 0; // default ??
                }


                try {
                    P = Float.parseFloat(textP.getText().toString());
                }
                catch(NumberFormatException ex) {
                    P = 0; // default ??
                }


                //funiciones if

                if(TextUtils.isEmpty(textI.getText())){
                    r = V / R;
                    I = r;


                    textI.setText(String.valueOf(r));
                }

                if(TextUtils.isEmpty(textV.getText())){
                    r = I / R;
                    V = r;
                    textV.setText(String.valueOf(r));


                }

                if(TextUtils.isEmpty(textR.getText())){
                    r = V / I;
                    R = r;

                    textR.setText(String.valueOf(r));
                }

                if(TextUtils.isEmpty(textR.getText()) & TextUtils.isEmpty(textI.getText()) & TextUtils.isEmpty(textV.getText()) & TextUtils.isEmpty(textP.getText())){
                    toast1.show();
                }

                if(R > 0 & V > 0 & I > 0) {

                }


                    r = V * I;

                    textP.setText(String.valueOf(r));


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
