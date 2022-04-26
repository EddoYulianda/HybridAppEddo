package com.eddo.hybridappeddo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.eddo.hybridappeddo.R;

public class SplashScreenActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}
