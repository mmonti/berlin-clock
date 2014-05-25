package com.inkglobal.exercise.bc.time.it;

import com.inkglobal.exercise.bc.AbstractClock;
import com.inkglobal.exercise.bc.Clock;
import com.inkglobal.exercise.bc.ClockFactory;
import com.inkglobal.exercise.bc.strategies.BerlinRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;
import com.inkglobal.exercise.bc.strategies.SimpleRepresentationStrategy;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by mmonti on 5/25/14.
 */
public class ClockFactoryITest {

    @Test
    public void testCreateInstanceWithBasicStrategy() throws Exception {
        final Clock clock = ClockFactory.getInstance(ClockRepresentationStrategy.SIMPLE);
        final AbstractClock abstractClock = (AbstractClock) clock;
        final RepresentableTime strategy = abstractClock.getRepresentationStrategy();

        assertTrue(strategy instanceof SimpleRepresentationStrategy);
    }

    @Test
    public void testCreateInstanceWithBerlinStrategy() throws Exception {
        final Clock clock = ClockFactory.getInstance(ClockRepresentationStrategy.BERLIN);
        final AbstractClock abstractClock = (AbstractClock) clock;
        final RepresentableTime strategy = abstractClock.getRepresentationStrategy();

        assertTrue(strategy instanceof BerlinRepresentationStrategy);
    }
}
