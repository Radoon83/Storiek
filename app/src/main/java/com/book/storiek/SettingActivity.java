package com.book.storiek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    androidx.appcompat.widget.SwitchCompat switchTheme, screenOn;
    com.google.android.material.button.MaterialButton playMusic, pauseMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setupViews();

        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

        });
        screenOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    Toast.makeText(SettingActivity.this, " حالت روشن فعال شد", Toast.LENGTH_SHORT).show();
                } else {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    Toast.makeText(SettingActivity.this, " حالت روشن غیر فعال شد", Toast.LENGTH_SHORT).show();
                }
            }
        });
       /* playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(SettingActivity.this, R.raw.music);
                player.setLooping(true);
                player.setVolume(50, 50);
                player.start();
            }
        });
        pauseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(SettingActivity.this, R.raw.music);
                player.stop();
            }
        });*/

    }


    private void setupViews() {
        switchTheme = findViewById(R.id.switchTheme);
        screenOn = findViewById(R.id.screenOn);
        //playMusic = findViewById(R.id.play);
        //pauseMusic = findViewById(R.id.pause);
    }
}