echo off
set path=C:\Users\Chenki\.jdks\openjdk-14.0.2\bin
set include=C:\Users\Chenki\.jdks\openjdk-14.0.2\include
set lib=C:\Users\Chenki\.jdks\openjdk-14.0.2\lib
set link=C:\Users\Chenki\.jdks\openjdk-14.0.2\bin
javac -version Lab1.java
java Lab1
javap -c Lab1 >code_output.txt
javadoc Lab1.java -d doc
pause