/*
 * To find the total number of duplicates of a particular element in an array
 * Using Binary search O(logn)
 * Using linear search - O(n) worst case
 */


package search;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumberOfDuplicates
{

	/*
	 * Function to find the number of duplicates of a particular element in an array
	 * FInd first occurence of the element in the array
	 * FInd last occurence of the element in the array
	 * Number of occurences will be Last - First + 1
	 */
	public int numOfDups(int A[],int num)
	{
		int first = findFirst(A,num,true);
		int last = findFirst(A,num,false);
		
		if( first == -1 || last == -1)
			return -1;
		else
			return last - first + 1;
	}
	
	/*
	 * To find the first/last occurence of an element in the array
	 */
	public int findFirst(int A[], int num, boolean firstOcc)
	{
		int start = 0 ; 
		int end = A.length - 1;
		int first = -1;
		
		while( start <= end )
		{
			int mid = start + (end - start)/2;
			if( num == A[mid] )
			{
				first = mid;
				if( firstOcc )
					end = mid - 1;
				else
					start = mid + 1;
			}
			else if( num < A[mid] )
				end = mid - 1;
			else
				start = mid + 1;
		}
		return first;
	}
	
	
	
	// Driver function
	public static void main(String[] args)
	{
		FindNumberOfDuplicates fnod = new FindNumberOfDuplicates();
		int A[] = new int[50];
		for (int i = 0; i < A.length; i++)
		{
			A[i] = (int) (Math.random() * 100);
		}

		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		int duplicates = fnod.numOfDups(A, num);

		if (duplicates != -1)
			System.out.println("Numer of duplicates of Element [" + num + "] in the array are [" + duplicates + "]");
		else
			System.err.println("Element not found");

		input.close();
	}

}
