package com.dev.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDb extends SQLiteOpenHelper {

    private final static String DB_NAME = "local db";

    public LocalDb(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable = "CREATE TABLE user (id INTEGER PRIMARY KEY, name TEXT, city TEXT)";

        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do it later if i need it
    }



    public String insertUser(User user) {

        String checkIfUserExistQuery = "SELECT * FROM user ";

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(checkIfUserExistQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int dbId= cursor.getInt(cursor.getColumnIndex("id"));
                if (user.getId() == dbId) return "Already Exist !!";
            }while (cursor.moveToNext());
        }

        db.close();

        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", user.getId());
        values.put("name", user.getName());
        values.put("city", user.getCity());
        db.insert("user", null, values);
        db.close();

        return "Insert user with success";
    }
}
