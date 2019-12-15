package br.com.maccommerce.paymentsservice.entities;

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
	
	private Long id;
	private String numeroCartao;
	private Date vencimentoCartao;
	
	public CartaoCredito () {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NUM_CART", nullable = false)
	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	@Column(name = "VENC_CART", nullable = false)
	public Date getVencimentoCartao() {
		return vencimentoCartao;
	}

	public void setVencimentoCartao(Date vencimentoCartao) {
		this.vencimentoCartao = vencimentoCartao;
	}

	@Override
	public String toString() {
		return "CartaoCredito [id=" + id + ", numeroCartao=" + numeroCartao + ", vencimentoCartao=" + vencimentoCartao
				+ "]";
	}
}
