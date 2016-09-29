package Lab4;

import java.io.*;
import java.util.*;

public class Scrabble {

		static PriorityQueueComparator pqc = new PriorityQueueComparator();
		static Scanner dict;

		public static void main(String args[]) throws FileNotFoundException {
			System.out.println("What letters do you have?");
			Scanner scan = new Scanner(System.in);
			String in = scan.nextLine();
			scan.close();// closes to save memory
			PriorityQueue<String> pq = new PriorityQueue<String>(pqc); // creates PQ
			pq = generator(in);//Calls Word Generator
			System.out.println("Searching for words...");//Status message
			System.out.println("Top 10 longest words found are:" + "\n");// print
			for (int i = 0; i < 10; i++) {
				if (pq.isEmpty() == false)
					System.out.println(pq.poll());
			}

		}

		static PriorityQueue<String> generator(String in) throws FileNotFoundException {
			PriorityQueue<String> pq = new PriorityQueue<String>(pqc); // lines to setup pq
			Scanner dict = new Scanner(new File("C:/Users/Kerrie-Ann/Documents/CS211/Lab4/dictionary.txt"));//Dictionary Scan
			do {
				String current = dict.nextLine(); // sets next line
				String temp = in; // sets or resets temp version of letters entered by user
				boolean valid = true;// resets/sets for loops to see if valid letter
				for (int i = 0; i < current.length() && valid == true; i++) { // loops through  dictionary
					if ((temp.indexOf(String.valueOf(current.charAt(i)))) > -1) { //checks if character is present in the current word
						temp = temp.replaceFirst(String.valueOf(current.charAt(i)), "");// remove char, replaces it with a blank space so that character isn't recounted in word
					} else
						valid = false;// breaks that words loop
				}
				if (valid == true) {// if true adds word to queue
					pq.add(current);
				}
			} while (dict.hasNext());// do while that runs while dictionary isnt
										// empty
			dict.close();// closes to save memory
			return pq;

		}
	}

	class PriorityQueueComparator implements Comparator<String> {// comparator for pq
		public int compare(String s1, String s2) {
			if (s1.length() > s2.length()) {// longer to front
				return -1; //-1 is at the top of the priority queue
			}
			if (s1.length() < s2.length()) {// shorter to back
				return 1;
			}
			return 0;// same
		}

	}

