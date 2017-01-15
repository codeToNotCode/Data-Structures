/*
 * To implement linear search
 * Time Complexity - Best case O(1) if the element is present at the first index of the array
 * Worst case O(n) if the element is present at the end or not present in the array at all
 */


package search;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch
{
	
	/*
	 * Function to perform linear search on an array
	 * If the element is found, its position in the array is returned
	 * If not found, -1 is returned
	 */
	public int linSearch(int A[], int num)
	{
		for (int i = 0; i < A.length; i++)
		{
			if(A[i] == num)
				return i;
		}
		return -1;
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		LinearSearch ls = new LinearSearch();
		int A[] = new int[20];
		for (int i = 0; i < A.length; i++)
		{
			A[i] = (int)(Math.random()*100);
		}
		
		System.out.println(Arrays.toString(A));
		System.out.println("Enter the element you wish to search : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		int index = ls.linSearch(A,num);
		
		if( index != -1 )
			System.out.println("Element ["+num+"] is present in the array at index ["+index+"]");
		else
			System.err.println("Element not found");
		
		input.close();
	}
}
