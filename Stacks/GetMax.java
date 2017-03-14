/*
 * Implement getMax() function in O(1) time complexity
 * This implementation alters the stack data structure 
 */

package Stacks;

public class GetMax
{
	private class Node
	{
		 int data;
		 Node next;
		
		//To keep track of the previous max that was added to the stack before the current push operation
		 Node oldMax;
		
		public Node(int d)
		{
			data = d;
			next = null;
			oldMax = null;
		}
	}
	
	 Node top;
	 Node newMax;
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	//push operation
	public void push(int data)
	{
		//Create a new node
		Node newNode = new Node(data);
		
		//If stack is empty, make the newNode as the top
		if ( isEmpty() )
		{
			top = newNode;
		}
		else
		{
			newNode.next = top;
			top = newNode;
		}
		
		//Update the newMax with every push operation
		if ( newMax == null || newNode.data > newMax.data)
		{
			newNode.oldMax = newMax;
			newMax = newNode;
		}
	}
	
	//pop operation
	public int pop()
	{
		if( isEmpty() )
		{
			System.err.println("Error: Cannot pop from an empty stack");
			return 0;
		}
				
		Node poppedElement = top;
		top = top.next;
		
		if( poppedElement.oldMax != null )
			newMax = poppedElement.oldMax;
		
		return poppedElement.data;		
	}
	
	//GetMaximum element of the stack
	public int getMax()
	{
		if( isEmpty() )
		{
			System.err.println("Error: Empty stack");
			return 0;
		}
		return newMax.data;
	}
	
	//Driver Function
	public static void main(String[] args) 
	{
		GetMax stack = new GetMax();
		  
		stack.push(1);
		stack.push(4);
		stack.push(2);
		stack.push(44);
		stack.push(21);
		
		System.out.println("Maximum element in the stack is :"+stack.getMax());
	}
}
