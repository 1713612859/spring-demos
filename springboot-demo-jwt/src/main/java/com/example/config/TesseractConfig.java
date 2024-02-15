package com.example.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ocr
 * @Desc TesseractConfig
 * @Author LiuYunLong
 */
@Component
public class TesseractConfig {


	 /**
	  * tesseract 位置路径
	  */
	 @Value("${tesseract.location}")
	 private String tesseractLocationPath;


	 @Bean
	 public Tesseract tesseract(){
		  Tesseract tesseract = new Tesseract();
		  // set dataPath prefix ,Then set language is default config file.
		  tesseract.setDatapath("C:\\tessdata");
		  tesseract.setLanguage("chi_sim");
		  return tesseract;
	 }


}
