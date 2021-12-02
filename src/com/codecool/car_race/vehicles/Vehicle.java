package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;

/**
 * Base class for all vehicles.  It is an abstract class meaning
 * - Instances of this class can't be created
 * - Methods can be left unimplemented
 */
public abstract class Vehicle {
    protected final String name;
    protected final int normalSpeed;  //specified in km/h
    protected int actualSpeed;  //specified in km/h
    protected int distanceTraveled;

    /**
     * Create a vehicle with the given name and normal speed.
     * NOTE: normalSpeed could also have a setter method like generateName(),
     * that would have been a good solution too
     *
     * @param normalSpeed normal travelling speed of this vehicle.
     */
    protected Vehicle(int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = normalSpeed;
    }

    /**
     * child classes should implement naming inside this method
     *
     * @return name of vehicle
     */
    protected abstract String generateName();

    /**
     * Prepare for the next hour: take the special events into consideration (broken truck etc)
     * Implemented per subclass
     *
     * @param race instance of the currently ongoing race
     */
    public abstract void prepareForLap(Race race);

    /**
     * Simulate the vehicle for one hour. Only updates the travelled distance,
     * actual speed should be updated before calling this method
     */
    public final void moveForAnHour() {
        distanceTraveled += actualSpeed;
    }

    /**
     * Return the textual representation of this vehicle.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("name:").append(name);
        sb.append(", type:").append(getClass().getSimpleName());
        sb.append(", distanceTraveled:").append(distanceTraveled);
        sb.append('}');
        return sb.toString();
    }
}
