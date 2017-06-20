package coursera;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        
        //Arrays.sort(a, (a1, a2) -> (a2+a1).compareTo(a1+a2));
        
        //Without using Gamma function
       ArrayList<String> input = new ArrayList<>();
       for(String num :a)
    	   input.add(num);
        
        while(!input.isEmpty()) {
        	int maxDigit = 0;
        	for(String digit : input){
        		if(isGreater(digit, String.valueOf(maxDigit))){
        			maxDigit = Integer.parseInt(digit);
        		}
        	}
        	result += String.valueOf(maxDigit);
        	input.remove(String.valueOf(maxDigit));
        }
        return result;
    }
    
    private static String largest(String[] a){
    	Arrays.sort(a,(a1,a2) -> (a2+a1).compareTo(a1+a2));
    	String result = String.join("", a);
    	if(result.charAt(0)=='0'||result.length()<=0)
    			return "0";
    	return result;
    }
    private static boolean isGreater(String num1, String num2){
    	String first = num1+num2;
    	String last = num2+num1;
    	if(Integer.parseInt(first)>=Integer.parseInt(last))
    		return true;
    	return false;
    }
    
    
    private static void stressTest(){
    	String res1 ="";
    	String res2 = "";
    	Random rand = new Random();
    	int i = 1;
    	int a = 1;
    	for(; i<=100; i++){
    		String[] in = new String[i];
    		for(a = 0; a<i; a++){
    			in[a] = String.valueOf(rand.nextInt(1000)+1);
    		}
    		res1 = largest(in);
    		res2 = largestNumber(in);
    		if(!res1.equals(res2)){
    			System.err.println("n :"+i);
    			for(String s : in)
    				System.err.print(s+" ");
    			System.out.println();
    			System.err.println("\nres1 : "+res1);
    			System.err.println("res2 : "+res2);
    			break;
    		}
    	}
    	System.out.println("No Error");
    }
    
    
    public static void main(String[] args) {
 // stressTest();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        
       
        System.out.println(largestNumber(a));
//       System.out.println(largest(a));
    
    }
}
