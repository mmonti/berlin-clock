package com.inkglobal.exercise.bc.time.ut;

import com.inkglobal.exercise.bc.ClockImpl;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;
import com.inkglobal.exercise.bc.strategies.SimpleRepresentationStrategy;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mmonti on 5/25/14.
 */
public class ClockImplTest {

    @Test
    public void testCreateInstance() throws Exception {
        final ClockImpl clock = new ClockImpl(new SimpleRepresentationStrategy());
        assertNotNull(clock);
    }

    @Test
    public void testGetStrategy() throws Exception {
        final ClockImpl clock = new ClockImpl(new SimpleRepresentationStrategy());
        final RepresentableTime representableTime = clock.getRepresentationStrategy();

        assertNotNull(clock);
        assertNotNull(representableTime);
        assertTrue(representableTime instanceof SimpleRepresentationStrategy);
    }

}
