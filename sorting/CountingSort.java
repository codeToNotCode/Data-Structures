/*
 * To implement counting sort
 * 
 * Time complexity - O(n+k) where n is the number of elements to be sorted and k is the range of elements (max - min)
 * Space Complexity - O(n+k)
 * Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted
 * For example -When the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
 *  It is not a comparison based sorting.
 *  It is often used as a sub-routine to another sorting algorithm like radix sort.
 */


package sorting;

import java.util.Arrays;

public class CountingSort
{
	
	public int[] cSort(int A[])
	{
		int max = 0;
		
		//To find the maximum element in the input array
		for(int i = 0 ; i < A.length; i++)
			if( A[i] > max)
				max = A[i];
		
		//To find the minimum element in the input array
		for(int i = 0 ; i < A.length; i++)
			if( A[i] > max)
				max = A[i];
		
		//Create a count array that keeps a count of number of occurences of each number in A
		int count[] = new int[A.length + max];
	
		//Initialize the count array with frequencies
		for(int i = 0 ; i < A.length ; i++)
			count[A[i]]++;
		
		//Add all frequencies upto a particular index
		for(int i = 1 ; i < count.length ; i++)
			count[i] = count[i] + count[i-1];
		
		//Create a new array that will contain all elements of A in a sorted order
		int sorted[] = new int[A.length];
		
		//Put individual elements of A in their respective order in the sorted Array
		for(int i = 0 ; i < A.length ; i++)
		{
			sorted[count[A[i]] - 1] = A[i];
			count[A[i]]--;
		}
		
		//Return the sorted array
		return sorted;
	}
	
	
	public static void main(String[] args)
	{
		CountingSort cs = new CountingSort();
		int A[] = new int[10];
		for(int i = 0 ; i < A.length ; i++)
			A[i] = (int)(5 + Math.random()*10);
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(cs.cSort(A)));
 	}
}
