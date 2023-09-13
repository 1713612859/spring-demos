package com.example.config;

import com.example.utils.PathUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Properties;

/**
 * properties 配置文件
 *
 * @author LiuYunLong
 * @date 2023/09/11 10:34:31
 */
@Slf4j
public class ZhlkConfig {

	 private static Properties zhlk = new Properties();

	 /**
	  * 配置文件名称
	  * TODO: 一定要保持一致
	  */
	 private final static String configFileName = "zhlk.properties";


	 static {
		  loadProperties(zhlk, configFileName);
	 }


	 /**
	  * 加载 properties
	  *
	  * @param zhlk
	  * @param configName TODO: 首先加载外部jar包 同级的外部配置文件，如果不存在则加载classpath 下的内部配置文件
	  */
	 private static void loadProperties(Properties zhlk, String configName) {
		  File propertiesFile = new File(PathUtil.getJarPath() + "\\" + configName);
		  // if 存在
		  if (propertiesFile.exists()) {
				log.info("load outside config file : {}", propertiesFile.getAbsolutePath());
		  }
	 }

	 public static void main(String[] args) {
		  System.out.println("222222");
	 }


}
