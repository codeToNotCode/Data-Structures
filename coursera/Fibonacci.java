package coursera;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static int getFibonacciFast(int n){
  	if(n<=1) return n;
  	int numMinusOne = 1;
  	int numMinusTwo = 0;
  	int fib = 0;
  	for(int i = 2; i<=n; i++){
  		fib = numMinusOne+numMinusTwo;
  		numMinusTwo = numMinusOne;
  		numMinusOne = fib;
  	}
  	return fib;
  }
  
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

  //  System.out.println(calc_fib(n));
    System.out.println(getFibonacciFast(n));
  }
}