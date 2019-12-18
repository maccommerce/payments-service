package br.com.maccommerce.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CartaoCreditoJaCadastradoException extends RuntimeException {

    public CartaoCreditoJaCadastradoException(String numero) {
        super("Já existe um cartão de crédito cadastrado com o número '" + numero + "'.");
    }

}
