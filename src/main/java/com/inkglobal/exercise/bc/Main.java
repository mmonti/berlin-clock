package com.inkglobal.exercise.bc;

import com.inkglobal.exercise.bc.strategies.ClockRepresentationStrategy;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by mmonti on 5/25/14.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

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
            logger.info("Input=[{}]", cmd.getOptionValue('i'));
            logger.info("Processing Strategy=[{}]", strategy);
            logger.info("Output=[{}]", clock.getTimeRepresentation(cmd.getOptionValue('i')));
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
