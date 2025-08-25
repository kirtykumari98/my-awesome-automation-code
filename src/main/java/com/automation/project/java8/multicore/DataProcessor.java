package com.automation.project.java8.multicore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataProcessor {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 9,10,9,3,2,1,1,0);

        int numOfThreads = 5;
        List<Integer> squaredIntegers = Collections.synchronizedList(new ArrayList<>());
        List<Integer> sites = integers;

        ExecutorService es = Executors.newFixedThreadPool(numOfThreads);
        for (Integer site : sites) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        squaredIntegers.add(site*site);
                    } finally {
//                        countDownLatch.countDown();
                    }
                }
            });
        }
//        countDownLatch.await();
        System.out.println(squaredIntegers);
    }
}
