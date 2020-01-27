package com.vangaren.app.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpiner1 = findViewById(R.id.currencySpinner1);
        Spinner mySpiner2 = findViewById(R.id.currencySpinner2);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currencyNames));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currencyNames));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpiner1.setAdapter(myAdapter1);
        mySpiner2.setAdapter(myAdapter2);
    }

    public void onCovert(View view){
        double valToConvert;
        double valConverted;
        TextView inputValue = findViewById(R.id.inputValue);
        String striVal = inputValue.getText().toString();
//        Toast.makeText(getApplicationContext(), striVal, Toast.LENGTH_LONG).show();

        // if the value isn't null, then convert
        if(striVal.compareTo("")!=0){
            valToConvert = Double.parseDouble(striVal);
            Log.d("valToConvert", Double.toString(valToConvert));

            Spinner fromCur = findViewById(R.id.currencySpinner1);
            Spinner toCur = findViewById(R.id.currencySpinner2);

            String fCur = fromCur.getSelectedItem().toString();
            String tCur = toCur.getSelectedItem().toString();

            Log.d("toFrom", "from: "+fCur+" to:"+tCur);

            valConverted = currencyConvertion(valToConvert, fCur, tCur);
            TextView outputValue = findViewById(R.id.outputValue);
            outputValue.setText(Double.toString(valConverted));
        }

    }

    private double currencyConvertion(double amount, String fromCountry, String toCountry){
        return amount * 0.91;
    }
}
