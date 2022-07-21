/**
 * 
 */
package mx.gob.imss.arquetipo.arquetipo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonRootName(value = "LoginRequestDTO")
public class LoginRequestDTO {

	public LoginRequestDTO() {

	}

	@JsonProperty
	private Integer ID_USUARIO;

	@JsonProperty
	private String CVE_MATRICULA;

	@JsonProperty
	private String DES_ESTATUS_USUARIO;

	@JsonProperty
	private String DES_MOTIVO;

	@JsonProperty
	private Integer ID_ROLES_USUARIO;

	@JsonProperty
	private Integer ID_UNIDAD_ADSCRIPCION;

	@JsonProperty
	private String NOM_USUARIO;

	@JsonProperty
	private String NOM_APELLIDO_PATERNO;

	@JsonProperty
	private String NOM_APELLIDO_MATERNO;

	@JsonProperty
	private String CVE_PASSWORD;

	@JsonProperty
	private Date FEC_PWD_CADUCA;

	@JsonProperty
	private String CVE_MATRIC_AUDIT;

	@JsonProperty
	private Integer IND_ACTIVO;

	@JsonProperty
	private Integer IND_SISTEMA;

	@JsonProperty
	private Integer NUM_INTENTOS;

	@JsonProperty
	private Date fecAlta;
	@JsonProperty
	private Integer FECHA_CADUDA;
	@JsonProperty
	private Date fecActualizacion;
	@JsonProperty
	private Date fecBaja;

}
