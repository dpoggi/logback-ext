package com.github.dpoggi.logback.ext.encoder;

/**
 * {@link ExtendedPatternLayoutEncoder} with a default pattern for file use.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class PlainPatternLayoutEncoder extends ExtendedPatternLayoutEncoder {

    private static final String DEFAULT_PATTERN =
            "%date{yyyy-MM-dd HH:mm:ss.SSS} %5level %pid --- [%thread] %-40.40logger{39} : %msg%n%padXThrowable";

    @Override
    protected String getDefaultPattern() {
        return DEFAULT_PATTERN;
    }
}
