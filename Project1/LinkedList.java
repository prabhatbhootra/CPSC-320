/*
 * A class to connect nodes for computers
 * using a linked list
 * @author Prabhat Bhootra
 * @version 1.00 10/9/18
 */
public class LinkedList<E>{
	private Node<E> head = new Node<E>(0, 0, null);    
	private Node<E> tail = new Node<E>(0, 0, null);
	private int size = 0;
	public LinkedList(){}

    /* A method to return the size
     * of the linked list
     * @return size the size of the linked list
     */    
	public int size(){
		return size;
	}
    /* A method to check if the linked list is empty
     * @return true if it is empty, false otherwise
     */
    public boolean isEmpty(){
    	return size == 0;
    }
    /* A method to return the head node of a linked list
     * @return head the head of the linked list
     */
    public Node<E> getHead(){
        return head;
    }
    /* A method to change the value of the elements
     * in the head node of the linked list
     * @param e an integer for the time of communication
     * @param nam an integer for the name of the computer
     * @return size the size of the linked list
     */
    public void setHead(int e, int nam, Node<E> n){
        head.setElement(e);
        head.setName(nam);
        head.setNext(n);
    }
    /* A method to return the time of the head node
     * @return the time of the head node
     */
    public int first(){
    	if (isEmpty()){
    		return 0;
    	}
    	return head.getElement();
    }
    /* A method to return the name of the head node
     * @return the name of the head node
     */
    public int firstName(){
        if (isEmpty()){
            return 0;
        }
        return head.getName();
    }
    /* A method to return the time of the tail node
     * @return the time of the tail node
     */
    public int last(){
    	if (isEmpty()){
    		return 0;
    	}
    	return tail.getElement();
    }
    /* A method to return the name of the tail node
     * @return the name of the tail node
     */
    public int lastName(){
        if (isEmpty()){
            return 0;
        }
        return tail.getName();
    }
    /* A method to add a node as the head of the linked list
     * @param e the time for the new head node
     * @param nam the name of the new head node
     */
    public void addFirst(int e, int nam){
    	head = new Node<E>(e, nam, head);
    	if (size == 0){
    		tail = head;
    	}
    	size++;
    }
    /* A method to add a node as the tail of the linked list
     * @param e the time of the new tail node
     * @param nam the name of the new tail node
     */
    public void addLast(int e, int nam){
    	Node<E> newest  = new Node<>(e, nam, null);
    	if (isEmpty()){
    		head = newest;
    	}
    	else{
    		tail.setNext(newest);
    	}
    	tail = newest;
    	size++;
    }
    /* A method to remove the head node of the linked list
     * @return answer the time of the previous head element
     */
    public int removeFirst(){
    	if (isEmpty()){
    		return 0;
    	}
    	int answer = head.getElement();
    	head = head.getNext();
    	size--;
    	if (size == 0){
    		tail = null;
    	}
    	return answer;
    }
}