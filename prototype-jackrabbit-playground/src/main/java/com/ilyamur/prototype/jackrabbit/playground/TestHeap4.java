package com.ilyamur.prototype.jackrabbit.playground;

public class TestHeap4 {

    public static void main(String[] args) throws InterruptedException {
        Object[] ref = new Object[1];
        Thread.sleep(10000L);
        while (true) {
            Object[] a = new Object[1];
            Object[] b = new Object[1];
            a[0] = b;
            b[0] = a;
            ref[0] = a;
        }
    }
}
