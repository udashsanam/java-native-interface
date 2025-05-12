package com.learn.employee;

public class Employee {

    private String name;

    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Employee() {}
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
