package mx.gob.imss.arquetipo.arquetipo.security.jwt;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.Header;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
	private final static Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "funcionamuybien";
	@Autowired
	JwtProvider jwtProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(req); 
			if (existeJWTToken(req, res)) {
			 
				Claims claims = validateToken(req); 
				if (claims.get("sub") != null) { 
					setUpSpringAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}
		} catch (Exception e) {
			logger.error("fail en el  doFilter " + e.getMessage());
		}
		filterChain.doFilter(req, res);
	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer"))
			return header.replace("Bearer ", "");
		return null;
	}

	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}

	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader("Authorization");

	 
		if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer "))
			return false;
		return true;
	}
}