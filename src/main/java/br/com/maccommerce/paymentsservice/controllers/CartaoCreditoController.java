package br.com.maccommerce.paymentsservice.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maccommerce.paymentsservice.dtos.CartaoCreditoDto;
import br.com.maccommerce.paymentsservice.entities.CartaoCredito;
import br.com.maccommerce.paymentsservice.services.CartaoCreditoService;
import io.swagger.models.Response;

@RestController
@RequestMapping("api/payments")
public class CartaoCreditoController {

	@Autowired
	private CartaoCreditoService cartaoCreditoService;
	
	//HttpStatus status = HttpStatus.ACCEPTED;
	
	@GetMapping(value="/{numeroCartao}")
	public ResponseEntity<CartaoCredito> validaCartao (@PathVariable("numeroCartao") String numeroCartao) throws ParseException {
		//public ResponseEntity<ResponseEntity<CartaoCreditoDto>> validaCartao (@PathVariable("numeroCartao") String numeroCartao) {
		
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
