package com.example.newest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Data_base extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "Fitness_App.db";
    final static int DATABASE_VERSION = 1;

    public Data_base(@Nullable Context context, @Nullable String name, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table records(" +
                "id text primary key," +
                "days text," +
                "calories text," +
                " steps text ," +
                "water text," +
                "sleeping text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DATABASE_NAME);
        onCreate(db);

    }
    public boolean insertUser(Records day_record) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("days",day_record.getDays());
        values.put("calories",day_record.getCalories());
        values.put("steps",day_record.getSteps());
        values.put("water",day_record.getWater());
        long result = db.insert(DATABASE_NAME, null, values);

        return result != -1;
    }
}
