package com.example.strategy;

import com.example.domain.vo.PayVo;

/**
 * @Desc PayFactory
 * @Author LiuYunLong
 */
public interface PayFactory {

	 void pay(PayVo payVo);
}
