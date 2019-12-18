package br.com.maccommerce.paymentservice.dtos;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.util.DateFormat;

public class CartaoCreditoDto {
	
	private Long id;
	private String numero;
	private String vencimento;

	public CartaoCreditoDto() { }

	public CartaoCreditoDto(CartaoCredito cartaoCredito) {
		this.id = cartaoCredito.getId();
		this.numero = cartaoCredito.getNumero();
		this.vencimento = DateFormat.CREDIT_CARD_EXPIRATION_DATE.format(cartaoCredito.getVencimento());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	@Override public String toString() {
		return "CartaoCreditoDto{" + "id=" + id + ", numero='" + numero + '\'' + ", vencimento='" + vencimento + '\'' + '}';
	}
}
