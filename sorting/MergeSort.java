/*
 * To implement Merge Sort - Divide and conquer algorithm using recursion
 * Not an IN-PLACE algorithm as extra space is involved for creating left and right arrays
 * Space Complexity : O(n) . Also can be said Theta(n) if we clear the memory space occupied by the new arrays after each call (java does this automatically)
 * If we do not clear the space occupied by the new arrays, then space complexity is Theta(nlogn)
 * Time Complexity : Worst - Average - Best - O(nlogn)
 */

package sorting;

import java.util.Arrays;

public class MergeSort
{

	/*
	 * Function to implement divide and conquer merge sort
	 * Keep on dividing the array into two halves untill you have only one element in the array
	 * Call the merge function to merge left and right halves back to the original array with all the elements sorted
	 */
	public void mergeSort(int[] A)
	{
		//Store the current length of the array in a variable
		int len = A.length;
		
		/*
		 * Base case for recursion
		 * If the array is reduced to only one element, stop the recursion and return the array
		 */
		if( len < 2 )
			return ;
		
		//Create a variable to split the array into two halves
		int mid = len / 2;
		
		//Create two arrays and coopy elements of original array into the respective halves
		int left[] = new int[mid];
		int right[] = new int[len - mid];
		for(int i = 0 ; i < mid ; i++)
			left[i] = A[i];
		for(int i = mid ; i < len ; i++)
			right[i - mid] = A[i];
		
		//Recursively sort the left and right subarrays
		mergeSort(left);
		mergeSort(right);
		
		//Merge the sorted left and right subarrays into the original array to complete the sorting algorithm
		merge(left,right,A);
		
	}
	
	
	/*
	 * To implement the merge function
	 * Merges the left and right subarrays back into the original array in a sorted order
	 */
	public int[] merge( int[] left, int[] right, int[] A)
	{
		//Create three variables to store index values of left,right and the original array
		int i = 0, j = 0,k = 0;
		
		//To copy the elements of left and right array into the original array until one of the array gets exhausted
		while(i < left.length && j < right.length)
		{
			if ( left[i] <= right[j] )
				A[k++] = left[i++];
			else
				A[k++] = right[j++];
		}
		
		//TO copy all the elements of the left/right array whichever is not exhausted into the original array
		while( i < left.length )
			A[k++] = left[i++];
		
		while( j < right.length )
			A[k++] = right[j++];
		
		//Return the merged sorted array
		return A;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		MergeSort ms = new MergeSort();
		
		int A[] = new int[10];
		
		for(int i = 0 ; i < A.length ; i++)
			A[i] = (int)(Math.random()*100);
		
		System.out.println(Arrays.toString(A));
		ms.mergeSort(A);
		System.out.println(Arrays.toString(A));
	}
}
