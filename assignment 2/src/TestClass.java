import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
	private static RedBlackBST<Integer> bst = new RedBlackBST<Integer>();
	public static void main(String args[]) throws Exception {
		// read number of data
		Stopwatch st = new Stopwatch();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		// median sum
		long SumMedians = 0;

		int i=0;
		while (i<N) {	
			bst.put(Integer.parseInt(br.readLine())); // Add a new node for the integer
			SumMedians+=findMedian(i+1);	// find median from current inputs
			i++;			
		}
		// take modulus!
		System.out.println( ""+(SumMedians % 100000));

		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");				
	}

	public static int findMedian(int size){
		int n;
		if(size%2==0)
			n=size/2-1;		// get median for even numbers
		else
			n=(size+1)/2-1;			// get median for odd numbers
		return bst.select(n);		
	}
}

/**
 * Note!!! 
 * This BST structure is inspired from the work of Robert Sedgewick and Kevin Wayne 
 * URL: http://algs4.cs.princeton.edu/33balanced/
 */

class RedBlackBST<Key extends Comparable<Key>> {
	private static final boolean RED   = true;
	private static final boolean BLACK = false;

	private Node root;     // root of the BST

	private class Node {
		private Key key;           // key
		private Node left, right;  // links to left and right subtrees
		private boolean color;     // color of parent link
		private int N;             // subtree count

		public Node(Key key, boolean color, int N) {
			this.key = key;
			this.color = color;
			this.N = N;
		}
	}

	// is node x red; false if x is null ?
	private boolean isRed(Node x) {
		if (x == null) return false;
		return x.color == RED;
	}

	// number of node in subtree rooted at x; 0 if x is null
	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	} 


	public int size() {
		return size(root);
	}


	public boolean isEmpty() {
		return root == null;
	}


	public void put(Key key) {
		root = put(root, key);
		root.color = BLACK;
	}

	// insert the key-value pair in the subtree rooted at h
	private Node put(Node h, Key key) { 
		if (h == null) return new Node(key, RED, 1);

		int cmp = key.compareTo(h.key);
		if      (cmp < 0 || cmp == 0) h.left  = put(h.left,  key); // for element with smaller or same value, put into left child node
		// this is unusual for a BST but in this coursework, specifically test 4, contains repeated values.
		else if (cmp > 0) h.right = put(h.right, key); 
		// else, insert into right child node

		// fix-up any right-leaning links
		if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
		if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
		if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;

		return h;
	}


	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	// make a right-leaning link lean to the left
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}

	// flip the colors of a node and its two children
	private void flipColors(Node h) {
		// h must have opposite color of its two children
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}


	public Key select(int k) {
		if (k < 0 || k >= size()) throw new IllegalArgumentException();
		Node x = select(root, k);
		return x.key;
	}

	// the key of rank k in the subtree rooted at x
	private Node select(Node x, int k) {
		int t = size(x.left); 
		if      (t > k) return select(x.left,  k); 
		else if (t < k) return select(x.right, k-t-1); 
		else            return x; 
	} 

	/**
	 * Note!!! 
	 * This BST structure is inspired from the work of Robert Sedgewick and Kevin Wayne 
	 * URL: http://algs4.cs.princeton.edu/33balanced/
	 */

}
