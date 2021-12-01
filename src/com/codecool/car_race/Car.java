package com.codecool.car_race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car extends Vehichle {
    private final byte NO_OF_NAME_COMPONENTS = 2;
    private final List<String> LIST_OF_CARNAMES = new ArrayList<>(Arrays.asList("Vulture", "Spirit", "Tempest", "Eminence",
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
            "Mystery"));
    private final int MIN_SPEED = 80;
    private final int MAX_SPEED = 110;


    public Car() {
        Random random = new Random();
        name = "";
        for (byte i = 0; i < NO_OF_NAME_COMPONENTS; i++) {
            name += LIST_OF_CARNAMES.get(random.nextInt(LIST_OF_CARNAMES.size())) + " ";
        }
        name = name.trim();
        normalSpeed = random.nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
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
        return "Car{" +
                "name='" + name + '\'' +
                ", actualSpeed=" + actualSpeed +
                ", normalSpeed=" + normalSpeed +
                ", distanceTraveled=" + distanceTraveled +
                '}';
    }
}
