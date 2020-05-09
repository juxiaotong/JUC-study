package com.jxt.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {
    public static void main(String[] args) {
//        Function<String,String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };
//        System.out.println(function.apply("asd"));
//        Function<String,String> function1 = (String s)->{ return s; };
//        System.out.println(function1.apply("zxc"));

//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                String a = "asc";
//                return s.equals(a);
//            }
//        };
//        System.out.println(predicate.test("asc"));
//        Predicate<String> predicate1 = (t)->{
//           return  t.isEmpty();
//        };
//        System.out.println(predicate1.test("a"));
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("aaaaaaa");
//        Consumer<String> consumer1 =(t)->{
//            System.out.println(t);
//        };
//        consumer1.accept("bbbbbbbbbbbbb");
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "nihao";
            }
        };
        System.out.println(supplier.get());
        Supplier<Integer> supplier1 = ()->{
            return 1024;
        };
        System.out.println(supplier1.get());
    }
}
