package com.example.babymanager;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaperDao {

    @Insert
    void insert(DiaperData diaperData);

    //Delete query
    @Delete
    void delete(DiaperData diaperData);

    @Query("SELECT * FROM table_name")
    List<DiaperData> getAll();
}
