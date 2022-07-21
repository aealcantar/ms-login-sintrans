package mx.gob.imss.arquetipo.arquetipo.security.jwt;

import io.jsonwebtoken.*;
import mx.gob.imss.arquetipo.arquetipo.model.LoginEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
 
	private String secret="Pmsoluciones";
	byte[] decodedSecret = Base64.getDecoder().decode(secret);

	private long expiration = 3600000; // 1h

	public String generateToken(LoginEntity datos) {
		System.out.println(decodedSecret);
		String datosUsuario="[{"+
				"\"matricula\":"+datos.getCVE_MATRICULA()+","+
				"\"rol\":"+datos.getDES_ROL()+","+
				"\"idUnidadAdscripcion\":"+datos.getID_UNIDAD_ADSCRIPCION()+","+
				"}]";
String token = Jwts.builder()
.setSubject(datosUsuario)

// Vamos a asignar un tiempo de expiracion de 6 minuto 
.setExpiration(new Date(System.currentTimeMillis() + 360000))

// Hash con el que firmaremos la clave
.signWith(SignatureAlgorithm.HS512, decodedSecret)
.compact();

return token;
/*
 * return Jwts.builder().setSubject(datos.getCVE_MATRICULA())
 * .claim("authorities", datos.getDES_ROL() ) .setIssuedAt(new Date())
 * .setExpiration(new Date(new Date().getTime() + expiration * 1000))
 * .signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
 */
	}

	public String getNombreUsuarioFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			System.out.println(Jwts.parser().setSigningKey(secret).parseClaimsJws(token));
			System.out.println(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
			return true;
		} catch (MalformedJwtException e) {
			logger.error("token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("token no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("token expirado");
		} catch (IllegalArgumentException e) {
			logger.error("token vacío");
		} catch (SignatureException e) {
			logger.error("fail en la firma");
		}
		return false;
	}

}
