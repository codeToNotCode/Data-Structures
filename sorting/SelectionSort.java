/*
 * TO implement selection sort
 * In this we find the minimum element of the array and swap it with the pass index
 * We then increment the pass index and find index of the minimum element from the remaining array
 * This way our array starts getting sorted from the begining
 * Total passes required will be total number of elements in the array minus 1
 * Average case complexity O(n^2)
 */


package sorting;

import java.util.Arrays;

public class SelectionSort
{

	/*
	 * Function to perform selection sort
	 * Find the index of the minimum element in the array
	 * Swap the element at the pass index with the minimum element
	 */
	public int[] selection(int A[])
	{
		for( int pass = 0 ; pass < A.length ; pass++)
		{
			int min = getMinIndex(A,pass);
			
			int temp = A[pass];
			A[pass] = A[min];
			A[min] = temp;
		}
		
		return A;
	}
	
	
	/*
	 * Function to return index of the minimum element in the array
	 */
	public int getMinIndex(int A[], int pass)
	{
		int min = A[pass];
		int minIndex = pass;
		
		for( int j = pass ; j < A.length ; j++ )
		{
			if ( A[j] < min )
			{
				min = A[j];
				minIndex = j;
			}
		}	
		return minIndex;
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		SelectionSort ss = new SelectionSort();
		
		int A[] = new int[10];
		
		for(int i = 0 ; i < A.length ; i++)
			A[i] = (int)(Math.random()*100);
		
		System.out.println(Arrays.toString(A));
		int sorted[] = ss.selection(A);
		System.out.println(Arrays.toString(sorted));
	}
}
