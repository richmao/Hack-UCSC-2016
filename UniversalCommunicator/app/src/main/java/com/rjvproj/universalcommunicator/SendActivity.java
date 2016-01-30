package com.rjvproj.universalcommunicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SendActivity extends MainActivity{

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // initiates all the nav drawer stuff from the BaseNavigationDrawerActivity
        setContentView(R.layout.activity_main);
        super.onCreateDrawer();
        Intent intent = getIntent();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(SendActivity.this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}