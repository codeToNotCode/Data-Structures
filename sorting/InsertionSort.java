/*
 * To implement Insertion Sort
 * Worst case (To sort an array which is in reverse sorted order)and average complexity O(n^2)
 * Best case complexity O(n) - When the list is alreasy sorted and the inner loop does not gets executed
 * The algorithm is similar to sorting of a hand of cards
 * Better than selection and bubble sort as number of comparisons are comparitively lesser
 */


package sorting;

import java.util.Arrays;

public class InsertionSort
{
	//Insertion Sort
	public int[] insSort(int[] A)
	{
		for( int pass = 1 ; pass < A.length ; pass++)
		{
			int temp = A[pass];
			int j = pass - 1;
			for(  ;  j >= 0 &&  temp < A[j] ; j--)
				A[j+1] = A[j];

			A[j+1] = temp;
		}
		return A;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		InsertionSort is = new InsertionSort();
		
		int[] A = new int[10];
		
		for(int i = 0 ; i < A.length ; i++)
			A[i] = (int)(Math.random()*100);
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(is.insSort(A)));
 	}
}
