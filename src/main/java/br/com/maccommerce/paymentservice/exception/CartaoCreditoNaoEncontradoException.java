package br.com.maccommerce.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartaoCreditoNaoEncontradoException extends RuntimeException {

    public CartaoCreditoNaoEncontradoException(Long id) {
        super("O cartão de crédio com identificador " + id + " não foi encontrado.");
    }

    public CartaoCreditoNaoEncontradoException(String numeroCartao) {
        super("O cartão de crédio com número " + numeroCartao + " não foi encontrado.");
    }

}
