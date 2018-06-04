package com.example.emma.lab3;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class, Stops.class, Travel.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase{

    public abstract MyDao myDao();

}
