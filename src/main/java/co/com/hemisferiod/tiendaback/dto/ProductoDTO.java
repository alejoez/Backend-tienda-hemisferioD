package co.com.hemisferiod.tiendaback.dto;

public class ProductoDTO {
	
	private Integer codigoProducto;
	private String nombreProducto;
	private Integer cantidadProducto;
	private CategoriaDTO categoriaDto;
	
	public Integer getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public CategoriaDTO getCategoriaDto() {
		return categoriaDto;
	}
	public void setCategoriaDto(CategoriaDTO categoriaDto) {
		this.categoriaDto = categoriaDto;
	}
}
