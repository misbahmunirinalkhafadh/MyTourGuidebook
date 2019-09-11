package com.dikoding.picodiploma.mytourguidebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {

    Animation appSplash;
    ImageView appLogo, appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        appLogo = findViewById(R.id.app_logo);
        appName = findViewById(R.id.app_name);

//        appSplash = AnimationUtils.loadAnimation(this, R.anim.app_splash);

        appLogo.setAnimation(appSplash);
        appName.setAnimation(appSplash);

        //Setting timer 2 detik untuk berpindah halaman
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Merubah activity ke activity lain
                Intent gogetstarted = new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(gogetstarted);
                finish();
            }
        }, 2000);
    }
}
