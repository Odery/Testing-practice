package com.vakamisu.testing.tdd;

import static java.lang.Math.min;

public class WordWrapper {

    public static String wrap(final String inputLine, final int lineLength) {
        final StringBuilder builder = new StringBuilder();
        final int length = inputLine.length();

        builder.append(inputLine, 0, min(length, lineLength));

        int split = lineLength;

        //generalizing from examples
        while (length > split) {
            builder.append('\n');
            builder.append(inputLine, split, min(length, split + lineLength));
            split += lineLength;
        }

        return builder.toString();
    }
}
