package ut3;
import java.util.*; // for Stack class

public class Tree implements Comparable<Tree> {
		public Node root; // first node of tree
		public int frequency = 0;

		public Tree() // constructor
		{
			root = null;
		} // no nodes in tree yet

		public Tree(Node inRoot, int inFrequency) {
			this.root = inRoot;
			this.frequency = inFrequency;
		}

		public int compareTo(Tree object) { //
			if (frequency - object.frequency > 0) { // compare the cumulative
													// frequencies of the tree
				return 1;
			} else if (frequency - object.frequency < 0) {
				return -1; // return 1 or -1 depending on whether these frequencies
							// are bigger or smaller
			} else {
				return 0; // return 0 if they're the same
			}
		}

		String path = "error"; // this variable will track the path to the letter
		// String path = "";

		public String getCode(char letter) { // we want the code for this letter

			inOrder(root, letter, ""); // uses inOrder method to traverse tree and
										// generate code
			return path; // return the path that results

		}

		private void inOrder(Node localRoot, char letter, String path) {
			if (localRoot != null) {// Checks for data
				if (localRoot.letter == letter) // if correct path is this value
					this.path = path; // stores path
				else { // traverses child paths and store corresponding child codes
						// using recursion
					inOrder(localRoot.leftChild, letter, path + "0");
					inOrder(localRoot.rightChild, letter, path + "1");
				}
			}
		}
	}