package co.com.hemisferiod.tiendaback.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.tiendaback.entities.UsuarioRol;
import co.com.hemisferiod.tiendaback.services.IUsuarioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private IUsuarioService iUsuarioService;
	
	public UsuarioController(IUsuarioService iUsuarioService) {
		this.iUsuarioService=iUsuarioService;
	}
	
	@PostMapping("/registrarNuevoUsuario")
	@ApiOperation("Registra nuevos usuarios")
	public String registrarNuevoUsuario(@RequestBody UsuarioRol usuarioRol) {
		return iUsuarioService.registrarUsuario(usuarioRol);
	}
}
