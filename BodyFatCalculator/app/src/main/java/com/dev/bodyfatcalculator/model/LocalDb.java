package com.dev.bodyfatcalculator.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class}, version = 1, exportSchema = false)
public abstract class LocalDb extends RoomDatabase {

    private static LocalDb INSTANCE = null;

    public static synchronized LocalDb getInstance(Context context) {
        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder (
                    context, // Application Context
                    LocalDb.class, // Db Class
                    "body fat calculator database" // Database Name
            )
                    .build(); // Function responsable for creating db Instance
        }

        return INSTANCE;
    }

    public abstract ProfileDao profileDao();

}
