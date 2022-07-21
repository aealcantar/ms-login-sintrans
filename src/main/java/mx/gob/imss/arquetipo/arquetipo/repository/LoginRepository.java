package mx.gob.imss.arquetipo.arquetipo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	@Query(value = "SELECT u.*,r.DES_ROL ,TIMESTAMPDIFF(DAY, NOW(), u.FEC_PWD_CADUCA) as FECHA_CADUDA FROM sintransc_usuarios u "
			+ " join sintransc_roles_usuarios r on r.ID_ROLES_USUARIO = u.ID_ROLES_USUARIO"
			+ " WHERE u.CVE_MATRICULA = :matricula AND u.IND_ACTIVO = 1 ", nativeQuery = true)
	LoginEntity getUsuario(@Param("matricula") String matricula);

	@Modifying(flushAutomatically = true)
	@Query(value = "UPDATE sintransc_usuarios SET NUM_INTENTOS = (select ifnull(NUM_INTENTOS,0)+1 from sintransc_usuarios "
			+ " where ID_USUARIO = ?" + ") WHERE ID_USUARIO = ?", nativeQuery = true)
	void actulizaNumeroIntentos(Integer id, Integer id2);

	@Modifying(flushAutomatically = true)
	@Query(value = "UPDATE sintransc_usuarios SET NUM_INTENTOS = 0 " + " where ID_USUARIO = ?", nativeQuery = true)
	void resetearNumeroIntentos(Integer id);

	@Modifying(flushAutomatically = true)
	@Query(value = "UPDATE sintransc_usuarios SET CVE_PASSWORD = ? " + " where ID_USUARIO = ?", nativeQuery = true)
	void cambiarPassword(String password, Integer idUsuario);

}
