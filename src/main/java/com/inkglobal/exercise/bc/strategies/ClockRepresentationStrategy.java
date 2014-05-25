package com.inkglobal.exercise.bc.strategies;

/**
 * Created by mmonti on 5/24/14.
 */
public enum ClockRepresentationStrategy {

    /**
     * Simple Representation.
     */
    SIMPLE(new SimpleRepresentationStrategy()),

    /**
     * Berlin's Clock representation.
     */
    BERLIN(new BerlinRepresentationStrategy());

    private RepresentableTime representationStrategy;

    /**
     *
     * @param representationStrategy
     */
    private ClockRepresentationStrategy(RepresentableTime representationStrategy) {
        this.representationStrategy = representationStrategy;
    }

    /**
     *
     * @return
     */
    public RepresentableTime getRepresentationStrategy() {
        return representationStrategy;
    }
}
