package com.jxt.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 1; i < 30; i++) {
                try {
                    ticket.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();
        new Thread(()->{
            for (int i = 1; i < 30; i++) {
                try {
                    ticket.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();
        new Thread(()->{
            for (int i = 1; i < 30; i++) {
                try {
                    ticket.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c").start();
        new Thread(()->{
            for (int i = 1; i < 30; i++) {
                try {
                    ticket.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"d").start();
    }


}

class Ticket2{
    private int numbers = 20;
    Lock lock = new ReentrantLock();
    public void buy() throws InterruptedException {
         lock.lock();
         try{
              if (numbers > 0){
                  Thread.sleep(100);
                  System.out.println(Thread.currentThread().getName()+"卖出了"+(numbers--)+"票,剩余："+numbers);
               }
         }catch (Exception e){
             System.out.println(e);
         } finally {
             lock.unlock();

         }



    }


}