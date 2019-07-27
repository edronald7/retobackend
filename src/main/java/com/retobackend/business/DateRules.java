package com.retobackend.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateRules {

	public int yearsOld(Date birthday) {
		  Calendar c = Calendar.getInstance();
		  c.setTime(birthday);
		  int year = c.get(Calendar.YEAR);
		  int month = c.get(Calendar.MONTH) + 1;
		  int date = c.get(Calendar.DATE);
		  LocalDate l1 = LocalDate.of(year, month, date);
		  LocalDate now1 = LocalDate.now();
		  Period diff1 = Period.between(l1, now1);
		  return diff1.getYears();
	}
	
	public Date deathDate(Date birthday, int edadMuertePromedio) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(birthday);
		cal.add(Calendar.YEAR, edadMuertePromedio);
		
		return cal.getTime();
	}
}
