package algorithm_assignment;

public class LargeIntegerLL {
	private LargeIntegerNode head = null;



	// A constructor that takes and converts a string of numbers
	public LargeIntegerLL(String digits) {
		try {
			LargeIntegerNode ptr = head;
			for (int i = digits.length()-1; i >= 0; i--) {
				int c = Integer.parseInt(String.valueOf(digits.charAt(i)));
				ptr = this.addAfter(ptr, c);
			}
		} catch (Exception e) {
			System.out.println("Parse Error!\n");
			System.out.println(e.toString());
			System.exit(-1);
		}
	}

	// A constructor that takes and converts a integer number
	public LargeIntegerLL(int number) {
		LargeIntegerNode ptr = head;
		while (number > 0) {
			int b = number % 10;
			number = number / 10;
			ptr = this.addAfter(ptr, b);
		}
	}

	// Copy constructor - make a copy of this LargeIntegerLL class
	public LargeIntegerLL(LargeIntegerLL secondNumber) {

		LargeIntegerNode second_ptr = secondNumber.head;
		LargeIntegerNode self_ptr = this.head;
		while (second_ptr != null) {
			self_ptr = this.addAfter(self_ptr, second_ptr.getData());
			second_ptr = second_ptr.getNext();
		}
	}

	// Add data to the front of the list
	public void addFront (int c) {
		LargeIntegerNode newNode = new LargeIntegerNode(c);
		newNode.setNext(this.head);
		this.head = newNode;
	}

	// Add a new node (with data) after the ptr
	public LargeIntegerNode addAfter (LargeIntegerNode ptr, int c) {
		LargeIntegerNode newNode = new LargeIntegerNode(c);
		if (head == null) {
			// empty list
			head = newNode;
		} else {
			newNode.setNext(ptr.getNext());
			ptr.setNext(newNode);
		}
		return newNode;
	}

	// Add N nodes (with initial values) at the end of the singly linked list
	public void addNLast (int numNode, int initial_value) {
		LargeIntegerNode ptr = head;
		// go to last element of the list
		while (ptr.getNext() != null) {
			ptr = ptr.getNext();
		}
		// add numNode of nodes at the end
		LargeIntegerNode newNode = null;
		for (int i=0; i<numNode; i++) {
			newNode = new LargeIntegerNode(initial_value);
			ptr.setNext(newNode);
			ptr = newNode;
		}
	}

	// Count the number of nodes in the list
	public int count() {
		LargeIntegerNode ptr = head;
		int count = 0;
		while (ptr != null) {
			count = count + 1;
			ptr = ptr.getNext();
		}
		return count;
	}

	// Print the number
	public void print() {
		printReverse(head);
	}
	// Print the singly linked list in reverse
	public void printReverse(LargeIntegerNode ptr) {
		// in reverse order
		if (ptr == null)
			return;
		else {
			printReverse(ptr.getNext());
			System.out.print(ptr.getData());
		}

		if (ptr == head)
			System.out.println();
	}

	// Add two LargeIntegerLLs (this and secondNumber) and return a new one storing the result.
	public LargeIntegerLL add(LargeIntegerLL secondNumber) {
		LargeIntegerLL firstNumber = this;
		LargeIntegerLL result = null;
		// Add firstNumber and secondNumber into a new one (in result)
		// The firstNumber(this) should not be modified.
		// .... your code below ....


		//	Initialize three pointers for all lists.
		//	ptrLong for the longer list, ptrShort for the shorter list.
		//	ptrResult for the pointer of result list.
		LargeIntegerNode ptrLong=firstNumber.head;
		LargeIntegerNode ptrShort=secondNumber.head;
		LargeIntegerNode ptrResult=null;

		//	The difference in length(number of digits) for two numbers.
		//	In case they have different length, more operations are required.
		int diff=Math.abs(firstNumber.count()-secondNumber.count());

		//	The length of the shorter list.
		int shortCount=secondNumber.count();

		//	If second number is longer.
		if((secondNumber.count()>firstNumber.count())){

			//	Set the count to first number's length.
			shortCount=firstNumber.count();

			//	Switch the pointer for both.
			ptrShort=firstNumber.head;
			ptrLong=secondNumber.head;
		}

		//	A boolean for carrying operation.
		boolean carry=false;


		//	Loops until the last position of the shorter list.
		int whileLoopCounter=0;
		while(whileLoopCounter<shortCount){

			//	Get the value from both list and go to next position.
			//	Sum is the result of adding two values.
			int sum=ptrLong.getData();
			ptrLong = ptrLong.getNext();
			sum+=ptrShort.getData();
			ptrShort = ptrShort.getNext();

			//	If carry is true, add 1 to current sum.
			if(carry)
				sum++;

			//	If sum>10, only keep the single digit, set carry to true.
			if(sum>=10){
				sum-=10;
				carry=true;
			}
			//	Else set carry to false.
			else
				carry=false;

			//	If result list is null, create a new node using sum.
			//	Set ptrResult pointer to head, which was newly created just now.
			if(result==null){

				//	Since LargeIntegerLL(int number) requires input>0,
				//	LargeIntegerLL(String digits) is used instead,
				//	Otherwise if the first digit is 0, the node will not be added.
				String str=""+sum;
				result=new LargeIntegerLL(str);
				ptrResult=result.head;
			}

			//	Else add sum to the position after the current ptrResult pointer.
			else
				ptrResult=result.addAfter(ptrResult, sum);

			//	Reset sum to 0 for next loop, increase while loop counter.
			sum=0;
			whileLoopCounter++;
		}

		//	Reset counter variable.
		whileLoopCounter=0;

		//	Loop diff times for the longer list.
		//	Where diff is the difference in length for two numbers.
		while(whileLoopCounter<diff){

			//	Get value from ptrLong's current position
			int value=ptrLong.getData();

			//	If the carry is set to true in the last addition of the previous while loop,
			//	Add the carry value.
			if(carry)
				value++;

			//	If value>10, only keep the single digit, set carry to true.
			if(value>=10){
				value-=10;
				carry=true;
			}
			//	Else set carry to false.
			else
				carry=false;

			//	Add sum to the position after the current ptrResult pointer and move to the next.
			ptrResult=result.addAfter(ptrResult, value);
			ptrLong = ptrLong.getNext();

			//	Reset value to 0 for next loop, increase while loop counter.
			value=0;
			whileLoopCounter++;
		}

		//	In case diff is 0, but a carry occurs.
		if(carry)
			ptrResult=result.addAfter(ptrResult, 1);

		// Return the result.
		return result;
	}	



