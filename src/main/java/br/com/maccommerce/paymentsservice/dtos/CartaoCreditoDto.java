package br.com.maccommerce.paymentsservice.dtos;

public class CartaoCreditoDto {
	
	private Long id;
	private String numeroCartao;

	public CartaoCreditoDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	@Override
	public String toString() {
		return "CartaoCreditoDto [id=" + id + ", numeroCartao=" + numeroCartao + "]";
	}

}
