package com.book.storiek.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.book.storiek.Model.Story;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    Context context;

    public Database(Context context) {
        super(context, info_db.DATABASE_NAME, null, info_db.DATABASE_VERSION);
        this.context = context;
        isDatabase();
    }

    private void isDatabase() {

        File check = new File(info_db.PACKAGE);
        if (check.exists()) {

        } else {
            check.mkdir();
        }
        check = context.getDatabasePath(info_db.DATABASE_NAME);
        if (check.exists()) {

        } else {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(info_db.DATABASE_SOURCE);

        String outFileName = info_db.PACKAGE + info_db.DATABASE_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public List<Story> getAllStory() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Story> data = new ArrayList<>();
        String query = "SELECT * FROM story";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Story story = new Story();
                story.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                story.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                story.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                story.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                story.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                story.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                story.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                data.add(story);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Story> getTanzStory() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Story> data = new ArrayList<>();
        String query = "SELECT * FROM story WHERE category='tanz'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Story story = new Story();
                story.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                story.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                story.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                story.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                story.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                story.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                story.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                data.add(story);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Story> getMasalStory() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Story> data = new ArrayList<>();
        String query = "SELECT * FROM story WHERE category='masal'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Story story = new Story();
                story.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                story.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                story.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                story.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                story.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                story.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                story.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                data.add(story);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return data;
    }

    public List<Story> getDiniStory() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Story> data = new ArrayList<>();
        String query = "SELECT * FROM story WHERE category='dini'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Story story = new Story();
                story.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                story.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                story.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                story.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                story.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                story.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                story.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                data.add(story);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return data;

    }

    public List<Story> getFavStory() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Story> data = new ArrayList<>();
        String query = "SELECT * FROM story WHERE fav = 1";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Story story = new Story();
                story.setId(cursor.getInt(cursor.getColumnIndex(info_db.DATA_ID)));
                story.setCategory(cursor.getString(cursor.getColumnIndex(info_db.DATA_CATEGORY)));
                story.setName(cursor.getString(cursor.getColumnIndex(info_db.DATA_NAME)));
                story.setField(cursor.getString(cursor.getColumnIndex(info_db.DATA_FIELD)));
                story.setFav(cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV)));
                story.setImage(cursor.getString(cursor.getColumnIndex(info_db.DATA_IMAGE)));
                story.setDisc(cursor.getString(cursor.getColumnIndex(info_db.DATA_DISC)));
                data.add(story);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return data;

    }

    public int fav_value(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + info_db.DATA_FAV + " FROM story WHERE " + info_db.DATA_ID + "=" + id + "";
        int value = 0;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            value = cursor.getInt(cursor.getColumnIndex(info_db.DATA_FAV));
            do {
            } while (cursor.moveToNext());

        }
        db.close();
        return value;
    }

    public void fav(int status, int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "UPDATE story SET " + info_db.DATA_FAV + "=" + status + " WHERE " + info_db.DATA_ID + "=" + id + "";
        db.execSQL(query);
        db.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
