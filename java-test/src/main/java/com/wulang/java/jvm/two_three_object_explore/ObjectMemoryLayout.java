package com.wulang.java.jvm.two_three_object_explore;

import org.openjdk.jol.info.ClassLayout;

/**
 * HotSpot虚拟机里，对象在堆中的布局可以划分为三部分：对象头、实例数据、对齐填充。
 *
 * 1、HotSpot虚拟机的对象头包括两类信息：
 *  第一类用于存储对象自身的运行时数据，如哈希码、GC分代年龄、锁信息等，在64位虚拟机中为64比特（未开启压缩指针），
 *  官方称它位Mark Word。
 *  另一部分是类型指针，即对象执行它的类型元数据的指针。
 *  此外，如果对象是java数组，对象头中还必须有一块用于记录数组长度的数据。
 *
 * 2、接下来实例数据部分是对象真正存储的有效信息，即我们在代码里定义的各种类型的字段内容。
 *
 * 3、对象的第三部分是对齐填充，由于HotSpot虚拟机的自动内存管理系统要求对象起始地址必须是8字节的整数倍。
 * 对象头已经被精心设计为8字节的倍数（1倍或者2倍）。
 */
public class ObjectMemoryLayout {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(0).instanceSize());
    }
}
