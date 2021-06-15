package com.book.storiek;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    Intent intent;
    View view;
    Button setting, rate, about, share, res;
    TextView name, email;
    public static final String LOGIN = "login";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menu_fragment, container, false);
        setupViews();
        return view;
    }

    private void setupViews() {
        //email = view.findViewById(R.id.email_prf_id);
        name = view.findViewById(R.id.username_prf_id);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(LOGIN, Context.MODE_PRIVATE);
        name.setText(sharedPreferences.getString("USERNAME", null));
        //email.setText(sharedPreferences.getString("EMAIL", null));


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        about = getView().findViewById(R.id.about_btn);
        rate = getView().findViewById(R.id.rate_btn);
        share = getView().findViewById(R.id.share_btn);
        setting = getView().findViewById(R.id.setting_btn);
        res = getView().findViewById(R.id.res_btn);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "myket://comment?id=com.book.storiek";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.cus_dialog);
                dialog.show();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "myket://details?id=com.book.storiek";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}