package org.example.format;

import java.text.DecimalFormat;

/**
 * @author LiuYunLong
 * @date 2023/09/07 15:47:13
 * @github : https://github.com/1713612859
 */
public class DecimalFormatTest {

	 final static DecimalFormat decimalFormat = new DecimalFormat("#.##");

	 public static void main(String[] args) {
		  double num = 20.555;

		  String format = decimalFormat.format(num);
		  System.out.println(Double.valueOf(format));
		  System.out.println("format = " + format2bit(5.66669999));
		  System.out.println("format = " + format2bit(0.978798798));

		  /**
			* 20.55
			* format = 5.67
			* format = 0.98
			*/
	 }

	 /**
	  * 格式化并保留两位
	  *
	  * @param number
	  * @return
	  */
	 public static Double format2bit(double number) {
		  return Double.valueOf(decimalFormat.format(number));
	 }
}
