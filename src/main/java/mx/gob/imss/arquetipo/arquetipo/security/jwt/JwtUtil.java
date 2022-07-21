package mx.gob.imss.arquetipo.arquetipo.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component

public class JwtUtil {

	private static String secret = "Pmsoluciones"; 
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	 

	// Método para crear el JWT y enviarlo al cliente en el header de la respuesta
	static void addAuthentication(HttpServletResponse res, String username) {

		String token = Jwts.builder().setSubject(username)

				// Vamos a asignar un tiempo de expiracion de 6 minuto
				.setExpiration(new Date(System.currentTimeMillis() + 360000))

				// Hash con el que firmaremos la clave
				.signWith(SignatureAlgorithm.HS512, secret).compact();
		System.out.println("nuevo token" + token);
		// agregamos al encabezado el token
		res.addHeader("Authorization", "Bearer " + token);
	}

	// Método para validar el token enviado por el cliente
	static Authentication getAuthentication(HttpServletRequest request) {

		// Obtenemos el token que viene en el encabezado de la peticion
		String token = request.getHeader("Authorization");
		System.out.println(token);
		// si hay un token presente, entonces lo validamos
		if (token != null) {
 
			
			String user=null;
			try {
				 user = Jwts.parser().setSigningKey(secret).parseClaimsJws(token.replace("Bearer", "")) // este metodo
						// es el que
						// valida
.getBody().getSubject();
				 
			} catch (MalformedJwtException e) {
				logger.error("token mal formado");
				return null;
			} catch (UnsupportedJwtException e) {
				logger.error("token no soportado");
				return null;
			} catch (ExpiredJwtException e) {
				logger.error("token expirado");
				return null;
			} catch (IllegalArgumentException e) {
				logger.error("token vacío");
				return null;
			} catch (SignatureException e) {
				logger.error("fail en la firma");
				return null;
			}
		 
			System.out.println(user);
			// Recordamos que para las demás peticiones que no sean /login
			// no requerimos una autenticacion por username/password
			// por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin
			// password
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}
}