package com.example.java8;

import java.util.function.*;

/**
 * 람다 표현식 : 변수 캡쳐 (Variable Capture)
 */
public class Main {
    public static void main(String[] args) {

    }
    private void run(){
        // Java8 이전은 무조건 final
        final int baseNumber = 10;

        // 로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                System.out.println(baseNumber);
            }
        }
        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 30;
                System.out.println(baseNumber);
            }
        };
        // 람다
        IntConsumer printInt = i -> System.out.println(i + baseNumber);
        printInt.accept(10); // 20 출력

    }
}
