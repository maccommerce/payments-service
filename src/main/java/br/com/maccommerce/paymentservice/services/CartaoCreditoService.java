package br.com.maccommerce.paymentservice.services;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.repositories.CartaoCreditoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service public class CartaoCreditoService {

	private final CartaoCreditoRepository cartaoCreditoRepository;

	public CartaoCreditoService(CartaoCreditoRepository cartaoCreditoRepository) {
		this.cartaoCreditoRepository = cartaoCreditoRepository;
	}

	public CartaoCredito cartaoCreditoValido (String numeroCartao){
		Date dataAtual = new Date();
		
		CartaoCredito cartaoCredito = cartaoCreditoRepository.findByNumeroCartao(numeroCartao);

		if ((cartaoCredito != null) && (cartaoCredito.getVencimentoCartao().after(dataAtual))) {
			return cartaoCredito;
		}

		return null;
	}

	
	
}
