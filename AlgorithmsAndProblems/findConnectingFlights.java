/*
	Given two unsorted lists of String destinations and sources, sort the flights from start to end.
	No two flights are the same, and they are all one-way. Two destinations are never visited more than once.

	Our flights are arranged so that the first index of each subarray is the departure, and the second index 
	of each subarray is the arrival
*/

import java.util.*;

public class findConnectingFlights{
	private static final int DEPARTURE_INDEX = 0;
	private static final int ARRIVAL_INDEX = 1;

	public static void main(String[] args){
		String[][] flightsArr = {{"SFO","LAX"}, {"JSA","XGW"}, {"PXY","HTA"}, {"XGW","PXY"},{"LAX","JSA"}};

		//Our starting flight
		int startIndex = findStartPointIndex(flightsArr);

		if(startIndex >= 0){

			//Our starting flight set
			String[] startFlights = flightsArr[startIndex];

			LinkedListNode head = createSortedLinkedList(flightsArr, startFlights);

			//Print out our linked list!
			while(head.next != null){
				head.printNode();
				head = head.next;
			}
		}
		else{
			System.out.println("Sorry, starting flight doesn't exist.");
		}

	}


	public static int findStartPointIndex(String[][] flights){

		//Create a hashtable and set key to the arrivals 
		Hashtable<String, String> arrivalTable = new Hashtable<>();

		for(int i = 0; i < flights.length; i++){
			arrivalTable.put(flights[i][ARRIVAL_INDEX], flights[i][DEPARTURE_INDEX]);
		}

		//Go through array and see if our departure exists as an arrival, if not, we have our start point
		for(int i = 0; i < flights.length; i++){
			if(!arrivalTable.containsKey(flights[i][DEPARTURE_INDEX])){
				System.out.println("FOUND OUR START!");
				return i;
			}
		}

		return -1;
	}


	public static LinkedListNode createSortedLinkedList(String[][] flights, String[] start){

		//Create a hashtable and set key to the departures
		Hashtable<String, String> departureTable = new Hashtable<>();

		for(int i = 0; i < flights.length; i++){
			departureTable.put(flights[i][DEPARTURE_INDEX], flights[i][ARRIVAL_INDEX]);
		}

		//Create a variable to hold our current arrival and list node as we go through the hash table
		String currentArrival = start[ARRIVAL_INDEX];
		LinkedListNode current = new LinkedListNode(start[DEPARTURE_INDEX], start[ARRIVAL_INDEX]);
		LinkedListNode head = current;

		//Loop through our flights and create a linked list from the departures and arrivals
		for(int i = 0; i < flights.length; i++){
			//Use our arrival to find the next linked departure
			String currentDeparture = departureTable.get(currentArrival); //HTA

			//Add it to the linked list (switch since our departure is now our arrival and vise versa)
			LinkedListNode temp = new LinkedListNode(currentArrival, currentDeparture);
			temp.previous = current;
			current.next = temp;
			current = temp;

			//Set our currentArrival to our new currentDeparture
			currentArrival = currentDeparture; //current arrival is now PXY
		}

		//return head of linked list
		return head;
	}

}


class LinkedListNode{
	String dep;
	String arrival;
	LinkedListNode next = null;
	LinkedListNode previous = null;

	public LinkedListNode(String d, String a){
		dep = d;
		arrival = a;
	}

	public String getDep(){
		return dep;
	}

	public String getArrival(){
		return arrival;
	}

	public void printNode(){
		System.out.println("DEPT: " + dep + "; ARR: " + arrival);
	}
}