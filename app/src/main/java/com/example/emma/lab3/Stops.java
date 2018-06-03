package com.example.emma.lab3;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Stops {

    @PrimaryKey
    int id;

    String name;

    String ip;

    public Stops(int id, String name, String ip){

        this.id = id;
        this.name = name;
        this.ip = ip;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
