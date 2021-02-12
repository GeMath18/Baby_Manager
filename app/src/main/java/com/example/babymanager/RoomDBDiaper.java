package com.example.babymanager;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DiaperData.class}, version = 2, exportSchema = false)
public abstract class RoomDBDiaper extends RoomDatabase {

    private static RoomDBDiaper database;
    private static String DATABASE_NAME = "database";
    public synchronized static RoomDBDiaper getInstance(Context context){

        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDBDiaper.class,DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return database;
    }

    public abstract DiaperDao diaperDao();
}
