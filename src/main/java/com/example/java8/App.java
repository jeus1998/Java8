package com.example.java8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 배열 병렬 정렬 배열 Parallel 정렬
 */
public class App {
    public static void main(String[] args) throws  RuntimeException{
        int size = 1000;
        int [] numbers = new int [size];
        Random random = new Random();
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());

        long start = System.nanoTime();
        Arrays.sort(numbers); // Single Thread
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers); // Multi Thread
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}

/*
Arrays.parallelSort()
Fork/Join 프레임워크를 사용해서 배열을 병렬로 정렬하는 기능을 제공한다.

병렬 정렬 알고리즘 -> 힙 sort
배열을 둘로 계속 쪼갠다.
합치면서 정렬한다.
알고리듬 효율성은 같다. 시간 O(n logN) 공간 O(n)

왜 난 배열 크기가 1500이든 100000이든 그냥 정렬이 더 빠르지? CPU 코어수가 적기도 하고 컨텍스트 스위칭 오버헤드가 큰건가
serial sorting took 40537300
parallel sorting took 64167100
 */