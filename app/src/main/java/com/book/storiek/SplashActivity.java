package com.book.storiek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    boolean isLogin = false;
    private static final String LOGIN = "login";
    ProgressBar progressBar;
    Handler handler;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getData();
        progressSetup();

        if (isLogin) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 4000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 4000);
        }

    }

    private void progressSetup() {
        progressBar = findViewById(R.id.progress);
        handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter != 100) {

                    try {
                        counter += 1;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(counter);
                                if (counter == 100) {
                                    getData();
                                }
                            }
                        });

                        Thread.sleep(18);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }

    private void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN, MODE_PRIVATE);
        isLogin = sharedPreferences.getBoolean("ISLOGIN", false);
    }
}