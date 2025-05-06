package com.learn.bridge;

import java.io.File;

// this file is used to call native method
class JNIExample {

  // Native method, no body.
  public native void sayHello(int length);

  public static void main (String args[]) {
    String str = "sanam";

    (new JNIExample()).sayHello(str.length());
  }

  // This loads the library at runtime. NOTICE: on *nix/Mac the extension of the
  // lib should exactly be `.jnilib`, not `.so`, and have `lib` prefix, i.e.
  // the library file should be `libjniexample.jnilib`.
  static {
    System.load(new File("src/main/java/com/learn/bridge/libjniexample.jnilib").getAbsolutePath());
  }
}