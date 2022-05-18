package co.com.hemisferiod.tiendaback.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import co.com.hemisferiod.tiendaback.entities.Cliente;
import co.com.hemisferiod.tiendaback.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	private ClienteRepository clienteRepo;
	
	public ClienteServiceImpl(ClienteRepository clienteRepo) {
		this.clienteRepo=clienteRepo;
	}

	@Override
	@Transactional
	public String crearCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
		cliente.setFechaCreacion(new Date());
		cliente.setFechaModificacion(new Date());
		cliente.setEstado(1);	
		
		return clienteRepo.save(cliente)+" Creado con exito";
	}
}