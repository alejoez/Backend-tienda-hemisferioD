package co.com.hemisferiod.tiendaback.services;

import co.com.hemisferiod.tiendaback.entities.PedidoCliente;

public interface IPedidoClienteService {
	
	public String realizarPedido(PedidoCliente pedidoCliente) throws Exception;
}
