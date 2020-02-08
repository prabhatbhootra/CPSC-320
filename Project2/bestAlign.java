import java.lang.Math;

/*
 * A class to implement functions that generate the correct sequence
 * alignment to reduce the minimum edit distance and calculate the minimum
 * edit distance  
 * @author Prabhat Bhootra
 * @version 1.00 11/27/2018
 */

public class bestAlign{
	int delta;
	similarityMatrix sim1;
	Sequence seq1;
	Sequence seq2;
	int[][] minCost;
	int len1;
	int len2;
	int[] penalties;
	public bestAlign(int del, similarityMatrix simMat, Sequence a, Sequence b){
		delta = del;
		sim1 = simMat;
		seq1 = a;
		seq2 = b;
		minCost = new int[seq1.getSize() + 1][seq2.getSize() + 1];
		len1 = seq1.getSize() - 1;
		len2 = seq2.getSize() - 1;
		if (seq1.getSize() < seq2.getSize()){
			penalties = new int[seq2.getSize()];
		}
		else{
			penalties = new int[seq1.getSize()];
		}
	}
	/*
	 * A method to get the mismatch penalty of two letters in sequences from
	 * the similarity matrix
	 * @param c1 a character from the first sequence
	 * @param c2 a character from the second sequence
	 * @return the mismatch penalty of two letters in different sequences
	 */
	public int mismatchPenalty(char c1, char c2){
		if ((c1 == 'A') && (c2 == 'A')){
			return sim1.getVal(0, 0);
		}
		else if ((c1 == 'A') && (c2 == 'C')){
			return sim1.getVal(0, 1);
		}
		else if ((c1 == 'A') && (c2 == 'G')){
			return sim1.getVal(0, 2);
		}
		else if ((c1 == 'A') && (c2 == 'T')){
			return sim1.getVal(0, 3);
		}
		else if ((c1 == 'C') && (c2 == 'A')){
			return sim1.getVal(1, 0);
		}
		else if ((c1 == 'C') && (c2 == 'C')){
			return sim1.getVal(1, 1);
		}
		else if ((c1 == 'C') && (c2 == 'G')){
			return sim1.getVal(1, 2);
		}
		else if ((c1 == 'C') && (c2 == 'T')){
			return sim1.getVal(1, 3);
		}
		else if ((c1 == 'G') && (c2 == 'A')){
			return sim1.getVal(2, 0);
		}
		else if ((c1 == 'G') && (c2 == 'C')){
			return sim1.getVal(2, 1);
		}
		else if ((c1 == 'G') && (c2 == 'G')){
			return sim1.getVal(2, 2);
		}
		else if ((c1 == 'G') && (c2 == 'T')){
			return sim1.getVal(2, 3);
		}
		else if ((c1 == 'T') && (c2 == 'A')){
			return sim1.getVal(3, 0);
		}
		else if ((c1 == 'T') && (c2 == 'C')){
			return sim1.getVal(3, 1);
		}
		else if ((c1 == 'T') && (c2 == 'G')){
			return sim1.getVal(3, 2);
		}
		else{
			return sim1.getVal(3, 3);
		}
	}
	/*
	 * A method to find the best alignment of two sequences by computing minimum edit distances
	 * as each character of a string is considered
	 */
	public void alignment(){
		for (int p = 0; p < seq1.getSize(); p++){
			minCost[p][0] = delta*p;
		}
		for (int q = 0; q < seq2.getSize(); q++){
			minCost[0][q] = delta*q;
		}
		for (int x = 1; x < seq1.getSize(); x++){
			for (int y = 1; y < seq2.getSize(); y++){
				minCost[x][y] = Math.min(mismatchPenalty(seq1.getChar(x), seq2.getChar(y)) + minCost[x-1][y-1], Math.min(delta + minCost[x-1][y], delta + minCost[x][y-1]));
			}
		}
	}
	/*
	 * A method to to add dashes where required to give the alignment of two sequences with
	 * the minimum edit distance based upon the values calculated by the alignment function
	 */
	public void output(){
		if (len2 == -1){
			for (int w = 0; w <= len1; w++){
				seq2.setChar(w, '-');
				penalties[w] = delta;
			}
		}
		else if (len1 == -1){
			for (int w = 0; w <= len2; w++){
				seq1.setChar(w, '-');
				penalties[w] = delta;
			}
		}
		else if (len1 == 0){ 
			if (mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2)) <= delta){
				if (len1 > len2){
					penalties[len1] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2));
				}
				else{
					penalties[len2] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2));
				}
				penalties[len2] = mismatchPenalty(seq1.getChar(0), seq2.getChar(len2));
				for (int w = 0; w < len2; w++){
					seq1.setChar(w, '-');
					penalties[w] = delta;
				}
			}
			else if (minCost[len1][len2] == (delta + minCost[len1][len2-1])){
				if (len1 > len2){
					penalties[len1] = delta;
				}
				else{
					penalties[len2] = delta;
				}
				seq1.setChar(len1 + 1, '-');
				len2--;
				output();
			}
			
		}
		else if (len2 == 0){
			if (mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2)) <= delta){
				if (len1 > len2){
					penalties[len1] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2));
				}
				else{
					penalties[len2] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2));
				}
				penalties[len1] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(0));
				for (int w = 0; w < len1; w++){
					seq2.setChar(w, '-');
					penalties[w] = delta;
				}
			}
			else if (minCost[len1][len2] == (delta + minCost[len1-1][len2])){
				if (len1 > len2){
					penalties[len1] = delta;
				}
				else{
					penalties[len2] = delta;
				}
				seq2.setChar(len2 + 1, '-');        
				len1--;
				output();
			}	
		}
		else if (minCost[len1][len2] == (mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2)) + minCost[len1-1][len2 - 1])){
			if (len1 > len2){
				penalties[len1] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2));
			}
			else{
				penalties[len2] = mismatchPenalty(seq1.getChar(len1), seq2.getChar(len2));
			}
			len1--;
			len2--;
			output();
		}
		else if (minCost[len1][len2] == (delta + minCost[len1-1][len2])){
			if (len1 > len2){
				penalties[len1] = delta;
			}
			else{
				penalties[len2] = delta;
			}
			seq2.setChar(len2 + 1, '-'); 
			len1--;
			output();
		}
		else if (minCost[len1][len2] == (delta + minCost[len1][len2-1])){
			if (len1 > len2){
				penalties[len1] = delta;
			}
			else{
				penalties[len2] = delta;
			}
			seq1.setChar(len1 + 1, '-');        
			len2--;
			output();
		}
	}
	/*
	 * A print the penalties between each of the characters in the sequences and 
	 * calculate the minimum edit distance
	 * @return sum an integer representing the minimum edit distance of the alignment
	 */
	public int printPenalties(){
		int sum = 0;
		System.out.print(penalties[0]);
		sum += penalties[0];
		for (int b = 1; b < penalties.length; b++){
			System.out.print(" " + penalties[b]);
			sum += penalties[b];
		}
		System.out.println();
		return sum;
	}

}