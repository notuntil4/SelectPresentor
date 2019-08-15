package com.collabera.nameselector.runner;

import java.util.ArrayList;

import com.collabera.nameselector.manager.FileManager;

public class FileManagerRunner {

	public static void main(String[] args) {

		String presentorFile = "presentors.txt", logFile = "logs file";

		FileManager fm = new FileManager();

		System.out.println("--Presentor File---");
		fm.createFile(presentorFile);

		System.out.println("--Log File--");
		fm.createFile(logFile);

		System.out.println("\n------------------------------\n");
		
		
		ArrayList<String> test = new ArrayList<String>();
		test.add("hello");
		
		System.out.println("--Write to Presentor File--");
		fm.appendToFile(test, presentorFile);
		
		System.out.println("\n--Write to Log File--");
		fm.appendToFile(test, logFile);
		
		System.out.println("\n------------------------------\n");
		
		

		System.out.println("--Read Presentor File--");
		ArrayList<String> presentorContent = fm.readFile(presentorFile);

		if (!presentorContent.isEmpty()) {
			for (String line : presentorContent) {
				System.out.println(line);
			}
		} else {
			System.out.println(presentorFile + " is empty");
		}

		System.out.println("\n--Read Log File--");
		ArrayList<String> logContent = fm.readFile(presentorFile);

		if (!logContent.isEmpty()) {
			for (String line : logContent) {
				System.out.println(line);
			}
		} else {
			System.out.println(logFile + " is empty");
		}
		
		System.out.println("\n------------------------------\n");
		
		
		
		System.out.println("--Empty Presentor File--");
		fm.emptyFile(presentorFile);
		
		System.out.println("\n--Empty Log File--");
		fm.emptyFile(logFile);
		
//		System.out.println("\n------------------------------\n");
//		System.out.println("\n------------------------------\n");
	}
}
