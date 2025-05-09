// File: nativecode.c
#include <jni.h>
#include <stdio.h>
#include "com_learn_newone_JNIExample.h"
#include "nativeapilib.h"
//gcc -dynamiclib -fPIC -o libnativecode.dylib nativecode.c \  -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/darwin"
// to generat dylib file
JNIEXPORT void JNICALL Java_com_learn_newone_JNIExample_sayHello
  (JNIEnv *env, jobject thisObj, jint len) {
    printf("✅ Hello from C! Received length = %d\n", len);
    int x = add(1, 2);
    printf("%d", x);
}
