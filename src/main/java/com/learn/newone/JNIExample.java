// File: com/learn/bridge/JNIExample.java
package com.learn.newone;

import java.io.File;
import java.nio.file.Paths;

public class JNIExample {
    static {

        try {
            // Get the absolute path to the library
            String libraryPath = Paths.get("src/main/java/com/learn/newone/libnativecode.dylib")
                    .toAbsolutePath()
                    .toString();

            // Check if the file exists
            File libraryFile = new File(libraryPath);
            if (!libraryFile.exists()) {
                throw new RuntimeException("Native library not found at: " + libraryPath);
            }

            // Load the library
            System.load(libraryPath);
        } catch (Exception e) {
            System.err.println("Failed to load native library: " + e.getMessage());
            throw new RuntimeException("Failed to initialize native library", e);
        }


//        System.load(new File("src/main/java/com/learn/newone/libnativecode.dylib").getAbsolutePath());  // 👈 use System.load (not loadLibrary)
    }

    public native void sayHello(int len); // native method

    public static void main(String[] args) {
        JNIExample obj = new JNIExample();
        obj.sayHello(42);  // This will call the C function
    }
}
