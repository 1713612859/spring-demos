package org.example.date;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 本地日期测试
 *
 * @desc LocalDateTest
 * @author  LiuYunLong
 * @date 2023/09/22 17:31:57
 */
public class LocalDateTest {

	 /**
	  * 参考：
	  * <a href="https://www.cnblogs.com/huanshilang/p/12013386.html">LocalDate连接</a>
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
