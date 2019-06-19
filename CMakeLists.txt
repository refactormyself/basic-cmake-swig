cmake_minimum_required(VERSION 2.8)
project(sample_project)

file(GLOB SOURCES "src/*.c")
include_directories(include)

#set(PRJ_LNK_DIRS ~/saheed/swig/basic_cmake/bin)
#set(PRJ_LNK_LIBS libmyappShared.a)

#link_directories(${PRJ_LNK_DIRS})

add_executable(mysample ${SOURCES})
#add_library(myappShared SHARED  ${SOURCES})
#add_library(myappStatic STATIC  ${SOURCES})

#install(TARGETS myappShared myappStatic DESTINATION bin)

