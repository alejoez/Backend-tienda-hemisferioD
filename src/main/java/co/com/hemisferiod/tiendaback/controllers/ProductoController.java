package co.com.hemisferiod.tiendaback.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.tiendaback.entities.Producto;
import co.com.hemisferiod.tiendaback.services.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	private IProductoService iProductoService;
	
	public ProductoController(IProductoService iProductoService) {
		this.iProductoService=iProductoService;
	}

	@PostMapping("/crearProducto")
	public String crearProducto(@RequestBody Producto producto) {
		return iProductoService.crearProducto(producto);
	}

	@PutMapping("/editarStockProducto/{proCodigo},{nuevaCantidad}")
	public String editarStockProducto(@PathVariable("proCodigo") Integer proCodigo, 
			@PathVariable("nuevaCantidad") Integer nuevaCantidad) {
		return iProductoService.editarStockDeProductos(proCodigo, nuevaCantidad);
	}
}