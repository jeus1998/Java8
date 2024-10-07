package com.example.java8;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
public @interface ChickenContainer {
    Chicken[] value();
}
