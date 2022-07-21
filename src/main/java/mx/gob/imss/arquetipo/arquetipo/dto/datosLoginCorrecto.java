package mx.gob.imss.arquetipo.arquetipo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.imss.arquetipo.arquetipo.model.menuEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "datosLoginCorrecto")
public class datosLoginCorrecto {

	@JsonProperty
	public datosGeneralesUsuario datosUsuario;

	public datosGeneralesUsuario getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(datosGeneralesUsuario datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty
	public String token;

	public List<DatosMenu> menu;

	public List<DatosMenu> getMenu() {
		return menu;
	}

	public void setMenu(List<DatosMenu> lisDatosMenu) {
		this.menu = lisDatosMenu;
	}

}
