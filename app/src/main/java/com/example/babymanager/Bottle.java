package com.example.babymanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bottle {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "bottleDatetime")
    private String datetime;

    @ColumnInfo(name = "bottleAmount")
    private String amount;

    @ColumnInfo(name = "bottleSpinner")
    private String spinner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }
}
