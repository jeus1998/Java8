package com.example.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executor).thenRun(() -> System.out.println("안녕 " + Thread.currentThread().getName()));

        future.get();
        executor.shutdown();
    }
}
/* 콜백 패턴
public class App {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept(s -> { // future 다른점 callback 적용
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        System.out.println(future.get());
    }
}
 */

/*
비동기 작업 (반환값이 있는)
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    System.out.println("Hello " + Thread.currentThread().getName());
    return "Hello";
});
System.out.println(future.get());

 */

/*
CompletableFuture.completeFuture() - static 메소드

주어진 값으로 이미 완료된 새로운 CompletableFuture 반환한다.

CompletableFuture<String> future = CompletableFuture.completedFuture("배제우");
System.out.println(future.isDone());
System.out.println(future.get());
 */

/*  CompletableFuture 명시적 완료
public class App {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();

        // 캐시에서 데이터를 가져온다고 가정
        String cachedData = getDataFromCache();
        if (cachedData != null) {
            future.complete(cachedData);
        } else {
            future.complete("배제우");
        }
        System.out.println(future.get());
    }
    private static String getDataFromCache() {
        return null; // 캐시에서 값이 없다고 가정
    }
}
*/
/* Future 단점: 블록킹 콜 get() 정리

ExecutorService executorService = Executors.newFixedThreadPool(4);
Future<String> future = executorService.submit(() -> {
    Thread.sleep(10000L); // 10초
    return "hello";
});
String str = future.get();// 블록킹 콜 -> 작업이 완료전까지 다음 구문은 진행 x -> 10초를 기다린다.
System.out.println("str = " + str);

executorService.shutdown();
 */
