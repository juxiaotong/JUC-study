package com.jxt.single;

public class LazyMan {
    private byte[] date1 = new byte[1024*1024];
    private byte[] date2 = new byte[1024*1024];
    private byte[] date3 = new byte[1024*1024];

    public LazyMan() {
    }
    private volatile static LazyMan LAZYMAN ;

    public static LazyMan getInstance(){
        if (LAZYMAN == null){
            synchronized (LazyMan.class){
                if (LAZYMAN == null){
                    LAZYMAN = new LazyMan();
                }
            }
        }
        return LAZYMAN;
    }

}
