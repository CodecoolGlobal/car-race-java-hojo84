package com.codecool.car_race;

import java.util.Random;

public class Truck extends Vehicle {
    private final int NORMAL_SPEED = 100;

    public Truck() {
        Random random = new Random();
        name = String.valueOf(random.nextInt(1001));
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

}
