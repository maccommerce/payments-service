package br.com.maccommerce.paymentservice.services;

import br.com.maccommerce.paymentservice.DatabaseMock;
import br.com.maccommerce.paymentservice.entities.CartaoCredito;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoJaCadastradoException;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoNaoEncontradoException;
import br.com.maccommerce.paymentservice.exception.CartaoCreditoVencidoException;
import br.com.maccommerce.paymentservice.exception.NumeroCartaoCreditoInvalidoException;
import br.com.maccommerce.paymentservice.repositories.CartaoCreditoRepository;
import org.flywaydb.core.Flyway;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@FlywayTest
@Transactional
@SpringBootTest
public class CartaoCreditoServiceTest {

	@Autowired private Flyway flyway;

	@Autowired private CartaoCreditoService service;

	@Autowired private CartaoCreditoRepository repository;

	private static DatabaseMock databaseMock;

	@BeforeAll static void beforeAll() throws IOException {
		databaseMock = new DatabaseMock();
	}

	@BeforeEach void beforeEach() {
		flyway.clean();
		flyway.migrate();
	}

	@AfterAll static void afterAkk() throws IOException {
		databaseMock.stopServer();
	}

	@Test
	@DisplayName("deve salvar um novo cartão com sucesso")
	public void cadastrarNovoCartao() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2027, Calendar.DECEMBER, 1);

		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setNumero("5208468326936067");
		cartaoCredito.setVencimento(calendar.getTime());

		service.cadastrar(cartaoCredito);
	}

	@Test
	@DisplayName("não deve salvar um novo cartão duplicado")
	public void cadastrarNovoCartaoDuplicado() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2027, Calendar.DECEMBER, 1);

		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setNumero("5208468326936067");
		cartaoCredito.setVencimento(calendar.getTime());

		repository.save(cartaoCredito);

		assertThrows(CartaoCreditoJaCadastradoException.class, () -> service.cadastrar(cartaoCredito));
	}

	@Test
	@DisplayName("não deve salvar um novo cartão com numero invalido")
	public void cadastrarNovoCartaoComNumeroInvalido() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2027, Calendar.DECEMBER, 1);

		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setNumero("5208468326936069");
		cartaoCredito.setVencimento(calendar.getTime());

		assertThrows(NumeroCartaoCreditoInvalidoException.class, () -> service.cadastrar(cartaoCredito));
	}

	@Test
	@DisplayName("não deve salvar um novo cartão vencido")
	public void cadastrarNovoCartaoVencido() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, Calendar.DECEMBER, 1);

		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setNumero("5208468326936067");
		cartaoCredito.setVencimento(calendar.getTime());

		assertThrows(CartaoCreditoVencidoException.class, () -> service.cadastrar(cartaoCredito));
	}

	@Test
	@DisplayName("buscar cartao por id")
	public void buscarCartaoPorId() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2027, Calendar.DECEMBER, 1);

		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setNumero("5208468326936067");
		cartaoCredito.setVencimento(calendar.getTime());

		cartaoCredito = repository.save(cartaoCredito);

		assertNotNull(service.buscarPorId(cartaoCredito.getId()));
	}

	@Test
	@DisplayName("buscar cartao inexistente por id")
	public void buscarCartaoInexistentePorId() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2027, Calendar.DECEMBER, 1);

		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setNumero("5208468326936067");
		cartaoCredito.setVencimento(calendar.getTime());

		repository.save(cartaoCredito);

		assertThrows(CartaoCreditoNaoEncontradoException.class, () -> service.buscarPorId(999L));
	}

}
