package org.example.format;

import java.text.MessageFormat;

/**
 * 字符串格式化测试
 *
 * @author LiuYunLong
 * @date 2023/09/08 13:44:57
 */
public class StringFormatTest {

	 public static void main(String[] args) {
		  int fileCount = 1273;
		  String diskName = "MyDisk";
		  Object[] testArgs = {new Long(fileCount), diskName};

		  MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s).");

		  System.out.println(form.format(testArgs));

		  String format = MessageFormat.format("my name is {0} , my age is {1}", "liuyunlong", 18);
		  System.out.println(format);
	 }
}
