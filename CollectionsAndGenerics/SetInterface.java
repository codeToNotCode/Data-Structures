/*
 * TO see the implementation of Set interface
 * TO create an object of Set interface , we need a class which implements the Set interface
 * THe class is HashSet
 * 
 * Set supports only unique elements
 * HashSet stores the values according to the algorithm described in the Hash function. H
 * Hence the output is not in a sequential order
 * 
 * To store the elements in an increasing order, instead of Using HashSet, you can use the class TreeSet
 */


package CollectionsAndGenerics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface
{
	public static void main(String[] args)
	{
		Set<Integer> values = new HashSet<Integer>();
		Set<Integer> moreValues = new TreeSet<Integer>();
		
		/*
		 * It adds values only if the value is not already present in the set
		 * It will not add the repeated value to the set
		 * add() function returns a boolean value stating whether a given value is added to the set or not
		 */
		values.add(13);		values.add(44);
		values.add(23);		values.add(155);
		
		/*
		 * Add values to the TreeSet object
		 * All the values in the moreValues object will be stored in an increasing order
		 */
		moreValues.add(13);		moreValues.add(44);
		moreValues.add(23);		moreValues.add(155);
		
		for(Integer i : values)
			System.out.print(i+" ");
		
		System.out.println();
		
		for(Integer i : moreValues)
			System.out.print(i+" ");
		
	}
}
