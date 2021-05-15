package javaPrograms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

public class DateUtils {

	public static void main(String args[]) {
		String date1 = "12/02-2020 5:20:30+5:30";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d-yyyy");
		TemporalAccessor temp = formatter.parse(date1);
		LocalDate date = LocalDate.from(temp);
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		System.out.println(formatter2.format(temp));
	}
}
