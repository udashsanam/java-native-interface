#include <jni.h>

JNIEXPORT jobject JNICALL
Java_com_learn_employee_EmployeeNativeApi_getEmployee(JNIEnv *env, jobject thiz, jint x) {
    // Find the Student class
    jclass studentClass = (*env)->FindClass(env, "com/learn/employee/Employee");
    if (studentClass == NULL) {
        return NULL; // Class not found
    }

    // Get the constructor method ID: Student(String name, int age)
    jmethodID constructor = (*env)->GetMethodID(env, studentClass, "<init>", "(Ljava/lang/String;I)V");
    if (constructor == NULL) {
        return NULL; // Constructor not found
    }

    // Create arguments
    jstring name = (*env)->NewStringUTF(env, "John Doe");
    jint age = 22;

    // Create the Student object
    jobject studentObject = (*env)->NewObject(env, studentClass, constructor, name, age);

    return studentObject;
}