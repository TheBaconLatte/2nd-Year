package ut10;
import java.util.*;
import java.lang.*;
import java.io.*;

public class dijkstra {

	    // A utility function to find the vertex with minimum distance value,
	    // from the set of vertices not yet included in shortest path tree
	    static final int V=10;
	    static int result = 0;
	    int minDistance(int dist[], Boolean sptSet[])
	    {
	        // Initialize min value
	        int min = Integer.MAX_VALUE, min_index=-1;
	 
	        for (int v = 0; v < V; v++)
	            if (sptSet[v] == false && dist[v] <= min)
	            {
	                min = dist[v]; //trying to find the shortest distance for the starting point
	                min_index = v; //index of the smallest point
	            }
	 
	        return min_index;
	    }
	 
	    //updates longest shortest distance
	    void longest(int dist[], int n)
	    {
	        for (int i = 0; i < V; i++){
	           	if(dist[i]>result){
	        		result = dist[i];
	        	}
	        }
	    }
	 
	    
	    void dijkstra(int array[][], int src)
	    {
	        int dist[] = new int[V]; // The output array. dist[i] will hold
	                                 // the shortest distance from src to i
	 
	        // sptSet[i] will true if vertex i is included in shortest
	        // path tree or shortest distance from src to i is finalized
	        Boolean sptSet[] = new Boolean[V];
	 
	        // Initialize all distances as INFINITE and stpSet[] as false
	        for (int i = 0; i < V; i++)
	        {
	            dist[i] = Integer.MAX_VALUE;
	            sptSet[i] = false;
	        }
	 
	        // Distance of source vertex from itself is always 0
	        dist[src] = 0;
	 
	        // Find shortest path for all vertices
	        for (int count = 0; count < V-1; count++)
	        {
	            // Pick the minimum distance vertex from the set of vertices
	            // not yet processed. u is always equal to src in first
	            // iteration.
	            int u = minDistance(dist, sptSet);
	 
	            // Mark the picked vertex as visited, won't go into min distance
	            sptSet[u] = true;
	 
	            // Update dist value of the adjacent vertices of the
	            // picked vertex.
	            for (int v = 0; v < V; v++)
	 
	                // Update dist[v] only if is not in sptSet, there is an
	                // edge from u to v, and total weight of path from src to
	                // v through u is smaller than current value of dist[v]
	                if (!sptSet[v] && array[u][v]!=0 &&
	                        dist[u] != Integer.MAX_VALUE &&
	                        dist[u]+array[u][v] < dist[v])
	                    dist[v] = dist[u] + array[u][v];
	        }
	 
	        // print the constructed distance array
	        longest(dist, V);
	    }
	 	
	
	public static void main(String args[]){
		FileIO io = new FileIO();
		String[] original = io.load("C:\\Users\\Kerrie-Ann\\Documents\\CS211\\graph.txt");
		int size=original.length-1;
		int[][] array = new int[size][size];

		for(int i=1;i<=size;i++){ //load up the data into array
			for(int j=1;j<=size;j++){
				array[i-1][j-1]=Integer.parseInt(original[i].split("\t")[j]);
			}
		}
        dijkstra t = new dijkstra();
        for(int i=0; i<size;i++){
        	t.dijkstra(array, i); //loops through all possible start points
        }
        System.out.println(result); // prints out solution
	}
	
}