package com.example.java8;

import java.util.Arrays;
import java.util.*;
import java.util.function.Function;

public class Main {
    @FunctionalInterface
    static interface Adder{
        abstract int add(int a, int b);
    }
    public Adder getAdder(){
        return (a, b) -> a + b;
    }
    public static void main(String[] args) {
        // 자바8 이전 방식: 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = (a, b) -> {
            return a + b;
        };
        int answer = runSomething.doIt(1, 3);

        // 람다 표현식 매개 변수로 활용
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println(name));

        // 람다 표현식 변수로 저장
        Function<Integer, Long> square = x -> (long) x * x;
        long result = square.apply(5);

        // 람다 표현식 리턴 타입
        Main main = new Main();
        Adder adder = main.getAdder(); // Adder 인터페이스 반환
        System.out.println(adder.add(5, 3));
    }
}
