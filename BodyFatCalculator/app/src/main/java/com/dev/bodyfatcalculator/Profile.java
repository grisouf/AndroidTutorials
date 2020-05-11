package com.dev.bodyfatcalculator;

public class Profile {

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
