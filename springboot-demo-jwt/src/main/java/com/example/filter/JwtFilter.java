package com.example.filter;

import com.auth0.jwt.interfaces.Claim;
import org.springframework.http.HttpMethod;
import utils.JwtTokenUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * jwt过滤器
 *
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-24
 * @DOC jwt过滤器
 * @date 2023/08/24 11:31:23
 */
// /api/user/secure/* URL 请求路径起作用
@WebFilter(filterName = "JwtFilter", urlPatterns = "/api/user/secure/*")
/**
 * @WebFilter WEB过滤器，urlPatterns 就是拦截当前应用路径下的 /api/user/secure/*
 * 如果请求头没有token 返回 no token
 * 有token 构建用户对象返回回去即可 我们通过解密构建用户对象
 */
public class JwtFilter implements Filter {
	 @Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
		  final HttpServletRequest request = (HttpServletRequest) req;
		  final HttpServletResponse response = (HttpServletResponse) res;

		  response.setCharacterEncoding("UTF-8");

		  final String token = request.getHeader("Auth");
		  // 是否是 OPTIONS 请求
		  if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
				response.setStatus(HttpServletResponse.SC_OK);
				filterChain.doFilter(request, response);
		  }
		  else {
				if (token == null) {
					 response.getWriter().write("no token");
					 return;
				}
				// 检验 token
				Map<String, Claim> userData = JwtTokenUtils.verifyToken(token);
				if (userData == null) {
					 response.getWriter().write("token illegal");
					 return;
				}
//				Long userId = userData.get("userId").asLong(); // 获取 id
//				String username = userData.get("username").asString(); // 获取用户名
//				String password = userData.get("password").asString(); // 获取密码
//				request.setAttribute("id", userId); // 设置 id
//				request.setAttribute("username", username); // 设置用户名
//				request.setAttribute("password", password); // 设置密码

				filterChain.doFilter(req, res); // 过滤成功
		  }

	 }
}
