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
	private List<Task> tasks;
	private ArrayList<Reminder> reminders;

	public List<String> getPeople() { return people; }
	public List<Task> getTasks() { return tasks; }
	public ArrayList<Reminder> getReminders() { return reminders; }
	
	public DataHandler() {	
		File data = new File("src/main/resources/data.txt");
		reminders = new ArrayList<Reminder>();

		try {
			Scanner scn = new Scanner(data);
			String schedule = scn.nextLine();
			
			for(String reminder:schedule.split(";")) {
				reminders.add(new Reminder(reminder.split(",")[0], Integer.valueOf(reminder.split(",")[1])));
			}
			
			people = new ArrayList<String>(Arrays.asList(scn.nextLine().split(";")));
			tasks = new ArrayList<Task>();
			for(String newTask:scn.nextLine().split(";")) {
				tasks.add(new Task(newTask));
			}
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
			
			for(Reminder reminder:reminders) {
				fw.write(reminder.toString()+';');
			}
			fw.write('\n');
			
			for(String person:people) {
				fw.write(person+";");
			}
			fw.write('\n');

			tasks.add(tasks.get(0));
			tasks.remove(0);

			for(Task task:tasks) {
				task.rotateSubtasks();
				fw.write(task.toString(true)+";");
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
		
		sb.append("**This week's tasks:**\n");
		for(int i=0; i<people.size(); i++) {
			System.out.println(tasks.get(i).getName());
			sb.append(people.get(i) + ": " + tasks.get(i).toString(false)+'\n');
		}
		
		return sb.toString();
	}

}
