/*
 * To implement Quick sort
 * Divide and Conquer recursive algorithm
 * In this version of quicksort, we select the last element in the array and put it at its correct position
 * The correct position is such that all elements to the right are greater and all elements to the left are lesser than the current pivot
 * We repeat this procedure untill all the elements are at their correct position and the array is sorted
 * Performance depends on the choice of pivot and also whether the array elements are already sorted or not
 * Best case occurs when the outcome of the partition is a balanced partition. meaning number of elements to the left and right of pivot selected are almost equ
 * TIme complexity -worst case - all elements are already sorted O(n^2) - can be avoided by using randomized quicksort
 * TIme complexity - Best and average case - O(nlogn)
 * Space Complexity - Best and average case - O(logn) - Since logn in grows very less wrt input, QS can be regarded as IN-PLACE sorting
 * Space Complexity - Worst case - O(n)
 */

package sorting;

import java.util.Arrays;

public class QuickSort
{

	/*
	 * Function to put the last element in the array at its correct position
	 * Recursively call the same procedure on the subarray to the left and right of the pivot index
	 */
	public int[] Qsort(int[] A, int start, int end)
	{
		int partitionIndex;
		
		//Base condition for recursion
		if( start > end )
			return A;
		
		//To find the pivot index
		partitionIndex = randomizedPartition(A, start, end);
		
		//Printing out all the pivot values that are selected during the program execution
		System.out.println(A[partitionIndex]);
		
		//Recursively finding pivot on the right side of the current pivot index
		Qsort(A, start, partitionIndex - 1);
		
		//Recursively finding pivot on the left side of the current pivot index
		Qsort(A, partitionIndex + 1, end);
		
		//Return the sorted array
		return A;
	}
	
	
	/*
	 * To implement randomized quick sort
	 * The pivot index is selected randomnly each time which lies between the start and the end indexes
	 * Randomized quick sort lead to selecton of pivot and random and removes the O(n^2) time complexity that arises due to sorted input
	 */
	public int randomizedPartition(int A[], int start, int end)
	{
		//Generate a random index value and store it in the pivotIndex variable
		int pivotIndex = start + (int)(Math.random()*(end - start + 1));
		
		//Swap the values of the pivotIndex element with the last index element
		swap(A, pivotIndex, end);
	
		//Call the partition function of the normal quick sort algorithm
		return Partition(A,start,end);
	}
	
	/*
	 * TO partition the array depending on the value of the pivot elements
	 * All the array elements less than the pivot element are to the left of the pivot element
	 * All the array elements greater than the pivot element are to the right of the pivot element
	 */
	public int Partition(int[] A, int start, int end)
	{
		//Declare variables to store the index values
		int pivot = A[end];
		
		//Let the pivot index be at the start of the array
		int pIndex = start;
		
		/*
		 * The algorithm to perform partitioning
		 * All elements less than the pivot element( always the last element) will be moved to the left of pIndex
		 */
		for( int i = start ; i < end ; i++)
		{
			if ( A[i] <= pivot )
			{
				swap(A,i,pIndex);
				pIndex++;
			}
		}
		
		//To put the pivot at the correct position in the array
		swap(A, pIndex, end);
		
		//Return the index of the pivot element
		return pIndex;
	}
	
	
	/*
	 * To perform the swap operation
	 * Puts the index element in its correct position in the array
	 */
	public void swap(int A[], int b, int c)
	{
		int temp = A[b];
		A[b] = A[c];
		A[c] = temp;
	}
	
	
	
	//Driver Function
	public static void main(String[] args)
	{
		QuickSort qs = new QuickSort();
		
		int A[] = new int[10];
		
		for(int i = 0 ; i < A.length ; i++)
			A[i] = (int)(Math.random()*100);
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(qs.Qsort(A,0,A.length-1)));
	}
}
