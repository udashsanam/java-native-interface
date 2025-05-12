package com.learn.employee;

import java.io.File;

public class EmployeeNativeApi {

    static {
        System.load(new File("src/main/java/com/learn/employee/libnativecode.dylib").getAbsolutePath());
    }

    public native Object getEmployee(int id);

    public static void main(String[] args) {
        EmployeeNativeApi obj = new EmployeeNativeApi();
        Employee x = (Employee) obj.getEmployee(1);
        System.out.println(x);
    }
}
