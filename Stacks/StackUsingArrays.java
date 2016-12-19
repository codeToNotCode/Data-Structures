/*
 * Implement Stack using Arrays
 */

package Stacks;

public class StackUsingArrays 
{
	
	static Object stack[] = new Object[10];
	static int top = -1;
	
	//To check if the stack is empty
	public static boolean isEmpty()
	{
		return top == -1 ;
	}
	
	//To check if the stack is full
	public static boolean isFull()
	{
		return top == stack.length - 1 ;
	}
	
	//To display the topmost element of the stack
	public static Object peek()
	{
		return stack[top];
	}
	
	//To push elements unto a stack
	public static void push(Object data)
	{
		//Check for full stack
		if( isFull())
		{
			System.err.println("Error: Stack is full! Cannot add more elements");
			return;
		}
		else
			stack[++top] = data; 
	}
	
	//To pop an element out of the stack
	public static Object pop()
	{
		//Check for Empty Stack
		if( isEmpty() )
		{
			System.err.println("Error: Stack is empty! Cannot pop from an Empty stack");
			return null;
		}
		
		return stack[top--];
	}
	
	//To display stack elements
	public static void display()
	{
		//check for empty stack
		if( isEmpty() )
		{
			System.err.println("Error: Stack is Empty");
			return;
		}
		
		for( int i = top ; i != -1 ; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	
	public static void main(String[] args)
	{
		
		push("Hi");
		push("My");
		push("Name");
		push("is");
		push("Prasan");
		push("Deep");
		push("Singh");
		push("Ubhi");
		push("How");
		push("You");
		push("Doing");
		display();
		System.out.println("Element at the top of the stack :"+peek());
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
		pop();
		display();
	}

}
