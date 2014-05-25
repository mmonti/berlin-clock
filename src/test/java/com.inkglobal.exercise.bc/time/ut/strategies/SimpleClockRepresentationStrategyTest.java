package com.inkglobal.exercise.bc.time.ut.strategies;

import com.inkglobal.exercise.bc.strategies.SimpleRepresentationStrategy;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by mmonti on 5/25/14.
 */
public class SimpleClockRepresentationStrategyTest {

    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);

    private SimpleRepresentationStrategy strategy;

    private String hourZeroPattern = "0";
    private String hourThirteenPattern = "13";
    private String hourTwentyThreePattern = "23";
    private String hourTwentyFourPattern = "24";

    private String minuteSeventeenPattern = "17";
    private String minuteFiftyNinePattern = "59";
    private String minuteZeroPattern = "0";

    private String secondsOnePattern = "1";
    private String secondsFiftyNinePattern = "59";
    private String secondsZeroPattern = "0";

    private String millisecondsZeroPattern = "0";

    @Before
    public void setUp() throws Exception {
        this.strategy = new SimpleRepresentationStrategy();
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

    @Test
    public void testGetMillisecondsRepresentationZero() throws Exception {
        final DateTime time = new DateTime().withTime(0,0,0,0);
        final String representation = this.strategy.getMillisecondsRepresentation(time.toDate());

        assertNotNull(representation);
        assertEquals(representation, millisecondsZeroPattern);
    }

}
