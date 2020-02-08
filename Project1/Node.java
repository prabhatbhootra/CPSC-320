/* 
 * A node class for computers
 * @author Prabhat Bhootra
 * @version 1.00 10/9/18
 */

public class Node<E>{
    	private int element = 0;
        private int name = 0;
    	private Node<E> next = null;
        private boolean visited  = false;
        /* 
         * Constructs a node with a given element
         * , name and next computer
         * @param e an integer element for the time to be stored
         * @param na an integer element for the computer name
         * @param n the node for the next computer
         */
    	public Node(int e, int na, Node<E> n){
    		element = e;
            name = na;
    		next = n;
    	}

        // accessor and update methods
    	public int getElement(){
    		return element;
    	}
        public int setElement(int e){
            int temp = element;
            element = e;
            return temp;
        }
        public int getName(){
            return name;
        }
        public int setName(int no){
            int temp = name;
            name = no;
            return temp;
        }
    	public Node<E> getNext(){
    		return next;
    	}
    	public void setNext(Node<E> n){
    		next = n;
    	}
        public void setVisited(boolean b){
            visited = b;
        }
        public boolean getVisited(){
            return visited;
        }
	}