package com.example.java8;


import javax.xml.crypto.Data;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class Practice {
    public static void main(String[] args) throws InterruptedException{
        Instant instant = Instant.now();// 기준시: UTC GMT 반환
        System.out.println("instant = " + instant);
        System.out.println("UTC = " + instant.atZone(ZoneId.of("UTC")));

        ZoneId zone = ZoneId.systemDefault(); // 내 컴퓨터 지역
        System.out.println("zone = " + zone); // zone = Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone); // Asia/Seoul 시간
        System.out.println("zonedDateTime = " + zonedDateTime);

        System.out.println("==========================================");

        LocalDateTime now = LocalDateTime.now(); // 현재 컴퓨터를 기준으로
        System.out.println("now = " + now);


        // 만약 잘못된 시간과 날짜 입력시 DateTimeException 발생 -> 타입 안정성이 있다
        LocalDateTime myBirthday = LocalDateTime.of(1998, 12, 12, 0, 0, 0);
        System.out.println("myBirthday = " + myBirthday);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2024, Month.DECEMBER, 12);

        Period between = Period.between(today, thisYearBirthday);
        System.out.println("between = " + between);                     // 월/일 표현
        System.out.println("between.getDays() = " + between.getDays()); // 날짜만 가져오기

        Period until = today.until(thisYearBirthday);
        System.out.println("until = " + until.getDays());

        Instant nowInstant = Instant.now();
        Instant plus = nowInstant.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(nowInstant, plus);
        System.out.println("duration.getSeconds() = " + duration.getSeconds());
    }
}
