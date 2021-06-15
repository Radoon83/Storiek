package com.book.storiek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ir.tapsell.sdk.Tapsell;
import ir.tapsell.sdk.TapsellAdRequestListener;
import ir.tapsell.sdk.TapsellAdRequestOptions;
import ir.tapsell.sdk.TapsellAdShowListener;
import ir.tapsell.sdk.TapsellShowOptions;

import static ir.tapsell.sdk.advertiser.TapsellAdActivity.AD_ID;

public class AboutActivity extends AppCompatActivity {
    com.google.android.material.button.MaterialButton contactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        contactUs = findViewById(R.id.contactUs);

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(AboutActivity.this);
                dialog.setContentView(R.layout.contact_dialog);
                dialog.show();

            }
        });
    }
}