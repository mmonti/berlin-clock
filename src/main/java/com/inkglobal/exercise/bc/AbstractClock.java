package com.inkglobal.exercise.bc;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Range;
import com.inkglobal.exercise.bc.exceptions.InvalidTimeRangeException;
import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import com.inkglobal.exercise.bc.strategies.RepresentableTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.collect.Iterables.*;

/**
 * Represents a clock abstraction and defines operations to compute time representation.
 *
 * Created by mmonti on 5/22/14.
 */
public abstract class AbstractClock implements Clock {

    private static final Logger logger = LoggerFactory.getLogger(AbstractClock.class);

    private static final String CONST_COLON = ":";
    private static final String CONST_ZERO = "0";
    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    private static final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);

    private Date time = null;

    protected RepresentableTime representationStrategy = null;

    /**
     * Defaults constructor.
     *
     * @param representableTime Strategy to use.
     */
    protected AbstractClock(final RepresentableTime representableTime) {
        if (logger.isDebugEnabled()) {
            logger.debug("Creating instance with strategy[{}]", representableTime.getClass());
        }
        setRepresentationStrategy(representableTime);
    }

    /**
     * @return
     */
    protected abstract String computeRepresentation();

    /**
     * @param time input time to represent.
     * @return String representation time.
     */
    public String getTimeRepresentation(final String time) {
        Preconditions.checkNotNull(time, "time is null");
        Preconditions.checkArgument(!time.isEmpty(), "time is empty");

        if (logger.isDebugEnabled()) {
            logger.debug("executing getTimeRepresentation[{}]", time);
        }

        checkTimeComponentsRange(time);

        try {
            this.time = formatter.parse(time);

        } catch (final ParseException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("Error parsing the input time=[{}] with the format=[{}]", time, DEFAULT_TIME_FORMAT);
            }

            throw new RuntimeException("Error parsing the input time=["+time+"] with the format=["+DEFAULT_TIME_FORMAT+"]");
        }
        return computeRepresentation();
    }

    /**
     * Check the range of hour, minute and seconds.
     * Throws an exception in case that any component of the time is out of range.
     *
     * @param time The given time.
     */
    private void checkTimeComponentsRange(final String time) {
        final Iterable<String> decomposedTime = Splitter.on(CONST_COLON).split(time);

        int hours = Integer.valueOf(getFirst(decomposedTime, CONST_ZERO)).intValue();
        int minutes = Integer.valueOf(get(decomposedTime, 1, CONST_ZERO)).intValue();
        int seconds = Integer.valueOf(getLast(decomposedTime)).intValue();

        if (!Range.closed(0, 24).contains(hours)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Component 'hours' is out of range. Expected=[{} - {}]. Found=[{}]", 0, 24, hours);
            }
            throw new InvalidTimeRangeException(hours, 0, 24);
        }

        if (!Range.closed(0, 59).contains(minutes)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Component 'minutes' is out of range. Expected=[{} - {}]. Found=[{}]", 0, 59, minutes);
            }
            throw new InvalidTimeRangeException(hours, 0, 59);
        }

        if (!Range.closed(0, 59).contains(seconds)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Component 'seconds' is out of range. Expected=[{} - {}]. Found=[{}]", 0, 59, minutes);
            }
            throw new InvalidTimeRangeException(hours, 0, 59);
        }
    }

    /**
     * Switch the strategy to use with the ClockImpl instance.
     *
     * @param strategy ClockRepresentationStrategy to use.
     * @return Clock instance with the new strategy.
     */
    @Override
    public Clock withStrategy(final ClockRepresentationStrategy strategy) {
        Preconditions.checkNotNull(strategy, "strategy is null");

        if (logger.isDebugEnabled()) {
            logger.debug("switching to strategy=[{}]", strategy.name());
        }

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
    protected void setRepresentationStrategy(final RepresentableTime representationStrategy) {
        this.representationStrategy = representationStrategy;
    }

    /**
     * @return
     */
    protected Date getTime() {
        return time;
    }

}
