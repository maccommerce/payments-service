package br.com.maccommerce.paymentservice.entities;

import java.io.Serializable;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NUM_CART", nullable = false)
	private String numeroCartao;

	@Column(name = "VENC_CART", nullable = false)
	private Date vencimentoCartao;
	
	public CartaoCredito () { }

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

	public Date getVencimentoCartao() {
		return vencimentoCartao;
	}

	public void setVencimentoCartao(Date vencimentoCartao) {
		this.vencimentoCartao = vencimentoCartao;
	}

	@Override public String toString() {
		return "CartaoCredito [id=" + id + ", numeroCartao=" + numeroCartao + ", vencimentoCartao=" + vencimentoCartao
				+ "]";
	}

}
