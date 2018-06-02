package com.example.emma.lab3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM travel")
    List<Travel> getAllTravels();

    @Query("SELECT * FROM stops")
    List<Stops> getAllStops();

    @Insert
    void insertUsers(User... users);

    @Insert
    void insertStops(List<Stops> stops);

    @Insert
    void insertTravels(Travel... travels);

    @Delete
    void deleteUser(User user);

    @Delete
    void deleteStop(Stops stop);

    @Delete
    void deleteTravels(Travel travel);



}
