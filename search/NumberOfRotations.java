/*
 * TO find the number of times a particular array has been rotated
 * Index of the minimum element of the array is the answer
 * LInear search - O(n)
 * Binary search - O(logn)
 * Array must not contain any duplicate values for the above algorithm to work
 */

package search;

import java.util.Arrays;

public class NumberOfRotations
{
	
	/*
	 * TO find the number of rotations that have been done to a sorted array
	 * Index of the minimum element is equal to the number of rotations performed
	 */
	public int rotations(int A[])
	{
		int start = 0;
		int end = A.length - 1 ;
		
		while( start <= end )
		{
			/*
			 * if no rotations have been performed, 
			 * First element will be the minimum element in the array
			 */
			if( A[start] <= A[end])
				return start;
			
			//Perform binary search if array has been rotated
			int mid = start + (end-start)/2;
			
			/*
			 * In a rotated array, the minimum element will be the only element which is smaller than both its adjacent elements
			 * Find the adjacent elements of the minimum element
			 * If its smaller than both next and prev, return the index
			 */
			int next = (mid + 1) % (A.length);
			int prev = (mid + A.length - 1) % (A.length);
			if( A[mid] <= A[next] && A[mid] <= A[prev])
				return mid;
			
			/*
			 * If minimum element is not present in the middle
			 * Use binary search to reduce the search space and iterate the loop again
			 */
			else if( A[mid] <= A[end] )
				end = mid - 1;
			else if( A[mid] >= A[start] )
				start = mid + 1;
		}
		
		//This statement will only be executed if the array that is provided as input is not sorted or is incorrect
		return -1;
	}

	
	
	// Driver function
	public static void main(String[] args)
	{
		NumberOfRotations nor = new NumberOfRotations();
		int A[] = {6,7,8,9,1,2,3,4,5};
		
		System.out.println(Arrays.toString(A));
	
		int rotations = nor.rotations(A);

		System.out.println("Numer of rotations : "+rotations);
	}

}
