package com.wgcleaningbot.maven.eclipse;

public class Reminder {
	private String dayOfMessage;
	private int hourOfMessage;
	
	public Reminder(String dayOfMessage, int hourOfMessage) {
		this.dayOfMessage = dayOfMessage;
		this.hourOfMessage = hourOfMessage;
	}
	public String getDayOfMessage() {
		return dayOfMessage;
	}
	public void setDayOfMessage(String dayOfMessage) {
		this.dayOfMessage = dayOfMessage;
	}
	public int getHourOfMessage() {
		return hourOfMessage;
	}
	public void setHourOfMessage(int hourOfMessage) {
		this.hourOfMessage = hourOfMessage;
	}
}
