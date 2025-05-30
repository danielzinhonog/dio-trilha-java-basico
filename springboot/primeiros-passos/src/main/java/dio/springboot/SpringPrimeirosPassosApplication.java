package dio.springboot;

import dio.springboot.app.ConversorJson;
import dio.springboot.app.ViaCepResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPrimeirosPassosApplication{
    public static void main(String[] args){ SpringApplication.run(SpringPrimeirosPassosApplication.class, args);
}
    @Bean
    public CommandLineRunner run(ConversorJson conversor) throws Exception{
        return args -> {
            String json = "{\"cep\":\"01001-000\",\"logradouro\": \"Praça da Sé\",\"localidade\": \"São Paulo\"}";
            ViaCepResponse response = conversor.converter(json);
            System.out.println("Dados do CEP: " + response);
        };
    }
}