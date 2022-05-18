package co.com.hemisferiod.tiendaback.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import co.com.hemisferiod.tiendaback.entities.UsuarioRol;
import co.com.hemisferiod.tiendaback.repositories.UsuarioRolRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private UsuarioRolRepository usuarioRolRepo;
	
	public UsuarioServiceImpl(UsuarioRolRepository usuarioRolRepo) {
		this.usuarioRolRepo = usuarioRolRepo;
	}

	@Override
	@Transactional
	public String registrarUsuario(UsuarioRol usuRol) {
		// TODO Auto-generated method stub
		
		usuRol.getUsuario().setFechaCreacion(new Date());
		usuRol.getUsuario().setFechaModificacion(new Date());
		usuRol.getUsuario().setEstado(1);

		usuRol.setFechaCreacion(new Date());
		usuRol.setFechaModificacion(new Date());
		usuRol.setEstado(1);
		
		return usuarioRolRepo.save(usuRol)
				+ " Creado con exito";
	}
}
