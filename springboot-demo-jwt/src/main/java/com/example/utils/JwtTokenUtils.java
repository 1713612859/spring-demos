package com.example.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.domian.SysUser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-24
 * @DOC 24
 */
public class JwtTokenUtils {
	 // 密钥
	 private static final String SECRET = "jwtSECRET";
	 // 3600 秒
	 private static final long EXPIRATION = 3600L;

	 /**
	  * 创建令牌
	  *
	  * @param sysUser 系统用户
	  * @return {@link String}
	  */
	 public static String createToken(SysUser sysUser) {
		  Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
		  Map<String, Object> map = new HashMap<>();
		  map.put("alg", "HS256");
		  map.put("typ", "JWT");
		  System.out.println(sysUser + "user");
		  String token =
					 // 这里的Claim 其实就是签名，根据签名生成一个token信息
					 // token 又分为三段 中间那段才是用户信息
					 JWT.create().withClaim("userId", sysUser.getUserId())
								.withClaim("username", sysUser.getUsername())
								.withClaim("password", sysUser.getPassword())
								.withExpiresAt(expireDate).withIssuedAt(new Date())
								.sign(Algorithm.HMAC256(SECRET));

		  return token;

	 }


	 /**
	  * 验证令牌
	  *
	  * @param token 令牌
	  * @return {@link Map}<{@link String}, {@link Claim}>
	  */
	 public static Map<String, Claim> verifyToken(String token) {
		  DecodedJWT jwt = null;
		  try {
				// 利用秘钥 验证token
				JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
				jwt = verifier.verify(token);
		  }
		  catch (Exception e) {
				return null;
		  }
		  // 返回签名对象
		  return jwt.getClaims();
	 }


	 /**
	  * 根据token获取SysUser 对象
	  *
	  * @param token 令牌
	  * @return {@link SysUser}
	  */
	 public static SysUser getPayload(String token) {

		  DecodedJWT jwt = null;
		  JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
		  DecodedJWT decodedJWT = jwtVerifier.verify(token);
		  System.out.println(decodedJWT.getPayload());//base64编码的payLoad
		  Map<String, Claim> claims = decodedJWT.getClaims();
		  Long userId = claims.get("userId").asLong();
		  String username = claims.get("username").asString();
		  String password = claims.get("password").asString();
		  long time = decodedJWT.getExpiresAt().getTime();

		  SysUser sysUser = new SysUser();
		  sysUser.setUserId(userId);
		  sysUser.setUsername(username);
		  sysUser.setPassword(password);
		  sysUser.setExpireDate(new Date(time));

		  return sysUser;

	 }
}
