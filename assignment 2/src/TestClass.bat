@echo off
javac *.java
java -cp . -Xmx1024m TestClass < input/test1.txt > Output1.txt
java -cp . -Xmx1024m TestClass < input/test2.txt > Output2.txt
java -cp . -Xmx1024m TestClass < input/test3.txt > Output3.txt
java -cp . -Xmx1024m TestClass < input/test4.txt > Output4.txt
java -cp . -Xmx1024m TestClass < input/test5.txt > Output5.txt
java -cp . -Xmx1024m TestClass < input/test6.txt > Output6.txt
diff --ignore-all-space --brief result/Result1.txt Output1.txt
diff --ignore-all-space --brief result/Result2.txt Output2.txt
diff --ignore-all-space --brief result/Result3.txt Output3.txt
diff --ignore-all-space --brief result/Result4.txt Output4.txt
diff --ignore-all-space --brief result/Result5.txt Output5.txt
diff --ignore-all-space --brief result/Result6.txt Output6.txt

pause

	
