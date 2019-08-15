package com.collabera.nameselector.manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManager {
	private static final String PRESENTORS_FILE_NAME = "presentors.txt";
	private static final String PRESENTORS_FILE_PATH = "./resources/" + PRESENTORS_FILE_NAME;
	private static File presentorFile;
	private static File logFile;

	public void createFile(String fileName) {
		File newFile = null;
		
		// needs to be absolute path to create resource and logs folder if 
		// they don't already exist
		File dirs = new File("C:\\Java_Workspace\\NameSelector\\resources\\logs\\");
		if(!dirs.exists()) {
			dirs.mkdir();
		}

		try {

			if (fileName == PRESENTORS_FILE_NAME) {			// check if presentor file...
				newFile = new File(PRESENTORS_FILE_PATH);
				presentorFile = newFile;
			} else {
				String logName = logFileName(new Date());
				newFile = new File("./resources/logs/" + logName); // ...if not, a log file
				logFile = newFile;
			}

			if (newFile.createNewFile()) {
				System.out.println("Creating new file " + newFile.getName());
			} else {
				System.out.println("File " + newFile.getName() + " already exists");
			}

		} catch (IOException e) {
			System.out.println("Could not open or create file " + newFile.getName() + " with file path "
					+ newFile.getAbsolutePath());
		}
	}
	
	public String logFileName(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		String logName = dateFormat.format(date) + ".log" ;
		return logName;
	}
	
	public ArrayList<String> readFile(String fileName) {
		
		ArrayList<String> records = new ArrayList<String>();
		
		File file = selectFile(fileName);

		if (!isFileEmpty(file)) {
			try {
				Scanner fileReader = new Scanner(file);

				while (fileReader.hasNextLine()) {
					String record = fileReader.nextLine().trim();
					records.add(record);
				}

				fileReader.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("Could not find file " + file.getName());
			}
		}
		
		return records;
	}
	
	public boolean isFileEmpty(File file) {
		if (file.length() == 0) {
			return true;
		}

		return false;
	}
	
	public void appendToFile(ArrayList<String> linesToAppend, String fileName) {
		try {
			File file = selectFile(fileName);

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);

			for(String line : linesToAppend) {
				bw.write(line);
				bw.newLine();
			}

			bw.close();
			fw.close();
			
		} catch (IOException e) {
			System.out.println("Could not write to file");
		}
	}
	
	public void emptyFile(String fileName) {
		File file = selectFile(fileName);
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + file.getName() + " and empty it");
		}
		
		pw.write("");
		pw.close();
	}
	
	public File selectFile(String fileName) {
		File file;
		
		if(fileName == PRESENTORS_FILE_NAME) {
			file = presentorFile;
		}
		else {
			file = logFile;
		}
		
		return file;
	}
	
	
}
