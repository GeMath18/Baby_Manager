package com.example.babymanager;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BottleDao {

    //Insert query
    void insert(Bottle bottle);

    //Delete query
    void delete(Bottle bottle);

    @Query("select * from bottle")
    List<Bottle>getAll();


}
