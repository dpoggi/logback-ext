package com.github.dpoggi.logback.ext.encoder;

import java.util.Map;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

import com.github.dpoggi.logback.ext.pattern.*;
import com.github.dpoggi.logback.ext.pattern.color.*;

/**
 * {@link PatternLayoutEncoder}-alike with all converters available from logback-ext pre-configured.
 *
 * @author Dan Poggi
 * @since 1.0.0
 */
public class ExtendedPatternLayoutEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {

    @Override
    public void start() {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setContext(context);
        patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);

        Map<String, String> converterMap = patternLayout.getInstanceConverterMap();

        converterMap.put("pid", PIDConverter.class.getName());

        converterMap.put("padEx", PaddedThrowableProxyConverter.class.getName());
        converterMap.put("padException", PaddedThrowableProxyConverter.class.getName());
        converterMap.put("padThrowable", PaddedThrowableProxyConverter.class.getName());

        converterMap.put("padXEx", PaddedExtendedThrowableProxyConverter.class.getName());
        converterMap.put("padXException", PaddedExtendedThrowableProxyConverter.class.getName());
        converterMap.put("padXThrowable", PaddedExtendedThrowableProxyConverter.class.getName());

        converterMap.put("padREx", PaddedRootCauseFirstThrowableProxyConverter.class.getName());
        converterMap.put("padRootException", PaddedRootCauseFirstThrowableProxyConverter.class.getName());

        converterMap.put("bold", BoldCompositeConverter.class.getName());
        converterMap.put("faint", FaintCompositeConverter.class.getName());
        converterMap.put("faintRed", FaintRedCompositeConverter.class.getName());
        converterMap.put("faintGreen", FaintGreenCompositeConverter.class.getName());
        converterMap.put("faintYellow", FaintYellowCompositeConverter.class.getName());
        converterMap.put("faintBlue", FaintBlueCompositeConverter.class.getName());
        converterMap.put("faintMagenta", FaintMagentaCompositeConverter.class.getName());
        converterMap.put("faintCyan", FaintCyanCompositeConverter.class.getName());
        converterMap.put("faintWhite", FaintWhiteCompositeConverter.class.getName());

        converterMap.put("levelHighlight", LevelHighlightingCompositeConverter.class.getName());
        converterMap.put("leHighlight", LevelHighlightingCompositeConverter.class.getName());
        converterMap.put("pHighlight", LevelHighlightingCompositeConverter.class.getName());

        String pattern = getPattern();
        String defaultPattern = getDefaultPattern();
        if (pattern != null) {
            patternLayout.setPattern(pattern);
        } else if (defaultPattern != null) {
            setPattern(defaultPattern);
            patternLayout.setPattern(defaultPattern);
        }

        patternLayout.start();

        this.layout = patternLayout;

        super.start();
    }

    protected String getDefaultPattern() {
        return null;
    }
}
