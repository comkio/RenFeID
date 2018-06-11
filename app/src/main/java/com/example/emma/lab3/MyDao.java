package com.example.emma.lab3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT COUNT(*) FROM user")
    int numUsers();

    @Query("SELECT * FROM travel")
    List<Travel> getAllTravels();

    @Query("SELECT * FROM travel WHERE userId = :user")
    List<Travel> getAllTravelsByUser(int user);

    @Query("SELECT id FROM travel WHERE userId = :user AND status LIKE 1")
    int getOngoingTravelByUser(int user);

    @Query("SELECT name FROM stops WHERE id = :id")
    String getStopNameById(int id);

    @Query("SELECT * FROM stops")
    List<Stops> getAllStops();

    @Query("SELECT id FROM user WHERE login is 1")
    int getUserLogged();

    @Query("SELECT id FROM travel WHERE status LIKE 1")
    int getTravelInitiated();

    @Query("SELECT COUNT(*) FROM stops")
    int numStops();

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
