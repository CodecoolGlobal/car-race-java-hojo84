package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Truck extends Vehicle {
    private static final int NORMAL_SPEED = 100;
    private static final int BREAKDOWN_CHANCE = 5;
    private static final int TURNS_NEEDED_TO_FIX_TRUCK = 2;
    private int breakDownTurnsLeft;

    /**
     * Trucks start out in an operational state.
     */
    private State state = State.OPERATIONAL;

    /**
     * Possible states a truck can be in.
     * <p>
     * It is embedded inside the truck class.
     */
    private enum State {
        OPERATIONAL,
        BROKEN_DOWN
    }

    public Truck() {
        super(NORMAL_SPEED);
    }

    /**
     * Generate name by converting a random integer to string
     *
     * @return the name of the truck
     */
    @Override
    protected String generateName() {
        return Integer.toString(RandomHelper.nextInt(1001));
    }

    /**
     * Calculate the actual speed and also advance the state of the truck.
     */
    @Override
    public void prepareForLap(Race race) {
        if (isBrokenDown()) actualSpeed = 0;
        else actualSpeed = NORMAL_SPEED;
        state = nextState();
    }

    /**
     * Determine whether this truck is operational.
     *
     * @return true if this truck is broken down.
     */
    public boolean isBrokenDown() {
        return state != State.OPERATIONAL;
    }

    /**
     * A state machine implementation.
     *
     * @return the state following this state.
     */
    private State nextState() {
        switch (state) {
            case OPERATIONAL:
                if (RandomHelper.eventWithChance(BREAKDOWN_CHANCE)) {
                    breakDownTurnsLeft = TURNS_NEEDED_TO_FIX_TRUCK;
                    return State.BROKEN_DOWN;
                }
                break;
            case BROKEN_DOWN:
                if (breakDownTurnsLeft-- > 0) {
                    return State.BROKEN_DOWN;
                }
                break;
        }
        return State.OPERATIONAL;
    }
}
