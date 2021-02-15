package com.example.babymanager;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NapDao {

    @Insert
    void insert(NapData napData);

    @Delete
    void delete(NapData napData);

    @Query("SELECT * FROM table_name")
    List<NapData> getAll();
}
