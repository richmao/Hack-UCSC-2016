package com.rjvproj.universalcommunicator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(translate(message));

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);

    }

    public String translate (String s) {
        // Goes through entire message and converts into morse code (character by character)
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'A') {
                str += ".-";
            }
            else if (c == 'b' || c == 'B') {
                str += "-...";
            }
            else if (c == 'c' || c == 'C') {
                str += "-.-.";
            }
            else if (c == 'd' || c == 'D') {
                str += "-..";
            }
            else if (c == 'e' || c == 'E') {
                str += ".";
            }
            else if (c == 'f' || c == 'F') {
                str += "..-.";
            }
            else if (c == 'g' || c == 'G') {
                str += "--.";
            }
            else if (c == 'h' || c == 'H') {
                str += "....";
            }
            else if (c == 'i' || c == 'I') {
                str += "..";
            }
            else if (c == 'j' || c == 'J') {
                str += ".---";
            }
            else if (c == 'k' || c == 'K') {
                str += "-.-";
            }
            else if (c == 'l' || c == 'L') {
                str += ".-..";
            }
            else if (c == 'm' || c == 'M') {
                str += "--";
            }
            else if (c == 'n' || c == 'N') {
                str += "-.";
            }
            else if (c == 'o' || c == 'O') {
                str += "---";
            }
            else if (c == 'p' || c == 'P') {
                str += ".--.";
            }
            else if (c == 'q' || c == 'Q') {
                str += "--.-";
            }
            else if (c == 'r' || c == 'R') {
                str += ".-.";
            }
            else if (c == 's' || c == 'S') {
                str += "...";
            }
            else if (c == 't' || c == 'T') {
                str += "-";
            }
            else if (c == 'u' || c == 'U') {
                str += "..-";
            }
            else if (c == 'v' || c == 'V') {
                str += "...-";
            }
            else if (c == 'w' || c == 'W') {
                str += ".--";
            }
            else if (c == 'x' || c == 'X') {
                str += "-..-";
            }
            else if (c == 'y' || c == 'Y') {
                str += "-.--";
            }
            else if (c == 'z' || c == 'Z') {
                str += "--..";
            }
            else if (c == ' '){
                str += "  ";
            }
            str += " ";
        }
        return str;

    }



}
