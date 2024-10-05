package com.example.java8;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 싱글 스레드풀 스레드 풀에 1개의 스레드가 생성 & BlockingQueue 존재
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // Callable Runnable 차이점 return 존재
        Callable<String> hello = () -> {
              Thread.sleep(2000L);
              return "Hello";
        };
        // executor 할일(Callable) 제공 반환 -> Future<T>
        Future<String> future = executorService.submit(hello);
        // System.out.println(future.isDone()); // 상태 조회 false

        future.cancel(false); // 이미 시작된 작업이어도 멈춘다.
        System.out.println("Started: " + LocalTime.now());
        // future.get(1L, TimeUnit.SECONDS);
        future.get();
        System.out.println(future.isDone()); // 상태 조회 true
        System.out.println("End " + LocalTime.now()); // 시작과 2초 차이

        executorService.shutdown();
    }
}
