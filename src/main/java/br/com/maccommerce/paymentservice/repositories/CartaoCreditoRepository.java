package br.com.maccommerce.paymentservice.repositories;

import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long>{
	
	CartaoCredito findByNumero(String numero);

}
