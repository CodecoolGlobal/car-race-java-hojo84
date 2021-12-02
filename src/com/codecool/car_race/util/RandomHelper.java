package com.codecool.car_race.util;

import java.util.Random;

public class RandomHelper {
    private static final Random RANDOM = new Random();

    /**
     * No point in making instances of this class.
     */
    private RandomHelper() {
    }

    /**
     * Generate a random integer from a given range.
     *
     * @param upperBound upper limit of the range.
     * @return a random number between 0 and an upper bound.
     */
    public static int nextInt(int upperBound) {
        return RANDOM.nextInt(upperBound);
    }

    /**
     * Choose a random element from an array of strings.
     *
     * @param carNames array of strings to choose from.
     * @return the chosen string.
     */
    public static String chooseOne(String[] carNames) {
        if (carNames == null || carNames.length < 1) {
            final String message = "List of car names should be a non-empty array of strings";
            throw new IllegalArgumentException(message);
        }
        return carNames[nextInt(carNames.length)];
    }

    /**
     * Generate a random integer from a given range.
     *
     * @param lower lower limit of the range.
     * @param upper upper limit of the range.
     * @return a random number between a lower and an upper bound.
     */
    public static int nextInt(int lower, int upper) {
        return nextInt(upper - lower + 1) + lower;
    }

    /**
     * Determine whether an event has occurred given the chance for it.
     *
     * @param chance the chance of the event happening in percents.
     * @return true if the event has happened.
     */
    public static boolean eventWithChance(int chance) {
        return RANDOM.nextInt(100) < chance;
    }
}
