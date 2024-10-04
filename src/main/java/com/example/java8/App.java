package com.example.java8;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println(Thread.currentThread().getName()); // main
        // MyThread myThread = new MyThread();
        // myThread.start();
        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try{
                Thread.sleep(10000L); // 10초
            }
            catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
        });
        thread.start();
        System.out.println(LocalDateTime.now());
        System.out.println("Hello: " + Thread.currentThread().getName());
        thread.join(); // 다른 쓰레드가 끝날 때까지 기다린다
        System.out.println(LocalDateTime.now());
        System.out.println(thread + " is finished");
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
