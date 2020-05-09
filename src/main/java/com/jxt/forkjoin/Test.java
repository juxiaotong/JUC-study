package com.jxt.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
//      test2();
        test3();

    }
    public static  void test1(){
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for (Long i = 1L;i <= 10_0000_00000L;i++){
            sum += i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
    public static void test2() throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = pool.submit(task);
        Long sum = submit.get();
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));

    }
    public static void test3(){
        Long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L,10_0000_0000).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
}
