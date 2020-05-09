package com.jxt.cas;

import java.util.concurrent.atomic.AtomicInteger;

/*
 CAS的ABA问题

 */
public class CASDemo2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        //捣乱线程
        System.out.println(atomicInteger.compareAndSet(100, 120));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(120, 100));
        System.out.println(atomicInteger.get());
// 期望线程
        System.out.println(atomicInteger.compareAndSet(100, 199));
        System.out.println(atomicInteger.get());
    }
}
