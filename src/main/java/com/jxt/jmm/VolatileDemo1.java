package com.jxt.jmm;

/*
  volatile
  保证可见性
 */

import java.util.concurrent.TimeUnit;

public class VolatileDemo1 {
    private  volatile  static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){

            }
        },"A").start();
        TimeUnit.SECONDS.sleep(2);

        num = 1;
        System.out.println(num);
    }
}
