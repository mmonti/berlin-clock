package com.inkglobal.exercise.bc.time.ut;

import com.inkglobal.exercise.bc.time.MidnightTime;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mmonti on 5/24/14.
 */
public class MidnightTimeTest {

    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);

    private String beginingOfDay = null;
    private String midnight = null;

    @Before
    public void setUp() throws Exception {
        this.beginingOfDay = "00:00:00";
        this.midnight = "24:00:00";
    }

    @Test
    public void testIsNotMidnight() throws Exception {
        final DateTime time = new DateTime(formatter.parse(beginingOfDay));
        final MidnightTime midnightTime = new MidnightTime(time);

        assertFalse(midnightTime.isMidnight());
    }

    @Test
    public void testIsMidnight() throws Exception {
        final DateTime time = new DateTime(formatter.parse(midnight));
        final MidnightTime midnightTime = new MidnightTime(time);

        assertTrue(midnightTime.isMidnight());
    }
}
