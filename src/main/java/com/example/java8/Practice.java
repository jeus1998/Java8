package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice {
    public static void main(String[] args) {

        // Optional 생성
        Optional<String> test1 = Optional.of("test");
        Optional<String> test2 = Optional.ofNullable(null);
        Optional<String> test3 = Optional.ofNullable("test3");
        Optional<String> test4 = Optional.empty();

        // Optional get()
        System.out.println(test1.get()); // test 출력

        // System.out.println(test2.get()); // NullSuchElementException


        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        // Optional 반환 Stream 종료 연산
        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println("present = " + present); // true

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findAny();

        boolean empty = jpa.isEmpty();
        System.out.println("empty = " + empty);     // true

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        OnlineClass onlineClass = optional.orElseGet(Practice::createNewClass);
        System.out.println(onlineClass.getTitle());

        // default Exception = NoSuchElementException
        OnlineClass onlineClass1 = optional.orElseThrow(IllegalStateException::new);


        List<OnlineClass> classes = new ArrayList<>();
        classes.add(new OnlineClass(1, "spring class1",true));
        classes.add(new OnlineClass(2, "spring class2",false));

        Optional<OnlineClass> optional1 = classes.stream().filter(oc -> oc.getId() > 1).findFirst();
        Optional<Optional<Progress>> progress1 = optional1.map(OnlineClass::getProgress);

        Optional<OnlineClass> optional2 = classes.stream().filter(oc -> oc.getId() > 1).findFirst();
        Optional<Progress> progress2 = optional2.flatMap(OnlineClass::getProgress);


    }

    private static OnlineClass createNewClass() {
        System.out.println("Practice.createNewClass");
        return new OnlineClass(10, "new class", false);
    }
}
