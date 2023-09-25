package com.example.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @Desc CustomMetaObjectHanlde
 * @Author LiuYunLong
 */

@Configuration
public class CustomMetaObjectHanlder implements MetaObjectHandler {
	 /**
	  * 插入元对象字段填充（用于插入时对公共字段的填充）
	  *
	  * @param metaObject 元对象
	  */
	 @Override
	 public void insertFill(MetaObject metaObject) {
		  this.setFieldValByName("create_time", LocalDateTime.now(), metaObject);
	 }

	 /**
	  * 更新元对象字段填充（用于更新时对公共字段的填充）
	  *
	  * @param metaObject 元对象
	  */
	 @Override
	 public void updateFill(MetaObject metaObject) {
		  this.setFieldValByName("update_time", LocalDateTime.now(), metaObject);
	 }
}
