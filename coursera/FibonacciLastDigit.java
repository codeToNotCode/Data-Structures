package coursera;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    private static int getFibonacciLastDigitFast(int n){
    	if(n<=1) return n;
    	int numMinusOne = 1;
    	int numMinusTwo = 0;
    	int lastDigit = 0;
    	for(int i = 2; i<=n; i++){
    		lastDigit = (numMinusOne+numMinusTwo)%10;
    		numMinusTwo = numMinusOne;
    		numMinusOne = lastDigit;
    	}
    	return lastDigit;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    //    int c = getFibonacciLastDigitNaive(n);
    //    System.out.println(c);
        System.out.println(getFibonacciLastDigitFast(n));
    }
}
