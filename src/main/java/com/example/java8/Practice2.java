package com.example.java8;

import javax.xml.crypto.Data;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Practice2 {
    public static void main(String[] args) {
        // 포매팅
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        // 파싱
        LocalDate parse = LocalDate.parse("12/12/1998", MMddyyyy);
        System.out.println(parse);

        // 레거시 API 지원
        Date date = new Date();
        Instant instant = date.toInstant();  // Date(레거시) -> Instant

        Date newDate = Date.from(instant);   // Instant -> Date

        GregorianCalendar calendar = new GregorianCalendar();

        // GregorianCalendar(레거시) ->  ZonedDateTime
        ZonedDateTime zonedDateTime = calendar.toInstant().atZone(ZoneId.systemDefault());
        // ZonedDateTime -> LocalDateTime
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        // ZonedDateTime -> GregorianCalendar(레거시)
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime);

        // TimeZone(레거시) -> ZoneId
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();

        // ZoneId -> TimeZone(레거시)
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

        // 주의 사항

        LocalDateTime time = LocalDateTime.now();
        // 새로운 객체를 사용해야 한다.
        LocalDateTime plus = time.plus(10, ChronoUnit.YEARS); // Immutable


    }
}
