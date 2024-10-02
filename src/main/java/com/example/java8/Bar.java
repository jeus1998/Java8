package com.example.java8;

public interface Bar{
    default void printNameUpperCase(){
        System.out.println("Bar");
    }
}
