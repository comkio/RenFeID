package com.example.emma.lab3;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey (autoGenerate = true)
    int id; //rfid tag

    String name;

    String password;

    boolean login;

    public User(int id, String name, String password, boolean login){

        this.id = id;
        this.name = name;
        this.password = password;
        this.login = login;

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

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
