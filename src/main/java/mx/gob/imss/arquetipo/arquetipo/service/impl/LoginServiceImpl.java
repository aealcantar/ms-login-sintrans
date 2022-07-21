package mx.gob.imss.arquetipo.arquetipo.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.imss.arquetipo.arquetipo.dto.Response;
import mx.gob.imss.arquetipo.arquetipo.dto.DatosMenu;
import mx.gob.imss.arquetipo.arquetipo.dto.DatosSubMenu;
import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity;
import mx.gob.imss.arquetipo.arquetipo.repository.LoginRepository;
import mx.gob.imss.arquetipo.arquetipo.repository.MenuRepository;
import mx.gob.imss.arquetipo.arquetipo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepo;

	@Autowired
	private MenuRepository menuRepo;

	@Override
	public LoginEntity getUsuario(String usuario) throws Exception {
		Response response = new Response();
		LoginEntity entity = null; 
		try {
			entity = loginRepo.getUsuario(usuario);

		} catch (Exception e) {
			Log.error(e);
			return entity;
		}

		return entity;
	}

	@Override
	@Transactional(rollbackOn = SQLException.class)
	public String actulizarNoDeIntentos(Integer idUsuario) {
		try {
			loginRepo.actulizaNumeroIntentos(idUsuario, idUsuario);
			return "Exito";
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e);
			return "error" + e.getMessage();
		}

	}

	@Override
	@Transactional(rollbackOn = SQLException.class)
	public String resetearNoDeIntentos(Integer idUsuario) {
		try {
			loginRepo.resetearNumeroIntentos(idUsuario);
			return "Exito";
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e);
			return "error" + e.getMessage();
		}
	}

	@Override
	@Transactional(rollbackOn = SQLException.class)
	public String cambiarPassword(String password, Integer idUsuario) {
		try {
			loginRepo.cambiarPassword(password, idUsuario);
			return "Exito";
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e);
			return "error" + e.getMessage();
		}
	}

	public List<menuEntity> getMenu(Integer idRol) {
		Response response = new Response();
		List<menuEntity> datos = new ArrayList<menuEntity>();
		try {
			datos = menuRepo.getMenu(idRol);
			System.out.println("datos");

		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("que paso"+e.getMessage());
			Log.error(e);
			return datos;
		}

		return datos;
	}

	public DatosMenu getDatosSubmenu(List<menuEntity> menu, String validacion) {
		DatosMenu datosMenu = new DatosMenu(); 
		for (Iterator iterator = menu.iterator(); iterator.hasNext();) {
			menuEntity menuEntity = (menuEntity) iterator.next();

			String nobreMenu = menuEntity.getDES_NOMBRE_MENU();
			String icono = menuEntity.getDES_ICONO();
			String ruta = menuEntity.getDES_RUTA();

			if (nobreMenu.equals(validacion)) {
				datosMenu.setEtiqueta(nobreMenu);
				datosMenu.setIcono(icono);
				datosMenu.setRuta(ruta);

				datosMenu.setColumna1(LoginServiceImpl.datosSumenu(menu, nobreMenu, 1));
				datosMenu.setColumna2(LoginServiceImpl.datosSumenu(menu, nobreMenu, 2));
				datosMenu.setColumna3(LoginServiceImpl.datosSumenu(menu, nobreMenu, 3));
				datosMenu.setColumna4(LoginServiceImpl.datosSumenu(menu, nobreMenu, 4));
			}

		}

		// TODO Auto-generated method stub
		return datosMenu;
	}

	private static List<DatosSubMenu> datosSumenu(List<menuEntity> menu, String nombreMenu, Integer Columna) {
		List<DatosSubMenu> submenu = new ArrayList<DatosSubMenu>();
		for (Iterator iterator = menu.iterator(); iterator.hasNext();) {

			menuEntity menuEntity = (menuEntity) iterator.next();
			String nobreMenu = menuEntity.getDES_NOMBRE_MENU();
			Integer nocolumna = menuEntity.getNUM_COLUMNA();
			String etiqueta = menuEntity.getDES_ETIQUETA();
			Integer esTitulo = menuEntity.getNUM_ES_TITULO();
			String ruta = menuEntity.getDES_RUTA();

			DatosSubMenu menuDatos = new DatosSubMenu();
			if (nobreMenu.equals(nombreMenu)) {
				if (nocolumna == Columna) {
					try {
						menuDatos.setEsTitulo(esTitulo);
						menuDatos.setEtiqueta(etiqueta);
						menuDatos.setRuta(ruta);

						submenu.add(menuDatos);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}

				}

			}

		}

		// TODO Auto-generated method stub
		return submenu;
	}

}
