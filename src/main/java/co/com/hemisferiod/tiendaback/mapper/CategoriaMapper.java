package co.com.hemisferiod.tiendaback.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.com.hemisferiod.tiendaback.dto.CategoriaDTO;
import co.com.hemisferiod.tiendaback.entities.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
	
	@Mappings({@Mapping(source="catCodigo", target="codigoCategoria"),
		@Mapping(source="nombreCategoria", target="categoriaNombre"),
		@Mapping(source="estado", target="estado")})
	CategoriaDTO toCategoriaDTO(Categoria categoria);
	
	@InheritInverseConfiguration
	@Mapping(target="fechaCreacion", ignore=true)
	Categoria toCategoria(CategoriaDTO categoriaDTO);
	
	List<CategoriaDTO> toListCategoriaDTO(List<Categoria> categorias);

}
