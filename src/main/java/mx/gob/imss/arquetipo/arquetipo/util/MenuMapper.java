package mx.gob.imss.arquetipo.arquetipo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers; 
import mx.gob.imss.arquetipo.arquetipo.dto.MenuRequestDTO;
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity; 

@Mapper
public interface MenuMapper {

	MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);
	List<MenuRequestDTO> listEntityAJson(List<menuEntity> menuEntity);
	MenuRequestDTO entityAJson(menuEntity menuEntity);
	 
	
}
