package mx.gob.imss.arquetipo.arquetipo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import mx.gob.imss.arquetipo.arquetipo.dto.LoginRequestDTO;
import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;

@Mapper
public interface LoginMapper {

	LoginMapper INSTANCE = Mappers.getMapper(LoginMapper.class);
	List<LoginRequestDTO> listEntityAJson(List<LoginEntity> loginEntity);
	LoginRequestDTO entityAJson(LoginEntity loginEntity);
	LoginEntity jsonAEntity(LoginRequestDTO requestDTO);
	
}
