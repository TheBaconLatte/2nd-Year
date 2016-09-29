package poop;

import java.util.*;

public class Lab1Q2 {
	public static void main(String args[]) {
		Random ran = new Random();
		double[] sides = new double[3]; // contains sides of triangle
		double[] snaps = new double[2]; // contains length of broken pieces
		double left = 0.0;
		int count = 0, trials = 100000; // trials = number of loops

		for (int x = 0; x < trials; x++) {
			snaps[0] = ran.nextDouble(); // breaks stick at random place
			left = 1.0 - snaps[0]; // finds out how much is left
			double temp = 1.0;
			if (snaps[0] <= 0.5) { // if the broken piece is the shorter piece, it breaks the longer piece
				while (temp >= left) { //temp cannot be greater than what is left of the stick
					temp = ran.nextDouble(); //generates random lengths to break
				}
				snaps[1] = temp; // stores value
			} else { //if the first side is the longest piece
				while (temp >= snaps[0]) { // temp cannot be longer than the piece we're breaking
					temp = ran.nextDouble(); // generates random length to break off
				}
				snaps[1] = temp; //stores the value of the second piece
				snaps[0] = snaps[0] - snaps[1]; //updates the value of the first piece
			}
			sides[0] = snaps[0]; //sets lengths of sides
			sides[1] = snaps[1];
			sides[2] = 1.0 - (snaps[0] + snaps[1]); // calculates length of remaining side

			Arrays.sort(sides); //sorts sides according to length

			if (sides[2] < (sides[1] + sides[0])) { //hypotenuse cannot be longer than other 2 sides added toegther
				count++; //triangle found!
			}
		}
		double prob = (double) count / trials; // calculates probability
		System.out.println("Number of triangles:" + count); //prints out number of triangles
		System.out.println("Probability:" + prob);
	}
}
