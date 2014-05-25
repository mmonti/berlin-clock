package com.inkglobal.exercise.bc.time;

import org.joda.time.DateTime;

/**
 * Utility class to define if we are parsing 00:00:00 or 24:00:00.
 * Since Joda Time does not distinguish between 24:00:00 or 00:00:00, we have to use getMillis() to calculate
 * if we are in the beginning of a day (00:00:00) or at the end of a day (24:00:00).
 *
 * Created by mmonti on 5/24/14.
 */
public class MidnightTime {

    private DateTime time = null;

    /**
     *
     * @param time
     */
    public MidnightTime(final DateTime time) {
        this.time = time;
    }

    /**
     * Defines if we are at the EOD or not.
     * @return true if we are parsing (24:00:00), false in another case.
     */
    public boolean isMidnight() {
        // = Maybe there is a better way to define if we are parsing a 24:00:00 or 00:00:00.
        // = Need more research on the usage of JodaTime.
        return this.time.getMillis() == 108000000;
    }
}
