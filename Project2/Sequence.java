import java.util.*;

/*
 * A class to allow storing of the 
 * two sequences
 * @author Prabhat Bhootra
 * @version 1.00 11/27/2018
 */

public class Sequence{
	LinkedList<Character> s;
	public Sequence(){
		s = new LinkedList<Character>();
	}
	/*
	 * A method to insert a character at a certain index of 
	 * a sequence
	 * @param index an integer representing the index of where the character should be added
	 * @param c a character that should be inserted into the given index of the sequence
	 */
	public void setChar(int index, char c){
		s.add(index, c);
	}
	/*
	 * A method to get a character from a certain index of the sequence
	 * @param index an integer representing the index from where the character should be retrieved from the sequence
	 * @return the character at the given index in the sequence
	 */
	public char getChar(int index){
		return s.get(index);
	}
	/*
     * A method that gives the length of the sequence
	 * @return the size of the linked list the sequence is stored in
	 */
	public int getSize(){
		return s.size();
	}
}