package com.example.java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

/**
 * Stream API Practice
 */
public class App {
        public static void main(String[] args) {
                List<OnlineClass> springClasses = new ArrayList<>();
                springClasses.add(new OnlineClass(1, "spring boot", true));
                springClasses.add(new OnlineClass(2, "spring data jpa", true));
                springClasses.add(new OnlineClass(3, "spring mvc", false));
                springClasses.add(new OnlineClass(4, "spring core", false));
                springClasses.add(new OnlineClass(5, "rest api development", false));

                System.out.println("spring 으로 시작하는 수업");
                springClasses
                .stream()
                .filter(c -> c.getTitle().startsWith("spring"))
                        .forEach(oc -> System.out.println(oc.getTitle()));

                System.out.println();
                System.out.println("close 되지 않은 수업");
                springClasses
                .stream()
                .filter(Predicate.not(OnlineClass::isClosed)) // !OnlineClass::isClosed 불가능 ㅋㅋ
                .forEach(oc -> System.out.println(oc.getTitle()));

                System.out.println();
                System.out.println("수업 이름만 모아서 출력");
                springClasses
                        .stream()
                        .map(OnlineClass::getTitle)
                        .forEach(System.out::println);

                List<OnlineClass> javaClasses = new ArrayList<>();
                javaClasses.add(new OnlineClass(6, "The Java, Test", true));
                javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
                javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

                List<List<OnlineClass>> keesunEvents = new ArrayList<>();
                keesunEvents.add(springClasses);
                keesunEvents.add(javaClasses);

                System.out.println();
                System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
                keesunEvents
                        .stream()
                        .flatMap(Collection::stream)
                        .forEach(oc -> System.out.println(oc.getId()));

                System.out.println();
                System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
                Stream.iterate(10, n -> n + 1) // 무제한 스트림
                        .skip(10)
                        .limit(10)
                        .forEach(System.out::println);

                System.out.println();
                System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");

                System.out.println(javaClasses
                        .stream()
                        .anyMatch(jc -> jc.getTitle().contains("Test")));

                System.out.println();
                System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 제목만 모아서 List로 만들기");
                List<String> springTitle = springClasses
                        .stream()
                        .filter(sc -> sc.getTitle().contains("spring"))
                        .map(sc -> sc.getTitle())
                        .collect(Collectors.toList());

                springTitle.forEach(System.out::println);

                // flatMap
                List<String> strings1 = new ArrayList<>();
                List<String> strings2 = new ArrayList<>();
                Stream.iterate("o", s -> s + s).limit(10)
                        .forEach(s -> {
                                strings1.add(s);
                                strings2.add(s);
                        });

                List<List<String>> strings = new ArrayList<>();
                strings.add(strings1);
                strings.add(strings2);

                List<String> collect = strings.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
                collect.forEach(System.out::println);
        }
}