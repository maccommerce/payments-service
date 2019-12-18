package br.com.maccommerce.paymentservice.controllers;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.services.CartaoCreditoService;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("api/payments")
public class CartaoCreditoController {

	private final CartaoCreditoService cartaoCreditoService;

	public CartaoCreditoController(CartaoCreditoService cartaoCreditoService) {
		this.cartaoCreditoService = cartaoCreditoService;
	}

	@GetMapping(value="/{numeroCartao}")
	public ResponseEntity<CartaoCredito> validaCartao (@PathVariable("numeroCartao") String numeroCartao) throws ParseException {
		Response response = new Response();
		//ResponseEntity<CartaoCreditoDto> response2 = new ResponseEntity<CartaoCreditoDto>(status);
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		//java.util.Date dataFormatada =  formato.parse(vencimentoCartao);
		
		CartaoCredito cartaoCredito = cartaoCreditoService.cartaoCreditoValido(numeroCartao);
		if (cartaoCredito == null) {
			
			return ResponseEntity.badRequest()
			        .header("Mensagem","Número do Cartão: " + numeroCartao + " não existe ou está fora da validade")
			        .body(new CartaoCredito());
		}
		
		
		//return ResponseEntity.ok(response);
		return ResponseEntity.ok()
		        .header("id",cartaoCredito.getId().toString())
		        .body(cartaoCreditoService.cartaoCreditoValido(numeroCartao));
	}

}
