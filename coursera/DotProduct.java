//package coursera;

import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
    	//sort a[] and b[] in decreasing order
    	//Keep Integer limits in mind before negating
    	a = sort(a);
    	b = sort(b);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (long)a[i] * (long)b[i];
        }
        return result;
    }

    private static int[] sort(int [] nums){
    	for(int i = 0; i<nums.length; i++)
    		nums[i] = (nums[i]==Integer.MIN_VALUE)?Integer.MAX_VALUE:-nums[i];
    	Arrays.sort(nums);
    	for(int i = 0; i<nums.length; i++)
    		nums[i] = (nums[i]==Integer.MIN_VALUE)?Integer.MAX_VALUE:-nums[i];
    	return nums;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

