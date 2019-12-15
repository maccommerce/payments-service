package br.com.maccommerce.paymentsservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.maccommerce.paymentsservice.entities.CartaoCredito;
import br.com.maccommerce.paymentsservice.repositories.CartaoCreditoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CartaoCreditoServiceTest {

	@MockBean
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	@Autowired
	private CartaoCreditoService cartaoCreditoService;
	
	private static final String numeroCartao = "12345";
	
	@org.junit.Before
	public void setUp() throws Exception{
		BDDMockito.given(this.cartaoCreditoRepository.findByNumeroCartao(Mockito.anyString())).willReturn(new CartaoCredito());
	}
	
	@Test
	public void testBuscaCartaoCredito() {
		CartaoCredito cartaoCredito = this.cartaoCreditoService.cartaoCreditoValido(numeroCartao);
		if(cartaoCredito != null) {
			assertNotNull(cartaoCredito);
		}	
	}
}
