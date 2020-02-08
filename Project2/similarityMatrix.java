/*
 * A class to allow storing of the matrix
 * of mismatch penalties between all possible 
 * combinations of two characters in sequences
 * @author Prabhat Bhootra
 * @version 1.00 11/27/2018
 */

public class similarityMatrix{
	int[][] m = new int[4][4];
	public similarityMatrix(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				m[i][j] = 0;
			}
		}
	}
	/*
	 * A method to set the mismatch penalty between two letters in sequences.
	 * @param a an integer representing the row of the matrix, which we need to set the value of the mismatch for
	 * @param b an integer representing the column of the matrix, which we need to set the value of the mismatch for
	 * @param c an integer representing a mismatch penalty between two letters in sequences
	 */
	public void setVal(int a, int b, int c){
		m[a][b] = c;
	}
	/*
	 * A method to get the mismatch penalty between two letters in sequences.
	 * @param a an integer representing the row of the matrix, which we need to get the value of the mismatch for
	 * @param b an integer representing the column of the matrix, which we need to get the value of the mismatch for
	 * @return the mismatch penalty between two letters of in sequences
	 */
	public int getVal(int a, int b){
		return m[a][b];
	}
}