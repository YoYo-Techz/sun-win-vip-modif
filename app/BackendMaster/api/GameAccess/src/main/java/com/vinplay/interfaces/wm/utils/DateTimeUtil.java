package com.vinplay.interfaces.wm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {
	
	public static void main(String[] args) {
		System.out.println(toISO8601UTC(new Date()));
	}
	public static String toISO8601UTC(Date datetime) {
		return  DateTimeFormatter.ISO_DATE_TIME.format(convertToLocalDateTimeViaInstant(datetime));
	}
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	public static Date fromISO8601UTC(String dateStr) {
		LocalDateTime ldt = LocalDateTime.parse(dateStr);
		Date out = Date.from(ldt.atZone(ZoneId.of("GMT-4")).toInstant());
		return out;
	}
	/**
	 * Transform ISO 8601 string to Date.
	 */
	public static Date toDate(final String iso8601string) throws ParseException {
	    String s = iso8601string.replace("Z", "+00:00");
	    try {
	        s = s.substring(0, 22) + s.substring(23);  // to get rid of the ":"
	    } catch (IndexOutOfBoundsException e) {
	        throw new ParseException("Invalid length", 0);
	    }
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    Date date = df.parse(s);
	    return date;
	}
}
