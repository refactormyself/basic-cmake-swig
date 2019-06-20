#!/usr/bin/env bash

set -e

rm -rf ./build/* ||yes
cd build
cmake ..
cmake --build .

echo
echo "BUILD IS SUCCESSFULL"
echo
java -Djava.library.path=. -jar Main.jar
