package br.com.maccommerce.paymentservice.entities;

import br.com.maccommerce.paymentservice.dtos.CartaoCreditoDto;
import br.com.maccommerce.paymentservice.util.DateFormat;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cartao_credito")
public class CartaoCredito implements Serializable {

	private static final long serialVersionUID = 7405059448479979725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "vencimento", nullable = false)
	private Date vencimento;
	
	public CartaoCredito () { }

	public CartaoCredito(CartaoCreditoDto dto) {
		this.id = dto.getId();
		this.numero = dto.getNumero();
		this.vencimento = DateFormat.CREDIT_CARD_EXPIRATION_DATE.parse(dto.getVencimento());
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

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	@Override public String toString() {
		return "CartaoCredito [id=" + id + ", numero=" + numero + ", vencimento=" + vencimento + "]";
	}

}
