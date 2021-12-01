package com.codecool.car_race;

public abstract class Vehicle {
    protected String name;
    protected int actualSpeed;  //specified in km/h
    protected int normalSpeed;  //specified in km/h
    protected int distanceTraveled;

    public String getName() {
        return name;
    }

    public abstract void prepareForLap();

    public abstract void moveForAnHour();
}
