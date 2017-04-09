/*
  * Implement Queues using arrays
 */


package Queues;

public class QueuesUsingArrays 
{

	static Object queue[] = new Object[10];
	static int head = -1;
	static int tail = -1;
	
	//To check if the queue is empty
	public static boolean isEmpty()
	{
		return ( head == -1 || tail == -1 || head>tail )  ;
	}
	
	//To check if the queue is full
	public static boolean isFull()
	{
		return tail == queue.length - 1 ;
	}
	
	//To display the topmost element of the queue
	public static Object peek()
	{
		return queue[head];
	}
	
	//To enqueue elements unto a queue
	public static void enqueue(Object data)
	{
		//Check for full queue
		if( isFull() )
		{
			System.err.println("Error: queue is full! Cannot add more elements");
			return;
		}
		else if ( isEmpty() )
		{
			queue[++tail] = data;
			++head;
		}
		else
			queue[++tail] = data;
		
	}
	
	//To dequeue an element out of the queue
	public static Object dequeue()
	{
		//Check for Empty queue
		if( isEmpty() )
		{
			System.err.println("Error: queue is empty! Cannot remove from an Empty queue");
			return null;
		}
		
		return queue[head++];
	}
	
	//To display queue elements
	public static void display()
	{
		//check for empty queue
		if( isEmpty() )
		{
			System.err.println("Error: queue is Empty");
			return;
		}
		
		for( int i = head ; i <= tail ; i++)
		{
			System.out.println(queue[i]);
		}
	}
	
	public static void main(String[] args)
	{
		enqueue("Hi");
		enqueue("My");
		enqueue("Name");
		enqueue("is");
		enqueue("Prasan");
		enqueue("Deep");
		enqueue("Singh");
		enqueue("Ubhi");
		enqueue("How");
		enqueue("You");
		enqueue("Doing");
		display();
		System.out.println("Element at the front of the queue :"+peek());
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
		dequeue();display();
	}

}
