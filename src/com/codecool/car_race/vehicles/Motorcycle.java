package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Motorcycle extends Vehicle {
    private static final int NORMAL_SPEED = 100;
    private static int instanceCounter = 1;

    public Motorcycle() {
        super(NORMAL_SPEED);
    }

    /**
     * Generate name using the word 'Motorcycle' followed by a serial number
     *
     * @return name of the motorcycle
     */
    @Override
    protected String generateName() {
        return "Motorcycle" + instanceCounter++;
    }

    /**
     * Motorcycles go with their normal speed. In case of rain they
     * have to slow down.
     *
     * @param race instance of the current race from where we can access data
     *             for example weather conditions and broken truck info
     */
    @Override
    public void prepareForLap(Race race) {
        actualSpeed = normalSpeed;
        if (race.isRaining()) {
            int slowDown = RandomHelper.nextInt(5, 50);
            actualSpeed -= slowDown;
        }
    }

}
