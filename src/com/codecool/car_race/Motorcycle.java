package com.codecool.car_race;

public class Motorcycle extends Vehichle {
    private final int NORMAL_SPEED = 100;
    private static int instanceCounter = 1;

    public Motorcycle() {
        name = "Motorcycle " + instanceCounter;
        instanceCounter++;
        normalSpeed = NORMAL_SPEED;
        actualSpeed = 0;
        distanceTraveled = 0;
    }

    @Override
    public void prepareForLap() {
        actualSpeed = normalSpeed;
    }

    @Override
    public void moveForAnHour() {
        distanceTraveled += actualSpeed;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "name='" + name + '\'' +
                ", actualSpeed=" + actualSpeed +
                ", normalSpeed=" + normalSpeed +
                ", distanceTraveled=" + distanceTraveled +
                '}';
    }
}
