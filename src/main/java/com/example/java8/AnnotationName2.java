package com.example.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface AnnotationName2 {
    String value();
    int count() default 1;
}
