package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;

/**
 *
 * Created by mmonti on 5/24/14.
 */
public interface Clock {

    /**
     * Computes the representation of a given time.
     *
     * @param time String input time in HH:mm:ss format.
     * @return String time representation.
     */
    String getTimeRepresentation(final String time);

    /**
     * Switch the strategy to use with the ClockImpl instance.
     *
     * @param strategy ClockRepresentationStrategy to use.
     * @return Clock instance with the new strategy.
     */
    Clock withStrategy(final ClockRepresentationStrategy strategy);
}
