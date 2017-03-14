/*
 * Given an arraylist of integers. Find all sets of 3 integers which add up to zero
 */

package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero
{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if( nums.length == 0 )
            return result;
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length-2; i++){
            if(i==0 || nums[i] != nums[i-1]){
            int start = i+1;
            int end = nums.length -1 ;
            while(start < end ){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0 ){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                }
                else if(sum < 0 ){
                    while (nums[start] == nums[start+1] && start<end)
                        start++;
                }
                else{
                    while (nums[end] == nums[end-1] && start<end)
                        end--;
                }
            }
        }
        }
        return result;
    }
}
