package com.wgcleaningbot.maven.eclipse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DataHandler {
	
	private List<String> people;
	private List<String> tasks;
	
	public List<String> getPeople() { return people; }
	public List<String> getTasks() { return tasks; }
	
	public DataHandler() {	
		File data = new File("src/main/resources/data.txt");

		try {
			Scanner scn = new Scanner(data);
			people = new ArrayList<String>(Arrays.asList(scn.nextLine().split(";")));
			tasks = new ArrayList<String>(Arrays.asList(scn.nextLine().split(";")));
			scn.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void update() {
		File data = new File("src/main/resources/data.txt");

		try {
			FileWriter fw = new FileWriter(data);
			for(String person:people) {
				fw.write(person+";");
			}
			fw.write('\n');

			tasks.add(tasks.get(0));
			tasks.remove(0);

			for(String task:tasks) {
				fw.write(task+";");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Oh no");
		}		
	}
	
	public String buildMessage() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("This week's tasks:\n");
		for(int i=0; i<people.size(); i++) {
			sb.append(people.get(i) + ": " + tasks.get(i)+'\n');
		}
		
		return sb.toString();
	}

}
