package com.google.constants;

import java.time.Duration;

public class Timeouts {
    public static final Duration DEFAULT_POLLING_INTERVAL = Duration.ofMillis(500);
    public static final Duration TIMEOUT_5_SECONDS = Duration.ofSeconds(5);
    public static final Duration TIMEOUT_10_SECONDS = Duration.ofSeconds(10);
    public static final Duration TIMEOUT_15_SECONDS = Duration.ofSeconds(15);
    public static final Duration TIMEOUT_20_SECONDS = Duration.ofSeconds(20);
    public static final Duration TIMEOUT_30_SECONDS = Duration.ofSeconds(30);
}
