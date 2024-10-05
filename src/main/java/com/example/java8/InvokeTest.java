package com.example.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * InvokeAll vs InvokeAny
 */
public class InvokeTest {
    // public static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws Exception{
        Callable<String> a = () ->{
            Thread.sleep(1000L);
            return "a";
        };
        Callable<String> b = () ->{
            Thread.sleep(2000L);
            return "b";
        };
        Callable<String> c = () ->{
            Thread.sleep(3000L);
            return "c";
        };
        List<Callable<String>> callables = Arrays.asList(a, b, c);
        invokeALL(callables);
        // invokeAny(callables);

        executorService.shutdown();
    }
    public static void invokeALL(List<Callable<String>> list) throws Exception{
        System.out.println("START invokeAll " + LocalDateTime.now());
        List<Future<String>> futures = executorService.invokeAll(list);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        System.out.println("END   invokeAll " + LocalDateTime.now()); // 6초
    }
    public static void invokeAny(List<Callable<String>> list) throws Exception{
        System.out.println("START invokeAny " + LocalDateTime.now());
        String future = executorService.invokeAny(list);
        System.out.println(future); // a
        System.out.println("END   invokeAny " + LocalDateTime.now()); // 1초
    }
}
