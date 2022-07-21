package mx.gob.imss.arquetipo.arquetipo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.jfree.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.arquetipo.arquetipo.dto.DatosMenu;
import mx.gob.imss.arquetipo.arquetipo.dto.Response;
import mx.gob.imss.arquetipo.arquetipo.dto.ResponseActualizaUsuario;
import mx.gob.imss.arquetipo.arquetipo.dto.datosGeneralesUsuario;
import mx.gob.imss.arquetipo.arquetipo.dto.datosLoginCorrecto;
import mx.gob.imss.arquetipo.arquetipo.dto.usuarioDto;
import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity;
import mx.gob.imss.arquetipo.arquetipo.security.jwt.JwtProvider;
import mx.gob.imss.arquetipo.arquetipo.service.impl.LoginServiceImpl;

@AllArgsConstructor
@Slf4j
@RestController

@RequestMapping("api")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class LoginController {

	@Autowired
	LoginServiceImpl serviceImpl;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping(path = "/login")
	public <T> Response login(@RequestBody usuarioDto datos) {

		String usuario = datos.getUsuario();
		String pasword = datos.getPassword();
		Response resp = new Response();
		LoginEntity response = null;
		List<menuEntity> menu = null;
		try {
			response = serviceImpl.getUsuario(usuario);
			if (response == null) {

				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje("usuario-pasword");
				resp.setData(null);
				return resp;
			} else {

				// aqui hacer update para actualizar numero de intentos
				Integer idUsuario = response.getID_USUARIO();
				String validaUpdate = serviceImpl.actulizarNoDeIntentos(idUsuario);
			 

			}
			String passB = response.getCVE_PASSWORD();
 
			// los intentos son menor de 3 y la fecha caduca es mayo de 0
			if (response.getNUM_INTENTOS() < 3 && response.getFECHA_CADUDA()>0) {

				// los intentos son menor de 3
				if (pasword.equals(passB)) {
					// password es el mismo que ingreso el usuaerio
					String token = jwtProvider.generateToken(response);
					datosGeneralesUsuario datosUsuario = new datosGeneralesUsuario();
					datosUsuario.setMatricula(response.getCVE_MATRICULA());
					String nombre = response.getNOM_USUARIO() == null ? "" : response.getNOM_USUARIO();
					String appPaterno = response.getNOM_APELLIDO_PATERNO() == null ? ""
							: response.getNOM_APELLIDO_PATERNO();
					String appMaterno = response.getNOM_APELLIDO_MATERNO() == null ? ""
							: response.getNOM_APELLIDO_MATERNO();

					String nombreUsuario = nombre + " " + appPaterno + " " + appMaterno;
					datosUsuario.setNombreUsuario(nombreUsuario);
					datosUsuario.setMatricula(response.getCVE_MATRICULA());
					datosUsuario.setRol(response.getDES_ROL());
					datosLoginCorrecto datosLogin = new datosLoginCorrecto();
					datosLogin.setDatosUsuario(datosUsuario);
					datosLogin.setToken(token);

					Integer idRol = response.getID_ROLES_USUARIO();
					menu = serviceImpl.getMenu(idRol);
					List<DatosMenu> lisDatosMenu = new ArrayList<DatosMenu>();

					DatosMenu datosMenu = new DatosMenu();
					datosMenu = serviceImpl.getDatosSubmenu(menu, "Inicio");
					lisDatosMenu.add(datosMenu);
					datosMenu = serviceImpl.getDatosSubmenu(menu, "Administración");
					lisDatosMenu.add(datosMenu);
					datosMenu = serviceImpl.getDatosSubmenu(menu, "Captura");
					lisDatosMenu.add(datosMenu);
					datosMenu = serviceImpl.getDatosSubmenu(menu, "Rutas y asignaciones");
					lisDatosMenu.add(datosMenu);
					datosMenu = serviceImpl.getDatosSubmenu(menu, "Reportes y formatos");
					lisDatosMenu.add(datosMenu);
					datosMenu = serviceImpl.getDatosSubmenu(menu, "Centracom");
					lisDatosMenu.add(datosMenu);

					datosLogin.setMenu(lisDatosMenu);

					// aqui hacer update para recetear el numero de intentos
					Integer idUsuario = response.getID_USUARIO();
					String validaUpdate = serviceImpl.resetearNoDeIntentos(idUsuario);

					resp.setCodigo(HttpStatus.OK.value());
					resp.setError(false);
					resp.setMensaje("Exito");
					resp.setData(datosLogin);

					return resp;

				} else {
					// usuario pasword incorrecto
					resp.setCodigo(HttpStatus.OK.value());
					resp.setError(false);
					resp.setMensaje("usuario-pasword");
					resp.setData(null);
					return resp;
				}

			} else {

				// usuario bloqueado
				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje("bloqueado");
				resp.setData(null);
				return resp;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.setCodigo(HttpStatus.NOT_FOUND.value());
			resp.setError(true);
			resp.setMensaje(e.getMessage());
			return resp;
		}

	}

	@GetMapping(path = "/")
	public <T> ResponseActualizaUsuario validarMatricula(@RequestBody usuarioDto datos) {

		String usuario = datos.getUsuario();
		ResponseActualizaUsuario resp = new ResponseActualizaUsuario();
		LoginEntity response = null;
		try {
			response = serviceImpl.getUsuario(usuario);
			if (response == null) {

				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje("usuarioInvalido");
				resp.setIdUsuario(null);
				return resp;
			} else {

				String token = jwtProvider.generateToken(response);
				datosGeneralesUsuario datosUsuario = new datosGeneralesUsuario();
				datosUsuario.setMatricula(response.getCVE_MATRICULA());
				 
			 

				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje("Exito");
				resp.setIdUsuario(response.getID_USUARIO());
				return resp;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.setCodigo(HttpStatus.NOT_FOUND.value());
			resp.setError(true);
			resp.setMensaje(e.getMessage());
			return resp;
		}

	}

	@PostMapping(path = "/cambiarPassword")
	public <T> Response cambiarPassword(@RequestBody usuarioDto datos) {
		Response resp = new Response();

		String datosUsuario= (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		
		JSONArray arrayDatosUsuario = new JSONArray(datosUsuario);  
		arrayDatosUsuario.get(0);
				System.out.println("que apso"+arrayDatosUsuario.get(0));
				JSONObject json =  (JSONObject) arrayDatosUsuario.get(0);  
				String matricula= ""+json.get("matricula");
				String idUnidadAdscripcion= ""+json.get("idUnidadAdscripcion");
				String rol= ""+json.get("rol");
				 
		String verificarPassword = datos.getVerificarPassword();
		String password = datos.getPassword();

		LoginEntity response = null;
		try {

			Integer idUsuario = 1;

			if (password.equals(verificarPassword)) {
				String resCambioPassword = serviceImpl.cambiarPassword(password, idUsuario);
				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje(resCambioPassword);
				resp.setData(null);
				return resp;
			} else {

				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje("password_no_coincide");
				resp.setData(null);
				return resp;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.setCodigo(HttpStatus.NOT_FOUND.value());
			resp.setError(true);
			resp.setMensaje(e.getMessage());
			return resp;
		}

	}
	
	
	@PutMapping(path = "/")
	public <T> Response cambiarContrasenia(@RequestBody usuarioDto datos) {
		Response resp = new Response();

	 
		String verificarPassword = datos.getVerificarPassword();
		String password = datos.getPassword();
		Integer idUsuario = datos.getIdUsuario();

		LoginEntity response = null;
		try {

			

			if (password.equals(verificarPassword)) {
				String resCambioPassword = serviceImpl.cambiarPassword(password, idUsuario);
				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje(resCambioPassword);
				resp.setData(null);
				return resp;
			} else {

				resp.setCodigo(HttpStatus.OK.value());
				resp.setError(false);
				resp.setMensaje("password_no_coincide");
				resp.setData(null);
				return resp;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.setCodigo(HttpStatus.NOT_FOUND.value());
			resp.setError(true);
			resp.setMensaje(e.getMessage());
			return resp;
		}

	}

}
