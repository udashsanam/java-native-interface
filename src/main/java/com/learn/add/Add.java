package com.learn.add;

import java.io.File;

public class Add {

    static {
        System.load(new File("src/main/java/com/learn/add/libnativecode.dylib").getAbsolutePath());
    }

    public native void add(int x, int y);

    public static void main(String[] args) {
        Add obj = new Add();
        obj.add(6, 10);
    }

}
