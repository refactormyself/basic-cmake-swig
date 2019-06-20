#!/usr/bin/env bash

set -e

rm -r ./build/*
cd build
cmake ..
cmake --build .

echo
echo "BUILD IS SUCCESSFULL"
echo
java -Djava.library.path=. -jar Main.jar
