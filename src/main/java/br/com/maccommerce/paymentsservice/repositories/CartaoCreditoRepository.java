package br.com.maccommerce.paymentsservice.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.maccommerce.paymentsservice.entities.CartaoCredito;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long>{
	
	@Transactional
	CartaoCredito findByNumeroCartao(String numeroCartao);

}
