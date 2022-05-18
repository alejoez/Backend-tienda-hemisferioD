package co.com.hemisferiod.tiendaback.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.tiendaback.entities.UsuarioRol;
import co.com.hemisferiod.tiendaback.services.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private IUsuarioService iUsuarioService;
	
	public UsuarioController(IUsuarioService iUsuarioService) {
		this.iUsuarioService=iUsuarioService;
	}
	
	@PostMapping("/registrarNuevoUsuario")
	public String registrarNuevoUsuario(@RequestBody UsuarioRol usuarioRol) {
		return iUsuarioService.registrarUsuario(usuarioRol);
	}
}
