package com.example.android.zahra_1202150246_modul3;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private static int splashInterval = 3000; //interval splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //menampilkan splash screen secara full
        //menghilangkan action bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //
                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i); // menghubungkan activity splashscren dengan intent

                //jeda selesai Splashscreen. Menyelesaikan splash screen, jadi tidak akan kembali ke
                //splashscreen meskipun menekan back
                this.finish();
            }

            private void finish() {
                //
            }

        }, splashInterval);

    }
}
