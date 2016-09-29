package ut11;
import java.util.*;
public class stocks {
		public static void main(String args[]){
			FileIO io = new FileIO();
			String original[] = io.load("C:\\Users\\Kerrie-Ann\\Documents\\StockData.txt");
			int numrows=original.length;
			int numcols=original[0].split("\t").length; //splits at tab (end of the line)
			double[][] array = new double[numrows][numcols];
			double[] prices = new double[numcols]; //stores the prices of stocks
			Scanner sc = new Scanner(System.in);
			System.out.println("How much do you want to invest?");
			double max = sc.nextDouble();
			sc.close();

			for(int i=1;i<numrows-1;i++){
				for(int j=1;j<numcols;j++){
						array[i][j]=Double.parseDouble(original[i].split("\t")[j]); //takes in all numberical values
						prices[j]=Double.parseDouble(original[numrows-1].split("\t")[j]); //gets the prices of all stocks
				}
			}
			
			double[] vol = new double[numcols]; //stores volatility
			double[] tempcols = new double[numrows]; //temporarily stores the array values
			for(int k=0;k<numcols;k++){
				for(int l=0;l<numrows;l++){
					tempcols[l]=array[l][k]; //runs through columns, then rows
				}
				vol[k]= sd(tempcols); //sends the current column to method to find the standard deviation, ie, volatility
				//System.out.println(vol[k]);
			}
			
			double[] answer = new double[numcols];
			for(int m=0;m<numcols;m++){
				answer[m] = 0.0;
			}
			
			double sum = 0, temp = 0;
			for(int q=0;q<(max*0.001);q++){ //INITIALISE MAX VALUE L8R
				temp = sum; //keep investing if you still have money
				for(int b=1;b<numcols;b++){ //run through companies
					if(vol[b]<1.51&& (sum+prices[b]<max)){//don't invest in anything with a high volatility or over your max
						sum+=prices[b]; //sum of money spent
						answer[b]++; //invested 1 stock into that company
					}
				}
				if(temp == sum){
					System.out.println(temp + " : "+max);
					break;
				}
			}
			
			for(int w = 1;w<answer.length;w++){
				System.out.print(answer[w]+"\t");
			}
		}
			public static double sd(double[] numbers) {
				double sum = 0;

				for (int i = 0; i < numbers.length; i++) {
					sum += numbers[i];
				}
				double average = sum / numbers.length;
				// System.out.println("Average value is : " + average);
				double standard = 0;
				for (int i = 0; i < numbers.length; i++) {

					standard += (numbers[i] - average) * (numbers[i] - average);
					//standard+= (numbers[i]*numbers[i])/numbers.length - average*average;
				}

				return Math.sqrt(standard / (numbers.length - 1));

			}
			
			
			
		}
