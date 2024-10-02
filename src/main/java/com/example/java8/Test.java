package com.example.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        // forEach - 람다 표현식
        name.forEach(s -> {
            System.out.println(s);
        });
        // 메소드 래퍼런스
        name.forEach(System.out::println);

        System.out.println("==================");

        Spliterator<String> spliterator1 = name.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("==================");
        while (spliterator2.tryAdvance(System.out::println));

        /*
        name.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .forEach(System.out::println);
         */
        /*
        name.removeIf(s -> s.length() == 3);
        name.forEach(System.out::println);
         */

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;

        name.sort(compareToIgnoreCase.reversed());

    }
}
/*
String.toUpperCase
Function <String, String> 메소드 래퍼런스 가능

-------------------------------------------
Predicate <String> return boolean

public boolean startsWith(String prefix) {
    return startsWith(prefix, 0);
}

input String return boolean 그런데 왜 메소드 래퍼런스 불가능?

메서드 참조는 인자에 대한 제어가 직접적으로 불가능합니다.
즉, startsWith("K")처럼 고정된 값을 사용하는 경우에는 람다식을 사용해야 합니다.
String::toUpperCase 는 인자가 없고, 반환 타입이 String 으로 고정되어 있기 때문에 메서드 참조로 사용할 수 있지만,
startsWith("K")처럼 특정 값을 전달해야 하는 경우에는 메서드 참조로 표현할 수 없습니다.
 */