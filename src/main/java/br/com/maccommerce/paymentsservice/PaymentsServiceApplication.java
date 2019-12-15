package br.com.maccommerce.paymentsservice;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.maccommerce.paymentsservice.entities.CartaoCredito;
import br.com.maccommerce.paymentsservice.repositories.CartaoCreditoRepository;
import br.com.maccommerce.paymentsservice.services.CartaoCreditoService;

@SpringBootApplication
public class PaymentsServiceApplication {

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	@Autowired
	private CartaoCreditoService ccService;

	
	public static void main(String[] args) {
		SpringApplication.run(PaymentsServiceApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			Calendar cal = new GregorianCalendar();

			cal.setTime(date.getTime());
			 
			CartaoCredito cartaoCredito = new CartaoCredito();
			cartaoCredito.setNumeroCartao("12345");
			cartaoCredito.setVencimentoCartao(new Gr);
			
			CartaoCredito cartaoCreditoBusca =  cartaoCreditoRepository.findByNumeroCartao("12345");
			//this.ccService.testaServiço();
			System.out.print(cartaoCreditoBusca.toString());
		};
	}*/
}
