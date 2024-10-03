package com.example.java8;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Practice {
    public static void main(String[] args) throws InterruptedException{
        Date date = new Date();
        long time = date.getTime(); // Date(날짜)에서 시간을 가져온다고?
        System.out.println("time = " + time); // 1970년 부터 현재까지의 시간
        System.out.println("date = " + date);

        Thread.sleep(1000 * 3); // 3초
        Date after3Seconds = new Date();
        System.out.println("after3Seconds = " + after3Seconds);
        after3Seconds.setTime(time); // mutable 하다. -> thread safe x
        System.out.println("after3Seconds = " + after3Seconds);

        // month 0부터 시작 내 생일은 12월인데 0부터 시작해서 11로 표현 -> 실수할 가능성이 많다.
        GregorianCalendar myBirthday1 = new GregorianCalendar(1998, 11, 12);
        GregorianCalendar myBirthday2 = new GregorianCalendar(1998, Calendar.DECEMBER, 12);
        System.out.println("myBirthday = " + myBirthday2.getTime());

        // 타입 안정성이 없다. (잘못된 값이 들어올 가능성이 있음)
        GregorianCalendar wrongMonth = new GregorianCalendar(1998, -2000, 12);

        Instant now = Instant.now(); // 현재 시점의 Instant 객체 생성
        System.out.println(now);
        
        LocalDate localDate = LocalDate.of(2024, 10, 3);
        System.out.println("localDate = " + localDate);
        
        LocalTime localTime = LocalTime.of(15, 30);
        System.out.println("localTime = " + localTime);

        LocalDateTime dateTime = LocalDateTime.of(2024, 10, 3, 15, 30);
        System.out.println("dateTime = " + dateTime);
        
        Duration duration = Duration.ofHours(2); // 2시간
        System.out.println("duration = " + duration);

        Period period = Period.ofDays(10); // 10일
        System.out.println("period = " + period);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter); // "2024-10-03 15:30:00"와 같은 문자열 생성
        System.out.println("formattedDateTime = " + formattedDateTime);

    }
}
