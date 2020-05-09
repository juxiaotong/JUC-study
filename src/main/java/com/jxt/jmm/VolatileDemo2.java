package com.jxt.jmm;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.util.concurrent.atomic.AtomicInteger;

/*
volatile
不保证原子性
 */
public class VolatileDemo2 {
//    private  volatile static int num = 0;
//    public static int add(){
//        return num++;
//    }
    private  static AtomicInteger num = new AtomicInteger();
    public static int add(){
        return num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
