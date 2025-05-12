#!/bin/bash

# ==== CONFIG ====
PACKAGE_PATH="com/learn/employee"
CLASS_NAME="EmployeeNativeApi"
JAVA_SRC_DIR="."
NATIVE_SRC="nativecode.c"
OUTPUT_MAC="libnativecode.dylib"
OUTPUT_LINUX="libnativecode.so"

# Check for OS
UNAME=$(uname)
if [[ "$UNAME" == "Darwin" ]]; then
  LIB_NAME=$OUTPUT_MAC
  INCLUDE_OS="darwin"
elif [[ "$UNAME" == "Linux" ]]; then
  LIB_NAME=$OUTPUT_LINUX
  INCLUDE_OS="linux"
else
  echo "Unsupported OS: $UNAME"
  exit 1
fi

# ==== STEP 1: Compile Java ====
echo "Compiling Java files..."
javac /${PACKAGE_PATH}/${CLASS_NAME}.java

# ==== STEP 2: Generate .h file ====
echo "Generating JNI header file..."
javac -h ${JAVA_SRC_DIR}/${PACKAGE_PATH} ${JAVA_SRC_DIR}/${PACKAGE_PATH}/${CLASS_NAME}.java

# ==== STEP 3: Compile native code into shared library ====
echo "Compiling native code into shared library ($LIB_NAME)..."
gcc -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/${INCLUDE_OS}" -fPIC -shared ${NATIVE_SRC} -o ${LIB_NAME}

# ==== Result ====
if [ -f "${LIB_NAME}" ]; then
  echo "✅ Successfully created: ${LIB_NAME}"
else
  echo "❌ Failed to create native library"
fi
