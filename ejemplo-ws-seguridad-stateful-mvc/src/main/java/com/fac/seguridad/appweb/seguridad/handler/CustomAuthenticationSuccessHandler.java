package com.fac.seguridad.appweb.seguridad.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fac.seguridad.accesoseguridadstateful.dominio.AccesoUserDetails;
import com.fac.seguridad.accesoseguridadstateful.filter.AccesoUsernamePasswordAuthenticationFilter;

/**
 * @author Franco Antonio Chamás. 
 * Clase handler de ejemplo para manejar el logeo
 *         correcto e inyectar en acceso Seguridad.
 *
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.debug("inicioi de handler succes");
		
		HttpSession session = request.getSession();
		UserDetails authUser = (AccesoUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("username", authUser.getUsername());
		session.setAttribute("authorities", authentication.getAuthorities());

		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		// since we have created our custom success handler, its up to us to
		// where
		// we will redirect the user after successfully login
		response.sendRedirect("jsp/home.jsp");
	}

}
