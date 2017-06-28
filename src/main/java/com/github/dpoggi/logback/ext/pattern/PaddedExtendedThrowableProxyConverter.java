package com.github.dpoggi.logback.ext.pattern;

import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.spi.IThrowableProxy;

import static ch.qos.logback.core.CoreConstants.LINE_SEPARATOR;

/**
 * {@link ExtendedThrowableProxyConverter} with newlines on either side of its output.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class PaddedExtendedThrowableProxyConverter extends ExtendedThrowableProxyConverter {

    @Override
    protected String throwableProxyToString(IThrowableProxy tp) {
        return LINE_SEPARATOR + super.throwableProxyToString(tp) + LINE_SEPARATOR;
    }
}
