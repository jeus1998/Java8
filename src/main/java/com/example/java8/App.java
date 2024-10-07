package com.example.java8;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
@Chicken("후라이")
public class App {
    public static void main(String[] args) throws  RuntimeException{
        Chicken[] chickens = App.class.getDeclaredAnnotationsByType(Chicken.class);
        Arrays.stream(chickens)
                .forEach(c -> System.out.println(c.value()));

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value())
                .forEach(c -> System.out.println(c.value()));

    }
    static class FeelsLikeChicken<T>{ // 타입 파라미터
        public static <C> void print(C c){  // <C>: 타입 파라미터 C: 타입
            System.out.println(c);
        }
    }
}
