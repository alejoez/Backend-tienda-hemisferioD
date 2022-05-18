package co.com.hemisferiod.tiendaback.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import co.com.hemisferiod.tiendaback.entities.Producto;
import co.com.hemisferiod.tiendaback.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	private ProductoRepository productoRepo;
	
	public ProductoServiceImpl(ProductoRepository productoRepo) {
		this.productoRepo = productoRepo;
	}

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

}
