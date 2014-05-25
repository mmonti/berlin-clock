package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Created by mmonti on 5/25/14.
 */
public class Main {

    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final Options options = new Options();
        options.addOption("i", true, "[input] input time");
        options.addOption("p", true, "[input] processing strategy (SIMPLE, BERLIN) - default: SIMPLE");

        final CommandLineParser parser = new BasicParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);

        } catch (ParseException pe) {
            usage(options);
            return;
        }

        if (!cmd.hasOption("i")) {
            usage(options);
            return;

        } else {
            ClockRepresentationStrategy strategy = ClockRepresentationStrategy.SIMPLE;
            if (cmd.hasOption('p')) {
                final String processingStrategy = cmd.getOptionValue('p');
                strategy = ClockRepresentationStrategy.valueOf(processingStrategy.toUpperCase());
            }

            final Clock clock = ClockFactory.getInstance(strategy);
            System.out.println("Processing...");
            System.out.println("-------------");
            System.out.println("Input: " + cmd.getOptionValue('i'));
            System.out.println("Processing Strategy: " + strategy);
            System.out.println("Output: " + clock.getTimeRepresentation(cmd.getOptionValue('i')));
        }
    }

    /**
     *
     * @param options
     */
    private static void usage(final Options options) {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", options);
    }
}
