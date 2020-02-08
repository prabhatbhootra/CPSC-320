
import java.util.*;
/*
 * A class to add computer nodes
 * and their edges to a graph and 
 * check whether a virus infected a 
 * particular computer
 * @author Prabhat Bhootra
 * @version 1.00 10/9/18
 */


public class Digraph<E>{                       
	private LinkedList<E>[] L1;
	private int sz;
	private int CAPACITY;
	public Digraph(int c){
		CAPACITY = c;
        sz = 0;
		L1 = (LinkedList<E>[]) new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++){
            L1[i] = new LinkedList<E>();
        }
	}
    /*
     * A method to add nodes to the graph along
     * with the time of the computers' communication
     * @param n1 an integer name of the first computer
     * @param n2 an integer name of the second computer
     * @param n3 an integer for the time of communication
     *
     */
    public void addNodes(int n1, int n2, int n3){
        if (L1[n1-1].firstName() == 0){
            L1[n1-1].addFirst(0, n1);
            L1[n1-1].addLast(n3, n2);
            if (L1[n2-1].firstName() == 0){
                L1[n2-1].addFirst(0, n2);
                L1[n2-1].addLast(n3, n1);
            }
            else{
                L1[n2-1].addLast(n3, n1);
            }
        }
        else{
            L1[n1-1].addLast(n3, n2);
            if (L1[n2-1].firstName() == 0){
                L1[n2-1].addFirst(0, n2);
                L1[n2-1].addLast(n3, n1);
            }
            else{
                L1[n2-1].addLast(n3, n1);
            }
        }
    }
    /*
     * A method to add nodes to check whether a virus inserted into a computer
     * at a certain time has infected another computer at another time
     * @param n1 an integer name of the first computer
     * @param t1 an integer for the time of infection of the first computer
     * @param n2 an integer name of the second computer
     * @param t2 an integer for the time to be checked for the second computer
     * @return flag true if it was infected at that time, false otherwise
     */
    public boolean checkVirus(int n1, int t1, int n2, int t2){
        boolean flag = false;
        Deque<Node<E>> s = new ArrayDeque<Node<E>>();
        s.addLast((Node<E>) L1[n1-1].getHead());
        while ((!s.isEmpty()) && (flag != true)){
            Node<E> k = (Node<E>) s.removeFirst();
            k.setVisited(true);
            if ((k.getName() == n2) && (k.getElement() != 0) && (k.getElement() <= t2)){
                flag = true;
            }
            while (k.getNext() != null){
                k = k.getNext();
                if (k.getElement() < t1){
                    break;
                }
                Node<E> v = L1[k.getName()-1].getHead();
                if (v.getElement() == 0){
                    v = v.getNext();
                }
                while (v.getNext() != null){
                    if (v.getVisited() == false){
                        v.setVisited(true);
                        s.addLast(v);
                        if ((v.getName() == n2) && (v.getElement() <= t2) && (v.getElement() != 0)){  //t1
                            flag = true;
                        }
                    }
                    v = v.getNext();
                } 
            }
        }
        return flag;
    }                      
}
