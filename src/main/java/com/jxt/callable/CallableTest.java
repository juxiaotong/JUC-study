package com.jxt.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Impl impl = new Impl();
        FutureTask futureTask = new FutureTask<>(impl);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        Integer integer = (Integer)futureTask.get();
        System.out.println(integer);

    }
}
class Impl implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("callcall");
        return 1024;
    }
}