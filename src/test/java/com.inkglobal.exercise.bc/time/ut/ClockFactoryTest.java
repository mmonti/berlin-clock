package com.inkglobal.exercise.bc.time.ut;

import com.inkglobal.exercise.bc.Clock;
import com.inkglobal.exercise.bc.ClockFactory;
import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by mmonti on 5/25/14.
 */
public class ClockFactoryTest {

    @Test(expected = NullPointerException.class)
    public void testCreateInstanceNullStrategy() throws Exception {
        ClockFactory.getInstance(null);
    }

    @Test
    public void testCreateInstanceWithStrategy() throws Exception {
        final Clock clock = ClockFactory.getInstance(ClockRepresentationStrategy.SIMPLE);
        assertNotNull(clock);
    }
}
