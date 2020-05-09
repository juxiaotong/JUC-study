package com.jxt.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinlockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "myLoke");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void myUnloke(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "myUnLoke");
        atomicReference.compareAndSet(thread,null);
    }
}
class Test{
    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo loke = new SpinlockDemo();
        new Thread(()->{
            loke.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                loke.myUnloke();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            loke.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                loke.myUnloke();
            }
        },"B").start();
    }
}
