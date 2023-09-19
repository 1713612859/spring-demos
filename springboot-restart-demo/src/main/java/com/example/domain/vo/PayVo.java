package com.example.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 支付VO
 *
 * @Desc qqq
 * @Author LiuYunLong
 * @date 2023/09/19 09:46:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayVo {

	 /**
	  * 类型
	  */
	 Long type;


	 /**
	  * 数
	  */
	 Long number;

	 /**
	  * 登录编号
	  */
	 Long loginId;

}
