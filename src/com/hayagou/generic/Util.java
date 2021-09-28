package com.hayagou.generic;

public class Util {
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompar = p1.getValue().equals(p2.getValue());

        return keyCompare && valueCompar;
    }

    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return Double.compare(v1, v2);
    }

    public static void main(String[] args) {

        int v1 = 1;
        int v2 = 3;
        int result = Util.compare(v1, v2); // 제네릭 메소드 호출

        switch (result) {
            case -1:
                System.out.println(v1 + "<" + v2);
                break;
            case 0:
                System.out.println(v1 + "==" + v2);
                break;
            case 1:
                System.out.println(v1 + ">" + v2);
                break;
        }
    }
}
