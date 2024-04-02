package br.edu.fatecpg.to.api.Api;
import java.util.Scanner;

import br.edu.fatecpg.to.api.Api.service.ConsomeApi;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// essa classe é criada automaticamente, colocamos o implements CommandLineRunner para rodar a aplicação
@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
//metodo para rodar a aplicação
	@Override
	public void run(String... args) throws Exception {
		ConsomeApi consomeApi = new ConsomeApi();
		String json = consomeApi.lerJson("https://parallelum.com.br/fipe/api/v1/carros/marcas");
		System.out.println("Retorno da API" + json);
		System.out.println("Digite o Codigo da Marca");
		Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();
		json = consomeApi.lerJson("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+n+"/modelos");
		System.out.println(json);
		System.out.println("Digite o codigo do carro");
		String x = scanner.nextLine();
		System.out.println("Digite o ano + semestre ex: 2015-1");
		String y = scanner.nextLine();
		json = consomeApi.lerJson("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+n+"/modelos/"+x+"/anos/"+y);
		System.out.println(json);

	}
}
