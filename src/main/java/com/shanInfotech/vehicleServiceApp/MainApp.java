package com.shanInfotech.vehicleServiceApp;

import java.util.ArrayDeque;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class MainApp {

	public static void main(String[] args) {
		Queue<String> queue=new ArrayDeque<String>();
		queue.add("Jhonny");
		queue.add("Jani");
		queue.add("Janardhan");
		for(String que:queue) {
			System.out.println(que);
		}
		System.out.println(queue.poll());
		System.out.println(queue.peek());
	
	PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	pq.offer(3);
	pq.offer(1);
	pq.offer(9);
	System.out.println(pq);
	System.out.println(pq.peek());
	
	NavigableSet< String> keeper=new TreeSet<String>();
	keeper.add("Gilchrist");
	keeper.add("Dhoni");
	keeper.add("Karthik");
	keeper.add("Ian");
	keeper.add("Parore");
	keeper.add("Poucher");
	keeper.add("Pant");
	keeper.add("Rahul");
	
	System.out.println(keeper.ceiling("G"));
	System.out.println(keeper.floor("P"));
	System.out.println(keeper.higher("P"));
	System.out.println(keeper.lower("R"));
	System.out.println(keeper.tailSet("Gi"));
	System.out.println(keeper.last());
	System.out.println(keeper.pollFirst());

}
}