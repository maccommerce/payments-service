package br.com.maccommerce.paymentservice.services;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoJaCadastradoException;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoNaoEncontradoException;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoVencidoException;
import br.com.maccommerce.paymentservice.exception.NumeroCartaoCreditoInvalidoException;
import br.com.maccommerce.paymentservice.repositories.CartaoCreditoRepository;
import org.apache.commons.validator.routines.CreditCardValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service public class CartaoCreditoService {

	private final CartaoCreditoRepository cartaoCreditoRepository;

	public CartaoCreditoService(CartaoCreditoRepository cartaoCreditoRepository) {
		this.cartaoCreditoRepository = cartaoCreditoRepository;
	}

	public CartaoCredito buscarPorId(Long id) {
		Optional<CartaoCredito> optional = cartaoCreditoRepository.findById(id);

		if(!optional.isPresent()) {
			throw new CartaoCreditoNaoEncontradoException(id);
		}

		return optional.get();
	}

	@Transactional public CartaoCredito cadastrar(CartaoCredito cartaoCredito) {
		verificarDuplicidade(cartaoCredito.getNumero());

		validarNumero(cartaoCredito.getNumero());

		validarVencimento(cartaoCredito.getNumero(), cartaoCredito.getVencimento());

		return cartaoCreditoRepository.save(cartaoCredito);
	}

	private void verificarDuplicidade(String numero) {
		CartaoCredito cartaoCredito = cartaoCreditoRepository.findByNumero(numero);

		if(cartaoCredito != null) {
			throw new CartaoCreditoJaCadastradoException(numero);
		}
	}

	private void validarNumero(String numero) {
		if(numero == null || (!CreditCardValidator.genericCreditCardValidator().isValid(numero))) {
			throw new NumeroCartaoCreditoInvalidoException(numero);
		}
	}

	private void validarVencimento(String numero, Date vencimento) {
		Date dataAtual = new Date();

		if(vencimento.before(dataAtual)) {
			throw new CartaoCreditoVencidoException(numero);
		}

	}
	
}
