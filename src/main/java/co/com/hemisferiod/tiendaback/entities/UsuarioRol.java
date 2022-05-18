package co.com.hemisferiod.tiendaback.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name = "usuariorol")
public class UsuarioRol implements Serializable{
	
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusurol")
	private Integer idUsuRol;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codusuario")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "codrol")
    private Rol rol;
	
	@NonNull
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@NonNull
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@NonNull
	@Column(name = "estado")
	private Integer estado;
	
	public UsuarioRol() {
		super();
	}

	public Integer getIdUsuRol() {
		return idUsuRol;
	}

	public void setIdUsuRol(Integer idUsuRol) {
		this.idUsuRol = idUsuRol;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioRol [usuario=").append(usuario).append(", rol=").append(rol).append("]");
		return builder.toString();
	}
}
