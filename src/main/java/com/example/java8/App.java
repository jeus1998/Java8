package com.example.java8;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        /*
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello "));
        executorService.submit(getRunnable("jeu "));
        executorService.submit(getRunnable("The "));
        executorService.submit(getRunnable("Java "));
        executorService.submit(getRunnable("Test "));

        executorService.shutdown(); // 작업을 모두 끝내고 끝낸다.
        // executorService.shutdownNow(); // 끝낸다 -> 작업을 모두 끝내지 핞고 종료될 가능성이 있다.
        */
        /*
        System.out.println(LocalDateTime.now());
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
        */

        System.out.println(LocalDateTime.now());
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // (시작 지연) initialDelay 1, (반복) period 2
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello "), 1, 2, TimeUnit.SECONDS);

        // scheduledExecutorService.shutdown();
    }
    private static Runnable getRunnable(String message){ // effectively final
        return () -> System.out.println(message + Thread.currentThread().getName() + " Time= " + LocalDateTime.now());
    }
}
