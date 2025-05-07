package dio.dio_spring_security_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import dio.dio_spring_security_jwt.security.SecurityConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(SecurityConfigProperties.class)
public class DioSpringSecurityJwtApplication{
	public static void main(String[] args){
		SpringApplication.run(DioSpringSecurityJwtApplication.class, args);
	}
}