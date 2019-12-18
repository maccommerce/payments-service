package br.com.maccommerce.paymentservice.repositories;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long>{
	
	@Transactional
	CartaoCredito findByNumeroCartao(String numeroCartao);

}
