package co.com.hemisferiod.tiendaback.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hemisferiod.tiendaback.dto.ProductoDTO;
import co.com.hemisferiod.tiendaback.entities.Producto;
import co.com.hemisferiod.tiendaback.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoRepository productoRepo;
	
//	@Autowired
//	ProductoMapper mapper;
	
	@Override
	@Transactional
	public String crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		
		producto.setFechaCreacion(new Date());
		producto.setFechaModificacion(new Date());
		producto.setEstado(1);
		
		return productoRepo.save(producto)+" creado con exito!";
	}

	@Override
	@Transactional
	public String editarStockDeProductos(Integer proCodigo, Integer cantidad){
		// TODO Auto-generated method stub
		
		Producto producto = productoRepo.findById(proCodigo).get();
		
		producto.setProCodigo(proCodigo);
		producto.setCantidadProducto(cantidad);
		producto.setFechaModificacion(new Date());
		
		return productoRepo.save(producto)+" actualizado exitosamente!";
	}

	@Override
	public List<ProductoDTO> listarProductos() {
		// TODO Auto-generated method stub
		return null;
//		List<Producto> productos =  (List<Producto>) productoRepo.findAll();
//		return mapper.toListProductoDTO(productos);
	}
	
}
