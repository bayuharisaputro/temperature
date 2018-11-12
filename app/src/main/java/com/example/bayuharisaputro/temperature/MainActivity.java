package com.example.bayuharisaputro.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultVal;
    EditText inputVal;
    Button farenheitAct, kelvinAct;
    LinearLayout mainLayout;
    Double temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        resultVal = (TextView) findViewById(R.id.resultText);
        inputVal =  (EditText) findViewById(R.id.inputText);
        farenheitAct = (Button) findViewById(R.id.farenheitBtn);
        kelvinAct = (Button) findViewById(R.id.kelvinBtn);
        final Converter conv = new Converter();

        farenheitAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Double.valueOf(inputVal.getText().toString());
                conv.setTemperature(temp);
                conv.getFarenheit();
                resultVal.setText(Double.toString(conv.getCelcius()) + " Farenheit");

            }
        });
        kelvinAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Double.valueOf(inputVal.getText().toString());
                conv.setTemperature(temp);
                conv.getKelvin();
                resultVal.setText(Double.toString(conv.getCelcius()) + " Kelvin" );
            }
        });


    }
}
