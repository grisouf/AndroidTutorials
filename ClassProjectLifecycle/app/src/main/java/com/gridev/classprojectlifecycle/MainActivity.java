package com.gridev.classprojectlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = "I/MainActivity";

    private long leftTime = 60000;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate : Called");

        findViewById(R.id.buttonShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart: Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart : Called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume : Called");

        startTimer();
    }

    @Override
    protected void onPause() {
        stopTimer();

        Log.i(TAG, "onPause : called");

        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop : called");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy : Called");

        super.onDestroy();
    }

    private void startTimer() {
        Log.i(TAG, "startTimer: Called");

        countDownTimer = new CountDownTimer(leftTime, 1000) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished == 0)
                {
                    millisUntilFinished = 0;
                    leftTime = millisUntilFinished;
                    Log.i(TAG, "onTick: " + millisUntilFinished);
                }

                leftTime = millisUntilFinished;
                Log.i(TAG, "onTick: " + millisUntilFinished);
            }

            public void onFinish() {

            }
        }.start();
    }

    private void stopTimer() {
        Log.i(TAG, "stopTimer: Called");
        countDownTimer.cancel();
    }

}
