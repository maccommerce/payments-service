package br.com.maccommerce.paymentservice.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.repositories.CartaoCreditoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CartaoCreditoServiceTest {

	@MockBean private CartaoCreditoRepository cartaoCreditoRepository;
	
	@Autowired private CartaoCreditoService cartaoCreditoService;
	
	private static final String numeroCartao = "12345";
	
	@Before public void setUp() {
		BDDMockito.given(this.cartaoCreditoRepository.findByNumeroCartao(Mockito.anyString())).willReturn(new CartaoCredito());
	}
	
	@Test public void testBuscaCartaoCredito() {
		CartaoCredito cartaoCredito = this.cartaoCreditoService.cartaoCreditoValido(numeroCartao);
		assertNotNull(cartaoCredito);
	}
}
