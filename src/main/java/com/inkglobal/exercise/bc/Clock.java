package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;

/**
 * Created by mmonti on 5/24/14.
 */
public interface Clock {

    /**
     *
     * @param time
     * @return
     */
    String getTimeRepresentation(final String time);

    /**
     *
     * @param strategy
     * @return
     */
    Clock withStrategy(final ClockRepresentationStrategy strategy);
}
