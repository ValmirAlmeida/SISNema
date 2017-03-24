package br.uefs.ecomp.sisNema.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.sisNema.controller.AdministradorController;
import br.uefs.ecomp.sisNema.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNuloException;
import br.uefs.ecomp.sisNema.model.Comprador;

public class MergeSortTest {
	
	private AdministradorController controllerAdministrador;


	@Before
	public void setUp() throws Exception {
		AdministradorController.zerarSingleton();
		controllerAdministrador = AdministradorController.getInstance();
	}

	@Test
	public void testOrdenar() {
		/* Cria instância compradores. */
		
		Comprador comprador0 = new Comprador();
		comprador0.setNome("Valmir Vinicius de Almeida Santos");
		comprador0.setEndereco(CriarObjetos.criarEndereco());
		comprador0.setTelefone("(75)99138-9942");
		comprador0.setEmail("vvalmeida96@gmail.com");
		comprador0.setDocumento(1234);
		
		Comprador comprador1 = new Comprador();
		comprador1.setNome("Rosane Maria Moura de Almeida Santos");
		comprador1.setEndereco(CriarObjetos.criarEndereco());
		comprador1.setTelefone("(75)98122-3263");
		comprador1.setEmail("rosane@email.com.br");
		comprador1.setDocumento(4321);
		
		Comprador comprador2 = new Comprador();
		comprador2.setNome("Ionara Maria de Almeida Santos");
		comprador2.setEndereco(CriarObjetos.criarEndereco());
		comprador2.setTelefone("(75)3425-1340");
		comprador2.setEmail("nara@email.com.br");
		comprador2.setDocumento(2222);
		
		Comprador comprador3 = new Comprador();
		comprador3.setNome("Valmir Souza Santos");
		comprador3.setEndereco(CriarObjetos.criarEndereco());
		comprador3.setTelefone("(75)98102-4907");
		comprador3.setEmail("valmir@email.com.br");
		comprador3.setDocumento(3333);
		
		Comprador comprador4 = new Comprador();
		comprador4.setNome("Driele Alana Ferreira");
		comprador4.setEndereco(CriarObjetos.criarEndereco());
		comprador4.setTelefone("(75)1111-11111");
		comprador4.setEmail("driele@email.com");
		comprador4.setDocumento(4444);
		
		Comprador comprador5 = new Comprador();
		comprador5.setNome("Welligton Carlos Moreira Junior");
		comprador5.setEndereco(CriarObjetos.criarEndereco());
		comprador5.setTelefone("(75)2222-2222");
		comprador5.setEmail("wellington@email.com");
		comprador5.setDocumento(5555);
		
		Comprador comprador6 = new Comprador();
		comprador6.setNome("Alysson Vilas Boas");
		comprador6.setEndereco(CriarObjetos.criarEndereco());
		comprador6.setTelefone("(75)3333-3333");
		comprador6.setEmail("alysson@email.com");
		comprador6.setDocumento(6666);
		
		Comprador comprador7 = new Comprador();
		comprador7.setNome("Gabriela Porto");
		comprador7.setEndereco(CriarObjetos.criarEndereco());
		comprador7.setTelefone("(75)4444-4444");
		comprador7.setEmail("gabi@email.com");
		comprador7.setDocumento(7777);
		
		Comprador comprador8 = new Comprador();
		comprador8.setNome("Nadine Cerqueira");
		comprador8.setEndereco(CriarObjetos.criarEndereco());
		comprador8.setTelefone("(75)5555-5555");
		comprador8.setEmail("nadi@email.com");
		comprador8.setDocumento(8888);
		
		Comprador comprador9 = new Comprador();
		comprador9.setNome("Tinashe");
		comprador9.setEndereco(CriarObjetos.criarEndereco());
		comprador9.setTelefone("(75)3232-3232");
		comprador9.setEmail("tee@email.com");
		comprador9.setDocumento(9999);
		
		
		/* Registra os compradores criados no sistema. */
		try {
			controllerAdministrador.cadastrarComprador(comprador0);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador1);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador2);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador3);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador4);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador5);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador6);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador7);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador8);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador9);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		
		Iterador i = controllerAdministrador.listarCompradores(); //obtém o iterador para a lista de compradores já ordenada
		Comprador auxiliarComprador = null; //referência auxiliar para comprador
		
		/* Obtém os compradores cadastrados e verifica se está na ordem alfabética. */
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Alysson Vilas Boas", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Driele Alana Ferreira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Gabriela Porto", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Ionara Maria de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Nadine Cerqueira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Rosane Maria Moura de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Tinashe", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Souza Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Vinicius de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Welligton Carlos Moreira Junior", auxiliarComprador.getNome());
		
		assertFalse(i.temProximo());

	}

	@Test
	public void testMergeSort() {
		/* Cria instância compradores. */
		
		Comprador comprador0 = new Comprador();
		comprador0.setNome("Valmir Vinicius de Almeida Santos");
		comprador0.setEndereco(CriarObjetos.criarEndereco());
		comprador0.setTelefone("(75)99138-9942");
		comprador0.setEmail("vvalmeida96@gmail.com");
		comprador0.setDocumento(1234);
		
		Comprador comprador1 = new Comprador();
		comprador1.setNome("Rosane Maria Moura de Almeida Santos");
		comprador1.setEndereco(CriarObjetos.criarEndereco());
		comprador1.setTelefone("(75)98122-3263");
		comprador1.setEmail("rosane@email.com.br");
		comprador1.setDocumento(4321);

		Comprador comprador2 = new Comprador();
		comprador2.setNome("Ionara Maria de Almeida Santos");
		comprador2.setEndereco(CriarObjetos.criarEndereco());
		comprador2.setTelefone("(75)3425-1340");
		comprador2.setEmail("nara@email.com.br");
		comprador2.setDocumento(2222);
		
		Comprador comprador3 = new Comprador();
		comprador3.setNome("Valmir Souza Santos");
		comprador3.setEndereco(CriarObjetos.criarEndereco());
		comprador3.setTelefone("(75)98102-4907");
		comprador3.setEmail("valmir@email.com.br");
		comprador3.setDocumento(3333);
		
		Comprador comprador4 = new Comprador();
		comprador4.setNome("Driele Alana Ferreira");
		comprador4.setEndereco(CriarObjetos.criarEndereco());
		comprador4.setTelefone("(75)1111-11111");
		comprador4.setEmail("driele@email.com");
		comprador4.setDocumento(4444);
		
		Comprador comprador5 = new Comprador();
		comprador5.setNome("Welligton Carlos Moreira Junior");
		comprador5.setEndereco(CriarObjetos.criarEndereco());
		comprador5.setTelefone("(75)2222-2222");
		comprador5.setEmail("wellington@email.com");
		comprador5.setDocumento(5555);
		
		Comprador comprador6 = new Comprador();
		comprador6.setNome("Alysson Vilas Boas");
		comprador6.setEndereco(CriarObjetos.criarEndereco());
		comprador6.setTelefone("(75)3333-3333");
		comprador6.setEmail("alysson@email.com");
		comprador6.setDocumento(6666);
		
		Comprador comprador7 = new Comprador();
		comprador7.setNome("Gabriela Porto");
		comprador7.setEndereco(CriarObjetos.criarEndereco());
		comprador7.setTelefone("(75)4444-4444");
		comprador7.setEmail("gabi@email.com");
		comprador7.setDocumento(7777);
		
		Comprador comprador8 = new Comprador();
		comprador8.setNome("Nadine Cerqueira");
		comprador8.setEndereco(CriarObjetos.criarEndereco());
		comprador8.setTelefone("(75)5555-5555");
		comprador8.setEmail("nadi@email.com");
		comprador8.setDocumento(8888);
		
		Comprador comprador9 = new Comprador();
		comprador9.setNome("Tinashe");
		comprador9.setEndereco(CriarObjetos.criarEndereco());
		comprador9.setTelefone("(75)3232-3232");
		comprador9.setEmail("tee@email.com");
		comprador9.setDocumento(9999);

		/* Registra os compradores criados no sistema. */
		
		try {
			controllerAdministrador.cadastrarComprador(comprador0);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador1);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador2);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador3);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador4);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador5);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador6);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador7);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador8);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador9);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		controllerAdministrador.getListaCompradores().mergeSort(2, 5); //ordena os elementos da lista que estão no intervalo de index's que vai de 2 até 5
		
		Iterador i = controllerAdministrador.getListaCompradores().iterador(); //obtém o iterador para a lista "semi-ordenada"
		Comprador auxiliarComprador = null; //referência auxiliar para comprador
		
		/* Obtém cada comprador cadastrado e verifica se a sua posição está condizente com a ordem alfabética. */
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Vinicius de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Rosane Maria Moura de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Driele Alana Ferreira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Ionara Maria de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Souza Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Welligton Carlos Moreira Junior", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Alysson Vilas Boas", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Gabriela Porto", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Nadine Cerqueira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Tinashe", auxiliarComprador.getNome());
		
		assertFalse(i.temProximo());
	}

	@Test
	public void testMerge() {
		/* Cria instância compradores. */

		Comprador comprador0 = new Comprador();
		comprador0.setNome("Valmir Vinicius de Almeida Santos");
		comprador0.setEndereco(CriarObjetos.criarEndereco());
		comprador0.setTelefone("(75)99138-9942");
		comprador0.setEmail("vvalmeida96@gmail.com");
		comprador0.setDocumento(1234);
		
		Comprador comprador1 = new Comprador();
		comprador1.setNome("Rosane Maria Moura de Almeida Santos");
		comprador1.setEndereco(CriarObjetos.criarEndereco());
		comprador1.setTelefone("(75)98122-3263");
		comprador1.setEmail("rosane@email.com.br");
		comprador1.setDocumento(4321);

		Comprador comprador2 = new Comprador();
		comprador2.setNome("Valmir Souza Santos");
		comprador2.setEndereco(CriarObjetos.criarEndereco());
		comprador2.setTelefone("(75)3425-1340");
		comprador2.setEmail("nara@email.com.br");
		comprador2.setDocumento(2222);
		
		Comprador comprador3 = new Comprador();
		comprador3.setNome("Ionara Maria de Almeida Santos");
		comprador3.setEndereco(CriarObjetos.criarEndereco());
		comprador3.setTelefone("(75)98102-4907");
		comprador3.setEmail("valmir@email.com.br");
		comprador3.setDocumento(3333);
		
		Comprador comprador4 = new Comprador();
		comprador4.setNome("Driele Alana Ferreira");
		comprador4.setEndereco(CriarObjetos.criarEndereco());
		comprador4.setTelefone("(75)1111-11111");
		comprador4.setEmail("driele@email.com");
		comprador4.setDocumento(4444);
		
		Comprador comprador5 = new Comprador();
		comprador5.setNome("Welligton Carlos Moreira Junior");
		comprador5.setEndereco(CriarObjetos.criarEndereco());
		comprador5.setTelefone("(75)2222-2222");
		comprador5.setEmail("wellington@email.com");
		comprador5.setDocumento(5555);
		
		Comprador comprador6 = new Comprador();
		comprador6.setNome("Alysson Vilas Boas");
		comprador6.setEndereco(CriarObjetos.criarEndereco());
		comprador6.setTelefone("(75)3333-3333");
		comprador6.setEmail("alysson@email.com");
		comprador6.setDocumento(6666);
		
		Comprador comprador7 = new Comprador();
		comprador7.setNome("Gabriela Porto");
		comprador7.setEndereco(CriarObjetos.criarEndereco());
		comprador7.setTelefone("(75)4444-4444");
		comprador7.setEmail("gabi@email.com");
		comprador7.setDocumento(7777);
		
		Comprador comprador8 = new Comprador();
		comprador8.setNome("Nadine Cerqueira");
		comprador8.setEndereco(CriarObjetos.criarEndereco());
		comprador8.setTelefone("(75)5555-5555");
		comprador8.setEmail("nadi@email.com");
		comprador8.setDocumento(8888);
		
		Comprador comprador9 = new Comprador();
		comprador9.setNome("Tinashe");
		comprador9.setEndereco(CriarObjetos.criarEndereco());
		comprador9.setTelefone("(75)3232-3232");
		comprador9.setEmail("tee@email.com");
		comprador9.setDocumento(9999);

		/* Registra os compradores criados no sistema. */
		
		try {
			controllerAdministrador.cadastrarComprador(comprador0);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador1);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador2);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador3);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador4);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador5);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador6);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador7);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador8);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador9);
		} catch (CompradorNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		/* Para testar o passo de fusão (merge) da ordenação primeiramente será ordenado um par, em seguida o
		 * par adjacente deste será também ordenado e por fim os dois pares serão fundidos ordenadamente.
		 */
		
		controllerAdministrador.getListaCompradores().merge(0, 1); //ordena o par de compradores que possuem index 0 e 1
		
		Iterador i = controllerAdministrador.getListaCompradores().iterador(); //obtém o iterador da lista de compradores após a ordenação de um par
		Comprador auxiliarComprador = null; //referência auxiliar para um comprador
		
		/* Verifica se o par foi ordenado corretamente. */
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Rosane Maria Moura de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Vinicius de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Souza Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Ionara Maria de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Driele Alana Ferreira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Welligton Carlos Moreira Junior", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Alysson Vilas Boas", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Gabriela Porto", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Nadine Cerqueira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Tinashe", auxiliarComprador.getNome());
		
		assertFalse(i.temProximo());
		
		
		controllerAdministrador.getListaCompradores().merge(2, 3); //ordena o par de compradores que possui index 2 e 3

		i = controllerAdministrador.getListaCompradores().iterador(); //obtém o iterador para a lista depois da ordenação do par
		
		/* Verifica se o par foi ordenado corretamente. */

		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Rosane Maria Moura de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Vinicius de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Ionara Maria de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Souza Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Driele Alana Ferreira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Welligton Carlos Moreira Junior", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Alysson Vilas Boas", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Gabriela Porto", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Nadine Cerqueira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Tinashe", auxiliarComprador.getNome());
		
		assertFalse(i.temProximo());
		
		
		controllerAdministrador.getListaCompradores().merge(0, 3); //faz o processo de fusão ordenada dos dois pares anteriormente ordenados
		
		i = controllerAdministrador.getListaCompradores().iterador(); //obtém o iterador da lista após a fusão dos pares
		
		auxiliarComprador = null;

		
		/* Verifica se a fusão ordenada dos pares foi realizada corretamente. */
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Ionara Maria de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Rosane Maria Moura de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Souza Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Valmir Vinicius de Almeida Santos", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Driele Alana Ferreira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Welligton Carlos Moreira Junior", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Alysson Vilas Boas", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Gabriela Porto", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Nadine Cerqueira", auxiliarComprador.getNome());
		
		assertTrue(i.temProximo());
		
		auxiliarComprador = (Comprador) i.obterProximo();
		
		assertEquals("Tinashe", auxiliarComprador.getNome());
		
		assertFalse(i.temProximo());
	}

}
