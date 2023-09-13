package com.example.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author LiuYunLong
 */
@Slf4j
public class PathUtil {
	 /**
	  * 获取项目加载类的根路径
	  *
	  * @return
	  */
	 public static String getJarPath() {
		  String path = "";
		  try {
				String location = System.getProperty("user.dir");

				File file = new File(location);
				if (file.isDirectory()) {
					 path = file.getAbsolutePath();
				}
				else {
					 path = file.getPath();
				}
				log.info("jar path is ，location is {}, {}", location, path);
		  }
		  catch (Exception e) {
				log.error("jar find location path error {}", e.getMessage());
		  }
		  return path;
	 }

	 /**
	  * 根据文件名加载为属性文件
	  *
	  * @param prop
	  * @param fileName
	  * @throws IOException
	  */
	 public static void loadPropertiesByFileName(Properties prop, String fileName) {
		  try {
				prop.load(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8));
				log.info("find properties  ");
		  }
		  catch (IOException e) {
				throw new RuntimeException(e);
		  }
	 }


	 /**
	  * 找外部文件
	  *
	  * @param jarPath
	  */
	 public static Properties findExartProperties(String jarPath) {
		  Properties pro = new Properties();
		  File file = new File(jarPath + "\\" + "zhlk.properties");
		  if (file.exists()) {
				try {
					 pro.load(new InputStreamReader(new FileInputStream(file), Charset.defaultCharset()));
					 System.out.println("username" + pro.getProperty("username"));
					 System.out.println("userage" + pro.getProperty("userage"));
				}
				catch (IOException e) {
					 throw new RuntimeException(e);
				}
		  }
		  else {
				System.out.println("file not found");
		  }
		  return pro;
	 }

	 public static void main(String[] args) {
		  System.out.println("当前jar path is " + PathUtil.getJarPath());
	 }
}
