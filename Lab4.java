import java.util.*;
import java.math.*;
/* java code to create an array of prime numbers and find the prime number closest to the input number
*/

public class Lab4 {
    public static void main(String args[] ) throws Exception {
     Scanner scan = new Scanner(System.in);
     int n = scan.nextInt();
        int prime[] = new int[100000];
        int count = 0, j = 0;
        for(int x = 0; x<=10000;x++){
        	for(int i = 2; i<x;i++){
           		 if(x%i == 0 && x!=i && x!=2){
               		 count++;
           		 }
      	  	}
        	if(count == 0){
           	 prime[j] = x;
           	 j++;
        	}
            count = 0;
       }

    int closest = 0, smallestdiff = 10000;
    int diff = 0;
    for(int i = 0; i<prime.length;i++)
    {
	diff = Math.abs(n - prime[i]);
	if(diff<smallestdiff){
		smallestdiff = diff;
		closest = prime[i];
	}
    }
System.out.println(closest);

    }
}