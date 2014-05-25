package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.RepresentableTime;

/**
 * Created by mmonti on 5/23/14.
 */
public class ClockImpl extends AbstractClock {

    /**
     *
     * @param representationStrategy
     */
    public ClockImpl(final RepresentableTime representationStrategy) {
        super(representationStrategy);
    }

    /**
     *
     * @return
     */
    @Override
    protected String computeRepresentation() {
        return representationStrategy.computeRepresentation(getTime());
    }
}
