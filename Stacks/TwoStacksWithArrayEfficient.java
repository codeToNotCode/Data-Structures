/*
 * Implement 2 stacks with an array
 * One stack starts from the begining and the other starts from the end of the array
 * Efficient implementation because of good utilisation of complete array space
 * Elements can be pushed onto either of the stacks untill the entire array space is utilized
 */

package Stacks;


public class TwoStacksWithArrayEfficient 
{
	Object arr[];
	int top1 , top2,size;
	
	public TwoStacksWithArrayEfficient(int s)
	{
		size = s;
		top1 = -1;
		top2 = s;
		arr= new Object[s];
	}
	
	//To check empty stack
	public boolean isEmpty1()
	{
		return top1 == -1 ;
	}
	public boolean isEmpty2()
	{
		return top2 == size  ;
	}
	
	//To check Full stack
	public boolean isFull()
	{
		return top1 == top2 - 1 ;
	}
	
	//To display the topmost element in each stack
	public void peek1()
	{
		if( isEmpty1() )
		{
			System.err.println("Error: Stack1 is empty! Cannot Peek");
			return;
		}
		System.out.println("Top element of First stack : "+arr[top1]);
	}
	public void peek2()
	{
		if( isEmpty2() )
		{
			System.err.println("Error: Stack2 is empty! Cannot Peek");
			return;
		}
		System.out.println("Top element of Second stack : "+arr[top2]);
	}
	
	//To push an element unto the top of a stack
	public void push1(Object data)
	{
		//Check for Full stack
		if( isFull() )
		{
			System.err.println("Error: Array is Full:Cannot push more elements onto the stack \n");
			return;
		}
		
		arr[++top1] = data;
		
	}
	public void push2(Object data)
	{
		//Check for Full stack
		if( isFull() )
		{
			System.err.println("Error: Array is Full:Cannot push more elements onto the stack \n");
			return;
		}
		
		arr[--top2] = data;
	}
	
	//To remove an element from the top of a stack
	public Object pop1()
	{
		//Check for empty stack
		if ( isEmpty1() )
		{
			System.err.println("Error: Cannot pop from an Empty stack1");
			return null;
		}
		
		//Create a new variable to store the data of the element that is going to be popped off
		Object poppedData = arr[top1--];
		System.out.println("Element removed from the stack is :"+poppedData);
		
		return poppedData;
	}
	public Object pop2()
	{
		//Check for empty stack
		if ( isEmpty2() )
		{
			System.err.println("Error: Cannot pop from an Empty stack2");
			return null;
		}
		
		//Create a new variable to store the data of the element that is going to be popped off
		Object poppedData = arr[top2++];
		System.out.println("Element removed from the stack is :"+poppedData);
		
		return poppedData;
	}
	
	//To display elements of a stack
	public void display1()
	{
		//Check for empty stack
		if ( isEmpty1() )
		{
			System.err.println("Error: Cannot Display an Empty stack1");
			return;
		}

		System.out.println("Elements of the first Stack are :");
		for( int i = top1 ; i != -1 ; i--)
			System.out.println(arr[top1]);
	}
	public void display2()
	{
		//Check for empty stack
		if ( isEmpty2() )
		{
			System.err.println("Error: Cannot Display an Empty stack2");
			return;
		}
		
		System.out.println("Elements of the second Stack are :");
		for( int i = top2 ; i < size ; i++)
			System.out.println(arr[i]);
	}

	
	//Driver function
	public static void main(String[] args) 
	{
		TwoStacksWithArrayEfficient a = new TwoStacksWithArrayEfficient(6);
		
		a.push1("32");
	
		a.push2("2");
		a.push2("5");
		a.push2("3");
		a.push2("1");
		a.push2("2");
				
		a.display1();
		a.display2();
		
	}
}
