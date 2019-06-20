cmake_minimum_required(VERSION 2.8)
project(sample_project)

# loacte required librariies and ignore those not needed
set(JAVA_AWT_INCLUDE_PATH NotNeeded) 
find_package(SWIG REQUIRED) 
find_package(Java REQUIRED) 
find_package(JNI REQUIRED) 

# include needed headerfiles and point to directories
include(UseJava) 
include(UseSWIG) 
include_directories(${JNI_INCLUDE_DIRS} include)  

# set location variables
set( CMAKE_SWIG_OUTDIR ${CMAKE_CURRENT_BINARY_DIR} ) 
#file(GLOB SOURCES "src/*.c")

###################################################

# Build the C/C++ code into a dynamic library: example.dll (on Windows) or libexample.so (on Linux) 

swig_add_module( example java  swig/example.i) #src/example.c)
#set_property(SOURCE swig/example.i PROPERTY CPLUSPLUS ON)
#swig_add_library(example 
#		 TYPE shared
#		 LANGUAGE java  
#		 SOURCES swig/example.i) #  src/example.c )  

# For convenience we copy the dynamic library to the current build folder 
add_custom_command( TARGET example POST_BUILD     
		    COMMAND ${CMAKE_COMMAND} -E copy_if_different $<TARGET_FILE:example> ${CMAKE_CURRENT_BINARY_DIR} )


# Build the Java code into ExampleJNI.jar
add_jar(
    ExampleJNI
    SOURCES
    ${CMAKE_SWIG_OUTDIR}/example.java
    ${CMAKE_SWIG_OUTDIR}/exampleJNI.java
)
add_dependencies( ExampleJNI example )

# Finally build the demonstration code into Main.jar

set(CMAKE_JAVA_JAR_ENTRY_POINT main) 
add_jar(
    Main 
    SOURCES main.java
    ENTRY_POINT main
)
add_dependencies( Main ExampleJNI )
