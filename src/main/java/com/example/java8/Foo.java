package com.example.java8;

public interface Foo {
    void printName();

    /**
     * getName()의 리턴값인 String 전부 대문자로 바꾼다.
     *
     * @return String
     * @implSpec
     * 이 메서드는 toUpperCase()를 사용하기 때문에 getName() 리턴값이 null이면 NullPointException이 발생합니다.
     */
    default void printNameUpperCase(){
       	System.out.println(getName().toUpperCase());
    }
    static void printAny(){
        System.out.println("static");
    }

    String getName();
}
