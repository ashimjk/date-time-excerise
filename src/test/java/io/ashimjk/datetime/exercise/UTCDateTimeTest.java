package io.ashimjk.datetime.exercise;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;

class UTCDateTimeTest {

    @Test
    void getUTCUsingLocalDateTime() {
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());

        // converts LocalDateTime to UTC date with offset e.g. 2020-04-27T13:30:40.121Z
        String utcDateTime = LocalDateTime.now(UTC).toInstant(UTC).toString();
        System.out.println("dateTime = " + utcDateTime);
    }

    @Test
    void getUTCUsingInstant() {
        System.out.println("utcDateTime = " + Instant.now());
    }

}
