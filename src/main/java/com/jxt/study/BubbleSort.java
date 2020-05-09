package com.jxt.study;

import java.util.Arrays;

public class BubbleSort {
    public static int[] sort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]){
//                    temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                    flag = 1;
                }
                
            }
            if (flag  == 0){
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {5,6,7,10,1,3,18};
        System.out.println(Arrays.toString(sort(a)));

    }
}
