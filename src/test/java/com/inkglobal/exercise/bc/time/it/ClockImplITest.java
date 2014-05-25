package com.inkglobal.exercise.bc.time.it;

import com.inkglobal.exercise.bc.Clock;
import com.inkglobal.exercise.bc.ClockFactory;
import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import org.junit.Test;

import static com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy.BERLIN;
import static com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy.SIMPLE;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by mmonti on 5/25/14.
 */
public class ClockImplITest {

    private static final String simpleRepresentation = "23:33:9:0";
    private static final String berlinRepresentation = "O RRRR RRRO YYRYYROOOOO YYYO";
    private static final String input = "23:33:09";

    @Test
    public void testInstanceWithBerlinStrategy() throws Exception {
        final ClockRepresentationStrategy strategy = BERLIN;
        final Clock clock = ClockFactory.getInstance(strategy);

        final String representation = clock.getTimeRepresentation(input);

        assertNotNull(strategy);
        assertNotNull(clock);
        assertNotNull(representation);

        assertEquals(representation, berlinRepresentation);
    }

    @Test
    public void testInstanceWithSimpleStrategy() throws Exception {
        final ClockRepresentationStrategy strategy = SIMPLE;
        final Clock clock = ClockFactory.getInstance(strategy);

        final String representation = clock.getTimeRepresentation(input);

        assertNotNull(strategy);
        assertNotNull(clock);
        assertNotNull(representation);

        assertEquals(representation, simpleRepresentation);
    }

    @Test
    public void testInstanceSwitchingStrategies() throws Exception {
        final ClockRepresentationStrategy strategy = SIMPLE;
        final Clock clock = ClockFactory.getInstance(strategy);

        final String simple = clock.getTimeRepresentation(input);

        assertNotNull(strategy);
        assertNotNull(clock);
        assertNotNull(simple);

        assertEquals(simple, simpleRepresentation);

        final String berlin = clock.withStrategy(BERLIN).getTimeRepresentation(input);

        assertNotNull(strategy);
        assertNotNull(clock);
        assertNotNull(berlin);

        assertEquals(berlin, berlinRepresentation);
    }
}
