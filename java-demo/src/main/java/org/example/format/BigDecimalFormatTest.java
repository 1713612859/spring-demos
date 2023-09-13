package org.example.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 高精度数值格式化测试
 *
 * @author LiuYunLong
 */
public class BigDecimalFormatTest {

	 public static void main(String[] args) {
		  BigDecimal b1 = new BigDecimal(0.1);
		  BigDecimal b2 = new BigDecimal(1);

		  System.out.println(b1); // 0.1000000000000000055511151231257827021181583404541015625
		  System.out.println(b2); // 1

		  BigDecimal b3 = BigDecimal.valueOf((long) 55.66777, 2);
		  System.out.println(b3); // 0.55 保留两位，并不四舍五入


		  BigDecimal b4 = new BigDecimal("10.96465465465");
		  BigDecimal decimal = b4.subtract(b2);

		  System.out.println(decimal);


		  BigDecimal bd1 = new BigDecimal("1.23");
		  BigDecimal bd2 = new BigDecimal("2.34");

		  // 加法
		  BigDecimal sum = bd1.add(bd2);
		  System.out.println(sum);

		  // 减法
		  BigDecimal difference = bd1.subtract(bd2);
		  System.out.println(difference);

		  // 乘法
		  BigDecimal product = bd1.multiply(bd2);
		  System.out.println(product);

		  // 除法
		  BigDecimal quotient = bd1.divide(bd2, 2, RoundingMode.HALF_UP);
		  System.out.println(quotient);
	 }


}
