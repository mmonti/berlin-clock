package com.inkglobal.exercise.bc.strategies;

import com.google.common.base.Strings;
import com.inkglobal.exercise.bc.time.MidnightTime;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Berlins Clock Representation Strategy.
 *
 * The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is
 * a yellow lamp that blinks on/off every two seconds. The time is calculated by adding rectangular lamps.
 *
 * The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps.
 * Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour.
 * So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
 *
 * The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps,
 * the second 4. In the first row every lamp represents 5 minutes.
 * In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last
 * quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.
 *
 * The lamps are switched on from left to right.
 *
 * Created by mmonti on 5/23/14.
 */
public class BerlinRepresentationStrategy implements RepresentableTime {

    private static final Logger logger = LoggerFactory.getLogger(BerlinRepresentationStrategy.class);

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
            boolean isMidnight = midnightTime.isMidnight();

            if (logger.isDebugEnabled()) {
                logger.debug("hourOfDay equals 0. MidnightTime.isMidnight=[{}]", isMidnight);
            }

            if (midnightTime.isMidnight()) {
                blocks = 24 / 5;
                modulus = 24 % 5;
            }
        }

        buffer.append(Strings.padEnd(Strings.padStart(EMPTY, blocks, RED.charAt(0)), 4, OFF.charAt(0)));
        buffer.append(SPACE);
        buffer.append(Strings.padEnd(Strings.padStart(EMPTY, modulus, RED.charAt(0)), 4, OFF.charAt(0)));

        if (logger.isDebugEnabled()) {
            logger.debug("getHoursRepresentation=[{}]", buffer.toString());
        }

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

        if (logger.isDebugEnabled()) {
            logger.debug("getMinutesRepresentation=[{}]", buffer.toString());
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
        final String seconds = ((new DateTime(time).getSecondOfDay() % 2) == 0) ? YELLOW : OFF;

        if (logger.isDebugEnabled()) {
            logger.debug("getSecondsRepresentation=[{}]", seconds);
        }

        return seconds;
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
