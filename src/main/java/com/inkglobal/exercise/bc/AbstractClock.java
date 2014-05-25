package com.inkglobal.exercise.bc;

import com.google.common.base.Preconditions;
import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mmonti on 5/22/14.
 */
public abstract class AbstractClock implements Clock {

    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);

    private Date time = null;

    protected RepresentableTime representationStrategy = null;

    /**
     * @param representationStrategy
     */
    protected AbstractClock(final RepresentableTime representationStrategy) {
        this.representationStrategy = representationStrategy;
    }

    /**
     * @return
     */
    protected abstract String computeRepresentation();

    /**
     * @param time
     * @return
     */
    public String getTimeRepresentation(final String time) {
        Preconditions.checkNotNull(time, "time is null");
        Preconditions.checkArgument(!time.isEmpty(), "time is empty");

        try {
            this.time = formatter.parse(time);

        } catch (final ParseException e) {
            throw new RuntimeException("Error parsing the input time=["+time+"] with the format=["+DEFAULT_TIME_FORMAT+"]");
        }
        return computeRepresentation();
    }

    /**
     *
     * @param strategy
     * @return
     */
    @Override
    public Clock withStrategy(final ClockRepresentationStrategy strategy) {
        Preconditions.checkNotNull(strategy, "strategy is null");

        setRepresentationStrategy(strategy.getRepresentationStrategy());
        return this;
    }

    /**
     *
     * @return
     */
    public RepresentableTime getRepresentationStrategy() {
        return representationStrategy;
    }

    /**
     *
     * @param representationStrategy
     */
    protected void setRepresentationStrategy(RepresentableTime representationStrategy) {
        this.representationStrategy = representationStrategy;
    }

    /**
     * @return
     */
    protected Date getTime() {
        return time;
    }

}
