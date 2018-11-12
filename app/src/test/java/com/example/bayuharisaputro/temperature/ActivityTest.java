package com.example.bayuharisaputro.temperature;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)

public class ActivityTest {

    private MainActivity activity;
    private Converter conv;
    private double min = 0.0; // Min Temperature Value private
     double max = 100.0; // Max Temperature Value
    @Before
    public void initTest() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        conv = new Converter();
    }
    @Test
    public void farenheitButtonClicking() {
        double x = (int)(Math.random()*((max-min)+1))+min;
        activity.inputVal.setText(Double.toString(x));
        activity.farenheitAct.performClick();
        conv.setTemperature(x);
        assertEquals("Farenheit Failed !!",conv.getFarenheit()+" Farenheit",activity.resultVal.getText().toString());
    }
    @Test
    public void kelvinButtonClicking() {
        double x = (int)(Math.random()*((max-min)+1))+min;
        activity.inputVal.setText(Double.toString(x));
        activity.kelvinAct.performClick();
        conv.setTemperature(x);
        assertEquals("Kelvin Failed !!",conv.getKelvin()+" Kelvin",activity.resultVal.getText().toString());
    }
}
