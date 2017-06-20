package coursera;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * (long)numbers[j] > result) {
                    result = (long)numbers[i] * (long)numbers[j];
                }
            }
        }
        return result;
    }

    public static long getMaxPairWiseProductFast(int[] nums){
    	long result = 0;
    	int maxIndex1 = -1;
    	for(int i = 0; i<nums.length; i++)
    		if(maxIndex1==-1 || nums[i]>nums[maxIndex1])
    			maxIndex1 = i;

    	int maxIndex2 = -1;
    	for(int i = 0; i<nums.length; i++)
    		if(i!=maxIndex1 && (maxIndex2==-1 || nums[i]>nums[maxIndex2]))
    			maxIndex2 = i;
    	
    	return (long)nums[maxIndex1]*(long)nums[maxIndex2];
    }
    
    static void stressTest(){
    	while(true){
    		Random myRand = new Random();
    		int n = myRand.nextInt(10)+2;
    		int nums[] = new int[n];
    		for(int i = 0; i<n; i++)
    			nums[i] = Math.abs(myRand.nextInt(11));
    		for(int i = 0; i<n; i++)
    			System.out.print(nums[i]+" ");
    	
    		long res1 = getMaxPairwiseProduct(nums);
    		long res2 = getMaxPairWiseProductFast(nums);
    		if(res1!=res2){
    			System.err.println("Wrong answer :"+res1 +"\t"+res2);
    			break;
    		}else
    			System.out.println("OK");
    	}
    }
    
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
        stressTest();
       // System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}