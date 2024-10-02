package com.example.java8;

public class Test {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("jeu");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAny();
    }
}
