/*
 * To implement Depth First Search (DFS) algorithm for a graph traversal
 * Graph is represented as an adjacency matrix
 * In DFS - we use a Stack to implement the algorithm
 * DFS is similar to Pre Order traversal of a tree
 */

package graphs;

import java.util.Scanner;
import java.util.Stack;
 
public class GraphTraversalDFS
{
	//Declare a stack instance for graph traversal
    private Stack<Integer> stack;
 
    //Constructor to initialize the stack
    public GraphTraversalDFS() 
    {
        stack = new Stack<Integer>();
    }
 
    
    /*
     * To traverse the graph using Depth First Search technique
     * Takes 2 arguments as inputs - The adjacency matrix depicting all the connections that are present in the graph
     * A source node from where to start the traversal
     */
    public void dfs(int adjacency_matrix[][], int source)
    {
    	/*
    	 * A variable to store the number of columns in a particular row
    	 * Also, depicts connection status of a particular node with th rest of the nodes 
    	 */
        int numNodes = adjacency_matrix[source].length - 1;
 
        //An array to mark that a particular node has been visited(traversed) once
        int visited[] = new int[numNodes + 1];		
        
        int element = source;		
        int i = source;		
        
        System.out.print(element + "\t");		

        //Mark the start node of the graph traversal as visited and add that to the stack
        visited[source] = 1;		
        stack.push(source);
 
        //Keep traversing untill all the nodes have been removed from the stack
        while (!stack.isEmpty())
        {
        	//Look at the topmost element of the stack and store it in a new variable
            element = stack.peek();
            i = 1;	
            
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
                	 * Add the neighbour to the stack
                	 * Change its visited status to 1
                	 * Display the element currently pushed onto the stack
                	 * Continue untill there are no more neighbours left 
                	 */
                    
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    System.out.print(element + "\t");
                    continue;
                }
     	        //Increment and check the next neighbour
                i++;
            }
            //Remove the visited vertex from the stack
            stack.pop();	
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
    public static void main(String...arg)
    {
        GraphTraversalDFS dfs = new GraphTraversalDFS();
        
        int number_of_nodes, source;
        Scanner scan = null;
	    System.out.println("Enter the number of nodes in the graph");
        scan = new Scanner(System.in);
        number_of_nodes = scan.nextInt();
 
	    int adjM[][] = dfs.initializeGraph(number_of_nodes);
 
	    System.out.println("Enter the source for the graph");
            source = scan.nextInt(); 
 
            System.out.println("The DFS Traversal for the graph is given by ");
      
            dfs.dfs(adjM, source);					
        scan.close();	
    }	
}