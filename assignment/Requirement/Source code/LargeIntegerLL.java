import java.io.*;

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
		// ....
		// .... your code above ....
		
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
		// ....
		// .... your code above ....
		
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
		// .... Hint, call mul(digit) above
		// ....
		// .... your code above ....
		
		// Return the result.
		return result;
    }
	
	// Compute factorial of a given number (<= 2000)
	public static LargeIntegerLL factorial(int number) {
		// create LargeIntegerLL storing only a one
		LargeIntegerLL result = new LargeIntegerLL("1");
		
		// Perform factorial
		// .... your code below ....
		// .... Hint, use mul(LargeIntegerLL) above
		// ....
		// .... your code above ....
		
		// Return the result.
		return result;
	}

}
