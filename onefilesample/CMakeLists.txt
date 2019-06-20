cmake_minimum_required(VERSION 2.8)
# Setup SWIG
find_package(SWIG REQUIRED)
include(UseSWIG)

# Find java
set(JAVA_AWT_INCLUDE_PATH NotNeeded)
find_package(Java COMPONENTS Development REQUIRED)
find_package(JNI REQUIRED)
include(UseJava)

#other directory setups
include_directories(${JNI_INCLUDE_DIRS})

set( CMAKE_SWIG_OUTDIR ${CMAKE_CURRENT_BINARY_DIR} )


# Build the C++ code into a dynamic library:
swig_add_module( sample java sample.i sample.h )  

# For convenience we copy the dynamic library to the current build folder 
add_custom_command(TARGET sample POST_BUILD 
		   COMMAND ${CMAKE_COMMAND} -E copy_if_different $<TARGET_FILE:sample> ${CMAKE_CURRENT_BINARY_DIR})

# Build the Java code into SampleJNI.jar 
add_jar(SampleJNI SOURCES ${CMAKE_SWIG_OUTDIR}/sample.java ${CMAKE_SWIG_OUTDIR}/sampleJNI.java)
add_dependencies(SampleJNI sample)

# Finally build the demonstration code into Main.jar  
set(CMAKE_JAVA_JAR_ENTRY_POINT main) 
add_jar(Main SOURCES main.java ENTRY_POINT main)
add_dependencies(Main SampleJNI)
