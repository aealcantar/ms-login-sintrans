package mx.gob.imss.arquetipo.arquetipo.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "response")
public class Response {

	 
	@JsonProperty
	public int codigo;

	@JsonProperty
	public String mensaje;

	@JsonProperty
	public boolean error;

	@JsonProperty
	public datosLoginCorrecto data;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public datosLoginCorrecto getData() {
		return data;
	}

	public void setData(datosLoginCorrecto data) {
		this.data = data;
	}
	
	
	

}
