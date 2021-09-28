package com.hayagou.generic;

public class ProductEx {
    public static void main(String[] args) {
        Box<Integer> box1 = Util.boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);
    }
}
