package com.wgcleaningbot.maven.eclipse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class Main {

	public static void main(String[] args) {
		final TelegramBot bot = new TelegramBot("");
		final long groupId = -568869104;
		final DataHandler dh = new DataHandler();

		bot.setUpdatesListener(new UpdatesListener() {
			@Override
			public int process(List<Update> updates) {
				for (Update update : updates) {
					try {
						if (update.message() != null && update.message().text().equals("/list_week@WGCleaningBot")) {
							SendMessage request = new SendMessage(groupId, dh.buildMessage())
									.parseMode(ParseMode.Markdown);

							//SendResponse sendResponse = 
									bot.execute(request);
						}

						// SendResponse sendResponse = bot.execute(request);
						// boolean ok = sendResponse.isOk();
						// Message message = sendResponse.message();
						// dh.update();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				return UpdatesListener.CONFIRMED_UPDATES_ALL;
			}
		});

		while (true) {
			Calendar c = Calendar.getInstance(Locale.GERMANY);
			String currentDay = DayOfWeek.of(c.get(Calendar.DAY_OF_WEEK)).toString();
			int currentHour = c.get(Calendar.HOUR_OF_DAY);
			ArrayList<Reminder> reminders = dh.getReminders();

			for (Reminder reminder : reminders) {
				if (currentDay.equals(reminder.getDayOfMessage()) && currentHour == reminder.getHourOfMessage()) {
					SendMessage request = new SendMessage(groupId, dh.buildMessage()).parseMode(ParseMode.Markdown);

					//SendResponse sendResponse = 
							bot.execute(request);
					//boolean ok = sendResponse.isOk(); 
					//Message message = sendResponse.message();

					try {
						TimeUnit.HOURS.sleep(1);
					} catch (InterruptedException e) { // TODO
						e.printStackTrace();
					}
				}
			}
		}
	}
}
