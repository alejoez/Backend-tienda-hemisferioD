package co.com.hemisferiod.tiendaback.controllers;

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

import co.com.hemisferiod.tiendaback.dto.AuthenticationRequest;
import co.com.hemisferiod.tiendaback.dto.AuthenticationResponse;
import co.com.hemisferiod.tiendaback.security.JWTUtil;
import co.com.hemisferiod.tiendaback.services.DetallesUsuarioSeguridadService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private DetallesUsuarioSeguridadService detalleUsuario;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> crearToken(@RequestBody AuthenticationRequest request) {
		try {

			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasena()));

			UserDetails userDetails = detalleUsuario.loadUserByUsername(request.getUsuario());

			String jwt = jwtUtil.generateToken(userDetails);
			
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
			
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}
}
