package co.com.hemisferiod.tiendaback.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.hemisferiod.tiendaback.dto.ProductoDTO;
import co.com.hemisferiod.tiendaback.entities.Producto;
import co.com.hemisferiod.tiendaback.services.IProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	private IProductoService iProductoService;
	
	public ProductoController(IProductoService iProductoService) {
		this.iProductoService=iProductoService;
	}

	@PostMapping("/crearProducto")
	@ApiOperation("Crea nuevos productos")
	public String crearProducto(@RequestBody Producto producto) {
		return iProductoService.crearProducto(producto);
	}

	@PutMapping("/editarStockProducto/{proCodigo},{nuevaCantidad}")
	@ApiOperation("Edita productos")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "No se pudo editar la cantidad") })
	public String editarStockProducto(
			@ApiParam(value = "Este es el id del producto(proCodigo)", required = true, example = "2") @PathVariable("proCodigo") Integer proCodigo,
			@ApiParam(value = "Agrega una nueva cantidad para el producto seleccionado", required = true, example = "10") @PathVariable("nuevaCantidad") Integer nuevaCantidad) {
		return iProductoService.editarStockDeProductos(proCodigo, nuevaCantidad);
	}
	
	@GetMapping("/listarProductos")
	public List<ProductoDTO> listarProductos(){
		return iProductoService.listarProductos();
	}
}