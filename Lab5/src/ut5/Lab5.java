package ut5;

import java.io.File;
import java.util.Scanner;

public class Lab5 {
	
	static Scanner myst;
	
	public static void main(String args[]){
		int freq[] = new int[70000];
		int k = 0;
		FileIO reader = new FileIO();

		String[] array = reader.load("C:/Users/Kerrie-Ann/Documents/mystery.txt"); //read file as string array
		String input = "";
		
		for (int i = 0; i < array.length - 1; i++) { // go through the sentence
			input += array[i];
		}
		input = input.replace("\n", "").replace("\r", "");
		 
		for(int j = 0; j<array.length;j++){// sorts through mystery text, line by line, character by character
				freq[(int) input.charAt(j)]++;  //increments corresponding ascii value
		}
		
		for(int x=0;x<256;x++){
			for(int y=0;y<256;y++){
				if(freq[x]>freq[y]){ //sorts letters according to frequency of letters
					int temp = freq[x]; //swaps index of letters so ascii value is still stores
					freq[x]=freq[y];
					freq[y]=temp;	
				}
			}
		}
		
		int freqtotal = 0;
		for(int i=0; i<freq.length;i++){
			freqtotal += freq[i]; //gets the total frequency to allow calculations later
		}
		
		double[] danish = { 15.45, 8.96, 7.24, 6.86, 6.03, 6.00, 5.86, 5.81, 5.23, 4.64, 4.08, 3.39, 3.24, 2.41, 2.33, 2, 1.98, 1.76, 1.62, 1.19, 0.94, 0.87, 0.73, 0.7, 0.56, 0.07, 0.03, 0.03, 0.01 };
		double[] french = { 14.47, 7.98, 7.60, 7.32, 7.21, 7.11, 6.86, 5.86, 5.55, 5.39, 4.08, 3.39, 2.98, 2.78, 2.43, 1.29, 1.18, 1.12, 0.96, 0.93, 0.85, 0.43, 0.43, 0.42, 0.34, 0.3, 0.16, 0.13, 0.1, 0.08, 0.05, 0.05, 0.05, 0.04, 0.02, 0.02, 0.02, 0.01};
		double[] english = { 12.10, 8.94, 8.55, 7.47, 7.33, 7.17, 6.73, 6.33, 4.96, 4.21, 3.87, 3.16, 2.68, 2.53, 2.18, 2.09, 2.07, 1.83, 1.72, 1.6, 1.06, 0.81, 0.22, 0.19, 0.11, 0.1};
		double[] finnish = { 12.22, 10.82, 8.83, 8.75, 7.97, 7.86, 5.76, 5.61, 5.01, 4.97, 3.58, 3.2, 2.87, 2.04, 1.85, 1.84, 1.74, 1.04, 0.44, 0,39, 0.28, 0.28, 0.19, 0.09, 0.05, 0.03, 0.01, 0};
		double[] german = { 15.99, 9.59, 7.71, 7.60, 6.43, 6.41, 6.34, 4.92, 4.11, 3.76, 3.72, 3.02, 2.75, 2.75, 2.71, 2.23, 1.8, 1.5, 1.4, 1.22, 1.06,0.94, 0.63, 0.54, 0.27, 0.24, 0.15, 0.13, 0.07, 0.4 };
		double[] spanish = { 13.24, 12.50, 8.98, 7.44, 7.09, 6.91, 6.62, 5.84, 5.14, 4.43, 4.42, 4, 2.75, 2.61, 1.27, 1.17, 0.98, 0.83, 0.81, 0.79, 0.79, 0.45, 0.42, 0.22, 0.19, 0.08, 0.03 };
		double[] swedish = { 10.15, 9.38, 8.54, 8.43, 7.69, 6.59, 5.82, 5.28, 4.70, 4.48, 3.47, 3.14, 2.86, 2.42, 2.09, 2.03, 1.92, 1.84, 1.8, 1.54, 1.49, 1.34, 1.31, 0.71, 0.61, 0,16, 0.14, 0.07, 0.02};
		double[] icelandic = {10.11, 8.58, 7.71, 7.58, 6.42, 5.63, 4.95, 4.56, 4.53, 4.39, 4.24, 4.04, 3.31, 3.01, 2.44, 2.17, 1.87, 1.8, 1.68, 1.57, 1.45, 1.14, 1.04, 0.99, 0.9, 0.97, 0.79, 0.78, 0.65, 0.61, 0.23, 0.05};
		double[] russian = {10.61, 8.21, 8.04, 7.98, 6.72, 5.83, 5.71, 5.38, 4.75, 4.32, 3.49, 3.11, 2.95, 2.82, 2.28, 2, 1.91, 1.88, 1.61, 1.55, 1.39, 1.36, 1.23, 1.02, 0.8, 0.63, 0.58, 0.55, 0.41, 0.34, 0.31, 0.22, 0.03};
		double[] polish = {9.02, 8.09, 7.9, 7.51, 5.81, 5.17, 5.06, 4.78, 4.46, 3.96, 3.94, 3.7, 3.54, 3.23, 2.92, 2.73, 2.59, 2.36, 2.26, 1.82, 1.54, 1.39, 1.25, 0.98, 0.95, 0.89, 0.66, 0.58, 0.41, 0.26, 0.21, 0.07};
		
		double dtotal=0, ftotal=0, etotal=0, fitotal=0,gtotal=0,sptotal=0,swtotal=0,itotal=0,rtotal=0,ptotal=0;
		
		//calculate percentage frequency of each language to find the closest(largest) one
		for (int i = 0; i < danish.length; i++) {
			dtotal += Math.abs(((float) freq[i] / freqtotal) * 100 - danish[i]);
		}
		for (int i = 0; i < english.length; i++) {
			etotal += Math.abs(((float) freq[i] / freqtotal) * 100- english[i]);
		}
		for (int i = 0; i < finnish.length; i++) {
			fitotal += Math.abs(((float) freq[i] / freqtotal) * 100 - finnish[i]);
		}
		for (int i = 0; i < french.length; i++) {
			ftotal += Math.abs(((float) freq[i] / freqtotal) * 100 - french[i]);
		}
		for (int i = 0; i < german.length; i++) {
			gtotal += Math.abs(((float) freq[i] / freqtotal) * 100 - german[i]);
		}
		for (int i = 0; i < spanish.length; i++) {
			sptotal += Math.abs(((float) freq[i] / freqtotal) * 100 - spanish[i]);
		}
		for (int i = 0; i < swedish.length; i++) {
			swtotal += Math.abs(((float) freq[i] / freqtotal) * 100 - swedish[i]);
		}
		for (int i = 0; i < icelandic.length; i++) {
			itotal += Math.abs(((float) freq[i] / freqtotal) * 100 - icelandic[i]);
		}
		for (int i = 0; i < russian.length; i++) {
			rtotal += Math.abs(((float) freq[i] / freqtotal) * 100 - russian[i]);
		}
		for (int i = 0; i < polish.length; i++) {
			ptotal += Math.abs(((float) freq[i] / freqtotal) * 100 - polish[i]);
		}

		System.out.println("Danish: " + dtotal);
		System.out.println("English: " + etotal);
		System.out.println("Finnish: " + fitotal);
		System.out.println("French: " + ftotal);
		System.out.println("German: " + gtotal);
		System.out.println("Spanish: " + sptotal);
		System.out.println("Swedish: " + swtotal);
		System.out.println("Icelandic: " + itotal);
		System.out.println("Russian: " + rtotal);
		System.out.println("Polish: " + ptotal);

	}
}