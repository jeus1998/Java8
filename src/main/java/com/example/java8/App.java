package com.example.java8;
import java.lang.annotation.*;
import java.util.ArrayList;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
    String yymmdd(); // 날짜
    String hhmmss(); // 시간
}
enum TestType{
    FIRST, SECOND
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
    int count();
    String testedBy();
    String[] testTools();
    TestType testType();
    DateTime testDate();
}

@TestInfo(
        count = 3,
        testedBy = "bae",
        testTools = {"Junit5", "AutoTester"},
        testType = TestType.FIRST,
        testDate = @DateTime(yymmdd = "240101", hhmmss = "235959")
)
public class App {
    public static void main(String[] args)  {
        App app1 = new App();
        TestInfo anno1 = app1.getClass().getAnnotation(TestInfo.class);

        Class<App> cls = App.class; // 메타 데이터 가져오기
        TestInfo anno2 = cls.getAnnotation(TestInfo.class);

        int count = anno1.count();
        System.out.println("count = " + count);
        DateTime dateTime = anno1.testDate();
        System.out.println("dateTime = " + dateTime);

        for(String tool : anno1.testTools()){
            System.out.println("tool = " + tool);
        }
    }
}
