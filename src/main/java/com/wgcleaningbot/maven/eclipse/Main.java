package com.wgcleaningbot.maven.eclipse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.model.request.InlineQueryResultArticle;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class Main {

	public static void main(String[] args) {
	TelegramBot bot = new TelegramBot("1602613525:AAH3HHjhREKiSP1wwex2rCDOkhPh58IGKyE");
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
		try {
			
			SendMessage request = new SendMessage(groupId, "HALLOOO");
	        
	    	//SendResponse sendResponse = bot.execute(request);
	    	//boolean ok = sendResponse.isOk();
	    	//Message message = sendResponse.message();
	    	TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
	
	

}
	