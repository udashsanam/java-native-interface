#include <jni.h>
#include <stdio.h>
#include "com_learn_add_Add.h"
#include "add.h"
// gcc -dynamiclib -o libnativecode.dylib nativecode.c -L. -ladd -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin"
// include already compile dylib file
JNIEXPORT void JNICALL Java_com_learn_add_Add_add
      (JNIEnv *env, jobject thisObj, jint x, jint y) {
      printf("from nativecode");
      int j = add(x,y);
      printf("result: %d",j);
}

