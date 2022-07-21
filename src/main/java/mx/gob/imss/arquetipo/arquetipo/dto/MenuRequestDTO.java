package mx.gob.imss.arquetipo.arquetipo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonRootName(value = "MenuRequestDTO")
public class MenuRequestDTO {

	public MenuRequestDTO() {

	}

	@JsonProperty
	private Integer ID_MENU;

	@JsonProperty
	private String DES_NOMBRE_MENU;

	@JsonProperty
	private String DES_ICONO;

	@JsonProperty
	private Integer NUM_COLUMNA;

	@JsonProperty
	private String DES_ETIQUETA;

	@JsonProperty
	private Integer NUM_ES_TITULO;

	@JsonProperty
	private String DES_RUTA;

}
