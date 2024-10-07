package com.example.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 어노테이션 타입 선언은 특별한 종류의 인터페이스로 친다.
 */
@Target(ElementType.METHOD)
public @interface AnnotationName {
    /**
     * 애노테이션은 속성을 가질 수 있다.
     * 속성은 타입과 이름으로 구성, 이름 뒤에 괄호를 붙인다.
     * default 가 붙으면 생략이 가능하지만 default가 없는 속성은 필수로 넣어줘야 한다.
     */
    String name();
    int count() default 1;
}
