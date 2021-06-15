package com.book.storiek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, email;
    Button submit;
    boolean isLogin = false;
    private static final String LOGIN = "login";
    String username_txt, email_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupViews();
    }

    private void setupViews() {
        username = findViewById(R.id.Username);
        submit = findViewById(R.id.Submit);
        //email = findViewById(R.id.email);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        switch (viewID) {
            case R.id.Submit:
                nameValidation();
                break;
        }
    }

    private void nameValidation() {
        username_txt = username.getText().toString().trim();
        //email_text = email.getText().toString().trim();
        //Boolean isEmail = email_text.contains("@gmail.com");
        if (username_txt.isEmpty()) {
            Toast.makeText(this, "نام کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show();
        }
        /*else if (email_text.isEmpty()) {
            Toast.makeText(this, "ایمیل را وارد کنید", Toast.LENGTH_SHORT).show();
        } else if (isEmail == false) {
            Toast.makeText(this, "ایمیل معتبر نیست", Toast.LENGTH_SHORT).show();
        }*/
        else {
            saveUsername();
        }

    }

    private void saveUsername() {

        isLogin = !isLogin;
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USERNAME", username_txt);
        //editor.putString("EMAIL", email_text);
        editor.putBoolean("ISLOGIN", isLogin);
        editor.apply();

        goToHome();

    }

    private void goToHome() {

        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}