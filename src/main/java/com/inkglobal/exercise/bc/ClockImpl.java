package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.RepresentableTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defaults Clock implementation. Relies on the specified strategy to represent the desired time.
 *
 * Created by mmonti on 5/23/14.
 */
public class ClockImpl extends AbstractClock {

    private static final Logger logger = LoggerFactory.getLogger(ClockImpl.class);

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
        final String representation = representationStrategy.computeRepresentation(getTime());

        if (logger.isDebugEnabled()) {
            logger.debug("Time=[{}], Representation=[{}]", getTime(), representation);
        }

        return representation;
    }
}
