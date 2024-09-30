package com.example.java8;

/**
 * 추상 메서드가 1개만 존재하면 해당 인터페이스는 함수형 인터페이스이다.
 * 함수형 인터페이스로 사용할거라면 @FunctionalInterface 키워드를 붙이는게 좋다.
 * 이유: 명시성, 컴파일러 체크
 */
@FunctionalInterface
public interface RunSomething {
    int doIt(int a, int b); // abstract 생략 가능
}
