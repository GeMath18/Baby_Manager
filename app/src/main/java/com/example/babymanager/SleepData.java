package com.example.babymanager;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_sleep")
public class SleepData implements Serializable {
    //Create id column
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "sleepDatetime")
    private String datetime;

    @ColumnInfo(name = "sleepTime")
    private String sleep_time;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getSleep_time() {
        return sleep_time;
    }

    public void setSleep_time(String sleep_time) {
        this.sleep_time = sleep_time;
    }
}
