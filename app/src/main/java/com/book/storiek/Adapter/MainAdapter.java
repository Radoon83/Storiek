package com.book.storiek.Adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends FragmentPagerAdapter {
    private List<String> lstTitle = new ArrayList<>();
    private List<Fragment> lstFragment = new ArrayList<>();

    public MainAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return lstFragment.get(i);
    }

    @Override
    public int getCount() {
        return lstTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitle.get(position);
    }
    public void addFragment(Fragment fragment, String title){
        lstFragment.add(fragment);
        lstTitle.add(title);
    }
}
