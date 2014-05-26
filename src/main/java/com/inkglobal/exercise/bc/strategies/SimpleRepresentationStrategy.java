package com.inkglobal.exercise.bc.strategies;

import com.inkglobal.exercise.bc.time.MidnightTime;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Simple Clock Representation Strategy.
 * Just returns the input time with the format: HH:m:s
 *
 * Created by mmonti on 5/23/14.
 */
public class SimpleRepresentationStrategy implements RepresentableTime {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRepresentationStrategy.class);

    private static final String COLON = ":";

    /**
     * Compute the time representation.
     *
     * @param time to compute.
     * @return String representation of the given time.
     */
    @Override
    public String computeRepresentation(final Date time) {
        final StringBuffer buffer = new StringBuffer();
        buffer.append(getHoursRepresentation(time)).append(COLON);
        buffer.append(getMinutesRepresentation(time)).append(COLON);
        buffer.append(getSecondsRepresentation(time)).append(COLON);
        buffer.append(getMillisecondsRepresentation(time));

        return buffer.toString();
    }

    /**
     * Compute the hours representation.
     *
     * @param time to compute the hours.
     * @return String representation of hours.
     */
    @Override
    public String getHoursRepresentation(final Date time) {
        final DateTime dateTime = new DateTime(time);
        int hourOfDay = dateTime.getHourOfDay();

        // = hourOfDay equals 0 means that it can be the beginning of day (00:00:00)
        // = or midnight (24:00:00).
        if (hourOfDay == 0) {
            final MidnightTime midnightTime = new MidnightTime(dateTime);
            final boolean isMidnight = midnightTime.isMidnight();

            if (logger.isDebugEnabled()) {
                logger.debug("hourOfDay equals 0. MidnightTime.isMidnight=[{}]", isMidnight);
            }

            hourOfDay = (isMidnight ? 24 : hourOfDay);
        }

        final String representation = String.valueOf(hourOfDay);

        if (logger.isDebugEnabled()) {
            logger.debug("getHoursRepresentation=[{}]", representation);
        }
        return representation;
    }

    /**
     * Compute the minutes representation.
     *
     * @param time to compute the minutes.
     * @return String representation of minutes
     */
    @Override
    public String getMinutesRepresentation(final Date time) {
        final String representation = String.valueOf(new DateTime(time).getMinuteOfHour());

        if (logger.isDebugEnabled()) {
            logger.debug("getMinutesRepresentation=[{}]", representation);
        }
        return representation;
    }

    /**
     * Compute the seconds representation.
     *
     * @param time to compute the seconds.
     * @return String representation of seconds.
     */
    @Override
    public String getSecondsRepresentation(final Date time) {
        final String representation = String.valueOf(new DateTime(time).getSecondOfMinute());

        if (logger.isDebugEnabled()) {
            logger.debug("getSecondsRepresentation=[{}]", representation);
        }
        return representation;
    }

    /**
     * Compute the milliseconds representation.
     * 
     * @param time to compute the milliseconds.
     * @return String representation of milliseconds
     */
    @Override
    public String getMillisecondsRepresentation(final Date time) {
        final String representation = String.valueOf(new DateTime(time).getMillisOfSecond());

        if (logger.isDebugEnabled()) {
            logger.debug("getMillisecondsRepresentation=[{}]", representation);
        }
        return representation;
    }
}
