package com.jxt.study;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        Collections.sort(null);
        int[] data = {5,8,1,20,9,0,68} ;
        mergeSort(data,0,data.length - 1);
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(data));

    }
    public static void mergeSort(int[] data,int left,int right){
        if (left < right){
            int mid = ( left + right ) / 2;
            mergeSort(data,left,mid);
            mergeSort(data,mid+1,right);

            merge(data,left,mid,right);
        }

    }
    public static void merge(int[] data, int left, int mid ,int right){
        int[] temp = new int[data.length];
        int point1 = left;
        int point2 = mid + 1;

        int index = left;
        while (point1 <= mid && point2 <= right){
            if (data[point1] >= data[point2]){
                temp[index] = data[point2];
                index ++;
                point2 ++;
            }else{
                temp[index] = data[point1];
                index ++;
                point1 ++;
            }

        }
        while (point1 <= mid){
            temp[index ++] = data[point1 ++];
        }
        while (point2 <= right){
            temp[index ++] = data[point2 ++];
        }
        for (int i = left; i <= right; i++) {
            data[i] = temp[i];

        }


    }
}
