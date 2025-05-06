// File: com/learn/bridge/JNIExample.java
package com.learn.newone;

import java.io.File;

public class JNIExample {
    static {
        System.load(new File("src/main/java/com/learn/newone/libnativecode.dylib").getAbsolutePath());  // 👈 use System.load (not loadLibrary)
    }

    public native void sayHello(int len); // native method

    public static void main(String[] args) {
        JNIExample obj = new JNIExample();
        obj.sayHello(42);  // This will call the C function
    }
}
