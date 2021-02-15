package com.example.babymanager;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NapData.class}, version = 2, exportSchema = false)
public abstract class RoomDBNap extends RoomDatabase {

    private static RoomDBNap database;
    private static String DATABASE_NAME = "databaseN";
    public synchronized static RoomDBNap getInstance(Context context){

        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDBNap.class,DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return database;
    }

    public abstract NapDao napDao();
}
