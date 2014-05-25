## Task:

Create a representation of the Berlin Clock for a given time (hh::mm:ss).

## Overview:

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that blinks on/off every two seconds. The time is calculated by adding rectangular lamps.

The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

The lamps are switched on from left to right.

## Test Scenarios

*** Reference: ***  (Y = Yellow, R = Red, O = Off)

**Input:** 00:00:00 - **Result:** Y OOOO OOOO OOOOOOOOOOO OOOO

**Input:** 13:17:01 - **Result:** O RROO RRRO YYROOOOOOOO YYOO

**Input:** 23:59:59 - **Result:** O RRRR RRRO YYRYYRYYRYY YYYY

**Input:** 24:00:00 - **Result:** Y RRRR RRRR OOOOOOOOOOO OOOO

## Build:

In order to build the project, follow these steps:

- Clone the git repository

```bash
~$ git clone git@github.com:mmonti/berlin-clock.git
```
- Run

```bash
~$ cd berlin-clock
~/berlin-clock$ mvn clean package
```

The previous steps genereate a jar file under: `./target/berlin-clock-1.0-SNAPSHOT.jar`

## Run:

To run and test the application:

```bash
~/berlin-clock$ cd target
~/berlin-clock/target$ java -jar berlin-clock-1.0-SNAPSHOT.jar -i 23:33:09 -p BERLIN
```

###Input Parameters:

 argument | required     | type    | description
:---------|:------------:|:-------:|:------------
 -i       | **required** | String  |  input time (any time with the following format: HH:mm:ss)
 -p       | optional     | String  | processing strategy (SIMPLE, BERLIN) - default: SIMPLE.


```
~/berlin-clock/target$ java -jar berlin-clock-1.0-SNAPSHOT.jar -i 00:00:00 -p Berlin
~/berlin-clock/target$ java -jar berlin-clock-1.0-SNAPSHOT.jar -i 13:17:01 -p berlin
~/berlin-clock/target$ java -jar berlin-clock-1.0-SNAPSHOT.jar -i 23:59:59 -p Berlin
~/berlin-clock/target$ java -jar berlin-clock-1.0-SNAPSHOT.jar -i 24:00:00 -p Berlin
```

## Notes

1. Argument -p is case insensitive.
2. To enable logs, change log level in `log4j.properties` to ***DEBUG***
