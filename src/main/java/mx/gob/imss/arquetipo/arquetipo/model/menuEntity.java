package mx.gob.imss.arquetipo.arquetipo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sintransc_menu_usuarios")
@Getter
@Setter
public class menuEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MENU", unique = true, nullable = true)
	private Integer ID_MENU;

	@Column(name = "DES_NOMBRE_MENU", unique = false, nullable = true)
	private String DES_NOMBRE_MENU;

	@Column(name = "DES_ICONO", unique = false, nullable = true)
	private String DES_ICONO;

	@Column(name = "NUM_COLUMNA", unique = false, nullable = true)
	private Integer NUM_COLUMNA;

	@Column(name = "DES_ETIQUETA", unique = false, nullable = true)
	private String DES_ETIQUETA;

	@Column(name = "NUM_ES_TITULO", unique = false, nullable = true)
	private Integer NUM_ES_TITULO;

	@Column(name = "DES_RUTA", unique = false, nullable = true)
	private String DES_RUTA;

	public Integer getID_MENU() {
		return ID_MENU;
	}

	public void setID_MENU(Integer iD_MENU) {
		ID_MENU = iD_MENU;
	}

	public String getDES_NOMBRE_MENU() {
		return DES_NOMBRE_MENU;
	}

	public void setDES_NOMBRE_MENU(String dES_NOMBRE_MENU) {
		DES_NOMBRE_MENU = dES_NOMBRE_MENU;
	}

	public String getDES_ICONO() {
		return DES_ICONO;
	}

	public void setDES_ICONO(String dES_ICONO) {
		DES_ICONO = dES_ICONO;
	}

	public Integer getNUM_COLUMNA() {
		return NUM_COLUMNA;
	}

	public void setNUM_COLUMNA(Integer nUM_COLUMNA) {
		NUM_COLUMNA = nUM_COLUMNA;
	}

	public String getDES_ETIQUETA() {
		return DES_ETIQUETA;
	}

	public void setDES_ETIQUETA(String dES_ETIQUETA) {
		DES_ETIQUETA = dES_ETIQUETA;
	}

	public Integer getNUM_ES_TITULO() {
		return NUM_ES_TITULO;
	}

	public void setNUM_ES_TITULO(Integer nUM_ES_TITULO) {
		NUM_ES_TITULO = nUM_ES_TITULO;
	}

	public String getDES_RUTA() {
		return DES_RUTA;
	}

	public void setDES_RUTA(String dES_RUTA) {
		DES_RUTA = dES_RUTA;
	}

}
