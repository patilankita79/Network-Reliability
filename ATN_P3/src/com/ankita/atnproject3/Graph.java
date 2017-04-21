package com.ankita.atnproject3;

public class Graph {
	
	/*
	 * adjacency matrix of a graph
	 */
	public int adjacencyMatrix[][]; 
	
	/*
	 * map i and j values of adjacency matrix to the link numbers
	 */
	public int mapToLink[][];
	
	/*
	 * p is the reliability of a link
	 */
	
	public double linkReliability_p; 
	
	public Graph(){
		
		linkReliability_p = 0;
		
		//Number of nodes in the network are 5, therefore initializing the adjacency matrix with 5 nodes
		adjacencyMatrix= new int[5][5];
		
		/*
		 * Total number of edges in undirected complete graph are [n * (n-1)]/2
		 * Hence initializing the following matrix with 10 edges and 2 nodes
		 * each row entry has the entry of two nodes having an edge and row number indicates the edge number
		 */
		
		mapToLink = new int[10][2];
		
		int key = 0;
		
		//adjacency matrix and map is generated for a 5 node network with all nodes connected
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if (i != j) {
					if(i > j) {
						mapToLink[key][0]= i;
						mapToLink[key][1]= j;
						key++;
					}
					adjacencyMatrix[i][j]=1;
				}
				else
					adjacencyMatrix[i][j]=0;
			}
		}
	}
	
	/*
	 * Output of mapToLink matrix:
	 * The 10 edges of the network  can be encoded as follows:
	 	    
   		0--1 : 0
   		0--2 : 1
   		1--2 : 2
   		0--3 : 3
   		1--3 : 4
   		2--3 : 5
   		0--4 : 6
   		1--4 : 7
   		2--4 : 8
   		3--4 : 9
			
	 */
	
	
	/*
	 * Following function implements depth first search starting from node i
	 */
	
	public void depthFirstSearch(int i, boolean visited[]) {
	
		//To keep a track of visited nodes
		visited[i] = true;
		
		//System.out.println("Visited "+i);
		
		for(int j = 0;j < 5; j++){
			if(adjacencyMatrix[i][j] == 1){
				if(!visited[j]){
					depthFirstSearch(j, visited);
				}
			}
		}
		
	}
	
	/*
	 * Following function checks if the graph or network is connected using depth first search
	 */
	
	public boolean isConnected(){
		boolean flag = true;
		
		//to keep a track of visited nodes
		boolean visited[] = new boolean[5];
		
		for(int i = 0; i < 5; i++){
			visited[i] = false;
		}
		
		depthFirstSearch(0, visited);		
		
		for(int i = 0;i < 5; i++){
			if(!visited[i]){ 
				flag = false;
			}
		}
		return flag;
	}
	
	/*
	 * Following function prints the adjacency matrix of a network or graph 
	 */
	public void print(){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println();	
		}
	}
	
	/*
	 * Following function returns the reliability of a given network or graph
	 */
	
	public double calculateReliability() {
		double reliability = 1;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if (i > j){
					
					//if the link is up
					if (adjacencyMatrix[i][j] == 1) {
						reliability = reliability * linkReliability_p;
					}
					//if the link is down	
					else {
						reliability = reliability * (1 - linkReliability_p);
					}
						
				}
			}
		}
		return reliability;
	}
	
	
	
}