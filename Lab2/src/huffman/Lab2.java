package huffman;
import java.util.*;

public class Lab2 {
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			int len = s.length();
			int[][] ascii = new int[256][2]; //array to store letters and frequency
			
			for(int i=0;i<256;i++){
				ascii[i][0] = i; //stores index of numbers
			}
			
			for(int i=0;i<len;i++){
				ascii[(int) s.charAt(i)][1]++; //fills array with letters, adds one for each occurrence of that letter
			}
			
			for(int i=0;i<256;i++){
				for(int j=0;j<256;j++){
					if(ascii[i][1]>ascii[j][1]){ //sorts letters according to frequency of letters
						int temp = ascii[i][0]; //swaps index of letters
						ascii[i][0]=ascii[j][0];
						ascii[j][0]=temp;
						
						int temp1 = ascii[i][1]; //swaps letters
						ascii[i][1]=ascii[j][1];
						ascii[j][1]=temp1;						
					}
				}
			}
			int count = 0;
			for(int i=0;i<256;i++){
				if(ascii[i][1] > 0){
					count++; //counts how many characters there are in the string after being sorted
				}
			}
			
			for(int i=0;i<count;i++){
				for(int j=0;j<count;j++){
					if(ascii[i][1]== ascii[j][1]){ //if amount of characters are equal
						if(ascii[i][0]<ascii[j][0]){ //if ascii value i is less than j, swap
							int temp2=ascii[i][0]; //index is swapped
							ascii[i][0]=ascii[j][0];
							ascii[j][0]=temp2;
							
							int temp3=ascii[i][1]; //value is swapped
							ascii[i][1]=ascii[j][1];
							ascii[j][1]=temp3;
						}
					}
				}
			}
			
			for(int i=0;i<count;i++){
				System.out.print((char) ascii[i][0]); //printing it out
			}
			
		}
		
	}