	// Multiple this LargeIntegerLLs with one digit, and return a new one storing the result.
	public LargeIntegerLL mul(int digit) {
		// make a copy
		LargeIntegerLL result = new LargeIntegerLL(this);

		// Add multiple a single digit to the largeNumber and return the result
		// The largeNumber(this) should not be modified.
		// .... your code below ....

		//	Returns itself when multiplying by 1.
		if(digit==1)
			return result;

		//	ptrResult pointer set to head.
		LargeIntegerNode ptrResult=result.head;

		//	Get the length of result.
		int count=result.count();

		int carryValue=0;
		int whileLoopCounter=0;

		//	This while loop multiplies the input digit by each digit in result list
		while(whileLoopCounter<count) {

			int product=digit*ptrResult.getData();

			//	Add carry value to the product.
			if(carryValue!=0)
				product+=carryValue;

			//	When product>10, calculate the correct carry value,
			//	And keep the single digit only.
			if(product>=10){
				carryValue=product/10;
				ptrResult.setData(product-10*carryValue);
			}

			//	No carry for the next calculation, set product directly.
			else{
				carryValue=0;
				ptrResult.setData(product);
			}

			//	Only getNext() when there is still a node.
			if(count-whileLoopCounter>1)
				ptrResult = ptrResult.getNext();


			whileLoopCounter++;
		}

		//	Add the leftover carry value to a new node if any.
		if(carryValue!=0)
			result.addAfter(ptrResult, carryValue);
		// Return the result.
		return result;
	}

	// Multiply two LargeIntegerLLs (this and secondNumber) and return a new one storing the result.
	public LargeIntegerLL mul(LargeIntegerLL secondNumber) {
		// create LargeIntegerLL storing only a zero
		LargeIntegerLL result = new LargeIntegerLL("0");

		// Multiple firstNumber(this) with secondNumber and return the result
		// The largeNumber(this) should not be modified.
		// .... your code below ....

		LargeIntegerNode ptr=secondNumber.head;

		// Get length for input.
		int nodeCount=secondNumber.count();
		int whileLoopCounter=0;
		int power=0;
		while(whileLoopCounter<nodeCount){
			//	Only operates when the digit != 0,
			//	as zero multiplication always gives 0.
			if(ptr.getData()!=0){
				LargeIntegerLL singleMultiply=this.mul(ptr.getData());

				//	Power represents the index position of current digit.
				//	This for loop adds correct number of 0s back to the result, 
				//	since they were omitted before calling mul(int digit).
				for(int i=0;i<power;i++){
					singleMultiply.addFront(0);
				}

				//	Add singleMultiply to result.
				result=result.add(singleMultiply);
			}

			//	Only getNext() when there is still a node.
			if(nodeCount-whileLoopCounter>1)
				ptr=ptr.getNext();

			power++;
			whileLoopCounter++;
		}


		// Return the result.
		return result;
	}

	// Compute factorial of a given number (<= 2000)
	public static LargeIntegerLL factorial(int number) {
		// create LargeIntegerLL storing only a one
		LargeIntegerLL result = new LargeIntegerLL("1");

		// Perform factorial
		// .... your code below ....

		//	If number=0, returns 1 which was declared above.
		if(number==0){
			return result;
		}

		//	This while loop loops number-1 times.
		//	Each time use mul(LargeIntegerLL secondNumber) to calculate the factorial.
		//	Add the result to result list, then decrease number by 1.

		while(number>1){
			result=result.mul(new LargeIntegerLL(number));
			number--;
		}
		return result;
	}

}
