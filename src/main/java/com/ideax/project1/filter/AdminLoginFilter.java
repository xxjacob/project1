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

import com.ideax.project1.pojo.Admin;

public class AdminLoginFilter implements Filter {

    // local store session
    Map<String, Admin> localSessions = new HashMap<String, Admin>();

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cs = req.getCookies();
        if (cs != null && cs.length > 0) {
            for (Cookie c : cs) {
                if ("sessionid".equals(c.getName())) {
                    String sessionid = c.getValue();
                    Admin user = localSessions.get(sessionid);
                    if (user == null) {
                        ((HttpServletResponse) response).sendRedirect("/asdf");
                        return;
                    }
                    request.setAttribute("sessionid", sessionid);
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
