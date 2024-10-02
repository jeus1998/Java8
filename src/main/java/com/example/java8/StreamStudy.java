package com.example.java8;

import java.util.*;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Tom");
        /**
         * Stream API 특징: Functional in nature 불변성 유지하며 처리
         */
        // 스트림으로 데이터를 처리하지만, 원본 리스트 names는 변경되지 않는다.
        names
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("========================");
        names.forEach(System.out::println);

        /**
         * Stream API 특징: 스트림은 데이터를 한 번만 처리한다
         */
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
        System.out.println("=====================");
        try {
            stream.forEach(System.out::println);
        }
        catch (IllegalStateException e){
            System.out.println("e = " + e.getMessage());
        }

        /**
         * 스트림은 무제한일 수 있다
         */
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2); // 무한 스트림
        infiniteStream.limit(10).forEach(System.out::println);

        System.out.println("=====================");
        System.out.println(names);
        System.out.println();

        /**
         * 중개 오퍼레이션은 Lazy하다
         */
        Stream<String> stringStream = names.stream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                });

        Stream.iterate(1, n -> n + 1).limit(3).forEach(System.out::println);
        stringStream.forEach(System.out::println);

        /**
         * 손쉽게 병렬 처리할 수 있다
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers
                .stream()
                .map(c -> {
                    System.out.println(c + " " + Thread.currentThread().getName());
                    return c;
                })
                .forEach(System.out::println);   // 병렬 처리 x (출력 순서 규칙적)
        System.out.println("==============================");
        numbers
                .parallelStream()
                .map(c -> {
                    System.out.println(c + " " + Thread.currentThread().getName());
                    return c;
                })
                .forEach(System.out::println);  // 병렬 처리 o (출력 순서 불규칙)

    }
}
