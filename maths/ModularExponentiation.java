/*
 * Modular Exponentiation is x^n % m
 * The above expression is used in cryptography to generate public keys encryption
 * Uses Distributive property of modulas operator :  (a*b)%m = ((a%m)*(b%m))%m
 * 
 * Time Complexity is same as that of normal exponention/power function - O(logn)
 * Refer to the video : https://www.youtube.com/watch?v=nO7_qu2kd1Q
 */


package maths;

public class ModularExponentiation
{
	public static int modExp(int x, int n, int m)
	{
		if( n == 0 )
			return 1;
		//For even powers of n
		else if( n%2 == 0)
		{
			int y = modExp(x%m, n/2, m);
			return (y*y) % m;
		}
		//For odd powers of n
		else
		{
			return ( x * modExp(x%m, n -1 , m) ) % m;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(modExp(2,3,3));
	}
}


//
//public class Solution {
//	public int pow(int x, int n, int d) {
//	    
//	    long a = x;
//	    long res = 1L;
//	    
//	    while (n > 0) {
//	        
//	        if (n % 2 == 1) {
//	            res *= a;
//	            res %= d;
//	        }
//	        
//	        a *= a;
//	        a %= d;
//	        n = n >> 1;
//	        
//	    }

//	    
//	    res = (res + d) % d;
//	    
//	    return (int) res;
//	    
//	}
//}