//package coursera;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
    	//Sort the segments in increasing order of end points
    	List<Segment> list = Arrays.asList(segments);
    	list.sort((seg1,seg2) -> Integer.compare(seg1.end, seg2.end));
    	List<Integer> points = new ArrayList<>();
    	for(int i = 0;i<list.size();i++){
    		int minEnd = list.get(i).end;
    		points.add(minEnd);
    		
    		for(int j = i; j<list.size(); j++)
    			if(minEnd>=list.get(j).start&&minEnd<=list.get(j).end)
    				i++;
    			else
    				break;
    		i--;
    	}
    	int[] result = new int[points.size()];
    	for(int i = 0; i<points.size(); i++)
    		result[i] = points.get(i);
    	
        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 