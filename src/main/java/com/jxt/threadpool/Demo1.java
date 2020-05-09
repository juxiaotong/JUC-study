package com.jxt.threadpool;

import java.util.concurrent.*;
/**
 * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异
 常
 * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
 * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会
 抛出异常！
 */
public class Demo1 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3) ,
                Executors.defaultThreadFactory(),
// 1 线程满了，进不来的线程不处理，抛出异常new ThreadPoolExecutor.AbortPolicy()
// 2                new ThreadPoolExecutor.CallerRunsPolicy()
// 3队列满了，丢掉任务，不会抛出异常！      new ThreadPoolExecutor.DiscardPolicy()
//4 队列满了，尝试去和最早的竞争，也不会抛出异常！
                 new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try{
            for (int i = 0; i < 10; i++) {
                pool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"-->OK");
                });
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}
