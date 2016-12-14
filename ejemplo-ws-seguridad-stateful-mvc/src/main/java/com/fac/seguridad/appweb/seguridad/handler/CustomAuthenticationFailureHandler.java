package com.fac.seguridad.appweb.seguridad.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		logger.debug("Inicio de autenticación fallida");
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		// since we have created our custom success handler, its up to us to
		// where
		// we will redirect the user after successfully login
		response.sendRedirect("jsp/login.jsp");
	}

}
