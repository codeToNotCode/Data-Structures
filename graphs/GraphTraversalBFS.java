/*
 * To implement Breadth First Search (BFS) algorithm for a graph traversal
 * Graph is represented as an adjacency matrix
 * In BFS - we use Queue to implement the algorithm
 * BFS is similar to Level Order traversal of a tree
 */

package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class GraphTraversalBFS
{ 
 
	//Declare a Queue instance
    private Queue<Integer> queue;
 
    
    /*
     * Constructor to set memory/Create an Object 
     * A linked list is used to create an Object and store it in a Queue reference because Queue in java is an interface
     * You cannot instantiate an interface
     */
    public GraphTraversalBFS()
    {
        queue = new LinkedList<Integer>();
    }
 
    
    
    /*
     * To traverse the graph using Breadth First Search technique
     * Takes 2 arguments as inputs - The adjacency matrix depicting all the connections that are present in the graph
     * A source node from where to start the traversal
     */
    public void bfs(int adjacency_matrix[][], int source)
    {
    	/*
    	 * A variable to store the number of columns in a particular row
    	 * Also, depicts connection status of a particular node with th rest of the nodes 
    	 */
        int numNodes = adjacency_matrix[source].length - 1;
 
        //An array to mark that a particular node has been visited(traversed) once
        int[] visited = new int[numNodes + 1];
        
        int i, element;
 
        //Mark the start node of the graph traversal as visited and add that to the queue
        visited[source] = 1;
        queue.add(source);
 
        //Keep traversing untill all the nodes have been removed from the queue
        while (!queue.isEmpty())
        {
        	//Dequeue the node that is at the front from the queue
            element = queue.remove();
           
            i = 1;
            
            //Display the element that has been just visited
            System.out.print(element + "\t");
            
            //Add neighbours of the newly visited element to the queue if they are not already in the queue
            while (i <= numNodes)
            {
            	/*
            	 * The first condition finds neighbours of the newly visited element
            	 * The second condtion checks whether the neighbour has already been visited or not
            	 */
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                	/*
                	 * Add the neighbour to the queue
                	 * Change its visited status to 1
                	 */
                    queue.add(i);
                    visited[i] = 1;
                }
                
                //increment and check the next neighbour
                i++;
            }
        }
    }
 
    /*
     * To initialize the graph in the form of an adjacency matrix based on user inputs
     */
    public int[][] initializeGraph(int numNodes)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int adjM[][] = new int[numNodes + 1][numNodes + 1];
        System.out.println("Enter the adjacency matrix");
        
        for (int i = 1; i <= numNodes; i++)
           for (int j = 1; j <= numNodes; j++)
             adjM[i][j] = scan.nextInt();
        
       
        return adjM;
    }
    
    //Driver Function
    public static void main(String[] args)
    {
    	GraphTraversalBFS bfs = new GraphTraversalBFS();
        int numNodes, source;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of nodes in the graph");
        numNodes = scan.nextInt();
 
        int[][] adjM = bfs.initializeGraph(numNodes);
        
        System.out.println("Enter the source for the graph");
        source = scan.nextInt();
 
        System.out.println("The BFS traversal of the graph is ");
        
        bfs.bfs(adjM, source);
 
        scan.close();
    }
}