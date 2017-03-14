/*
 * To check whether the given pattern is present in the given string or not
 * Built in methods is java are used in this example
 */

package ArraysAndStrings;

public class PatternMatchingBuiltIn
{
	public static boolean matchPattern(String str, String p)
	{
		return str.contains(p);
	}
	
	public static void main(String[] args)
	{
		System.out.println(matchPattern("Prasandeep Singh","  "));
	}
}
