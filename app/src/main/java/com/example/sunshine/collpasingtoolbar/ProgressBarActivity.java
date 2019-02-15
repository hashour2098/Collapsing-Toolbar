package com.example.sunshine.collpasingtoolbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar progressBar, verticalProgressbar;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        verticalProgressbar = findViewById(R.id.verticalProgressBar);
        progressBar = findViewById(R.id.progressbar);
        verticalProgressbar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        verticalProgressbar.setProgress(0);
        verticalProgressbar.setMax(100);
        verticalProgressbar.setSecondaryProgress(0);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                if(++i <= 100){
                    verticalProgressbar.setProgress(i);
                    verticalProgressbar.setSecondaryProgress(i+10);
                }else{
                    timer.cancel();
//                    progressBar.setVisibility(View.GONE);

                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 8000, 300);
    }
}
