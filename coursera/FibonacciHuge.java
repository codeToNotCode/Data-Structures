package coursera;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    private static long getFibonacciHugeFast(long n, long m){
    	long numMinusOne =1;
    	long numMinusTwo = 0;
    	long fib = 0;
    	long pisanoPeriodLength = 0;
    	do{
    		fib = (numMinusOne%m + numMinusTwo%m)%m;
    		numMinusTwo = numMinusOne;
    		numMinusOne = fib;
    		pisanoPeriodLength++;
    	}while(!(numMinusOne==1 && numMinusTwo==0));
    	
    	long nthFib =  n%pisanoPeriodLength;
    	if(nthFib<=1)return nthFib%m;
    	long newFib =0;
    	for(int i=2; i<=nthFib; i++){
    		newFib =(numMinusOne%m + numMinusTwo%m)%m;
    		numMinusTwo = numMinusOne;
    		numMinusOne = newFib;
    	}
    	return newFib%m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
     //   System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHugeFast(n, m));
    }
}
