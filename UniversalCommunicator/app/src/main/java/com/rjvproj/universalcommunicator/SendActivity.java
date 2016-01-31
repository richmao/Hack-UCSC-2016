package com.rjvproj.universalcommunicator;
/**
 * @author Vinod Krishnamurthy
 * @author Richard Mao
 * @author Jake Runyan
 * @file SendActivity.java
 * @version Last Update 31 Jan 2016 4:53am
 * @description This class represents the page that holds all the sendable options for user input.
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
import android.widget.EditText;

public class SendActivity extends MainActivity{

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_send, null, false);
        drawer.addView(contentView, 0);
        Intent intent = getIntent();
    }

    /**
     * Prompts the DisplayMessageActivity class to run its onCreate method and become visible.
     * @param view The current viewable page.
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(SendActivity.this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}