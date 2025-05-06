#include <stdio.h>
#include <jni.h>
#include "JNIExample.h"  // The JNI header file generated from your class
// this is the implementation of or jni java class
JNIEXPORT void JNICALL Java_com_learn_bridge_JNIExample_sayHello
  (JNIEnv *env, jobject object, jint len) {
  printf("\nThe length of your string is %d.\n\n", len);
}
