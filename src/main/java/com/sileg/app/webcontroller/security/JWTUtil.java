package com.sileg.app.webcontroller.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Clase que se encargad e generar el JWT
 */
@Component
public class JWTUtil {
	
	private static final String KEY = "pl4tz1";
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256,KEY).compact();
	}
	
	/*
	 * Para poder verificar que un JWT es valido lo primero es 
	 * validar que este creado para el usuario que esta haciendo la peticion
	 * y que no haya vencido
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		return userDetails.getUsername().equals(extractUserName(token)) && !isTokenExpired(token);
	}
	
	public String extractUserName(String token) {
		// Para este ejemplo en el subject esta el name del usuario que envio la peticion
		return getClaims(token).getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		//Si esta antes de la fecha actual va retornar true (Aun es valido)
		return getClaims(token).getExpiration().before(new Date());
	}
	
	private Claims getClaims(String token) {
		//Tenemos el parser le pasamos la KEY  y luego si es valido pdimos el body del JWT
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}
	
}
