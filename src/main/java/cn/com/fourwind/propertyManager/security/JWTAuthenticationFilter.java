package cn.com.fourwind.propertyManager.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


public class JWTAuthenticationFilter extends GenericFilterBean {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		  Authentication authentication = TokenAuthenticationService
	                .getAuthentication((HttpServletRequest)request);
//		  if(null!=authentication) {
			  SecurityContextHolder.getContext().setAuthentication(authentication);
//		  }else {
//			  HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//			  httpServletResponse.sendRedirect("/login");
//		  }
//		  System.out.println(response.getOutputStream().toString());  
		  filterChain.doFilter(request,response);
	}
}
