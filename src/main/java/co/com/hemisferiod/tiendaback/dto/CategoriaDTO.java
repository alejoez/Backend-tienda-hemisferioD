package co.com.hemisferiod.tiendaback.dto;

public class CategoriaDTO {
	
	private Integer codigoCategoria;
	private String categoriaNombre;
	private Integer estadoCategoria;
	
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getCategoriaNombre() {
		return categoriaNombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
	public Integer getEstadoCategoria() {
		return estadoCategoria;
	}
	public void setEstadoCategoria(Integer estadoCategoria) {
		this.estadoCategoria = estadoCategoria;
	}
}
