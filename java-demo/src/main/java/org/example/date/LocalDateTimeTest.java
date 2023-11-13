package org.example.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Desc LocalDateTimeTest
 * @Author LiuYunLong
 */
public class LocalDateTimeTest {

	 public static void main(String[] args) {
		  LocalDateTime now = LocalDateTime.now();
		  System.out.println("now = " + now);
		  System.out.println(now.plusMinutes(3));
		  System.out.println(now.minusMinutes(5));

		  String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		  System.out.println("format = " + format);

	 }

}
