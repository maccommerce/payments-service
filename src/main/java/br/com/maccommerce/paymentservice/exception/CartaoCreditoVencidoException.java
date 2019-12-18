package br.com.maccommerce.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartaoCreditoVencidoException extends RuntimeException {

    public CartaoCreditoVencidoException(String numeroCartao) {
        super("O cartão de crédito com número " + numeroCartao + " está vencido.");
    }

}
