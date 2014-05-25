package com.inkglobal.exercise.bc.time.ut.strategies;

import com.inkglobal.exercise.bc.strategies.BerlinRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;
import com.inkglobal.exercise.bc.strategies.SimpleRepresentationStrategy;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mmonti on 5/25/14.
 */
public class ClockRepresentationStrategyTest {

    @Test
    public void testGetBerlinRepresentationStrategy() throws Exception {
        final ClockRepresentationStrategy representationStrategy = ClockRepresentationStrategy.BERLIN;
        final RepresentableTime instance = representationStrategy.getRepresentationStrategy();

        assertNotNull(representationStrategy);
        assertNotNull(instance);
        assertTrue(instance instanceof BerlinRepresentationStrategy);
    }

    @Test
    public void testGetSimpleRepresentationStrategy() throws Exception {
        final ClockRepresentationStrategy representationStrategy = ClockRepresentationStrategy.SIMPLE;
        final RepresentableTime instance = representationStrategy.getRepresentationStrategy();

        assertNotNull(representationStrategy);
        assertNotNull(instance);
        assertTrue(instance instanceof SimpleRepresentationStrategy);
    }
}
