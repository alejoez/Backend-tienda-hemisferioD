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
import javax.validation.constraints.NotEmpty;

import lombok.NonNull;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codusuario")
	private Integer codUsuario;
	
	@NotEmpty
	@Column(name = "nombreusuario")
	private String nombreUsuario;
	
	@NotEmpty
	@Column(name = "apellidosusuario")
	private String apellidosUsuario;

	@NonNull
	@Column(name = "fechanacimiento")
	private Date fechaNacimiento;
	
	//Campos de auditoria
	@NonNull
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@NonNull
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@NonNull
	@Column(name = "estado")
	private Integer estado;
	
	@OneToMany(mappedBy="usuario")
	private Set<UsuarioRol> usuarioRol;
	
	public Usuario() {
		super();
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
		builder.append("Usuario [nombreUsuario=").append(nombreUsuario).append(", apellidosUsuario=")
				.append(apellidosUsuario).append(", fechaNacimiento=").append(fechaNacimiento).append("]");
		return builder.toString();
	}
}
