/*
 * Given an array of integers in sorted order, find two integers in the array that add up to a given sum
 * Give a O(n) inplace ddsolution without using extra space
 */

package ArraysAndStrings;

public class ArraySum
{
	
	public static boolean arraySum(int[] A, int sum){
		
		int j = A.length -1;
		for(int i = 0; i<A.length; i++){
			for(; j>i ; j--){
				if( A[i] + A[j] == -2) return true;
				if( A[i] + A[j] < 0 ) break;
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		int A[] = {-5,-3,-2,-1};
		System.out.println(arraySum(A,6));
	}
}
