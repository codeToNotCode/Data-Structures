/*
 * To rotate a given array(sorted) in a circular manner by n steps 
 * {123456} : n = 2 : output : {345612}
 * Rotation is towards the left
 */

package ArraysAndStrings;

import java.util.ArrayList;

public class RotateCircularly
{
	public static ArrayList<Integer> rotate(ArrayList<Integer> a , int n){
		if(a == null || n % a.size() == 0)
			return a;
		int numRot = n %  a.size();
		ArrayList<Integer> befRot = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0 ; i < numRot; i++)
			befRot.add(a.get(i));
		for(int j = 0 ; j < a.size() - numRot; j++)
			result.add(a.get(j + numRot));
		result.addAll(befRot);
		
		return result;
	}
	
	public static void main(String[] args)
	{
	
		ArrayList<Integer> ab = new ArrayList<Integer>();
		ab.add(1);ab.add(2);ab.add(3);ab.add(4);ab.add(5);ab.add(6);

		System.out.println(ab.toString());
		System.out.println(rotate(ab,10).toString());
	}
}
