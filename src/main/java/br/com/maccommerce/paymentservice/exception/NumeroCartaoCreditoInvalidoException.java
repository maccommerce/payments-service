package br.com.maccommerce.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumeroCartaoCreditoInvalidoException extends RuntimeException {

    public NumeroCartaoCreditoInvalidoException(String numero) {
        super("O cartão de crédito com número " + numero + " não é válido.");
    }

}
