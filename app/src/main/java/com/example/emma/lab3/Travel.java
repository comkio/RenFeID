package com.example.emma.lab3;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Travel {

    @PrimaryKey (autoGenerate = true)
    int id;

    String idFrom;

    String idTo;

    boolean status;

    double cost;

    int userId;

    public Travel(int id, String idFrom, String idTo, boolean status, double cost, int userId) {
        this.id = id;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.status = status;
        this.cost = cost;
        this.userId = userId;
    }

    public Travel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
