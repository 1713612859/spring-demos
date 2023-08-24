package utils;

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
					 JWT.create().withClaim("userId", sysUser.getUserId()).withClaim("username", sysUser.getUsername()).withClaim("password", sysUser.getPassword()).withExpiresAt(expireDate).withIssuedAt(new Date()).sign(Algorithm.HMAC256(SECRET));

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
				JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
				jwt = verifier.verify(token);
		  }
		  catch (Exception e) {
				return null;
		  }
		  return jwt.getClaims();
	 }


	 public static SysUser getPayload(String token) {

		  DecodedJWT jwt = null;
		  JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
		  DecodedJWT decodedJWT = jwtVerifier.verify(token);
		  System.out.println(decodedJWT.getPayload());//base64编码的payLoad
		  Claim userIdInt = decodedJWT.getClaim("userId");
		  Claim username = decodedJWT.getClaim("username");
		  Claim password = decodedJWT.getClaim("password");
		  Long userId = userIdInt.asLong();
		  System.out.println("userIdInt:" + userId);
		  System.out.println("userIdString:" + username.asString());
		  System.out.println("userName:" + password.asString());
		  System.out.println("过期时间:" + (decodedJWT.getExpiresAt()).getTime());

		  SysUser sysUser = new SysUser();
		  sysUser.setUserId(userId);
		  sysUser.setUsername(username.asString());

		  return sysUser;

	 }
}
