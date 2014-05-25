package com.inkglobal.exercise.bc.strategies;

import java.util.Date;

/**
 * Created by mmonti on 5/23/14.
 */
public interface RepresentableTime {

    /**
     *
     * @param time
     * @return
     */
    String computeRepresentation(final Date time);

    /**
     *
     * @param time
     * @return
     */
    String getHoursRepresentation(final Date time);

    /**
     *
     * @param time
     * @return
     */
    String getMinutesRepresentation(final Date time);

    /**
     *
     * @param time
     * @return
     */
    String getSecondsRepresentation(final Date time);

    /**
     *
     * @param time
     * @return
     */
    String getMillisecondsRepresentation(final Date time);
}
