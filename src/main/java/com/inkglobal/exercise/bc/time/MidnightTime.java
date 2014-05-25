package com.inkglobal.exercise.bc.time;

import org.joda.time.DateTime;

/**
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

    public boolean isMidnight() {
        return this.time.getMillis() == 108000000;
    }
}
