package com.jxt.unsafeCollection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) {
        //ConcurrentModificationException并发修改异常
      //  List<String> list = new ArrayList<String>();不安全
        //解决方法1
        //List<String> list = new Vector<String>();
        //解决方法2
        //List<String> list = Collections.synchronizedList(new ArrayList<String>());
        List<String> list = new CopyOnWriteArrayList<>();



        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
