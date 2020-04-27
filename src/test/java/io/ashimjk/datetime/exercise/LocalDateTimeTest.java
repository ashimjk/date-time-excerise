package io.ashimjk.datetime.exercise;

import org.junit.jupiter.api.Test;

import java.time.*;

import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class LocalDateTimeTest {

    @Test
    void getLocalDateTimeUsingLocalDateTime() {
        LocalDateTime utcDateTime = LocalDateTime.now(UTC);
        System.out.println("utcDateTime = " + utcDateTime.toString());

        // Needs to extract Instant by providing UTC Offset because LocalDateTime doesn't maintain offset
        ZonedDateTime zonedDateTime = utcDateTime.toInstant(UTC).atZone(ZoneId.of("Asia/Kathmandu"));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime);
    }

    @Test
    void getLocalDateTimeUsingInstant() {
        Instant utcDateTime = Instant.now(Clock.systemUTC());
        System.out.println("utcDateTime = " + utcDateTime);

        // Doesn't not work this way
        ZonedDateTime zonedDateTime = utcDateTime.atOffset(UTC).toInstant().atZone(ZoneId.of("Asia/Kathmandu"));
        Instant localDateTime = zonedDateTime.toInstant();
        System.out.println("localDateTime = " + localDateTime);

        System.out.println();

        LocalDateTime dateTime = utcDateTime.atOffset(UTC).toLocalDateTime();
        System.out.println("dateTime = " + dateTime.toString());

        ZonedDateTime zonedDateTime1 = dateTime.atZone(ZoneId.of("Asia/Kathmandu"));
        Instant localDateTime1 = zonedDateTime1.toInstant();
        System.out.println("localDateTime1 = " + localDateTime1);
    }

    @Test
    void getLocalDateTimeUsingInstant2() {
        String dateTime = LocalDateTime.now(UTC).toInstant(UTC).toString();
        Instant instant = Instant.from(ISO_DATE_TIME.parse(dateTime));
        System.out.println("Instant.from(parsedDate) = " + instant);

        System.out.println("instant.atZone(ZoneId.of(\"Asia/Kathmandu\")) = " + instant.atZone(ZoneId.of("Asia/Kathmandu")));
    }

}
