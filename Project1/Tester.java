
import java.util.*;
import java.io.*;

/*
 * A tester class to get input of computers and a virus infection
 * from a file and check whether a computer can be infected at a 
 * certain time, if another computer was infected at a certain time 
 * @author Prabhat Bhootra
 * @version 1.00 10/9/18
 */

public class Tester{
	public static void main(String args[]){
		Digraph<String> D = new Digraph<String>(0);
		ArrayList<Integer> b = new ArrayList<Integer>();
		int countline = 0;
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()){
			String[] a;
			a =input.nextLine().split(" ");
			countline++;
			if ((a.length < 3) && (countline == 1)){
				D = (Digraph<String>) new Digraph<String>(Integer.valueOf(a[0]));
			}
			else if (a.length == 3){
				D.addNodes(Integer.valueOf(a[0]), Integer.valueOf(a[1]), Integer.valueOf(a[2]));
			}
			else{
				if (countline > 2){
					for (int i = 0; i < a.length; i++){
						b.add(Integer.valueOf(a[i]));
					}
				}	
			}
			a = null;
		}
		if (D.checkVirus(b.get(0), b.get(1), b.get(2), b.get(3)) == true){
			System.out.println("The virus has infected C" + b.get(2) + " by time " + b.get(3) + ".");
		}
		else{
			System.out.println("The virus has not infected C" + b.get(2) + " by time " + b.get(3) + ".");
		}
	}
}