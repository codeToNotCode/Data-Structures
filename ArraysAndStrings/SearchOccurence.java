/*
 * To count the number of occurences of a given number in the array using recursion
 * Looks O(logn) but is actually O(n)
 */


package ArraysAndStrings;

public class SearchOccurence
{
	/* 
	 * V is sorted 
	 * V.size() = N
	 * The function is initially called as searchNumOccurrence(V, k, 0, N-1)
	 */
	public static int searchNumOccurrence(int V[], int k, int start, int end) {
	    if (start > end) return 0;
	    int mid = (start + end) / 2;
	    if (V[mid] < k) return searchNumOccurrence(V, k, mid + 1, end);
	    if (V[mid] > k) return searchNumOccurrence(V, k, start, mid - 1);
	    return searchNumOccurrence(V, k, start, mid - 1) + 1 + searchNumOccurrence(V, k, mid + 1, end);
	}
	public static void main(String[] args)
	{
		int V[] = {6,6,6};
		System.out.println(searchNumOccurrence(V,6 , 0, V.length-1));
	}
}
