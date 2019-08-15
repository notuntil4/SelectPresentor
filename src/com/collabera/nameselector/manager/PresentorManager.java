package com.collabera.nameselector.manager;

import java.util.ArrayList;

import com.collabera.nameselector.model.Presentor;

public class PresentorManager {
	
	private static final String PRESENTOR_FILE = "presentors.txt";
	private static final String LOG_FILE = "log file";
	private FileManager fileManager;
	private ArrayList<Presentor> presentors = new ArrayList<Presentor>();
	
	public PresentorManager() {
		fileManager = new FileManager();
	}
	
	public void setPresentors() {
		
		ArrayList<String> filePresentors = fileManager.readFile(PRESENTOR_FILE);
		
		for(String name : filePresentors) {
			presentors.add(new Presentor(name, 0, false));
		}
		
		//System.out.println("Set Presentor array from file");
	}
	
	public ArrayList<Presentor> getPresentors() {
		return presentors;
	}
	
	public ArrayList<String> getPresentorNames() {
		ArrayList<String> names = new ArrayList<String>();
		
		for(Presentor p : presentors) {
			names.add(p.getName());
		}
		
		return names;		
	}
	
}
