/*
 * TO implement shell sort
 * It is an improved version if insertion sort. Also called interval sort/ gap sort
 * 
 * http://quiz.geeksforgeeks.org/shellsort/
 * https://www.youtube.com/watch?v=IlRyO9dXsYE
 * https://www.youtube.com/watch?v=SCBf7aqKQEY 
 */

package sorting;

import java.util.Arrays;

public class ShellSort
{
	public int[] shellSort(int A[]) {
		int length = A.length;
		int pass = 0;
		for(int gap = length/2; gap > 0; gap = gap/2) {
			for(int i = gap; i < length; i++) {
				int temp = A[i];
				int j;
				for(j = i ; j >= gap && A[j-gap]>temp; j = j - gap)
					A[j] = A[j-gap];
				A[j] = temp;
			}
			pass++;
			System.out.println("Array after pass "+pass+" : "+Arrays.toString(A) );
		}
		return A;
	}
	public static void main(String[] args)
	{
		ShellSort ss = new ShellSort();
		int A[] = {9,4,7,2,6,3,1,5,8};
		System.out.println(Arrays.toString(A));
		int sorted[] = ss.shellSort(A);
		System.out.println(Arrays.toString(sorted));
	}
}
