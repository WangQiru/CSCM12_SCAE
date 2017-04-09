package algorithm_assignment;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LargeIntegerDemo {
	public static void main(String[] args) {
		String digits1=null;
		String digits2=null;
		String digits3=null;
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			// Read the first number
			System.out.print("First number:");
			while (true) {
				digits1=in.readLine();
				if (digits1 != null && !digits1.equals(""))
					break;
			}

			// Read the second number
			System.out.print("Second number:");
			while (true) {
				digits2=in.readLine();
				if (digits2 != null && !digits2.equals(""))
					break;
			}

						// Read the third number
						System.out.print("Third number (<= 2000):");
			            while (true) {
			                digits3=in.readLine();
			                if (digits3 != null && !digits3.equals(""))
			                    break;
			            }

		} catch (Exception e) {
			System.out.println("Error in input, aborting...\n");
			System.out.println(e.toString());
			System.exit(-1);
		}

		System.out.println();
		LargeIntegerLL longInt1 = new LargeIntegerLL(digits1);
		LargeIntegerLL longInt2 = new LargeIntegerLL(digits2);
		
				int c = Integer.parseInt(digits3);

		System.out.println("Addition: ");
		longInt1.add(longInt2).print();

		
		        System.out.println("Multiplication: ");
				longInt1.mul(longInt2).print();
				
				System.out.println("Factorial: ");
				LargeIntegerLL longInt3 = LargeIntegerLL.factorial(c);
				longInt3.print();
	}
}


