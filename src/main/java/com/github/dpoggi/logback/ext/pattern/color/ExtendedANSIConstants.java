package com.github.dpoggi.logback.ext.pattern.color;

/**
 * String constants representing ANSI escape codes.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public abstract class ExtendedANSIConstants {

    public static final String FAINT = "2;";

    private ExtendedANSIConstants() {
        throw new AssertionError("No instance for you!");
    }
}
