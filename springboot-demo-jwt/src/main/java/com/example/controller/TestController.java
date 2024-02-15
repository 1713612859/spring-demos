package com.example.controller;

import com.example.domian.SysUser;
import com.example.domian.SysUserHobby;
import com.example.model.AjaxResult;
import com.example.utils.PathUtil;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author LiuYunLong
 */
@RestController
@RequestMapping("/api/test/")
@Slf4j
public class TestController {


	 @Value("${tesseract.location}")
	 private String tesseractLocationPath;

	 @Resource
	 private Tesseract tesseract;


	 /**
	  * 执行OCR识别
	  *
	  * @param multipartFile
	  * @return
	  */
	 @PostMapping("/doOCR")
	 public AjaxResult doOCR(@RequestBody MultipartFile multipartFile) {

		  byte[] bytes;
		  try {
				bytes = multipartFile.getBytes();
				Path path = Paths.get("C:\\tessdata" + File.separator + multipartFile.getOriginalFilename());
				Files.write(path, bytes);

				File convert = convert(multipartFile);
				String result = tesseract.doOCR(convert);

				return AjaxResult.success(result);

		  }
		  catch (IOException | TesseractException e) {
				log.error("do ocr has error {}", e.getMessage());
				e.printStackTrace();
		  }

		  return AjaxResult.error();
	 }

	 @GetMapping("/ok")
	 public String ok() {
		  String jarPath = PathUtil.getJarPath();
		  findExartProperties(jarPath);


		  return "ok !   " + jarPath + " \t";
	 }

	 /**
	  * 找外部文件
	  *
	  * @param jarPath
	  */
	 private Properties findExartProperties(String jarPath) {
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

	 @GetMapping("/sysUser")
	 public SysUser sysUser() {
		  return new SysUser(1L, "张三", "45645456", new Date(), new Date(), new ArrayList<>(new Set<SysUserHobby>() {
				@Override
				public int size() {
					 return 0;
				}

				@Override
				public boolean isEmpty() {
					 return false;
				}

				@Override
				public boolean contains(Object o) {
					 return false;
				}

				@Override
				public Iterator<SysUserHobby> iterator() {
					 return null;
				}

				@Override
				public Object[] toArray() {
					 return new Object[0];
				}

				@Override
				public <T> T[] toArray(T[] a) {
					 return null;
				}

				@Override
				public boolean add(SysUserHobby sysUserHobby) {
					 return false;
				}

				@Override
				public boolean remove(Object o) {
					 return false;
				}

				@Override
				public boolean containsAll(Collection<?> c) {
					 return false;
				}

				@Override
				public boolean addAll(Collection<? extends SysUserHobby> c) {
					 return false;
				}

				@Override
				public boolean retainAll(Collection<?> c) {
					 return false;
				}

				@Override
				public boolean removeAll(Collection<?> c) {
					 return false;
				}

				@Override
				public void clear() {

				}
		  }));
	 }


	 public static File convert(MultipartFile file) throws IOException {
		  File convFile = new File(file.getOriginalFilename());
		  convFile.createNewFile();
		  FileOutputStream fos = new FileOutputStream(convFile);
		  fos.write(file.getBytes());
		  fos.close();
		  return convFile;
	 }


}
