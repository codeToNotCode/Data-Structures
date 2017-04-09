/*
 * To implement the standard power function
 * In O(n) time complexity
 * in O(logn) time complexity
 * 
 * Great explanation for logn time complexity : https://www.youtube.com/watch?v=VHcZtdp5054
 * To pass all test cases : consider leetcode solution. Implemented below
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
    public static double myPow(double x, int n) {
    	if(n==0)    return 1;
        if(x==0)    return 0;
        if(n==1||x==1)  return x;
        if(x==-1)   return (n%2==0)?1:-1;
        if(n<0)
            return 1/myPow(x, (n==Integer.MIN_VALUE)?Integer.MAX_VALUE:-n);
        if(n%2==0){
            double y = myPow(x, n/2);
            return y*y;
        }else
            return x * myPow(x, n-1);
  }
	
	
	public static void main(String[] args)
	{
		
		System.out.println(myPow(3,29));
		System.out.println(pow(3,29));
	}
}
