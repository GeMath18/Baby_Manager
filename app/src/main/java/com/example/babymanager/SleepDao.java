package com.example.babymanager;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SleepDao {

    @Insert
    void insert(SleepData sleepData);

    //Delete query
    @Delete
    void delete(SleepData sleepData);

    @Query("SELECT * FROM table_name")
    List<SleepData> getAll();


}
