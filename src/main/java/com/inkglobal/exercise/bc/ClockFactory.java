package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;

/**
 * Created by mmonti on 5/24/14.
 */
public class ClockFactory {

    /**
     *
     * @param strategy
     * @return
     */
    public static Clock getInstance(final ClockRepresentationStrategy strategy) {
        final RepresentableTime representableTime = strategy.getRepresentationStrategy();
        return new ClockImpl(representableTime);
    }

}
