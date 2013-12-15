package com.ideax.project1.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.ideax.project1.pojo.Admin;

public class AdminLoginFilter implements Filter {

	// local store session
	public static Map<String, Admin> loginAdmins = new HashMap<String, Admin>();

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public static void login(Admin admin, HttpServletResponse response, boolean remember) {
		String sessionid = RandomStringUtils.random(32, true, true);
		loginAdmins.put(sessionid, admin);
		Cookie cookie = new Cookie("sessionid", sessionid);
		cookie.setPath("/asdf");
		if (remember)
			cookie.setMaxAge(3600 * 30);
		response.addCookie(cookie);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		// 根路径是用户第一次访问的路径
		if (path.equals("/asdf") || "/asdf/dologin".equals(path)) {
			chain.doFilter(request, response);
			return;
		}
		Cookie[] cs = req.getCookies();
		if (cs != null && cs.length > 0) {
			for (Cookie c : cs) {
				if ("sessionid".equals(c.getName())) {
					String sessionid = c.getValue();
					Admin user = loginAdmins.get(sessionid);
					if (user == null) {
						((HttpServletResponse) response).sendRedirect("/asdf");
						return;
					}
					request.setAttribute("sessioninfo", user);
					chain.doFilter(request, response);
					return;
				}
			}
		}
		((HttpServletResponse) response).sendRedirect("/asdf");
		return;
	}

	public void destroy() {
	}

}
