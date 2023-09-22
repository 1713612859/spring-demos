package org.example.date;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Desc LocalDateTest
 * @Author LiuYunLong
 */
public class LocalDateTest {

	 /**
	  * 参考：
	  * https://www.cnblogs.com/huanshilang/p/12013386.html
	  */
	 public static void main(String[] args) {
		  LocalDate now = LocalDate.now();

		  System.out.println("now = " + now);

		  LocalDate now1 = LocalDate.now(Clock.systemDefaultZone());
		  System.out.println("now1 = " + now1);

		  LocalDateTime localDateTime = LocalDateTime.now();
		  System.out.println("localDateTime = " + localDateTime);

		  String format = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		  System.out.println("format = " + format);
	 }
}
