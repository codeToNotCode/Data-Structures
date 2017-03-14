/*
 * To remove duplicates from an array and keep only pairs
 */

package ArraysAndStrings;

import java.util.ArrayList;

public class RemoveDups
{
	public static int removeDuplicates(ArrayList<Integer> a) {
	    int index = 1;
	    int count = 1;
	    if( a == null || a.size() == 0 )
	        return 0;
	        
	    for(int i = 1 ; i < a.size(); i++){
	        if( i == 0 || a.get(i).intValue() != a.get(i-1).intValue() ){
	            a.set(index++, a.get(i++));
	            count = 1;
	        }
	        if( count == 1 &&  i < a.size()&& a.get(i).intValue() == a.get(i-1).intValue()){
	            a.set(index++, a.get(i).intValue());
	            count = 0;
	        }
	    }
	    System.out.println(a);
	    return index;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);a.add(0);a.add(0);a.add(1);a.add(1);a.add(2);a.add(2);a.add(3);
		System.out.println(removeDuplicates(a));
	}
}
