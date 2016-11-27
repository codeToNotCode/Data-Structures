//Merge two sorted linked lists
//Recursively without adding a new list

package linkedlists;

public class MergeTwoSortedRecursion {

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
	
		

	//Merge two lists using recursion
	Node MergeLists(Node list1, Node list2) 
	{
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  if (list1.data <= list2.data) 
		  {
		    list1.next = MergeLists(list1.next, list2);
		    return list1;
		  }
		  else 
		  {
		    list2.next = MergeLists(list2.next, list1);
		    return list2;
		  }
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
		MergeTwoSortedRecursion L1 = new MergeTwoSortedRecursion();
		MergeTwoSortedRecursion L2 = new MergeTwoSortedRecursion();
		
		//Insert nodes into the list
		L1.push(50);
		L1.push(23);
		L1.push(14);
		L1.push(0);
		L1.push(0);
		L2.push(225);
		L2.push(23);
		L2.push(7);
		L2.push(1);
		
		//Display both lists
		L1.display(L1.head);
		System.out.println();
		L2.display(L2.head);
		System.out.println();
	
		Node mergeRec = L1.MergeLists(L1.head, L2.head);
		
		L1.display(mergeRec);
	}

}
