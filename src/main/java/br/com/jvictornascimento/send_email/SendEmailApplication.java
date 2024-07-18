package br.com.jvictornascimento.send_email;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ms-send-email",version = "0.0.1",description = "microservice to send email."))
public class SendEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApplication.class, args);
	}

}
