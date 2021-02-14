package com.example.babymanager;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SleepData.class}, version = 2, exportSchema = false)
public abstract class RoomDBSleep extends RoomDatabase {

    private static RoomDBSleep database;
    private static String DATABASE_NAME = "database";
    public synchronized static RoomDBSleep getInstance(Context context){

        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDBSleep.class,DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return database;
    }

    public abstract SleepDao sleepDao();

}
