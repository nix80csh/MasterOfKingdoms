package com.mok.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import com.mok.dao.AccountDao;
import com.mok.entity.Account;
import com.mok.service.AccountService;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	@Autowired
	private AccountDao accountDao;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);

		String authToken = this.extractAuthTokenFromRequest(httpRequest);
		String userId = TokenUtils.getUserIdFromToken(authToken);
		// System.out.println("userId : " + userId + " // token :" + authToken);

		if (userId != null) {
			System.out.println("AuthenticationTokenProcessingFilter");
			Account account = this.accountDao.readByUserId(userId);
			if (account != null) {

				System.out.println("UserId: " + account.getUserId());
				System.out.println("Udid:" + account.getUdid());

				if (TokenUtils.validateToken(authToken, account)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							account.getUserId(), account.getUdid());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		// 테스트주석
		// 이상하다 주석2

		chain.doFilter(request, response);
	}

	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP request");
		}

		return (HttpServletRequest) request;
	}

	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
		String authToken = httpRequest.getHeader("X-Auth-Token");

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}
}
