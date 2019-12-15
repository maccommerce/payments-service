package br.com.maccommerce.paymentsservice.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maccommerce.paymentsservice.entities.CartaoCredito;
import br.com.maccommerce.paymentsservice.repositories.CartaoCreditoRepository;

@Service 
public class CartaoCreditoService {

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	public CartaoCredito cartaoCreditoValido (String numeroCartao){
		Date dataAtual = new Date();
		
		CartaoCredito cartaoCredito = cartaoCreditoRepository.findByNumeroCartao(numeroCartao);
		if ((cartaoCredito != null) && (cartaoCredito.getVencimentoCartao().after(dataAtual))) {
			return cartaoCredito;
		}
		return null;
		//return cartaoCreditoRepository.findByNumeroCartao(numeroCartao);
		
	}

	
	
}
