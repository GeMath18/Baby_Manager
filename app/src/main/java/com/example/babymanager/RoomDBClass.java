package com.example.babymanager;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Bottle.class}, version = 2)
public abstract class RoomDBClass extends RoomDatabase {

    public abstract BottleDao bottleDao();
}
