package com.jxt.pc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"C").start();

    }

}
class Data3{

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int flag = 1;
    public  void printA() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1){
                condition1.await();
            }

            System.out.println(Thread.currentThread().getName()+"=>"+"aaaaaaaaaaaaaaaaaaaaaaaaaa");
            flag = 2;
            condition2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
    public  void printB() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2){
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName()+"=>"+"bbbbbbbbbbbbbbbb");
            flag = 3;
            condition3.signal();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            lock.unlock();
        }
    }
    public  void printC() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3){
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName()+"=>"+"bbbbbbbbbbbbbbbb");
            flag = 1;
            condition1.signal();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            lock.unlock();
        }
    }

}