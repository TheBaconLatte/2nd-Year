package ut9;

import java.util.*;

public class lab9 {
	public static void main(String args[]){
		int six_count = 0;
		int sneeze_count = 0;
		int snapchat_count = 0;
		double D = 0; // rolling a six
		double simulation = 100000000; // will simulate rolling the dice this amount of times
		int roll_point = 0; //acts as a counter (i)

		while(roll_point<simulation){
			int d6 = (int)((Math.random()*6)+1); //generates a random number between 1 and 6
			int snap = (int)((Math.random()*150)+1);
			int snz = (int)((Math.random()*300)+1);

			boolean six = false,snapchat = false, sneeze = false;
			if(d6 == 6){
				six_count++; //counts total number of sixes rolled
				six = true;
			}
			if(snap == 1){
				snapchat = true;
				snapchat_count++; //number of snaps received
			}
			if(snz==1){
				sneeze = true;
				sneeze_count++; //number of sneezes occurred 
			}

			if((six && !snapchat)&& !sneeze){
				D++; //number of only sixes without sneezes or snapchatw
			}
			roll_point++;
		}
		System.out.println("Number of total sixes : " + six_count);
		System.out.println("Number of total snaps : " + snapchat_count);
		System.out.println("Number of total sneezes : " + sneeze_count);
		System.out.println("Number rolls needed : " + D/(snapchat_count+sneeze_count));

	}

}