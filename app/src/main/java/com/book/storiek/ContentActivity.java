package com.book.storiek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.book.storiek.Database.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView back;
    CircleImageView image;
    TextView name, field, disc;
    FloatingActionButton fab;
    Database db;
    int id, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setupViews();
        getAndSetData();
        favCondition();
        back.setOnClickListener(this);
        fab.setOnClickListener(this);

    }

    private void favCondition() {
        db = new Database(ContentActivity.this);
        value = db.fav_value(id);

        if (value == 0) {
            // NOT FAV
            fab.setImageResource(R.drawable.ic_like);
        } else if (value==1){
            // FAV
            fab.setImageResource(R.drawable.ic_liked);
        }
    }


    private void setupViews() {
        back = findViewById(R.id.back_btn);
        image = findViewById(R.id.image_id);
        name = findViewById(R.id.name_id);
        field = findViewById(R.id.field);
        disc = findViewById(R.id.dics_id);
        fab = findViewById(R.id.fab_id);
    }

    private void getAndSetData() {
        Intent intent = getIntent();
        name.setText(intent.getExtras().getString("NAME"));
        field.setText(intent.getExtras().getString("FIELD"));
        disc.setText(intent.getExtras().getString("DISC"));
        id = intent.getExtras().getInt("ID");
        String imageLink = intent.getExtras().getString("IMAGE");
        Picasso.with(ContentActivity.this).load(imageLink).resize(128, 128).into(image);

    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        switch (viewID) {

            case R.id.back_btn:

                onBackPressed();

                break;
            case R.id.fab_id:

                addOrRemoveFab();

                break;
        }
    }

    private void addOrRemoveFab() {
        db = new Database(ContentActivity.this);
        value = db.fav_value(id);

        if (value == 0) {
            // NOT FAV
            db.fav(1,id);
            fab.setImageResource(R.drawable.ic_liked);
            Toast.makeText(ContentActivity.this, "به لیست علاقه مندی ها اضافه شد",Toast.LENGTH_SHORT);
        } else {
            // FAV
            db.fav(0,id);
            fab.setImageResource(R.drawable.ic_like);
            Toast.makeText(ContentActivity.this, "از لیست علاقه مندی ها حذف شد",Toast.LENGTH_SHORT);
        }
    }
}