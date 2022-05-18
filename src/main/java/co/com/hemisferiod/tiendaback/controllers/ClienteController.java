package co.com.hemisferiod.tiendaback.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.tiendaback.entities.Cliente;
import co.com.hemisferiod.tiendaback.services.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private IClienteService iClienteService;
	
	public ClienteController(IClienteService iClienteService) {
		this.iClienteService = iClienteService;
	}
	
	@PostMapping("/registrarCliente")
	public String registrarCliente(@RequestBody Cliente cliente) {
		return iClienteService.crearCliente(cliente);
	}
}
