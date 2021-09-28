package com.hayagou.generic;

public class BoxEx {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("김현중");
        String name = box.get();

        Box<Integer> box1 = new Box<>();
        box1.set(6);
        box1.get();
    }
}
