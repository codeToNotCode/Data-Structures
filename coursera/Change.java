//package coursera;

import java.util.Scanner;

public class Change {
	

    private static int getChange(int m) {
        int change[] = {10,5,1};
        int numCoins = 0;
        int i = 0;
        while(m!=0&&i<change.length){
        	int currDenom = change[i];
        	int currDenomCoinsReq = m/currDenom;
        	numCoins += currDenomCoinsReq;
        	i++;
        	m = m- (currDenomCoinsReq*currDenom);
       }
        return numCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}
