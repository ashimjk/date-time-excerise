package io.ashimjk.datetime.exercise;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

public class FormatDateTest {

    @Test
    void formatDate() {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("zdt = " + zdt);
        System.out.println(zdt.format(ISO_INSTANT));
    }

}
