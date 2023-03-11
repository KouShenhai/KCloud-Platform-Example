package org.laokou.test.jdk.jdk8;

import java.sql.Date;
import java.time.Clock;
import java.time.Instant;

public class Jdk8Test37 {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        System.out.println(instant);
        java.util.Date from = Date.from(instant);
        System.out.println(from);
    }
}
