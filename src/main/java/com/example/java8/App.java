package com.example.java8;

import java.util.concurrent.CompletableFuture;
import java.util.*;
import java.util.stream.*;
public class App {
    public static void main(String[] args) throws Exception {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if(throwError){
                throw new IllegalStateException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if(ex != null){
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });
        System.out.println(hello.get());

        /*
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<Object> future = CompletableFuture
                .anyOf(hello, world)
                .thenApply(s -> s);

        System.out.println(future.get());

        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        // f.get() checked exception 발생 f.join() unchecked exception 발생
        CompletableFuture<List<String>> futureList = CompletableFuture
                .allOf(futuresArray)
                .thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));

        futureList.get().forEach(System.out::println);
         */
    }
}
