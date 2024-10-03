package com.example.java8;

import java.time.Duration;
import java.util.*;

/**
 * Optional Study
 */
public class App {
        public static void main(String[] args) {
                List<OnlineClass> springClasses = new ArrayList<>();
                springClasses.add(new OnlineClass(1, "spring boot", true));
                springClasses.add(new OnlineClass(2, "spring data jpa", true));
                springClasses.add(new OnlineClass(3, "spring mvc", false));
                springClasses.add(new OnlineClass(4, "spring core", false));
                springClasses.add(new OnlineClass(5, "rest api development", false));

                OnlineClass spring_boot = new OnlineClass(1, "spring_boot", true);


                Optional.ofNullable(10); // 원시타입 -> 오토 박싱 / int -> Integer
                OptionalInt.of(10); // 오토 박싱 x 원시 타입 그대로 저장 / int -> int


                OptionalInt empty = OptionalInt.empty();
                if(empty.isPresent()){
                        System.out.println(empty.getAsInt());
                }
                else System.out.println("is Empty");

        }
}