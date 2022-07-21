package mx.gob.imss.arquetipo.arquetipo.service;

import mx.gob.imss.arquetipo.arquetipo.dto.Response;

import java.util.List;

import mx.gob.imss.arquetipo.arquetipo.dto.DatosMenu;
import mx.gob.imss.arquetipo.arquetipo.dto.LoginRequestDTO;
import mx.gob.imss.arquetipo.arquetipo.dto.usuarioDto;
import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity;

public interface LoginService {

	 
	LoginEntity getUsuario(String usuario) throws Exception;
	String actulizarNoDeIntentos(Integer idUsuario)throws Exception;
	String resetearNoDeIntentos(Integer idUsuario)  throws Exception;
	String cambiarPassword(String password, Integer idUsuario) throws Exception;
	List<menuEntity> getMenu(Integer idRol) throws Exception;
	DatosMenu getDatosSubmenu(List<menuEntity> menu,String validacion) throws Exception;
}
