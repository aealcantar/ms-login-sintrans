package mx.gob.imss.arquetipo.arquetipo.helper;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("mx.gob.imss.arquetipo.arquetipo.controller"))
				.paths(PathSelectors.ant("/generic/*/*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("SINTRANS", "Arquetipo Generico para apis", "API", "",
				new Contact("IMSS", "imss.gob.mx", ""), "", "", Collections.emptyList());
	}

}