//Merge two sorted linked lists
//Iteratively without adding a new list

package linkedlists;

public class MergeTwoSorted {

	Node head;
	
	class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	//Merge two sorted lists without creation of a new list
	//Algorithm involves swapping and reordering of list1 and list2
	//Final result is the modified list1
	public Node mergeSorted(Node list1, Node list2)
	{
		
		//If there is only one list , return that list without going further
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		//Declare a new head and initialize it with head of either List1 or List2 whichever is lesser  
		  Node head;
		  if (list1.data <= list2.data) 
		  {
			    head = list1;
		  }
		  else 
		  {
			  //Intialize head to list2 
			    head = list2;
			   
			    //Copies first node of list1 to list2, and since from the first node you have links to successive nodes(and the complete list)
			    //Hence, You are actually reinitializing list2 as list1   
			    //Basically swapping list1 and list2
			    list2 = list1;
			    
			  //list1 now contains head which points to list2  
			    list1 = head;
		  }
		  
		  //Traverse the updated list 1 until it reaches its end
		  while(list1.next != null) 
		  {
			  //If next element in the list is bigger than the current element of other list, Swap nodes (/Lists)
			    if (list1.next.data > list2.data)
			    {
			      Node tmp = list1.next;
			      list1.next = list2;
			      list2 = tmp;
			    }
			    
			   //Move the current node to the next node
			    list1 = list1.next;
		  } 
		  
		  //If list 1 reaches its end, make its last node's next pointer to point to list2
		  if (list1.next == null) list1.next = list2;

		  //Return the updated head of the updated list. 
		  //We update head only once in the begining and then work with a temporary node to traverse the list
		  //Head remains untouched after initial intialization
		  return head;
	}
		

	

	//DIsplay linked list
	public void display(Node head)
	{
		Node traverse = head;
		
		if(traverse == null)
			System.out.println("\n EMPTY LIST");
		
		while( traverse!= null)
		{
			System.out.print(" "+traverse.data);
			traverse = traverse.next;
		}
	}

	
	public static void main(String[] args) 
	{
	
		//Create a Linked list
		MergeTwoSorted L1 = new MergeTwoSorted();
		MergeTwoSorted L2 = new MergeTwoSorted();
		
		//Insert nodes into the list
		L1.push(50);
		L1.push(23);
		L1.push(14);
		L1.push(0);
		L1.push(0);
		L2.push(225);
		L2.push(23);
		L2.push(7);
		L2.push(0);
		
		//Display both lists
		L1.display(L1.head);
		System.out.println();
		L2.display(L2.head);
		System.out.println();
		Node merge = L1.mergeSorted(L1.head, L2.head);
		
		L1.display(merge);
	}

}
