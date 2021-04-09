package com.dev1.sort;

/**
 * @author: 邹祥发
 * @date: 2021/4/9 09:23
 */
public class Person implements Comparable<Person> {

    private String name;
    private Integer age;
    private Integer beauty;

    public Person(String name, Integer age, Integer beauty) {
        this.name = name;
        this.age = age;
        this.beauty = beauty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBeauty() {
        return beauty;
    }

    public void setBeauty(Integer beauty) {
        this.beauty = beauty;
    }

 @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", beauty=" + beauty +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return -(this.age - o.getAge());
    }
}
