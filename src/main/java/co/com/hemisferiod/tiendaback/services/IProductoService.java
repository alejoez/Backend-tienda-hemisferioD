package co.com.hemisferiod.tiendaback.services;

import co.com.hemisferiod.tiendaback.entities.Producto;

public interface IProductoService {
	
	public String crearProducto(Producto producto);
	
	public String editarStockDeProductos(Integer proCodigo, Integer cantidad); 
}
