import java.util.*;

/*
 * A class to take the input provided by the user and to call 
 * functions to generate an alignment of sequences and calculate
 * the minimum edit distance.
 * @author Prabhat Bhootra
 * @version 1.00 11/27/2018
 */

public class Tester{
	public static void main(String args[]){
		similarityMatrix sm = new similarityMatrix();
		Sequence s1 = new Sequence();
		Sequence s2 = new Sequence();
		Scanner scan = new Scanner(System.in);
		int d = 0;
		int row = 0;
		int countlines = 0;
		int MinEditDist;

		while (scan.hasNextLine()){
			String line = scan.nextLine().replaceAll("\\s", "");
			countlines++;
			if ((line.length() < 2) && (countlines < 2)){
				d = Character.getNumericValue(line.charAt(0));
			}
			else if ((line.length() < 5) && (countlines < 6)){
				for (int k = 0; k < line.length(); k++){
					sm.setVal(row, k, Character.getNumericValue(line.charAt(k)));
				}
				row++;
			}
			else{
				if (s1.getSize() == 0){
					for (int j = 0; j < line.length(); j++){
						s1.setChar(j, line.charAt(j));
					}
				}
				else {
					for (int j = 0; j < line.length(); j++){
						s2.setChar(j, line.charAt(j));
					}
				}
			}
		}
		System.out.println();
		System.out.println("The best alignment is");
		System.out.println();
		bestAlign b1 = new bestAlign(d, sm, s1, s2);
		b1.alignment();
		b1.output();
		System.out.print(s1.getChar(0));
		for (int c = 1; c < s1.getSize(); c++){
			System.out.print(" " + s1.getChar(c));
		}
		System.out.println();
		System.out.print(s2.getChar(0));
		for (int h = 1; h < s2.getSize(); h++){
			System.out.print(" " + s2.getChar(h));
		}
		System.out.println();
		MinEditDist = b1.printPenalties();
		System.out.println();
		System.out.println("with the minimum edit distance of " + MinEditDist + ".");
	}
}