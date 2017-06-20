package coursera;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciPartialSumFast(long m, long n){
//    	if (m==n)
//    		return getFibonacciSumFast(n);
    	long lastDigitM = getFibonacciSumFast(m-1);
    	long lastDigitN = getFibonacciSumFast(n);
    	return (lastDigitN-lastDigitM+10)%10;
    }
    
    
    private static long getFibonacciSumFast(long n){
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
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}
