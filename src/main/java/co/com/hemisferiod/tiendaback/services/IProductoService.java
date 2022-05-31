package co.com.hemisferiod.tiendaback.services;

import java.util.List;

import co.com.hemisferiod.tiendaback.dto.ProductoDTO;
import co.com.hemisferiod.tiendaback.entities.Producto;

public interface IProductoService {
	
	public String crearProducto(Producto producto);
	
	public String editarStockDeProductos(Integer proCodigo, Integer cantidad); 
	
	public List<ProductoDTO> listarProductos();
}
