package com.inkglobal.exercise.bc.strategies;

import com.google.common.base.Strings;
import com.inkglobal.exercise.bc.time.MidnightTime;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by mmonti on 5/23/14.
 */
public class BerlinRepresentationStrategy implements RepresentableTime {

    private static final String YELLOW = "Y";
    private static final String RED = "R";
    private static final String OFF = "O";
    private static final String SPACE = " ";
    private static final String EMPTY = "";

    /**
     *
     * @param time
     * @return
     */
    @Override
    public String computeRepresentation(final Date time) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append(getSecondsRepresentation(time)).append(SPACE);
        buffer.append(getHoursRepresentation(time)).append(SPACE);
        buffer.append(getMinutesRepresentation(time));

        return buffer.toString();
    }

    /**
     *
     * @param time
     * @return
     */
    @Override
    public String getHoursRepresentation(final Date time) {
        final DateTime dateTime = new DateTime(time);
        final StringBuffer buffer = new StringBuffer();
        int hourOfDay = dateTime.getHourOfDay();

        int blocks = (hourOfDay / 5);
        int modulus = (hourOfDay % 5);

        // = Joda Time does not distinguish between 24:00 and 00:00. We have to handle this specific case.
        if (hourOfDay == 0) {
            final MidnightTime midnightTime = new MidnightTime(dateTime);
            if (midnightTime.isMidnight()) {
                blocks = 24 / 5;
                modulus = 24 % 5;
            }
        }

        buffer.append(Strings.padEnd(Strings.padStart(EMPTY, blocks, RED.charAt(0)), 4, OFF.charAt(0)));
        buffer.append(SPACE);
        buffer.append(Strings.padEnd(Strings.padStart(EMPTY, modulus, RED.charAt(0)), 4, OFF.charAt(0)));

        return buffer.toString();
    }

    /**
     *
     * @param time
     * @return
     */
    @Override
    public String getMinutesRepresentation(final Date time) {
        final DateTime dateTime = new DateTime(time);
        int minutesOfHour = dateTime.getMinuteOfHour();
        int blocks = (minutesOfHour / 5);
        int modulus = (minutesOfHour % 5);

        final StringBuffer buffer = new StringBuffer();
        buffer.append(Strings.padEnd(Strings.padStart(EMPTY, blocks, YELLOW.charAt(0)), 11, OFF.charAt(0)));
        buffer.append(SPACE);
        buffer.append(Strings.padEnd(Strings.padStart(EMPTY, modulus, YELLOW.charAt(0)), 4, OFF.charAt(0)));

        if (blocks >= 3) {  // = First quarter.
            buffer.setCharAt(2, RED.charAt(0));
        }
        if (blocks >= 6) {  // = Half.
            buffer.setCharAt(5, RED.charAt(0));
        }
        if (blocks >= 9) {  // = Last quarter.
            buffer.setCharAt(8, RED.charAt(0));
        }
        return buffer.toString();
    }

    /**
     *
     * @param time
     * @return
     */
    @Override
    public String getSecondsRepresentation(final Date time) {
        return ((new DateTime(time).getSecondOfDay() % 2) == 0) ? YELLOW : OFF;
    }

    /**
     *
     * @param time
     * @return
     */
    @Override
    public String getMillisecondsRepresentation(final Date time) {
        throw new UnsupportedOperationException("Berlin Clock does not have milliseconds representation.");
    }

}
