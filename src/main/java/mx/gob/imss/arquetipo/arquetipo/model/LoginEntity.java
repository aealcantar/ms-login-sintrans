package mx.gob.imss.arquetipo.arquetipo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sintransc_usuarios")
@Getter
@Setter
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO", unique = true, nullable = true)
	private Integer ID_USUARIO;

	@Column(name = "CVE_MATRICULA")
	private String CVE_MATRICULA;

	@Column(name = "DES_ESTATUS_USUARIO")
	private String DES_ESTATUS_USUARIO;

	@Column(name = "DES_MOTIVO")
	private String DES_MOTIVO;

	@Column(name = "ID_ROLES_USUARIO")
	private Integer ID_ROLES_USUARIO;

	@Column(name = "ID_UNIDAD_ADSCRIPCION")
	private Integer ID_UNIDAD_ADSCRIPCION;

	@Column(name = "NOM_USUARIO")
	private String NOM_USUARIO;

	@Column(name = "NOM_APELLIDO_PATERNO")
	@JoinColumn(name = "NOM_APELLIDO_PATERNO")
	private String NOM_APELLIDO_PATERNO;

	@Column(name = "NOM_APELLIDO_MATERNO")
	private String NOM_APELLIDO_MATERNO;

	@Column(name = "CVE_PASSWORD")
	private String CVE_PASSWORD;

	@Column(name = "FEC_PWD_CADUCA")
	private Date FEC_PWD_CADUCA;

	@Column(name = "CVE_MATRIC_AUDIT")
	private String CVE_MATRIC_AUDIT;

	@Column(name = "IND_ACTIVO")
	private Integer IND_ACTIVO;

	@Column(name = "IND_SISTEMA")
	private Integer IND_SISTEMA;

	@Column(name = "NUM_INTENTOS")
	private Integer NUM_INTENTOS;

	@Column(name = "FEC_ALTA")
	private Date fecAlta;
	
	
	@Column(name = "FECHA_CADUDA")
	private Integer FECHA_CADUDA;

	public Integer getFECHA_CADUDA() {
		return FECHA_CADUDA;
	}

	public void setFECHA_CADUDA(Integer fECHA_CADUDA) {
		FECHA_CADUDA = fECHA_CADUDA;
	}

	public Integer getID_USUARIO() {
		return ID_USUARIO;
	}

	public void setID_USUARIO(Integer iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}

	public String getCVE_MATRICULA() {
		return CVE_MATRICULA;
	}

	public void setCVE_MATRICULA(String cVE_MATRICULA) {
		CVE_MATRICULA = cVE_MATRICULA;
	}

	public String getDES_ESTATUS_USUARIO() {
		return DES_ESTATUS_USUARIO;
	}

	public void setDES_ESTATUS_USUARIO(String dES_ESTATUS_USUARIO) {
		DES_ESTATUS_USUARIO = dES_ESTATUS_USUARIO;
	}

	public String getDES_MOTIVO() {
		return DES_MOTIVO;
	}

	public void setDES_MOTIVO(String dES_MOTIVO) {
		DES_MOTIVO = dES_MOTIVO;
	}

	public Integer getID_ROLES_USUARIO() {
		return ID_ROLES_USUARIO;
	}

	public void setID_ROLES_USUARIO(Integer iD_ROLES_USUARIO) {
		ID_ROLES_USUARIO = iD_ROLES_USUARIO;
	}

	public Integer getID_UNIDAD_ADSCRIPCION() {
		return ID_UNIDAD_ADSCRIPCION;
	}

	public void setID_UNIDAD_ADSCRIPCION(Integer iD_UNIDAD_ADSCRIPCION) {
		ID_UNIDAD_ADSCRIPCION = iD_UNIDAD_ADSCRIPCION;
	}

	public String getNOM_USUARIO() {
		return NOM_USUARIO;
	}

	public void setNOM_USUARIO(String nOM_USUARIO) {
		NOM_USUARIO = nOM_USUARIO;
	}

	public String getNOM_APELLIDO_PATERNO() {
		return NOM_APELLIDO_PATERNO;
	}

	public void setNOM_APELLIDO_PATERNO(String nOM_APELLIDO_PATERNO) {
		NOM_APELLIDO_PATERNO = nOM_APELLIDO_PATERNO;
	}

	public String getNOM_APELLIDO_MATERNO() {
		return NOM_APELLIDO_MATERNO;
	}

	public void setNOM_APELLIDO_MATERNO(String nOM_APELLIDO_MATERNO) {
		NOM_APELLIDO_MATERNO = nOM_APELLIDO_MATERNO;
	}

	public String getCVE_PASSWORD() {
		return CVE_PASSWORD;
	}

	public void setCVE_PASSWORD(String cVE_PASSWORD) {
		CVE_PASSWORD = cVE_PASSWORD;
	}

	public Date getFEC_PWD_CADUCA() {
		return FEC_PWD_CADUCA;
	}

	public void setFEC_PWD_CADUCA(Date fEC_PWD_CADUCA) {
		FEC_PWD_CADUCA = fEC_PWD_CADUCA;
	}

	public String getCVE_MATRIC_AUDIT() {
		return CVE_MATRIC_AUDIT;
	}

	public void setCVE_MATRIC_AUDIT(String cVE_MATRIC_AUDIT) {
		CVE_MATRIC_AUDIT = cVE_MATRIC_AUDIT;
	}

	public Integer getIND_ACTIVO() {
		return IND_ACTIVO;
	}

	public void setIND_ACTIVO(Integer iND_ACTIVO) {
		IND_ACTIVO = iND_ACTIVO;
	}

	public Integer getIND_SISTEMA() {
		return IND_SISTEMA;
	}

	public void setIND_SISTEMA(Integer iND_SISTEMA) {
		IND_SISTEMA = iND_SISTEMA;
	}

	public Integer getNUM_INTENTOS() {
		return NUM_INTENTOS;
	}

	public void setNUM_INTENTOS(Integer nUM_INTENTOS) {
		NUM_INTENTOS = nUM_INTENTOS;
	}

	public Date getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(Date fecAlta) {
		this.fecAlta = fecAlta;
	}

	public Date getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	public Date getFecBaja() {
		return fecBaja;
	}

	public void setFecBaja(Date fecBaja) {
		this.fecBaja = fecBaja;
	}

	@Column(name = "FEC_ACTUALIZACION")
	private Date fecActualizacion;

	@Column(name = "FEC_BAJA")
	private Date fecBaja;

	@Column(name = "DES_ROL")
	private String DES_ROL;

	public String getDES_ROL() {
		return DES_ROL;
	}

	public void setDES_ROL(String dES_ROL) {
		DES_ROL = dES_ROL;
	}

}
