package com.collabera.nameselector.runner;

import java.util.ArrayList;
import java.util.Scanner;

import com.collabera.nameselector.manager.PresentorManager;
import com.collabera.nameselector.model.Presentor;

public class PresentorManagerRunner {
	
	private static PresentorManager pm;

	public static void main(String[] args) {
		
		pm = new PresentorManager();
		pm.setPresentors();		

		Scanner sc = new Scanner(System.in);
		String selection = "";

		while (selection != "5") {
			
			System.out.println("\nPresentor Menu");
			System.out.println("1. List Presentors");
			System.out.println("2. Add Presentor");
			System.out.println("3. Edit Presentor");
			System.out.println("3. Remove Presentor");
			System.out.println("4. Set Presentor as Absent");
			System.out.println("5. Exit\n");
			
			selection = sc.nextLine().trim();
			
			switch (selection) {
			case "1":
				listPresentors();
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			default:
				System.out.println("Enter a valid choice.");
				break;
			}
		}
		
		sc.close();
	}
	
	public static void listPresentors() {
		ArrayList<Presentor> allPresentors = pm.getPresentors();
		
		if(allPresentors.isEmpty()) {
			System.out.println("There are no presentors");
		}
		else {
			for(Presentor p : allPresentors) {
				System.out.println(p.getId() + ". " + p.getName());
			}
		}
	}
}
