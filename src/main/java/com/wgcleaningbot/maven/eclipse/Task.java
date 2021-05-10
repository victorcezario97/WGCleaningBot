package com.wgcleaningbot.maven.eclipse;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {
	
	private String name;
	private ArrayList<String> subtasks;
	
	public Task(String data) {
		if(data.contains("(")) {
			name = data.split("\\(")[0];
			System.out.println(name);
			subtasks = new ArrayList<String>(Arrays.asList(data.split("\\(")[1].split("\\)|,")));
		}
		else {
			name = data;
			subtasks = null;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getSubtasks(){
		return subtasks;
	}
	
	public boolean containsSubtasks() {
		if(subtasks != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void rotateSubtasks() {
		if(!containsSubtasks()) {
			return;
		}
		
		subtasks.add(subtasks.get(0));
		subtasks.remove(0);
	}
	
	public String toString(boolean allSubtasks) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(name);
		if(containsSubtasks()) {
			sb.append('(');
			if(allSubtasks) {
				for(String sub:subtasks) {
					sb.append(sub);
					sb.append(',');
				}
			}else {
				sb.append(subtasks.get(0));
			}
			sb.append(')');
		}
		
		return sb.toString();
	}

}
