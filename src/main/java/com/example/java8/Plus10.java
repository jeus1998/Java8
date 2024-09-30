package com.example.java8;

import java.util.function.Function;

/**
 * Function<T, R> 함수형 인터페이스 T: 매개 변수 R: 반환 타입
 * java.util.function 패키지
 */
public class Plus10 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
