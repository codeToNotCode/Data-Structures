//package coursera;

/*
 * Create a new data structure to sort items in decreasing order of value/weights
 * Greedily select item with max V/W ratio until the knapsack has space
 */
import java.util.ArrayList;
import java.util.Scanner;

public class FractionalKnapsack{
	static class Item{
		
		int val;
		int weight;
		double valByWeight;
		public Item(int i, int j) {
			val = i;
			weight = j;
			valByWeight = (double)i/j;
		}
	}
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double cap = (double)capacity;
        //write your code here
        ArrayList<Item> items = new ArrayList<Item>();
        for(int i = 0; i< values.length; i++){
        	Item it = new Item(values[i], weights[i]);
        	items.add(it);
        }
     
        items.sort((a,b) -> Double.compare( b.valByWeight, a.valByWeight));
        double maxValue = 0;
        boolean moreSpace = true;
        while(moreSpace&&items.size()!=0){
        	Item bestItem = items.get(0);
        	int bestWeight = bestItem.weight;
        	if(bestWeight <= cap){
        		maxValue += bestItem.val;
        		cap = cap - bestWeight;
        	}else{
        		double valWeightRatio = bestItem.valByWeight;
        		double value = valWeightRatio*cap;
        		maxValue += value;
        		moreSpace = false;
        	}
        	items.remove(0);
        }
        return maxValue;
    }

   
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}  