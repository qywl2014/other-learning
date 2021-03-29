package com.wulang.java.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ObjectInMemory {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
