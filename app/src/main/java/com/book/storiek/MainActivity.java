package com.book.storiek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ir.tapsell.sdk.bannerads.TapsellBannerType;
import ir.tapsell.sdk.bannerads.TapsellBannerView;
import ir.tapsell.sdk.bannerads.TapsellBannerViewEventListener;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout frameLayout;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        bottomNav.setOnNavigationItemSelectedListener(this);
    }


    private void setUpView() {
        frameLayout = findViewById(R.id.frame_id);
        bottomNav = findViewById(R.id.bottom_nav_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int navID = menuItem.getItemId();
        switch (navID) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new HomeFragment()).commit();
                break;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new SearchFragment()).commit();
                break;
            case R.id.favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new FavoriteFragment()).commit();
                break;
            case R.id.manu:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new MenuFragment()).commit();
                break;
            case R.id.send:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new SendFragment()).commit();
                break;
        }
        return true;
    }
}