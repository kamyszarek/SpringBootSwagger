package pl.arkadiusz.SpringAndSwagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@EntityScan(basePackages = {"pl.arkadiusz.SpringAndSwagger"})
@SpringBootApplication
public class SpringAndSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAndSwaggerApplication.class, args);
	}

}
