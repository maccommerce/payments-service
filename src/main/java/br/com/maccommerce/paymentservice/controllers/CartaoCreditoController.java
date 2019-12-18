package br.com.maccommerce.paymentservice.controllers;

import br.com.maccommerce.paymentservice.dtos.CartaoCreditoDto;
import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.services.CartaoCreditoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/cards")
public class CartaoCreditoController {

	private final CartaoCreditoService cartaoCreditoService;

	public CartaoCreditoController(CartaoCreditoService cartaoCreditoService) {
		this.cartaoCreditoService = cartaoCreditoService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public CartaoCreditoDto salvar(@RequestBody CartaoCreditoDto dto) {
		CartaoCredito cartaoCreditoSalvo = cartaoCreditoService.cadastrar(new CartaoCredito(dto));
		return new CartaoCreditoDto(cartaoCreditoSalvo);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public CartaoCreditoDto buscarPorId(@PathVariable Long id) {
		CartaoCredito cartaoCredito = cartaoCreditoService.buscarPorId(id);
		return new CartaoCreditoDto(cartaoCredito);
	}

}
