package com.jxt.study;

public class SelectSort {
    public static int[] sort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]){
                    minIndex = j;

                }
            }
            if (minIndex != i){
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        return array;
    }

    public static void main(String[] args) {
//        int[] a ={22,4,86,32,14,69,45,1};
//        int[] sort = sort(a);
//        for (int i : sort) {
//            System.out.println(i);
//        }
//        int i = 1;
//        int y = ++i;
//        System.out.println(y);

    }
}
