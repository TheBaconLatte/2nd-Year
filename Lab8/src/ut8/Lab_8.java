package ut8;

public class Lab_8 {
	public static void main(String[] args){

		FileIO io = new FileIO();
		String[] original = io.load("C:\\Users\\Kerrie-Ann\\Documents\\StockData.txt");
		int numrows=original.length;
		int numcols=original[0].split("\t").length; //splits at tab (end of the line)
		double[][] array = new double[numrows][numcols];

		for(int i=1;i<numrows;i++){
			for(int j=1;j<numcols;j++){
					array[i][j]=Double.parseDouble(original[i].split("\t")[j]); //takes in all numberical values
			}
		}
		
		String[] cName = original[0].split("\t"); //takes in first name after date
		for(int i=1;i<numcols;i++){ //runs along all columns
			System.out.println(cName[i]+": "); //prints out the name at that point
			for(int j=numrows-1;j>0;j--){					
					System.out.print(" "+array[j][i]+" "); //prints out numerical values corresponding to that name
			}
			System.out.println(); //moves to next line
		}
	}
}
