package com.wgcleaningbot.maven.eclipse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Main {

	public static void main(String[] args) {
	TelegramBot bot = new TelegramBot("");
	final long groupId = -568869104;
	DataHandler dh = new DataHandler();		
	
	bot.setUpdatesListener(new UpdatesListener() {
	    @Override
	    public int process(List<Update> updates) {
	        for(Update update:updates) {
	        	try {
		        	SendMessage request = new SendMessage(groupId, dh.buildMessage());
		        
		        	SendResponse sendResponse = bot.execute(request);
		        	//boolean ok = sendResponse.isOk();
		        	//Message message = sendResponse.message();
		        	dh.update();
	        	} catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
	        }

	        return UpdatesListener.CONFIRMED_UPDATES_ALL;
	    }
	});
	
	
	
	while(true) {
		Calendar c = Calendar.getInstance(Locale.GERMANY);
		String currentDay = DayOfWeek.of(c.get(Calendar.DAY_OF_WEEK)).toString();
		int currentHour = c.get(Calendar.HOUR_OF_DAY);
		ArrayList<Reminder> reminders = dh.getReminders();
		
		for(Reminder reminder:reminders) {
			if(currentDay.equals(reminder.getDayOfMessage()) && currentHour == reminder.getHourOfMessage()) {
				SendMessage request = new SendMessage(groupId, "HALLOOO");
		        
		    	SendResponse sendResponse = bot.execute(request);
		    	//boolean ok = sendResponse.isOk();
		    	//Message message = sendResponse.message();
			}
		}
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	
	

}
	