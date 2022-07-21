package mx.gob.imss.arquetipo.arquetipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import mx.gob.imss.arquetipo.arquetipo.security.jwt.JWTAuthorizationFilter;
import mx.gob.imss.arquetipo.arquetipo.security.jwt.JwtEntryPoint;
import mx.gob.imss.arquetipo.arquetipo.security.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	@Autowired
	JwtEntryPoint jwtEntryPoint;

	 
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		 http.cors().and().csrf().disable().authorizeRequests()
         .antMatchers("/api/**").permitAll() //permitimos el acceso a /login a cualquiera
         .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
         .and()
             // Las demás peticiones pasarán por este filtro para validar el token
         .addFilterBefore(new JwtFilter(),
                 UsernamePasswordAuthenticationFilter.class);
		
			
		/*
		 * 
		 * 
		 * 
		 * http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/login", "/api/validarMatricula")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 
		 
		 
		 * http.csrf().disable().authorizeRequests()
		 * .antMatchers("/mssintetrans-tarjetas-electronicas/api/cambiarPassword").
		 * authenticated()
		 * .antMatchers("/mssintetrans-tarjetas-electronicas/api/login").permitAll()
		 * 
		 * .and() .exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
		 */

	}
}
