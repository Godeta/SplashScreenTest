package fr.godeta.splashscreentest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // rediriger vers la page princip après 3 sec
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            //démarrer une page
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
            }
        };

        //handler post delayed
        new Handler().postDelayed(runnable,3000);
    }
}
