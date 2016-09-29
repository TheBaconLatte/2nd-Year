package ut3;

import java.io.*;

	public class Node implements Serializable {

		public char letter = '\0'; // stores letter

		public Node leftChild = null; // this node's left child
		public Node rightChild = null; // this node's right child

		public Node() {
		} // Constructor

		public Node(char inLetter) { // add node
			this.letter = inLetter;
		}

	}
