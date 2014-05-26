package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;

/**
 * ClockImpl Factory.
 *
 * Created by mmonti on 5/24/14.
 */
public class ClockFactory {

    /**
     * Creates an instance of ClockImpl with the specified strategy.
     *
     * @param strategy strategy to delegate the representation of time.
     * @return ClockImpl instance.
     */
    public static Clock getInstance(final ClockRepresentationStrategy strategy) {
        final RepresentableTime representableTime = strategy.getRepresentationStrategy();
        return new ClockImpl(representableTime);
    }

}
