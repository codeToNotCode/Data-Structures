/*
 * To check whether a given patten is present in the given string
 * No inbuild methods to be used
 * O(MN) time complexity
 */

package ArraysAndStrings;

public class PatternMatchingNoBuiltIn
{
	public static boolean matchPattern(String str, String pat)
	{
		int sLen = str.length();
		int pLen = pat.length();
		int count = 0;
		int i = 0;
		
		for(; i <= sLen - pLen; i++)
		{
			count = 0;
			char s = str.charAt(i);
			char p = pat.charAt(0);
			
			if( s==p )
			{
				for(int j = i, k = 0 ; k < pLen; j++,k++ )
				{
					s = str.charAt(j);
					p = pat.charAt(k);
					if( s == p )
						count++;
				}
				
				if( count == pLen)
					break;
			}
		}
		System.out.println("Index where the pattern starts :"+i);
		if( count == pLen)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(matchPattern("ababbbbbbbbbbbbabababba","bba"));
	}
}
