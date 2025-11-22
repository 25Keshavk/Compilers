/**
 * Write a description of class DoubleNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class DoubleNode<E> {
	private DoubleNode next;
	private DoubleNode previous;
	private E value;
	
	public DoubleNode(E value) {
		next = null;
		previous = null;
		this.value = value;
	}
	
	public DoubleNode getNext() {
		return next;
	}
	
	public DoubleNode getPrevious() {
		return previous;
	}
	
	public E getValue() {
		return value;
	}
	
	public void setNext(DoubleNode newNext) {
		next = newNext;
	}
	
	public void setPrevious(DoubleNode newPrevious) {
		previous = newPrevious;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
}
