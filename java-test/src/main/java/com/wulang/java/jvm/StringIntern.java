package com.wulang.java.jvm;

import org.junit.Test;

import java.util.List;

public class StringIntern {
    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str1Intern = str1.intern();
        System.out.println(str1Intern == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        String str2Intern = str2.intern();
        System.out.println(str2Intern == str2);

//        char data[] = {'a', 'b', 'c'};
//        String s1 = new String(data);
//        new User("abc");
//        String s1 = new String("abc");
        String s1 = new StringBuilder("ab").append("c").toString();
        String s2 = new StringBuilder("ab").append("c").toString();
        String s3 = new StringBuilder("ab").append("c").toString();
        String s4 = new StringBuilder("ab").append("c").toString();
        String s1Intern = s1.intern();
        System.out.println(s1 == s2);
        System.out.println();
    }

    @Test
    public void Test(){

    }
}
