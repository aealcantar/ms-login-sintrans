package mx.gob.imss.arquetipo.arquetipo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class usuarioDto {
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty
	private String usuario;
	@JsonProperty
	private String password;
	@JsonProperty
	private String verificarPassword;
	
	@JsonProperty
	private int idUsuario;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getVerificarPassword() {
		return verificarPassword;
	}

	public void setVerificarPassword(String verificarPassword) {
		this.verificarPassword = verificarPassword;
	}
}
