package com.book.storiek;

import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.book.storiek.Adapter.MainAdapter;
import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    View view;
    TabLayout tabLayout;
    RtlViewPager viewPager;
    MainAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        setupViews();
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupViews() {
        tabLayout = view.findViewById(R.id.tab_layer_id);
        viewPager = view.findViewById(R.id.viewpager_id);
        adapter = new MainAdapter(getChildFragmentManager());
        adapter.addFragment(new TanzFragment(), "طنز");
        adapter.addFragment(new DiniFragment(), "مذهبی");
        adapter.addFragment(new MasalFragment(), "حکایات");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
