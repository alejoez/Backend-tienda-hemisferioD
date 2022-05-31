package co.com.hemisferiod.tiendaback.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.tiendaback.entities.PedidoCliente;
import co.com.hemisferiod.tiendaback.services.IPedidoClienteService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedidoCliente")
public class PedidoClienteController {
	
	private IPedidoClienteService iPedidoClienteService;
	
	public PedidoClienteController(IPedidoClienteService iPedidoClienteService) {
		this.iPedidoClienteService=iPedidoClienteService;
	}
	
	@PostMapping("/crearPedido")
	@ApiOperation("Crea un pedido")
	public String crearPedido(@RequestBody PedidoCliente pedidoCliente) throws Exception {
		return iPedidoClienteService.realizarPedido(pedidoCliente);
	}
}
