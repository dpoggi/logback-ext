package com.github.dpoggi.logback.ext.pattern.color;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

import static ch.qos.logback.core.pattern.color.ANSIConstants.*;

/**
 * Highlights text in different colors depending on the {@link Level}.
 *
 * ERROR =&gt; Bold Red
 * WARN  =&gt; Yellow
 * INFO  =&gt; Blue
 * DEBUG =&gt; Green
 * TRACE =&gt; Default
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class LevelHighlightingCompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {

    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        switch (event.getLevel().toInt()) {
        case Level.ERROR_INT:
            return BOLD + RED_FG;
        case Level.WARN_INT:
            return YELLOW_FG;
        case Level.INFO_INT:
            return BLUE_FG;
        case Level.DEBUG_INT:
            return GREEN_FG;
        case Level.TRACE_INT:
            return DEFAULT_FG;
        default:
            throw new IllegalArgumentException("event level is invalid");
        }
    }
}
