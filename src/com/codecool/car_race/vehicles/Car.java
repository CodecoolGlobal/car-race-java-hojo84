package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Car extends Vehicle {
    private static final String[] LIST_OF_CAR_NAMES = {
            "Vulture",
            "Spirit",
            "Tempest",
            "Eminence",
            "Striker",
            "Spire",
            "Whim",
            "Whirlpool",
            "Mystery",
            "Icon", "Essence",
            "Dynamics",
            "Motive",
            "Realm",
            "Treasure",
            "Quicksilver",
            "Crown",
            "Inquiry",
            "Phantom",
            "Mystery"
    };
    private static final int MIN_SPEED = 80;
    private static final int MAX_SPEED = 110;
    private static final int YELLOW_FLAG_SPEED = 75;


    /**
     * Create a car.
     * <p>
     * The call to the parent class' constructor has to be the first
     * thing the constructor does.  But we have to pass data to it.
     * We solve this by calling two static methods because both values
     * are calculated per instance.
     */
    public Car() {
        super(calculateNormalSpeed());
    }

    /**
     * The normal speed of the car determined by random.
     *
     * @return a value between 80 and 110 inclusive.
     */
    private static int calculateNormalSpeed() {
        return RandomHelper.nextInt(MIN_SPEED, MAX_SPEED);
    }

    @Override
    protected String generateName() {
        String firstName = RandomHelper.chooseOne(LIST_OF_CAR_NAMES);
        String lastName = RandomHelper.chooseOne(LIST_OF_CAR_NAMES);
        return firstName + " " + lastName;
    }

    /**
     * If there is a broken truck on the track the actual speed is limited
     *
     * @param race instance of the current race from where we can access data
     *             for example weather conditions and broken truck info
     */
    @Override
    public void prepareForLap(Race race) {
        if (race.isYellowFlagActive()) actualSpeed = YELLOW_FLAG_SPEED;
        else actualSpeed = normalSpeed;
    }

}
