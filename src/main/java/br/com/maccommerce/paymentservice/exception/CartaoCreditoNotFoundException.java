package br.com.maccommerce.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartaoCreditoNotFoundException extends RuntimeException {

    public CartaoCreditoNotFoundException(String numeroCartao) {
        super("O cartão de crédio com número " + numeroCartao + " não foi encontrado.");
    }

}
