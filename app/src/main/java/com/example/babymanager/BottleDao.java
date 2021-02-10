package com.example.babymanager;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BottleDao {


    //Insert query
    @Insert
    void insert(Bottle bottle);

    //Delete query
    @Delete
    void delete(Bottle bottle);

    @Query("SELECT * FROM bottle")
    List<Bottle> getAll();


}
