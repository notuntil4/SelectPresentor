package com.collabera.nameselector.runner;

import com.collabera.nameselector.model.Presentor;

public class PresentorRunner {
	
	public static void main(String[] args) {
		Presentor p1 = new Presentor();
		System.out.println("The default constructer p1:\n" + p1);
		
		Presentor p2 = new Presentor("Alex", 4, false);
		System.out.println("\nPresentor p2:\n" + p2);
		Presentor p3 = new Presentor("Sam", 1, true);
		System.out.println("\nPresentor p3:\n" + p3);
	}

}
