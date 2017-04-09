#!/bin/sh
testDataPath=input
ResultDataPath=result

# Remove all Output1-6.txt
rm -f Output*.txt

# Run test cases and Timing
START=$(date +%s%N);
timeout 5 java -Xmx1024m TestClass < ${testDataPath}/test1.txt > Output1.txt
timeout 5 java -Xmx1024m TestClass < ${testDataPath}/test2.txt > Output2.txt
timeout 5 java -Xmx1024m TestClass < ${testDataPath}/test3.txt > Output3.txt
timeout 5 java -Xmx1024m TestClass < ${testDataPath}/test4.txt > Output4.txt
timeout 30 java -Xmx1024m TestClass < ${testDataPath}/test5.txt > Output5.txt
timeout 30 java -Xmx1024m TestClass < ${testDataPath}/test6.txt > Output6.txt
END=$(date +%s%N);

# Check correctness
diff --ignore-all-space --brief ${ResultDataPath}/Result1.txt Output1.txt
diff --ignore-all-space --brief ${ResultDataPath}/Result2.txt Output2.txt
diff --ignore-all-space --brief ${ResultDataPath}/Result3.txt Output3.txt
diff --ignore-all-space --brief ${ResultDataPath}/Result4.txt Output4.txt
diff --ignore-all-space --brief ${ResultDataPath}/Result5.txt Output5.txt
diff --ignore-all-space --brief ${ResultDataPath}/Result6.txt Output6.txt

# Calculate total time
TIME=$((END-START))
SECOND=$((TIME/1000000000))
MSECOND=$((TIME%1000000000/1000000))
echo "$SECOND (sec) $MSECOND (msec)"
