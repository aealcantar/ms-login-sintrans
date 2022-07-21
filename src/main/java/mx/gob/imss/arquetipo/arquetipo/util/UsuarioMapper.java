package mx.gob.imss.arquetipo.arquetipo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import mx.gob.imss.arquetipo.arquetipo.dto.LoginRequestDTO;
import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;

@Mapper
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
 
	LoginEntity jsonAEntity(LoginRequestDTO usuarioDto);
	
}
