import java.io.BufferedReader;
import java.io.InputStreamReader;

// ----- Your Code Here, if need to -----
// ...
// ...
// ----- Your Code Here, if need to -----

class TestClass {
	
	// ----- Your Code Here, if need to -----
	// ...
	// ...
	// ----- Your Code Here, if need to -----
	
    public static void main(String args[] ) throws Exception {
		// read number of data
		Stopwatch st = new Stopwatch();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
		
		// median sum
		long SumMedians = 0;
		
		// ----- Your Code Here -----
		// ...
		// ...
		// ----- Your Code Here -----
		
		// take modulus!
		System.out.println( ""+(SumMedians % 100000));

		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");				
	}
}
