package com.sileg.app.webcontroller.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sileg.app.domain.service.ProjectUserDetailsService;
import com.sileg.app.webcontroller.security.JWTUtil;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jWTUtil;
	
	@Autowired
	private ProjectUserDetailsService projectUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//Verificamos que lo que venga en el encabezado de la peticion es un token. Y si es correcto
		String authorizationHeader = request.getHeader("Authorization");
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			//Quitamos del JWT el prefijo Bearer dejando solo el JWT
			String jwt = authorizationHeader.substring(7);
			String userName = jWTUtil.extractUserName(jwt);
			//Validamos que aun no exista una autenticacion previa para el usuario
			if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = projectUserDetailsService.loadUserByUsername(userName);
				
				if(jWTUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		
		filterChain.doFilter(request, response);
		
	}
	
}
