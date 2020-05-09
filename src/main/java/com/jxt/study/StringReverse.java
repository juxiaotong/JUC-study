package com.jxt.study;

public class StringReverse {
    public static void main(String[] args) {
        char[] a= {'a',',','b','e','r'};
        //System.out.println(reverse(a));



    }
    public static char[] reverse(char[] chars){
        if (chars == null && chars.length <= 1){
            return chars;
        }
        int left = 0;
        int right = chars.length - 1;
        char temp;
        while (left < right){
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }


        return chars;
    }
    public static void reverse1(char[] chars){

        for (int i = chars.length - 1; i >= 0; i--) {
            char temp = chars[i];
            System.out.println(temp);
        }


    }

}
