package co.com.hemisferiod.tiendaback.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hemisferiod.tiendaback.entities.Factura;
import co.com.hemisferiod.tiendaback.entities.PedidoCliente;
import co.com.hemisferiod.tiendaback.entities.Producto;
import co.com.hemisferiod.tiendaback.repositories.PedidoClienteRepository;
import co.com.hemisferiod.tiendaback.repositories.ProductoRepository;

@Service
public class PedidoClienteServiceImpl implements IPedidoClienteService {

	@Autowired
	private PedidoClienteRepository pedidoClienteRepo;

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional
	public String realizarPedido(PedidoCliente pedidoCliente) throws Exception{
		// TODO Auto-generated method stub

		try {
			
			int nuevaCantidadProducto; 
			int totalCompra=0;
			int totalProductos=0;
			
			for (int i = 0; i < pedidoCliente.getProductos().size(); i++) {

				Optional<Producto> producto2 = productoRepository
						.findById(pedidoCliente.getProductos().get(i).getProCodigo());

				nuevaCantidadProducto = producto2.get().getCantidadProducto()
						- pedidoCliente.getProductos().get(i).getCantidadProducto();
				
				totalCompra = (pedidoCliente.getProductos().get(i).getCantidadProducto()*(producto2.get().getPrecioProducto()).intValue()) + totalCompra;

				if (nuevaCantidadProducto < 0) {
					throw new Exception(
							"La cantidad a registrar no puede superar a la que hay en el stock del producto: "
									+ producto2.get().getNombreProducto());
				}

				producto2.get().setCantidadProducto(nuevaCantidadProducto);
				producto2.get().setFechaModificacion(new Date());
				
				totalProductos=pedidoCliente.getProductos().get(i).getCantidadProducto()+totalProductos;
				
				//Se actualiza la cantidad del producto
				productoRepository.save(producto2.get());
			}
			
			pedidoCliente.setFactura(new Factura(new Date(), BigInteger.valueOf(totalCompra), new Date(), new Date(), 1));
			
			pedidoCliente.setNumeroProductos(totalProductos);
			pedidoCliente.setFechaCreacion(new Date());
			pedidoCliente.setFechaModificacion(new Date());
			pedidoCliente.setEstado(1);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}

		return pedidoClienteRepo.save(pedidoCliente)+" Pedido generado exitosamente!";
	}

}
