/*
 * TO sort a given list of numbers according to the digit at the one's place only
 * TO use the and implement the Comparator Interface
 * Use the compare method inside the comparator interface to provide a custom logic for sorting
 */



package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUse implements Comparator<Integer>
{

	@Override
	public int compare(Integer obj1, Integer obj2)
	{
		if( obj1 % 10 > obj2 % 10)
			return 1;
		return -1;
	}
	
	public static void main(String[] args)
	{
		List<Integer> num = new ArrayList<Integer>();
		num.add(42);num.add(21); num.add(25); num.add(43); num.add(49);
		
		Comparator<Integer> comp = new ComparatorUse();
		
		Collections.sort(num, comp);
		
		
		for( Integer i : num )
			System.out.print(i + " " );
		
	}
}
