/*
 * Given a positive integer in the form of an array, return that integer
 * [1,4,3] should return 143
 */

package maths;

public class BuildIntegerFromArray
{
	public int getInt(int A[]) {
		String s = "";
		s+=A[0];
		for(int i = 1; i < A.length; i++) {
			if(Integer.parseInt(s) > (Integer.MAX_VALUE/10) &&
					 Integer.parseInt(s) <= Integer.MAX_VALUE) {
				return Integer.parseInt(s);
			}
			s+=A[i];
		}
		return Integer.parseInt(s);
	}
	public static void main(String[] args)
	{
		BuildIntegerFromArray bifa = new BuildIntegerFromArray();
		int A[] = {1,7,7,4,3,1,7,0,1,4,4};
		System.out.println(bifa.getInt(A));
	}
}
