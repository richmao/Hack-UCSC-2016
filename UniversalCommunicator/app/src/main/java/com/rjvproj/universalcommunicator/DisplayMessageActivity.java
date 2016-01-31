package com.rjvproj.universalcommunicator;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.media.SoundPool;
import android.media.AudioAttributes;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.io.IOException;


public class DisplayMessageActivity extends AppCompatActivity implements Callback {
    String translated;

    private boolean isMorsing = false;

    private boolean isLightOn = false;
    private Camera camera;
    private Button button;
    private SurfaceHolder mHolder;
    private Parameters p = null;

    @Override
    protected void onStart() {
        super.onStart();
        SurfaceView preview = (SurfaceView) findViewById(R.id.surfaceView);
        mHolder = preview.getHolder();
        mHolder.addCallback(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(camera != null){
            camera.release();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = (Button) findViewById(R.id.button3);

        Context context = this;
        PackageManager pm = context.getPackageManager();

        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "Device has no camera!");
            return;
        }

        camera = Camera.open();
        p = camera.getParameters();

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isMorsing = true;
                turnOnFlash();
                SystemClock.sleep(2000);
                turnOffFlash();
                for(int i = 0; i < translated.length(); i++) {
                    if(!isMorsing){
                        break;
                    }
                    if (translated.charAt(i) == '.') {
                        turnOnFlash();
                        SystemClock.sleep(25);
                        turnOffFlash();
                    } else if (translated.charAt(i) == '-') {
                        turnOnFlash();
                        SystemClock.sleep(750);
                        turnOffFlash();
                    } else if (translated.charAt(i) == ' ')
                        SystemClock.sleep(1000);
                }
                isMorsing = false;
            }
        });


        Intent intent = getIntent();
        String message = intent.getStringExtra(SendActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        translated = translate(message);
        textView.setText(translated);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);


    }

        private void turnOnFlash(){
            Log.i("info", "Light Is On!");
            p.setFlashMode(Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
            camera.startPreview();
            isLightOn = true;
        }

        private void turnOffFlash() {
            Log.i("info", "Light Is Off!");
            p.setFlashMode(Parameters.FLASH_MODE_OFF);
            camera.setParameters(p);
            camera.stopPreview();
            isLightOn = false;
        }






    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        mHolder = holder;
        try{
            Log.i("SurfaceHolder", "setting preview");
            camera.setPreviewDisplay(mHolder);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        Log.i("SurfaceHolder", "stopping preview");
        camera.stopPreview();
        mHolder = null;
    }

    public String translate (String s) {
        // Goes through entire message and converts into morse code (character by character)
        String str = " ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'A') {
                str += ".-";
            } else if (c == 'b' || c == 'B') {
                str += "-...";
            } else if (c == 'c' || c == 'C') {
                str += "-.-.";
            } else if (c == 'd' || c == 'D') {
                str += "-..";
            } else if (c == 'e' || c == 'E') {
                str += ".";
            } else if (c == 'f' || c == 'F') {
                str += "..-.";
            } else if (c == 'g' || c == 'G') {
                str += "--.";
            } else if (c == 'h' || c == 'H') {
                str += "....";
            } else if (c == 'i' || c == 'I') {
                str += "..";
            } else if (c == 'j' || c == 'J') {
                str += ".---";
            } else if (c == 'k' || c == 'K') {
                str += "-.-";
            } else if (c == 'l' || c == 'L') {
                str += ".-..";
            } else if (c == 'm' || c == 'M') {
                str += "--";
            } else if (c == 'n' || c == 'N') {
                str += "-.";
            } else if (c == 'o' || c == 'O') {
                str += "---";
            } else if (c == 'p' || c == 'P') {
                str += ".--.";
            } else if (c == 'q' || c == 'Q') {
                str += "--.-";
            } else if (c == 'r' || c == 'R') {
                str += ".-.";
            } else if (c == 's' || c == 'S') {
                str += "...";
            } else if (c == 't' || c == 'T') {
                str += "-";
            } else if (c == 'u' || c == 'U') {
                str += "..-";
            } else if (c == 'v' || c == 'V') {
                str += "...-";
            } else if (c == 'w' || c == 'W') {
                str += ".--";
            } else if (c == 'x' || c == 'X') {
                str += "-..-";
            } else if (c == 'y' || c == 'Y') {
                str += "-.--";
            } else if (c == 'z' || c == 'Z') {
                str += "--..";
            } else if (c == ' '){
                str += "  ";
            } else if (c == '.'){
                str += ".-.-.-";
            } else if (c == ','){
                str += "--..--";
            } else if (c == '?'){
                str += "..--..";
            } else if (c == '!'){
                str += "..--.";
            } else if (c == ':'){
                str += "---...";
            } else if (c == '"'){
                str += ".-..-.";
            } else if (c == '='){
                str += "-...-";
            } else if (c == '1'){
                str += ".----";
            } else if (c == '2'){
                str += "..---";
            } else if (c == '3'){
                str += "...--";
            } else if (c == '4'){
                str += "....-";
            } else if (c == '5'){
                str += ".....";
            } else if (c == '6'){
                str += "-....";
            } else if (c == '7'){
                str += "--...";
            } else if (c == '8'){
                str += "---..";
            } else if (c == '9'){
                str += "----.";
            } else if (c == '0'){
                str += "-----";
            } else if (c == '\''){
                str += "-...-";
            }

            str += " ";
        }
        return str;

    }

    public void soundMorse(View view){ //MAke sure that sound doesn't play concurrently, do this by having a value, boolean isPlaying
        isMorsing = true;
        AudioAttributes aa = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();
        SoundPool sound = new SoundPool.Builder()
                .setMaxStreams(10)
                .setAudioAttributes(aa)
                .build();

        int dash = sound.load(this, R.raw.longbeep, 1);

        int dot = sound.load(this, R.raw.shortbeep, 1);

        for(int i = 0; i < translated.length(); i++) {
            if(!isMorsing){
                break;
            }
            if(translated.charAt(i) == '.'){
                sound.play(dot, 1, 1, 1, 0, 1);
                SystemClock.sleep(200);
            }
            else if(translated.charAt(i) == '-'){
                sound.play(dash, 1, 1, 1, 0, 1);
                SystemClock.sleep(400);
            }
            else if(translated.charAt(i) == ' ')
                SystemClock.sleep(300);

        }
        isMorsing = false;

    }


    public void vibrateMorse(View view) {
        isMorsing = true;
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (v.hasVibrator()) {
            for (int i = 0; i < translated.length(); i++) {
                if(!isMorsing){
                    break;
                }
                if (translated.charAt(i) == '.') {
                    v.vibrate(250);
                    SystemClock.sleep(350);
                } else if (translated.charAt(i) == '-') {
                    v.vibrate(500);
                    SystemClock.sleep(750);
                } else if (translated.charAt(i) == ' ')
                    SystemClock.sleep(750);

            }

        }
    isMorsing = false;
    }

    public void stopMorsing(View view){
        isMorsing = false;
    }

}
