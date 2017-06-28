package com.github.dpoggi.logback.ext.pattern.color;

import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

import static ch.qos.logback.core.pattern.color.ANSIConstants.DEFAULT_FG;
import static com.github.dpoggi.logback.ext.pattern.color.ExtendedANSIConstants.FAINT;

/**
 * Encloses a given set of converter output in faint "default" using the appropriate ANSI escape codes.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class FaintCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {

    @Override
    protected String getForegroundColorCode(E event) {
        return FAINT + DEFAULT_FG;
    }
}
