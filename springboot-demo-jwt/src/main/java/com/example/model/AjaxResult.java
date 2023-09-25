package com.example.model;


import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author zhlk
 */
public class AjaxResult extends HashMap<String, Object> {
	 private static final long serialVersionUID = 1L;

	 /**
	  * 状态码
	  */
	 public static final String CODE_TAG = "code";

	 /**
	  * 返回内容
	  */
	 public static final String MSG_TAG = "msg";

	 /**
	  * 数据对象
	  */
	 public static final String DATA_TAG = "data";

// --Commented out by Inspection START (2023-09-22 17:31):
//	 /**
// --Commented out by Inspection START (2023-09-22 17:31):
////	  * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
////	  */
////	 public AjaxResult() {
////	 }
//// --Commented out by Inspection STOP (2023-09-22 17:31)
//
//	 /**
//	  * 初始化一个新创建的 AjaxResult 对象
//	  *
//	  * @param code 状态码
//	  * @param msg  返回内容
// --Commented out by Inspection STOP (2023-09-22 17:31)
	  */
	 public AjaxResult(int code, String msg) {
		  super.put(CODE_TAG, code);
		  super.put(MSG_TAG, msg);
	 }

	 /**
	  * 初始化一个新创建的 AjaxResult 对象
	  *
// --Commented out by Inspection START (2023-09-22 17:31):
//	  * @param code 状态码
//	  * @param msg  返回内容
//	  * @param data 数据对象
//	  */
//	 public AjaxResult(int code, String msg, Object data) {
//		  super.put(CODE_TAG, code);
// --Commented out by Inspection STOP (2023-09-22 17:31)
		  super.put(MSG_TAG, msg);
		  if (!StringUtils.isEmpty(data)) {
				super.put(DATA_TAG, data);
		  }
	 }

	 /**
	  * 返回成功消息
	  *
	  * @return 成功消息
	  */
	 public static AjaxResult success() {
		  return AjaxResult.success("操作成功");
	 }

	 /**
	  * 返回成功数据
	  *
	  * @return 成功消息
	  */
	 public static AjaxResult success(Object data) {
		  return AjaxResult.success("操作成功", data);
	 }

	 /**
	  * 返回成功消息
	  *
	  * @param msg 返回内容
	  * @return 成功消息
	  */
	 public static AjaxResult success(String msg) {
// --Commented out by Inspection START (2023-09-22 17:31):
//		  return AjaxResult.success(msg, null);
//	 }
//
//	 /**
//	  * 返回成功消息
//	  *
//	  * @param msg  返回内容
//	  * @param data 数据对象
//	  * @return 成功消息
// --Commented out by Inspection STOP (2023-09-22 17:31)
	  */
	 public static AjaxResult success(String msg, Object data) {
		  return new AjaxResult(HttpStatus.OK.value(), msg, data);
	 }

	 /**
	  * 返回错误消息
	  *
	  * @return
	  */
	 public static AjaxResult error() {
		  return AjaxResult.error("操作失败");
	 }

// --Commented out by Inspection START (2023-09-22 17:31):
//	 /**
//	  * 返回错误消息
//	  *
//	  * @param msg 返回内容
//	  * @return 警告消息
//	  */
//	 public static AjaxResult error(String msg) {
//		  return AjaxResult.error(msg, null);
//	 }
//
//	 /**
//	  * 返回错误消息
//	  *
//	  * @param msg  返回内容
// --Commented out by Inspection STOP (2023-09-22 17:31)
	  * @param data 数据对象
	  * @return 警告消息
	  */
	 public static AjaxResult error(String msg, Object data) {
		  return new AjaxResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
	 }

	 /**
	  * 返回错误消息
	  *
	  * @param code 状态码
	  * @param msg  返回内容
	  * @return 警告消息
	  */
	 public static AjaxResult error(int code, String msg) {
		  return new AjaxResult(code, msg, null);
	 }
}
