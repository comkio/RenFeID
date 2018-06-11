package com.example.emma.lab3;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.BoolRes;
import android.support.annotation.NonNull;

@Entity
public class User {

    @PrimaryKey (autoGenerate = true)
    int id; //rfid tag

    String name;

    String password;

    int login = 0;

    public User(int id, String name, String password){

        this.id = id;
        this.name = name;
        this.password = password;

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

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", login=" + login +
                '}';
    }
}
