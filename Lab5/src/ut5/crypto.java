package ut5;

import java.util.*;

public class crypto {

	public static void main(String[] args) {
		FileIO reader = new FileIO();

		String[] inputs = reader.load("C:/Users/Kerrie-Ann/Documents/mystery.txt"); // Reading
																				// the
																				// File
																				// as
																				// a
																				// String
																				// array
		int x = 0;
		String input = "";

		for (int i = 0; i < inputs.length - 1; i++) { // go through the sentence
			input += inputs[i];
		}
		input = input.replace("\n", "").replace("\r", "");

		int[] array = new int[256]; // an array to store all the frequencies

		for (int i = 0; i < input.length(); i++) { // go through the sentence
			array[(int) input.charAt(i)]++; // increment the appropriate
											// frequencies
		}

		int length = 0;
		for (int i = 0; i < array.length; i++) { // go through frequency array
			x += array[i];
		}

		float frequency = 0, perTot = 0;
		Arrays.sort(array);

		for (int i = 0; i < array.length / 2; i++) {
			double temp3 = array[i];
			array[i] = array[array.length - (i + 1)];
			array[array.length - (i + 1)] = (int) temp3;
		}
		/*for (int i = 0; i < array.length; i++) { // go through frequency array
			if (array[i] > 0) { // print out non-zero frequencies - cast to a
								// char
				frequency = ((float) array[i] / x) * 100;
				System.out.println("'" + (char) i + "' appeared " + array[i] + " || frequency = " + frequency);
				perTot += frequency;

			}
		}*/

		//System.out.println("\n" + perTot);
		double[] danish = { 15.45, 8.96, 7.24, 6.86, 6.03, 6.00, 5.86, 5.81, 5.23, 4.64 };
		double[] french = { 14.47, 7.98, 7.60, 7.32, 7.21, 7.11, 6.86, 5.86, 5.55, 5.39 };
		double[] english = { 12.10, 8.94, 8.55, 7.47, 7.33, 7.17, 6.73, 6.33, 4.96, 4.21 };
		double[] finnish = { 12.22, 10.82, 8.83, 8.75, 7.97, 7.86, 5.76, 5.61, 5.01, 4.97 };
		double[] german = { 15.99, 9.59, 7.71, 7.60, 6.43, 6.41, 6.34, 4.92, 4.11, 3.76 };
		double[] spanish = { 13.24, 12.50, 8.98, 7.44, 7.09, 6.91, 6.62, 5.84, 5.14, 4.43 };
		double[] swedish = { 10.15, 9.38, 8.54, 8.43, 7.69, 6.59, 5.82, 5.28, 4.70, 4.48 };

		// created a total for every language
		double dtotal = 0, etotal = 0, fitotal = 0, frtotal = 0, gtotal = 0, sptotal = 0, swtotal = 0;
		;

		// got the difference of each language
		System.out.println("Percentage error (lower is better) are: ");
		for (int i = 0; i < danish.length; i++) {
			dtotal += Math.abs(((float) array[i] / x) * 100 - danish[i]);
		}
		for (int i = 0; i < english.length; i++) {
			etotal += Math.abs(((float) array[i] / x) * 100- english[i]);
		}
		for (int i = 0; i < finnish.length; i++) {
			fitotal += Math.abs(((float) array[i] / x) * 100 - finnish[i]);
		}
		for (int i = 0; i < french.length; i++) {
			frtotal += Math.abs(((float) array[i] / x) * 100 - french[i]);
		}
		for (int i = 0; i < german.length; i++) {
			gtotal += Math.abs(((float) array[i] / x) * 100 - german[i]);
		}
		for (int i = 0; i < spanish.length; i++) {
			sptotal += Math.abs(((float) array[i] / x) * 100 - spanish[i]);
		}
		for (int i = 0; i < swedish.length; i++) {
			swtotal += Math.abs(((float) array[i] / x) * 100 - swedish[i]);
		}
		// printed out answers, didnt bother with rounding it yet
		System.out.println("Danish: " + dtotal);
		System.out.println("English: " + etotal);
		System.out.println("Finnish: " + fitotal);
		System.out.println("French: " + frtotal);
		System.out.println("German: " + gtotal);
		System.out.println("Spanish: " + sptotal);
		System.out.println("Swedish: " + swtotal);

	}
}
