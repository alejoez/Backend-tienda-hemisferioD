package co.com.hemisferiod.tiendaback.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name = "factura")
public class Factura implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faccodigo")
	private Integer facCodigo;
	
	@Column(name = "fechafactura")
	@NonNull
	private Date fechaFactura;
	
	@NonNull
	@Column(name = "totalcompra")
	private BigInteger totalCompra;
	
	@NonNull
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@NonNull
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@NonNull
	@Column(name = "estado")
	private Integer estado;
	
	@OneToMany(mappedBy="factura")
	private Set<PedidoCliente> pedidoCliente;
	
	public Factura() {
		super();
	}

	public Factura(@NonNull Date fechaFactura, @NonNull BigInteger totalCompra, @NonNull Date fechaCreacion,
			@NonNull Date fechaModificacion, @NonNull Integer estado) {
		this.fechaFactura = fechaFactura;
		this.totalCompra = totalCompra;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Integer getFacCodigo() {
		return facCodigo;
	}

	public void setFacCodigo(Integer facCodigo) {
		this.facCodigo = facCodigo;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
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

	public BigInteger getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigInteger totalCompra) {
		this.totalCompra = totalCompra;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Factura [facCodigo=").append(facCodigo).append(", fechaFactura=").append(fechaFactura)
				.append(", totalCompra=").append(totalCompra).append("]");
		return builder.toString();
	}
}
