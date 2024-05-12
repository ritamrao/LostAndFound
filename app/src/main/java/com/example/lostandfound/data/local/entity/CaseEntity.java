package com.example.lostandfound.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "your_table_name")
public class CaseEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public String name;
    private String status;
    private String phone;
    private String description;
    private String date;
    private String location;

    // Constructor
    public CaseEntity(String name,String status, String phone, String description, String date, String location) {
        this.name = name;
        this.status = status;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
