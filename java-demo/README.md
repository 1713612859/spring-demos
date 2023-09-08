# Java 基础案例

## Format 使用

### DecimalFormat 使用

数字格式化 ：
    1. #.## 保留两位（四舍五入）
    2. 0.00 不足补0
```java
DecimalFormat decimalFormat = new DecimalFormat("#.##");
```

```java
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
```

### MessageFormat 使用

```java
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

			// The disk "MyDisk" contains 1,273 file(s).
            // my name is liuyunlong , my age is 18
	 }
}
```
