package co.com.hemisferiod.tiendaback.entities;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name = "pedidocliente")
public class PedidoCliente implements Serializable{
	
	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codpedcliente")
	private Integer codPedCliente;
	
	@ManyToOne
	@JoinColumn(name = "codcliente")
	private Cliente cliente;
	
	@Column(name = "numeroproductos")
	private Integer numeroProductos;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "faccodigo")
    private Factura factura;
	
	@ManyToMany(mappedBy = "pedidos", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	@NonNull
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@NonNull
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;
	
	@NonNull
	@Column(name = "estado")
	private Integer estado;
	
	public PedidoCliente() {
		super();
	}

	public Integer getCodPedCliente() {
		return codPedCliente;
	}

	public void setCodPedCliente(Integer codPedCliente) {
		this.codPedCliente = codPedCliente;
	}

	public Integer getNumeroProductos() {
		return numeroProductos;
	}

	public void setNumeroProductos(Integer numeroProductos) {
		this.numeroProductos = numeroProductos;
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PedidoCliente [cliente=").append(cliente).append(", factura=").append(factura)
				.append(", productos=").append(productos).append("]");
		return builder.toString();
	}
}

