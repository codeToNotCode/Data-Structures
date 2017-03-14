/*
 * Given an array of integers. find 3 integers whose sum is closest to the target sum
 * give an O(n^2) solution without use of extra space
 */

package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeArraySum
{

	public static int threeSumClosest(ArrayList<Integer> a, int b) {
	    Collections.sort(a);
	    
	    int minSum = 0;
	    int diff = 0;
	    int minDiff = Integer.MAX_VALUE;
	    
	    for(int i = 0 ; i < a.size()-2; i++){
	        if( i == 0 || a.get(i) != a.get(i-1) ){
	            int start = i+1;
	            int end = a.size() - 1;
	            while(start < end){
	                int localSum = a.get(i) + a.get(start) + a.get(end);
	                 diff = b - localSum;
	                if( diff == 0 ) return localSum;
	                if( diff > 0 ){
	                    int temp = a.get(start);
	                    while( temp == a.get(start) && start < end )    start++;
	                }else{
	                    int temp = a.get(end);
	                    while( temp == a.get(end) && start < end ) end--;
	                }
	                if(Math.abs( diff ) < Math.abs(minDiff)){
	                    minDiff = diff;
	                    minSum = localSum;
	                }
	            }
	        }
	    }
	    return minSum;
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> a =new ArrayList<>();
		a.add(10);a.add(-6);a.add(3);a.add(4);a.add(-8);a.add(-5);
		System.out.println(threeSumClosest(a,3));
	}
}
