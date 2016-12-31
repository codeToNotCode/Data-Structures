/*
 * To represent a graph in the form of an Adjacency Matrix V*V
 * This representation is good when the graph is dense ie. number of edges is close to V^2
 * This code can be used for both directed as well as undirected graphs
 * For undirected graph, the matrix formed will be symetric: you can traverse only upper/lower half to know all the connections
 * Space complexity O(V^2)
 * Time Complexity O(1)
 */


package graphs;

import java.util.Scanner;
 
public class AdjacencyMatrix
{
	//Declaration of the class instance variables that are used to build up the matrix
	int numVertices;
    int adjacency_matrix[][];
 
    //Constructor to initialize the instance variables
    public AdjacencyMatrix(int number_of_vertices)
    {
        numVertices = number_of_vertices;
        adjacency_matrix = new int[numVertices + 1][numVertices + 1];
    }
 
    /*
     * function to connect to given vertices in the form of an edge
     * If it is a directed graph, only the first line of code is required
     * For undirected graph, both the lines are required
     */
    public void setNeighbour(int from_vertex, int to_vertex, int edgeWeight) 
    {
            adjacency_matrix[from_vertex][to_vertex] = edgeWeight;
            adjacency_matrix[to_vertex][from_vertex] = edgeWeight;
    }
 
    /*
     * Function to show which all vertices are connected
     * A value of '1' in the matrix show that the corrosponding vertices are connected via an edge
     * If the graph is weighted, then any positive value shows the connection bw vertices
     */
    public int getNeighbour(int from_vertex, int to_vertex)
    {
            return adjacency_matrix[from_vertex][to_vertex];
    }
 
    
    /*
     * Function to initialize the graph in an Adjacency Matrix format
     */
    public void initializeGraph(int numVertices, int numEdges)
    {
    	 Scanner scan = new Scanner(System.in);
    	 
         int source = 0, destination = 0;
         
    	 
         System.out.println("Enter The Graph Egdes :<source> <destination>");
        
         //User enters the vertices that are to be connected in the graph
         for (int i = 1  ; i <= numEdges ; i++)
         {
             source = scan.nextInt();
             destination = scan.nextInt();
             
             /*
              * Set the edge corrosponding to the vertices enterred by the user 
              * If it is a non-weighted graph - make all the edges as 1
              * Else input edgeWeight from the user while taking input for source and destination vertices
              */
             this.setNeighbour(source, destination,1);
         }
         
         scan.close();
    }
    
    
    /*
     * Function to display contents of the adjacency matrix
     */
    public void displayGraph(int numVertices)
    {
    	System.out.println("The adjacency matrix for given graph is\n ");
        for (int i = 1; i <= numVertices; i++)
            System.out.print(" "+i);

        System.out.println();
        for (int i = 1; i <= numVertices; i++) 
        {
            System.out.print(i+ " ");
            for (int j = 1; j <= numVertices; j++)
            { 
                System.out.print(this.getNeighbour(i, j)+" ");
            } 
            System.out.println();
        }
    }
    
    
    //Driver Function
    public static void main(String args[]) 
    {
    	 Scanner scan = new Scanner(System.in);
    	 int numVertices;
      
    	 System.out.println("Enter the Number of Vertices");
    	 numVertices = scan.nextInt();
         System.out.println("Enter the Number of Edges(connections)"); 
         int numEdges = scan.nextInt();
         
         AdjacencyMatrix  adjM = new AdjacencyMatrix(numVertices);

         adjM.initializeGraph(numVertices,numEdges );
         adjM.displayGraph(numVertices);
         
         scan.close();
    }
}