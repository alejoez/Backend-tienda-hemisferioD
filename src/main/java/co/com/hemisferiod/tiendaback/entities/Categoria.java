package co.com.hemisferiod.tiendaback.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.NonNull;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catcodigo")
	private Integer catCodigo;
	
	@NotEmpty
	@Column(name = "nombrecategoria")
	private String nombreCategoria;
	
	@NonNull
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@NonNull
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@NonNull
	@Column(name = "estado")
	private Integer estado;
	
	public Categoria() {
		super();
	}

	public Integer getCatCodigo() {
		return catCodigo;
	}

	public void setCatCodigo(Integer catCodigo) {
		this.catCodigo = catCodigo;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categoria [catCodigo=").append(catCodigo).append("]");
		return builder.toString();
	}
}
