package de.bmw.aw.transportservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	 public static final ApiInfo DEFAULT = new ApiInfo("Awesome api title", "Awesome api description", "1.0", "", DEFAULT_CONTACT, "", "");
//	 public static final Contact DEFAULT_CONTACT = new Contact("Markus Schneider", "", "");
//	 private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
//	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2);
	               // .apiInfo(DEFAULT)
	               // .produces(DEFAULT_PRODUCES_AND_CONSUMES)
	                //.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	    }
	
}
