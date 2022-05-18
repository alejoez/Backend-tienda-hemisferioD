package co.com.hemisferiod.tiendaback.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "procodigo")
	private Integer proCodigo;
	
	@Column(name = "nombreproducto")
	private String nombreProducto;
	
	@Column(name = "fechavencimiento")
	private Date fechaVencimiento;
	
	@NonNull
	@Column(name = "cantidadproducto")
	private Integer cantidadProducto;
	
	@Column(name = "precioproducto")
	private BigInteger precioProducto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catcodigo")
	private Categoria categoria;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@NonNull
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@Column(name = "estado")
	private Integer estado;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoCliente> pedidos;
	
	public Producto() {
		super();
	}

	public Integer getProCodigo() {
		return proCodigo;
	}

	public void setProCodigo(Integer proCodigo) {
		this.proCodigo = proCodigo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public BigInteger getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(BigInteger precioProducto) {
		this.precioProducto = precioProducto;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [proCodigo=").append(proCodigo).append(", nombreProducto=").append(nombreProducto)
				.append(", fechaVencimiento=").append(fechaVencimiento).append(", cantidadProducto=")
				.append(cantidadProducto).append(", precioProducto=").append(precioProducto).append(", categoria=")
				.append(categoria).append("]");
		return builder.toString();
	}
}
