package com.example.babymanager;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_name")
public class NapData implements Serializable {

    //Create id column
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "napStartTime")
    private String start_nap;

    @ColumnInfo(name = "napStopTime")
    private String stop_nap;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStart_nap() {
        return start_nap;
    }

    public void setStart_nap(String start_nap) {
        this.start_nap = start_nap;
    }

    public String getStop_nap() {
        return stop_nap;
    }

    public void setStop_nap(String stop_nap) {
        this.stop_nap = stop_nap;
    }
}
