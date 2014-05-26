package com.inkglobal.exercise.bc.exceptions;

/**
 * Created by mmonti on 5/26/14.
 */
public class InvalidTimeRangeException extends RuntimeException {

    /**
     * @param component time component (hour, minute, second).
     * @param expectedLowerBound lower bound
     * @param expectedUpperBound upper bound
     */
    public InvalidTimeRangeException(int component, int expectedLowerBound, int expectedUpperBound) {
        super("Component is out of range. Expected=["+expectedLowerBound+"-"+expectedUpperBound+"]. Found=["+component+"]");
    }

}
