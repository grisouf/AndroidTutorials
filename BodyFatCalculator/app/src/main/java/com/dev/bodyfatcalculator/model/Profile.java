package com.dev.bodyfatcalculator.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_profile") // "CREATE DATABASE tb_profile"
public class Profile {

    @PrimaryKey(autoGenerate = true) // "id PRIMARY KEY IDENTITY(1,1)"
    public int id;

    // @ColumnInfo(name = "Column Name", index = true)

    private int age;
    private double height;
    private double weight;
    private int gender;

    public Profile(int age, double height, double weight, int gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}
