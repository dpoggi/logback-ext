package com.github.dpoggi.logback.ext.encoder;

/**
 * {@link ExtendedPatternLayoutEncoder} with PRETTY COLORS by default.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class ColorPatternLayoutEncoder extends ExtendedPatternLayoutEncoder {

    private static final String DEFAULT_PATTERN =
            "%faint(%date{yyyy-MM-dd HH:mm:ss.SSS}) %levelHighlight(%5level) %magenta(%pid) %faint(---) %faint([%15.15thread]) %cyan(%-40.40logger{39}) %faint(:) %msg%n%padXThrowable";

    @Override
    protected String getDefaultPattern() {
        return DEFAULT_PATTERN;
    }
}
