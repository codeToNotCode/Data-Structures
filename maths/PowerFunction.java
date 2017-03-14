/*
 * To implement the standard power function
 * In O(n) time complexity
 * in O(logn) time complexity
 * 
 * Great explanation for logn time complexity : https://www.youtube.com/watch?v=VHcZtdp5054
 */


package maths;

public class PowerFunction
{
	
	/*
	 * This is O(n) algorithm.
	 * Better algorithm exists
	 */
	public static long pow(long x, int n )
	{
		if( n == 1 )
			return x;
		
		x = x * pow(x,n-1);
		
		return x;
	}
	
	/*
	 * This Algorithm takes O(log n ) time
	 */
	public static long powRecurse(long x, int n)
	{
		if( n == 0 )
			return 1;
		
		//For even powers of n
		else if ( n % 2 == 0 )
		{
			long y = powRecurse(x,n/2);
			return y*y;
		}
		//For odd powers of n
		else
			return x * powRecurse(x,n-1);
	}
	
	
	
	public static void main(String[] args)
	{
		
		System.out.println(powRecurse(3,29));
		System.out.println(pow(3,29));
	}
}
