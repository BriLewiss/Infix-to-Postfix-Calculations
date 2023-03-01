
// Class: Data Structures Section 02
// Term: Spring
// Name: Brianna Lewis
// Program Number: 3
// IDE: Eclipse

import java.util.ArrayList;

public class MyStackBriannaLewis <E> { 
	ArrayList <E> myStack = new ArrayList<E> ();
	
	//this method returns true if the stack is empty
	public boolean isEmpty () {
		if (myStack.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//this method returns the number of elements in the stack
	public int size () {
		return myStack.size();
	}
	
	//this method returns the top element in the stack
	public E peek () {
		return myStack.get(myStack.size()-1);
	}
	
	//this method returns and removes the top element in the stack
	public E pop () {
		E data = myStack.get(myStack.size()-1);
		myStack.remove(myStack.size()-1);
		return data;
	}
	
	//this method adds an element to the stack
	public void push (E data) {
		myStack.add(data);
	}
	
	//this method lists out all elements in the stack
	public String toString() {
		return "Stack: " + myStack.toString();

	}
}
