package com.wgcleaningbot.maven.eclipse;

import java.time.DateTimeException;

public enum DayOfWeek {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY;
	
	private static final DayOfWeek[] ENUMS = DayOfWeek.values();
	
	public static DayOfWeek of(int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new DateTimeException("Invalid value for DayOfWeek: " + dayOfWeek);
        }
        return ENUMS[dayOfWeek - 1];
    }
}
