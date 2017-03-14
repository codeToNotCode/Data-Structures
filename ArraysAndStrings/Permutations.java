/*
 * To find all permutations of a given string
 */


package ArraysAndStrings;

public class Permutations
{
	public void permutations(String s, int i, int n)
	{
		if( i == n )
		{
			System.out.println(s);
			return;
		}
		else
		{
			for(int j = 0 ; j <= n ; j++ )
			{
				swap(i,j);
				permutations(s,i+1,n);
				swap(i,j);
			}
		}
	}

	public 
	public static void main(String[] args)
	{
		Permutations per = new Permutations();
		String s = "ABC";
		per.permutations(s,0,s.length()-1);
	}
}
