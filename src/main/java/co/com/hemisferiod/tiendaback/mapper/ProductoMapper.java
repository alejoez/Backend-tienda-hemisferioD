package co.com.hemisferiod.tiendaback.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.com.hemisferiod.tiendaback.dto.ProductoDTO;
import co.com.hemisferiod.tiendaback.entities.Producto;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ProductoMapper {

	@Mappings({@Mapping(source="proCodigo", target="codigoProducto"),
		@Mapping(source="nombreProducto", target="nombreProducto"),
		@Mapping(source="cantidadProducto", target="cantidadProducto"),
		@Mapping(source="categoria", target="categoriaDto")})
	ProductoDTO toProductoDTO(Optional<Producto> dto);
	
	@InheritInverseConfiguration
	@Mapping(target="fechaVencimiento", ignore=true)
	Producto toProducto(ProductoDTO productoDTO);
	
	List<ProductoDTO> toListProductoDTO(List<Producto> productos);
}
