/*
 * To implement binary search using recursion
 */

package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursion
{
	/*
	 * Function to perform binary search using recursion
	 */
	public int binSearch(int A[], int num, int start, int end)
	{
		//Base case for recursion
		if( start > end )
			return -1;
		
		/*
		 * To find the middle element
		 * The below formula prevents overflow if the values of start and end are close to Integer.MAX_VALUE
		 */
		int mid = start + (end - start)/2;
		
		//Return index of the element if it is found
		if( num == A[mid])
			return mid;
		
		/*
		 * If not found in the current recursive step
		 * If element not found: 
		 * if element to be searched for is less than the middle element: Recursively Search on the left half
		 * Else search on the left half 
		 */
		if( num < A[mid])
			return binSearch(A,num, start, mid - 1);
		else
			return binSearch(A,num, mid + 1, end);
	}
	
	// Driver function
	public static void main(String[] args)
	{
		BinarySearchRecursion bsr = new BinarySearchRecursion();
		int A[] = new int[10];
		for (int i = 0; i < A.length; i++)
		{
			A[i] = (int) (Math.random() * 100);
		}

		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		int index = bsr.binSearch(A, num,0, A.length-1);

		if (index != -1)
			System.out.println("Element [" + num + "] is present in the array at index [" + index + "]");
		else
			System.err.println("Element not found");

		input.close();
	}

}
