package com.dev1.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 15654
 */
public class PersonDemo {
    public static void main(String[] args) {
        //创建对象
        Person p1 = new Person("ly", 36, 88);
        Person p2 = new Person("llf", 16, 98);
        Person p3 = new Person("lx", 26, 78);
        List<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        //打印
        for(Person p:list){
            System.out.println(p);
        }
        System.out.println("-------------------");
        //排序
        Collections.sort(list);
        //打印
        for(Person p:list){
            System.out.println(p);
        }
        System.out.println("-------------------");
    }
}
