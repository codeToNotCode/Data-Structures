/*
 * To find an element in a circular sorted array
 * Linear search : O(n) worst case
 * Binary Search : O(logn) best case
 */

package search;

import java.util.Arrays;
import java.util.Scanner;

public class SearchCircularSortedArray
{
	
	/*
	 * To search for a given number in a circularly sorted array
	 * Find the half which does not contain the minimum element ie. the half which contains all the elements in a sorted order
	 * Check whether the given number lies within the start and end elements of this half
	 * If yes - update the start/end indexes and iterate the loop again until the mid index is equal to the index of the number you are searching for
	 * If no - perform the above operation on the other half
	 * If element not found, return -1
	 */
	public int cirSearch(int []A, int num)
	{
		int start = 0;
		int end = A.length - 1;
		
		while( start <= end )
		{
			int mid = start + (end - start) / 2;
			
			//If element is found, return its index
			if( num == A[mid] )
				return mid;
						
			/*
			 * The outer ifs check for the half which is completely sorted
			 * The inner ifs checks whether the number to be searched for lies in the sorted half or not
			 * If not search the other half ( non sorted )
			 */
			if( A[mid] <= A[end] )
			{
				if( num > A[mid] && num <= A[end] )
					start = mid + 1;
				else
					end = mid - 1;
			}
			else if ( A[mid] >= A[start] )
			{
				if( num >= A[start] && num < A[mid] )
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		
		//If the element is not present in the array, return -1
		return -1;
	}
	
	// Driver function
	public static void main(String[] args)
	{
		SearchCircularSortedArray scsa = new SearchCircularSortedArray();
		int A[] ={ 6, 7, 8, 9, 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(A));

		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		int index = scsa.cirSearch(A, num);

		if (index != -1)
			System.out.println("Element [" + num + "] is present in the array at index [" + index + "]");
		else
			System.err.println("Element not found");

		input.close();
	}
}
