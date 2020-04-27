package io.ashimjk.datetime.exercise;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_INSTANT;

public class ParseDateTest {

    @Test
    void parseDate() {
        // ISO_DATE_TIME parse date whether dateTime contains offset or not
        // e.g. 2020-04-27T13:30:40.121Z or 2020-04-27T13:30:40.121 or 2020-04-27T13:30:40

        String dateTime1 = "2020-04-27T13:30:40.121Z";
        LocalDateTime eventTime1 = LocalDateTime.from(ISO_DATE_TIME.parse(dateTime1));
        System.out.println("eventTime1 = " + eventTime1);

        String dateTime2 = "2020-04-27T13:30:40.121";
        LocalDateTime eventTime2 = LocalDateTime.from(ISO_DATE_TIME.parse(dateTime2));
        System.out.println("eventTime2 = " + eventTime2);

        String dateTime3 = "2020-04-27T13:30:40";
        LocalDateTime eventTime3 = LocalDateTime.from(ISO_DATE_TIME.parse(dateTime3));
        System.out.println("eventTime3 = " + eventTime3);
    }

    @Test
    void parseDate2() {
        String utcDateTime = LocalDateTime.now(UTC).toInstant(UTC).toString();
        System.out.println("utcDateTime = " + utcDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime parsedDate = LocalDateTime.parse(utcDateTime, formatter);
        System.out.println("parsedDate = " + parsedDate);
    }

    @Test
    void parseDate3() {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        String currentDateTime = instant.toString();
        System.out.println("currentDateTime = " + currentDateTime);

        Instant parsedDate = Instant.from(ISO_INSTANT.parse(currentDateTime));
        System.out.println("parsedDate = " + parsedDate);
    }

}
