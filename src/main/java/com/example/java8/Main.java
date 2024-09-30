package com.example.java8;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Plus10 plus10_class = new Plus10();
        System.out.println(plus10_class.apply(10)); // 10

        // 람다 표현식을 통한 Function 함수 일급 객체화
        Function<Integer, Integer> plus10 = i -> i + 10;
        Function<Integer, Integer> multiply2 = i -> i * 2;

        /**
         * 고차 함수의 성격을 가짐 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
         */
        Function<Integer, Integer> multiply2BeforePlus10 = plus10.compose(multiply2);
        System.out.println(multiply2BeforePlus10.apply(20)); // 20 * 2 + 10 -> 50

        System.out.println(plus10.andThen(multiply2).apply(5)); // (5 + 10) * 2 -> 30

        //BiFunction<T, U, R> 사용
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> {
            return a + b;
        };
        System.out.println(biFunction.apply(10, 21)); // 10 + 21 -> 31

        // Consumer<T>
        Consumer<String> printStr = s -> System.out.println(s);
        printStr.accept("안녕"); // "안녕" 출력

        // Supplier<T>
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get()); // 10 출력

        // Predicate<T>
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println(startsWithA.test("ABC")); // true
        System.out.println(startsWithA.test("BAC")); // false

    }
}
