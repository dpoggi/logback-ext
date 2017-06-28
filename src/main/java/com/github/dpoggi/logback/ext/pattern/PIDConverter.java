package com.github.dpoggi.logback.ext.pattern;

import java.lang.management.ManagementFactory;
import java.util.regex.Pattern;

import ch.qos.logback.core.pattern.DynamicConverter;

/**
 * Returns the JVM's process ID if available, otherwise "????".
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class PIDConverter<E> extends DynamicConverter<E> {

    private static final String PLACEHOLDER = "????";

    private static final Pattern AT_SIGN_PATTERN = Pattern.compile("@");

    private static String getPid() {
        try {
            String name = ManagementFactory.getRuntimeMXBean().getName();
            return AT_SIGN_PATTERN.split(name)[0];
        } catch (Throwable t) {
            return PLACEHOLDER;
        }
    }

    private String pid;

    @Override
    public void start() {
        this.pid = getPid();
        super.start();
    }

    @Override
    public String convert(E event) {
        return pid;
    }
}
