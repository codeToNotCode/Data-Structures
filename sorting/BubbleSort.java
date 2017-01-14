/*
 * To implement bubble sort
 * In bubble sort the heaviest element is placed at the end of the array
 * So the array starts gets sorted from the end
 * Hence, we need not traverse the entire array again and again
 * Just keep on reducing the outer loop by 1 after each pass
 * Worst case is O(n^2) - total number of passes requiired will always be equal to number of elements - 1
 * Best case is O(n) if the elements is already sorted (For this to be O(n) little modifications to the code have to be made)
 * The total number of passes will be 1 if the array is already sorted
 * Once the array is sorted, no more passes will be considered and the algorithm will stop
 */

package sorting;

import java.util.Arrays;

public class BubbleSort
{
	/*
	 * Function to implement bubble sort
	 * Compare two elements and swap if the first is larger than the second
	 * Keep on doing this untill you reach the end and place the largest element at the end of the array
	 * Repeat this step untill all the elements are sorted
	 * Total number of passes required will be equal to total number of elements minus 1
	 */
	public int[] bubble(int[] A)
	{
		for( int pass = 1 ; pass < A.length ; pass++)
		{
			int flag = 0;
			for( int j = 0 ; j < A.length - pass ; j++ )
			{
				if( A[j] > A[j+1])
				{
					flag = 1;
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
			if( flag == 0 )
			{
				System.out.println("Total number of rounds :"+pass);
				break;
			}
		}
		
		return A;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		BubbleSort bs = new BubbleSort();
		
		int A[] = new int[10];
		
		for(int i = 0 ; i < A.length ; i++ )
			A[i] = (int)(Math.random()*100);
		
		System.out.println(Arrays.toString(A));
		int sorted[] = bs.bubble(A);
		System.out.println(Arrays.toString(sorted));
	}
}
