# logback-ext

A collection of custom converters for Logback, unified by a set of custom
encoders.

## Getting Started

With Maven:

```xml
<dependency>
  <groupId>com.github.dpoggi.logback</groupId>
  <artifactId>logback-ext</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <scope>runtime</scope>
</dependency>
```

With Gradle:

```gradle
runtime 'com.github.dpoggi.logback:logback-ext:1.0.0-SNAPSHOT'
```

## Example Usage (`logback.xml`)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
  <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
    <!-- Specifying a pattern is optional, a default is provided -->
    <encoder class="com.github.dpoggi.logback.ext.encoder.ColorPatternLayoutEncoder"/>
  </appender>

  <appender name="file" class="ch.qos.logback.core.FileAppender">
    <file>example.log</file>
    <!-- As with ColorPatternLayoutEncoder above, specifying a pattern is optional -->
    <encoder class="com.github.dpoggi.logback.ext.encoder.PlainPatternLayoutEncoder"/>
  </appender>

  <root level="WARN">
    <appender-ref ref="console"/>
    <appender-ref ref="file"/>
  </root>
</configuration>
```

## License

[MIT License](https://opensource.org/licenses/MIT)

## Copyright

Copyright &copy; 2017 Dan Poggi
