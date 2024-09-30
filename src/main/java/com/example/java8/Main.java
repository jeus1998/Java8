package com.example.java8;

import java.util.*;
import java.util.function.*;

/**
 * 메소드 래퍼런스
 */
public class Main {
    public static void main(String[] args) {
        // static 메소드 래퍼런스 활용
        UnaryOperator<String> hi = Greeting::hi;

        hi.apply("kkk"); // kkk hi 출력

        // 인스턴스 메소드 래퍼런스 활용
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi2 = greeting::hello;

        // 생성자() 활용
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greeting2 = greetingSupplier.get();
        System.out.println(greeting2.getName()); // null

        // 생성자(String name) 활용
        Function<String, Greeting> greetingFunction = Greeting::new;

        Greeting greeting3 = greetingFunction.apply("NEW");
        System.out.println(greeting3.getName()); // NEW

        // comparator
        ArrayList<String> list = new ArrayList<>(List.of("라", "가", "다", "나"));
        Collections.sort(list, String::compareTo);
        System.out.println(list); // [가, 나, 다, 라]

    }
}
