package mx.gob.imss.arquetipo.arquetipo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonRootName(value = "DatosSubMenu")
public class DatosSubMenu {

	public DatosSubMenu() {

	}

	@JsonProperty
	private String etiqueta;

	@JsonProperty
	private Integer esTitulo;

	@JsonProperty
	private String ruta;

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Integer getEsTitulo() {
		return esTitulo;
	}

	public void setEsTitulo(Integer esTitulo) {
		this.esTitulo = esTitulo;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
