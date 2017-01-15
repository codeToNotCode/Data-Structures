/*
 * TO find the first and last occurence of an element which repeats itself in an array
 * Step1 : Sort the array to apply binary search
 * Apply binary search with slight modification
 */

package search;

import java.util.Arrays;
import java.util.Scanner;

public class FirstLastOccurence
{
	
	/*
	 * Function to find the first/last occurence of an element in a array
	 * Input is sorted so that binary search can be applied 
	 * For the first occurence, we will first find the element in the array
	 * Once the element has been located, we will search for its first occurence in the left half
	 * TO find the last occurence of an element, we will search in the right half
	 */
	public int firstLast(int A[], int num)
	{
		int start = 0;
		int end = A.length - 1 ;
		int result = -1;

		while(start <= end )
		{
			int mid = start + (end - start)/2;
			
			if( num == A[mid] )
			{
				result = mid;
				end = mid - 1;
				//to find the last occurence :: start = mid + 1;
			}
			else if ( num < A[mid] )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return result;
	}
	
	
	
	// Driver function
	public static void main(String[] args)
	{
		FirstLastOccurence flo = new FirstLastOccurence();
		int A[] = new int[20];
		for (int i = 0; i < A.length; i++)
		{
			A[i] = (int) (Math.random() * 100);
		}

		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		int index = flo.firstLast(A, num);

		if (index != -1)
			System.out.println("First occurence of Element [" + num + "] in the array is at index [" + index + "]");
		else
			System.err.println("Element not found");

		input.close();
	}
}
