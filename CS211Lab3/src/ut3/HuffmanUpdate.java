package ut3;
import java.util.*;

public class HuffmanUpdate {
	public static void main(String args[]){
		System.out.println("Please enter your sentence: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String binary = ""; // will store the string of binary code
		int len = s.length();
		
		for(int i =0;i<len;i++){ //run through the sentence
			int dec = (int) s.charAt(i); //converts each char to its decimal value
			String binaryVal = Integer.toBinaryString(dec); //converts decimal values to binary
			for(int j=7;j>binaryVal.length();j--){
				binary += "0"; //adds leading 0's
			}
			binary += binaryVal+" "; //adds converted letters to string to reform the sentence
		}
		
		System.out.println(binary); //prints out binary sentence		
		
		int[] array = new int[256]; //array to store frequency
		
		for(int i=0;i<len;i++){
			array[(int) s.charAt(i)]++; //stores frequency of each character
		}
				
		PriorityQueue<Tree> PQ = new PriorityQueue<Tree>(); //make a priority queue to store forest
		
		for(int i=0;i<array.length;i++){
			if(array[i]>0){ //print out all characters that occurred and their frequencies
				System.out.println("'"+(char) i +"' appeared "+array[i]+ ((array[i] == 1) ? " time." : " times."));
				Node rootNode = new Node((char) i); //make the forest and add them to the PQ
				Tree letterTree = new Tree(rootNode, array[(char) i]);//create a new tree, set the cumulative frequency of that tree, insert the letter as root node
				PQ.add(letterTree); //add tree to queue
			}
		}
		
		while(PQ.size() > 1){ //while there are more or more trees left
			Tree tree1 = PQ.poll();//take out trees
			Tree tree2 = PQ.poll();
			Node newRoot = new Node(); //huffman algorithm, new root
			newRoot.leftChild = tree1.root; //sets trees as children or root
			newRoot.rightChild = tree2.root;
			
			int frequency = tree1.frequency + tree2.frequency; //calculates new frequency
			Tree newTree = new Tree(newRoot, frequency); //creates new tree
			PQ.add(newTree); //place it in queue
		}
		
		Tree HuffmanTree = PQ.poll(); //now there's one tree left
		String binaryString = ""; //stores codes
		for(int i =0;i<array.length;i++){
			if(array[i] > 0){
				binaryString += "Char: " + ((char) i) + " Huffman code is: ";//stores codes of chars in string
				binaryString += HuffmanTree.getCode((char) i);
				binaryString += "\n";
			}
		}
		System.out.println("\n Characters in huffman code are:\n" + binaryString);//prints out huffman codes
		String binaryString2 = ""; //string to store sentence
		for(int i =0;i< len;i++){ //loops through sentence to store is all
			binaryString2 += HuffmanTree.getCode(s.charAt(i));
			binaryString2 += " ";
		}
		System.out.println("Sentence in huffman code is: "+binaryString2); //prints out sentence in huffman code
		//time to get compression values~
		int ascii = (binary.replaceAll("\\s+","").length());
		int huffman = (binaryString2.replaceAll("\\s+",  "").length());
		double compression = ((double) huffman/ascii);
		compression = compression *100;
		System.out.println("Compressed size is: "+huffman+"/"+ascii+" = "+(int) compression + " %");
	}
	
}

