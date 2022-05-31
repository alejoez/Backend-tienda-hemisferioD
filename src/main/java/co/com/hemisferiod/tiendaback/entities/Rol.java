package co.com.hemisferiod.tiendaback.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codrol")
	private Integer codRol;
	
	@Column(name = "nombrerol")
	private String nombreRol;
	
	//Campos de auditoria
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@Column(name = "estado")
	private Integer estado;
	
	@OneToMany(mappedBy="rol")
	private Set<UsuarioRol> usuarioRol;
	
	public Rol() {
		super();
	}

	public Integer getCodRol() {
		return codRol;
	}

	public void setCodRol(Integer codRol) {
		this.codRol = codRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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
		builder.append("Rol [codRol=").append(codRol).append(", nombreRol=").append(nombreRol).append("]");
		return builder.toString();
	}
}
