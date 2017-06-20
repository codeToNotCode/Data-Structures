package coursera;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  
  private static long lcm_fast(int a, int b){
	  return a/gcd(a,b) * b;
  }
  private static long gcd(int a, int b){
	  while(b!=0){
		  int temp = b;
		  b = a%b;
		  a = temp;
	  }
	  return a;
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

  //  System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a, b));
  }
}