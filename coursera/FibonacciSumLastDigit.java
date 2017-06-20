package coursera;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    /*
     * Sum(n) = F(n+2) - 1
     * Since to find the last digit, we take modulo by 10. Therefore, for very large numbers
     * We first find the pisano length of 10
     * And then reduce the large n by taking its modulo by pisanoLengthObtained
     * The expression in the return statement is for edge case when sumLastDigit is -1
     * We wrap it around such that digit remains between 0 and 9
     */
    private static long getFibonacciSumFast(long n){
    	if(n<=1) return n;
    	
    	int pisanoPeriodLength = getPisano(10);
    	long nthPlusTwoFib = n%pisanoPeriodLength+2 ;
    	long FibNPlusTwoLastDigit = findFib(nthPlusTwoFib);
    	long sumLastDigit = FibNPlusTwoLastDigit-1;
    	return (sumLastDigit+10)%10;
    }
    private static long findFib(long n){
    	long prev = 0;
    	long curr = 1;
    	long fib = 0;
    	for(int i =2; i<=n; i++){
    		fib = (prev%10+curr%10)%10;
    		prev = curr;
    		curr = fib;
    	}
    	return fib;
    }
    private static int getPisano(int m){
    	 int length = 0;
    	 int prev = 0;
    	 int curr = 1;
    	 int fib = 0;
    	 do{
    		 fib = (prev%m + curr%m)%m;
    		 prev = curr;
    		 curr = fib;
    		 length++;
    	 }while(!(prev==0&&curr==1));
    	 return length;
    }
    
    
    private static void stressTest(){
    	int i = 0;
    	while(true){
    		long res1 = getFibonacciSumNaive(i);
    		long res2 = getFibonacciSumFast(i);
    		if(res1!=res2){
    			System.err.println(res1+"\t"+res2);
    			break;
    		}else{
    			System.out.println("Both correct for n = "+i);
    		}
    		i++;
    	}
    }
    public static void main(String[] args) {
  //  	stressTest();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
  //      long s = getFibonacciSumNaive(n);
 //       System.out.println(s);
        System.out.println(getFibonacciSumFast(n));
    }
}
