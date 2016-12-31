/*
 * To represent a graph in the form of an Adjacency List 
 * This representation is good when the graph is sparse ie. number of edges is less than V^2 (most of the practical scenarios)
 * This code can be used for both directed as well as undirected graphs
 * Space Complexity  O(2*E) for undirected graphs , O(E) for directed graphs
 * Time Complexity O(V)
 * 
 * For most of the real world modelled graphs, Adjacency List representation is better in both time and space complexities
 */


package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class AdjacencyList 
{
   /* 
    * Makes use of Map collection to store the adjacency list for each vertex.
    * The First parameter Integer stores the Vertex Number
    * The Second parameter List<Integer> will store all the vertices that the above Integer is connected to. 
    * Together the above pair of parameters will store connections (edges) for a particular vertex 
    */
    private  Map<Integer, List<Integer>> Adjacency_List;	
    
   /*
    * Constructor: Initializes the map to with size equal to number of vertices in a graph
    * Maps each vertex to a given List Object (A new list dedicated for each vertex) 
    */
    public AdjacencyList(int numVertices)
    {
        Adjacency_List = new HashMap<Integer, List<Integer>>();	
        for (int i = 1 ; i <= numVertices ; i++)
        { 
        	//Associating every vertex with its own list
            Adjacency_List.put(i, new LinkedList<Integer>());
        }
    }
 
 
    /* Adds nodes in the Adjacency list for the corresponding vertex 
     * Adds vertices that are connected to a particular vertex 
     * Populates the list
     */
    public void setNeighbour(int source , int destination, int edgeWeight)
    {
       if (source > Adjacency_List.size() || destination > Adjacency_List.size())
       {
           System.err.println("Error: The vertex entered is not present ");
           return;
       }
       
       //Store the particuar vertex in concern into a list
       List<Integer> slist = Adjacency_List.get(source);
       
       //Link the mentioned destination vertex to the source vertex ie. establish connection
       slist.add(destination);
       
       //For undirected graphs, do the same by reversing the source and destination vertices
       List<Integer> dlist = Adjacency_List.get(destination);
       dlist.add(source);
   }
 
    
    /*
     * Function to show which all vertices are connected
     * A value of '1' in the matrix show that the corrosponding vertices are connected via an edge
     * If the graph is weighted, then any positive value shows the connection bw vertices
     */
    public List<Integer> getNeighbour(int source)
    {
        if (source > Adjacency_List.size())
        {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return Adjacency_List.get(source);
    }
    
    
    /*
     * Function to initialize the graph in an Adjacency List format
     */
    public void initializeGraph(int numVertices, int numEdges)
    {
    	int source , destination;
    	
        Scanner scan = new Scanner(System.in);
        
        /* Reads the edges present in the graph */
        System.out.println("Enter the edges in graph Format : <source index> <destination index>");
        
        /*
         * User enters the vertices that are to be connected in the graph
         * For a weighted graph - edgeWeights could also be taken as an input from the user
         */
        for (int i = 1 ; i <= numEdges; i++)
        {
            source = scan.nextInt();
            destination = scan.nextInt();
            this.setNeighbour(source, destination,1);
        }
        
        scan.close();
    }
 
    /*
     * Function to display contents of the adjacency list
     */
    public void displayGraph(int numVertices)
    {
    	for (int i = 1 ; i <= numVertices ; i++)
        {
            System.out.print(i+"->");
            List<Integer> neighbourList = this.getNeighbour(i);
          
            for (int j = 1 ; ; j++ )
            {
            	//To display all the vertices that are connected to a particular vertex
                if (j != neighbourList.size())
                {
                    System.out.print(neighbourList.get(j - 1 )+"->");
                }
                else
                {
                	//To display the last element in the list
                    System.out.print(neighbourList.get(j - 1 ));
                    break;
                }						 
            }
            System.out.println();					
         }
 
    }
    
    /*
     * Main Function reads the number of vertices and edges in a graph.
     * then creates a Adjacency List for the graph and prints it  
     */
     public static void main(String...arg)
     {
         
         int numEdges,numVertices;
         Scanner scan = new Scanner(System.in);
         
         /* Read the number of vertices and edges in graph */
         System.out.println("Enter the number of vertices and edges(connections) in graph");
         
         numVertices = scan.nextInt();
         numEdges = scan.nextInt();
         
         AdjacencyList adjList = new AdjacencyList(numVertices);
         
         adjList.initializeGraph(numVertices, numEdges);
            
         /* Prints the adjacency List representing the graph.*/
         System.out.println ("the given Adjacency List for the graph \n");
         adjList.displayGraph(numVertices);
              
         scan.close();
     }
}