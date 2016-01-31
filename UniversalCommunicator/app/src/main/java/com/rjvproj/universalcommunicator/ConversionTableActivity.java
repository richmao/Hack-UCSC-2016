package com.rjvproj.universalcommunicator;
/**
 * @author Vinod Krishnamurthy
 * @file ConversionTableActivity.java
 * @version Last Update 31 Jan 2016 2:43am
 * @description This class represents the resource Conversion Table for Morse Code.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

public class ConversionTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_conversion_table);
        Intent intent = getIntent();


    }

}
