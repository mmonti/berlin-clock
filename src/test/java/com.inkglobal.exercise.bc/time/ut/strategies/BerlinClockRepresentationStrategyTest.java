package com.inkglobal.exercise.bc.time.ut.strategies;

import com.inkglobal.exercise.bc.strategies.BerlinRepresentationStrategy;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by mmonti on 5/25/14.
 */
public class BerlinClockRepresentationStrategyTest {

    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);

    private BerlinRepresentationStrategy strategy;

    private String hourZeroPattern = "OOOO OOOO";
    private String hourThirteenPattern = "RROO RRRO";
    private String hourTwentyThreePattern = "RRRR RRRO";
    private String hourTwentyFourPattern = "RRRR RRRR";

    private String minuteSeventeenPattern = "YYROOOOOOOO YYOO";
    private String minuteFiftyNinePattern = "YYRYYRYYRYY YYYY";
    private String minuteZeroPattern = "OOOOOOOOOOO OOOO";

    private String secondsOnePattern = "O";
    private String secondsFiftyNinePattern = "O";
    private String secondsZeroPattern = "Y";

    @Before
    public void setUp() throws Exception {
        this.strategy = new BerlinRepresentationStrategy();
    }

    @Test
    public void testGetHoursRepresentationZero() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,0,0);
        final String representation = this.strategy.getHoursRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, hourZeroPattern);
    }

    @Test
    public void testGetHoursRepresentationThirteen() throws Exception {
        final DateTime time = new DateTime().withTime(13,0,0,0);
        final String representation = this.strategy.getHoursRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, hourThirteenPattern);
    }

    @Test
    public void testGetHoursRepresentationTwentyThree() throws Exception {
        final DateTime time = new DateTime().withTime(23,0,0,0);
        final String representation = this.strategy.getHoursRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, hourTwentyThreePattern);
    }

    @Test
    public void testGetHoursRepresentationTwentyFour() throws Exception {
        // = Using formatter to parse 24:00:00 since Joda Time doesn't
        // = have support to parse 24:00:00
        final DateTime time = new DateTime(formatter.parse("24:00:00"));
        final String representation = this.strategy.getHoursRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, hourTwentyFourPattern);
    }

    @Test
    public void testGetMinutesRepresentationSeventeen() throws Exception {
        final DateTime time = new DateTime().withTime(0,17,0,0);
        final String representation = this.strategy.getMinutesRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, minuteSeventeenPattern);
    }

    @Test
    public void testGetMinutesRepresentationFiftyNine() throws Exception {
        final DateTime time = new DateTime().withTime(0,59,0,0);
        final String representation = this.strategy.getMinutesRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, minuteFiftyNinePattern);
    }

    @Test
    public void testGetMinutesRepresentationZero() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,0,0);
        final String representation = this.strategy.getMinutesRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, minuteZeroPattern);
    }

    @Test
    public void testGetSecondsRepresentationZero() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,0,0);
        final String representation = this.strategy.getSecondsRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, secondsZeroPattern);
    }

    @Test
    public void testGetSecondsRepresentationOne() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,1,0);
        final String representation = this.strategy.getSecondsRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, secondsOnePattern);
    }

    @Test
    public void testGetSecondsRepresentationFiftyNine() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,59,0);
        final String representation = this.strategy.getSecondsRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, secondsFiftyNinePattern);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetMillisecondsRepresentation() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,0,0);
        final String representation = this.strategy.getMillisecondsRepresentation(time.toDate());
    }

}
