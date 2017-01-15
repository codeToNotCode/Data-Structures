/*
 * To implement Binary search iteratively
 * For binary search algorithm, the input must be sorted first
 * Time Complexity - Best Case O(1) if the element to be searched is present in the middle of the array
 * Worst case O(logn) if the element is not present in the array
 * If the array is very large, then to avoid overflow while calculating mid index value:
 * Instead of using (start+end)/2 : the expression start + end might result in a number greater than Integer.MAX_VALUE
 * We can calculate mid as start + (end - start)/2
 */

package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchIterative
{
	
	/*
	 * Function to perform binary search
	 * The input array is sorted
	 * After each iteration of the loop, the search space is reduced to half
	 */
	public int binSearch(int A[], int num)
	{
		//Declare variables to store the start and end index
		int start = 0;
		int end = A.length - 1 ;
		
		
		//Iterate the loop untill start and end meet
		while( start <= end )
		{
			//For every iteration of the loop, find the new middle element
			int mid = (start + end ) / 2 ;
			
			/*
			 * If the number to be searched is at the middle, you found the element, return its index
			 * If element not found: 
			 * if element to be searched for is less than the middle element: Search on the left half
			 * Else search on the left half 
			 */
			if( num == A[mid] )
				return mid;
			else if ( num < A[mid] )
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		//Element not found
		return -1;
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		BinarySearchIterative bsi = new BinarySearchIterative();
		int A[] = new int[10];
		for (int i = 0; i < A.length; i++)
		{
			A[i] = (int)(Math.random()*100);
		}
		
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		int index = bsi.binSearch(A,num);
		
		if( index != -1 )
			System.out.println("Element ["+num+"] is present in the array at index ["+index+"]");
		else
			System.err.println("Element not found");
		
		input.close();
	}

}
