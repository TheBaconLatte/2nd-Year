package ut6;

public class privateKey {
	public static void main(String args[]){
		long p = 24852977, g = 2744, gxp = 8414508, c1 = 15268076, c2 = 743675;
		long x =0;
		for(long i = 1; i<p;i++)			//brute forcing the private key by 
		{									//checking every value between 0 and p
			if(modPow(g,i,p)==gxp)		//searching for x, if the current i makes it equal to the known value of g^x mod p
			{
				x = i;						//sets x to the private key value
				break;						//breaks for efficiency
			}
		}
		System.out.println("Private key: " + x); //prints private key value
		long c1x = modPow(c1,(p-1-x),p);	//gets the value of c1^x mod p
		//System.out.println(c1x);
		c2=c2%p;								//c2 mod p
		//System.out.println(c2);
		long message=modMult(c1x,c2,p);		//multiplies c1x*c2 and mods by p
		System.out.println("Message: " + message);
		
	}
	
	// ****** PHIL'S CODE ********
	public static long modPow(long number, long power, long modulus){
		//raises a number to a power with the given modulus
		//when raising a number to a power, the number quickly becomes too large to
		//handle
		//you need to multiply numbers in such a way that the result is consistently
		//moduloed to keep it in the range
		//however you want the algorithm to work quickly - having a multiplication
		//loop would result in an O(n) algorithm!
		//the trick is to use recursion - keep breaking the problem down into smaller
		//pieces and use the modMult method to join them back together
		if(power==0)
			return 1;
		else if (power%2==0) {
			long halfpower=modPow(number, power/2, modulus); //recursively gets the modulus of the number
			return modMult(halfpower,halfpower,modulus);
		}else{
			long halfpower=modPow(number, power/2, modulus);
			long firstbit = modMult(halfpower,halfpower,modulus);
			return modMult(firstbit,number,modulus);
		}
	}

	public static long modMult(long first, long second, long modulus){
		//multiplies the first number by the second number with the given modulus
		//a long can have a maximum of 19 digits. Therefore, if you're multiplying
		//two ten digits numbers the usual way, things will go wrong
		//you need to multiply numbers in such a way that the result is consistently
		//moduloed to keep it in the range
		//however you want the algorithm to work quickly - having an addition loop
		//would result in an O(n) algorithm!
		//the trick is to use recursion - keep breaking down the multiplication into
		//smaller pieces and mod each of the pieces individually
		if(second==0)
			return 0;
		else if (second%2==0) {
			long half=modMult(first, second/2, modulus); //halving the number because otherwise it's too big to calculate
			return (half+half)%modulus;
		}else{
			long half=modMult(first, second/2, modulus);
			return (half+half+first)%modulus;
		}
	}
}
