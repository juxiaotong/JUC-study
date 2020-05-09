package com.jxt.demo1;

public class SaleTicketDemo1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
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

class Ticket{
    private int numbers = 20;
    public synchronized  void buy() throws InterruptedException {
        if (numbers > 0){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"卖出了"+(numbers--)+"票,剩余："+numbers);
        }
    }


}
