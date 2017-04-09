javac *.java
java -cp . LargeIntegerDemo < input.txt > output.txt
diff.exe output.txt result.txt