package mx.gob.imss.arquetipo.arquetipo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonRootName(value = "DatosMenu")
public class DatosMenu {

	public DatosMenu() {

	}

	@JsonProperty
	private String etiqueta;

	@JsonProperty
	private String icono;

	@JsonProperty
	private String ruta;

	@JsonProperty
	private List<DatosSubMenu> columna1;

	@JsonProperty
	private List<DatosSubMenu> columna2;

	@JsonProperty
	private List<DatosSubMenu> columna3;

	@JsonProperty
	private List<DatosSubMenu> columna4;

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<DatosSubMenu> getColumna1() {
		return columna1;
	}

	public void setColumna1(List<DatosSubMenu> columna1) {
		this.columna1 = columna1;
	}

	public List<DatosSubMenu> getColumna2() {
		return columna2;
	}

	public void setColumna2(List<DatosSubMenu> columna2) {
		this.columna2 = columna2;
	}

	public List<DatosSubMenu> getColumna3() {
		return columna3;
	}

	public void setColumna3(List<DatosSubMenu> columna3) {
		this.columna3 = columna3;
	}

	public List<DatosSubMenu> getColumna4() {
		return columna4;
	}

	public void setColumna4(List<DatosSubMenu> columna4) {
		this.columna4 = columna4;
	}

}
