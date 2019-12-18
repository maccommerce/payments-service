package br.com.maccommerce.paymentservice.controllers;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.services.CartaoCreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
public class CartaoCreditoController {

	private final CartaoCreditoService cartaoCreditoService;

	public CartaoCreditoController(CartaoCreditoService cartaoCreditoService) {
		this.cartaoCreditoService = cartaoCreditoService;
	}

	@GetMapping(value="/{numeroCartao}")
	public ResponseEntity<CartaoCredito> validaCartao (@PathVariable("numeroCartao") String numeroCartao) {
		return ResponseEntity.ok()
		        .body(cartaoCreditoService.cartaoCreditoValido(numeroCartao));
	}

}
