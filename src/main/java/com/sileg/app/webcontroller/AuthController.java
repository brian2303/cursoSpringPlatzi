package com.sileg.app.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sileg.app.domain.dto.AuthenticationRequest;
import com.sileg.app.domain.dto.AuthenticationResponse;
import com.sileg.app.domain.service.ProjectUserDetailsService;
import com.sileg.app.webcontroller.security.JWTUtil;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ProjectUserDetailsService projectUserDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest){
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUserName(), 
							authenticationRequest.getPassword())
					);
		 	
			UserDetails userDetails = projectUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
			String jwt = jwtUtil.generateToken(userDetails);
			return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
