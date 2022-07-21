package mx.gob.imss.arquetipo.arquetipo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;

 
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity;

@Repository
public interface MenuRepository extends JpaRepository<menuEntity, Integer> {

	@Query(value = "SELECT u.* FROM sintransc_menu_usuarios u "
			+ " where u.ID_MENU in (SELECT ID_MENU  from sintransc_relacion_rol_menu  where ID_ROLES_USUARIO = ? )  "
			+ "order by ID_MENU", nativeQuery = true)
	List<menuEntity> getMenu(Integer idRol);

}
