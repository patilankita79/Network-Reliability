package com.ankita.atnproject3;

import java.util.ArrayList;
import java.util.Random;
/**
 * A program to find the reliability of a network using exhaustive enumeration
 * @author patil
 *
 */
public class NetworkReliability {
	
	/*
	 * This function returns reliability for a given value of p and k
	 * p : Reliability of a link
	 */
	
	public static double findReliability(double linkReliability_p, int k)
	{
		//list of k distinct random numbers between 0 and 1024 are generated
		ArrayList<Integer> listOfKRandomSystemStates = new ArrayList<Integer>();
		
		for(int j = 0; j < k; j++) {
		
		   Random rand = new Random();
		   
		   int randomNumber = rand.nextInt(1024);
		   //System.out.println("Random no" +randomNumber);
		   
		   while(listOfKRandomSystemStates.contains(randomNumber)){
			   randomNumber = rand.nextInt(1024);
		   }
		   listOfKRandomSystemStates.add(randomNumber);
		}
		
		
		double R =0;
		
		 /*
        All combinations involved in the network can be represented by the numbers from 0 to 1023 as follows
        0 - 0000000000
        1 - 0000000001 - one link is up
        2 - 0000000010 - a different link is up
        3 - 0000000011 - two different links are up
        ...
        1023 - 1111111111 - all links are up!
        
        */
        
		for(int i = 0; i < 1024; i++) {
			
			
			Graph Graph= new Graph();
			
			Graph.linkReliability_p = linkReliability_p;
			//All possible combinations are generated using all 10 digit binary numbers
			String systemState = String.format("%10s", Integer.toBinaryString(i)).replace(" ", "0");
			//System.out.println(systemState);
			
			for(int j = 0; j < 10; j++){
				
				if (systemState.charAt(j) =='1'){
					
					Graph.adjacencyMatrix[Graph.mapToLink[j][0]][Graph.mapToLink[j][1]]= 0;
					Graph.adjacencyMatrix[Graph.mapToLink[j][1]][Graph.mapToLink[j][0]]= 0;
					
				}
			}
			
			//if i (current system state) is in the list of randomly chosen system states then, 
			//flip or reverse the system condition(or state) 
			//else do not reverse state
			if(listOfKRandomSystemStates.contains(i)){
				if(!Graph.isConnected()){
					//compute reliability by adding reliability of different states
					R = R + Graph.calculateReliability();
				}
			}
			else{				
				if(Graph.isConnected()){
					
					R = R + Graph.calculateReliability();
				}
			}
		}
		
		return R;
	}
	
	
	public static void main(String[] args) {
		
		/*
		 * k is the number of system states with reversed or flipped  system conditions 
		 */
		int k=0; 
		
		/*
		 * link reliability
		 */
		double linkReliability_p; 
		
		//finding variation of probability with p with k =0
		for ( linkReliability_p = 0; linkReliability_p <1.05; linkReliability_p += 0.05) {
		
			System.out.println("For link reliability p = "+String.format("%.2g", linkReliability_p)+"\t Network Reliability = "+findReliability(linkReliability_p, k));
		}
		System.out.println();
		
		
		//Fix the link reliability to 0.85
		for(k = 0; k <= 20; k++){
			double rel = 0;
			for(int j = 0;j < 100; j++){
				rel = rel +findReliability(0.85, k);
			}
			rel = rel/100;
			System.out.println("Reliability for k = "+k+" is "+rel);
			
		}
		
	}
}