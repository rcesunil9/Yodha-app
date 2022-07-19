package com.yodha.gadvasu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.yodha.gadvasu.MainActivity;
import com.yodha.gadvasu.Otherdatacls.Sharepredata;
import com.yodha.gadvasu.R;

public class SplashActivity extends BaseActivity {
Sharepredata sharepredata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharepredata = new Sharepredata(SplashActivity.this);
        int SPLASH_SCREEN_TIME_OUT = 5000;

        //the current activity will get finished.
        new Handler().postDelayed(this::checklogin, SPLASH_SCREEN_TIME_OUT);
    }

    private void checklogin() {

        if (sharepredata.getBooleanData(Sharepredata.HAS_LOGIN)) {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);

           // String fcmtoken = sharepreference.getData(Sharepredata.NOTIFICATION_TOKEN);
            // FirebaseMessaging.getInstance().subscribeToTopic("hello");
            /*String deviceId = Settings.Secure.getString(this.getContentResolver(),
                    Settings.Secure.ANDROID_ID);*/
            //  Toast.makeText(this, deviceId +fcmtoken, Toast.LENGTH_SHORT).show();
            //Intent is used to switch from one activity to another.
            startActivity(i);

            //invoke the SecondActivity.
            finish();
        } else {
            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            //Intent is used to switch from one activity to another.
            startActivity(i);
            //invoke the SecondActivity.
            finish();
        }
    }
}