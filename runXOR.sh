# !/bin/bash

echo Running xor gate simulation using $1 . . .
javac *.java 
java Network $1
echo Done
