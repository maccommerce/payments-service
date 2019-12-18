package br.com.maccommerce.paymentservice.services;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoNotFoundException;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoVencidoException;
import br.com.maccommerce.paymentservice.repositories.CartaoCreditoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service public class CartaoCreditoService {

	private final CartaoCreditoRepository cartaoCreditoRepository;

	public CartaoCreditoService(CartaoCreditoRepository cartaoCreditoRepository) {
		this.cartaoCreditoRepository = cartaoCreditoRepository;
	}

	@Transactional public CartaoCredito cartaoCreditoValido (String numeroCartao){
		Date dataAtual = new Date();
		
		CartaoCredito cartaoCredito = cartaoCreditoRepository.findByNumeroCartao(numeroCartao);

		if(cartaoCredito == null) {
			throw new CartaoCreditoNotFoundException(numeroCartao);
		}

		if (cartaoCredito.getVencimentoCartao().after(dataAtual)) {
			throw new CartaoCreditoVencidoException(numeroCartao);
		}

		return cartaoCredito;
	}

	
	
}
