package com.registrationapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.registrationapp.R;
import com.registrationapp.prefrences.PrefsConstants;
import com.registrationapp.prefrences.RegistrationPrefrence;


public class SplashActivity extends AppCompatActivity {
    private final static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        moveToNextScreen();


    }

    private void moveToNextScreen() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                RegistrationPrefrence registrationPrefrence = new RegistrationPrefrence(SplashActivity.this);
                if (registrationPrefrence.getBoolean(PrefsConstants.MEMBER_LOGGED_IN)) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_TIME_OUT);
    }


}
