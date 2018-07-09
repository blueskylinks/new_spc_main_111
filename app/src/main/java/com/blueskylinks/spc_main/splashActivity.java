package com.blueskylinks.spc_main;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class splashActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    ProgressBar sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                //Perform any task here which you want to do after time finish.
            Intent it=new Intent(splashActivity.this,Main2Activity.class);
            startActivity(it);
            }
        };
        handler.postDelayed(runnable, 2000);

    }
}

