package com.github.dpoggi.logback.ext.pattern.color;

import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

import static ch.qos.logback.core.pattern.color.ANSIConstants.CYAN_FG;
import static com.github.dpoggi.logback.ext.pattern.color.ExtendedANSIConstants.FAINT;

/**
 * Encloses a given set of converter output in faint cyan using the appropriate ANSI escape codes.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class FaintCyanCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {

    @Override
    protected String getForegroundColorCode(E event) {
        return FAINT + CYAN_FG;
    }
}
