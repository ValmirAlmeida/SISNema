package br.uefs.ecomp.sisNema.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.sisNema.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNuloException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNuloException;
import br.uefs.ecomp.sisNema.exceptions.FanHabilitadoInexistenteException;
import br.uefs.ecomp.sisNema.exceptions.HorarioImproprioException;
import br.uefs.ecomp.sisNema.exceptions.IntervaloMinimoInsuficienteException;
import br.uefs.ecomp.sisNema.exceptions.LimiteIngressosExcedidoException;
import br.uefs.ecomp.sisNema.exceptions.LimiteSalasExcedidoException;
import br.uefs.ecomp.sisNema.exceptions.SalaNaoEncontradaException;
import br.uefs.ecomp.sisNema.exceptions.SalaNulaException;
import br.uefs.ecomp.sisNema.exceptions.SessaoNaoEncontradaException;
import br.uefs.ecomp.sisNema.exceptions.SessaoNulaException;
import br.uefs.ecomp.sisNema.model.Cinema;
import br.uefs.ecomp.sisNema.model.Comprador;
import br.uefs.ecomp.sisNema.model.CompradorFan;
import br.uefs.ecomp.sisNema.model.Endereco;
import br.uefs.ecomp.sisNema.model.Sala;
import br.uefs.ecomp.sisNema.model.Sessao;
import br.uefs.ecomp.sisNema.util.CriarObjetos;
import br.uefs.ecomp.sisNema.util.Iterador;

public class DistribuicaoCamisasTest {

	private AdministradorController controllerAdministrador;
	private CompradorController controllerComprador;
	
	@Before
	public void setUp() throws Exception {
		AdministradorController.zerarSingleton();
		controllerAdministrador = AdministradorController.getInstance();
		controllerComprador = CompradorController.getInstance();
	}
	
	@Test
	public void testDistribuirCamisasSucesso() {
		Endereco end = CriarObjetos.criarEndereco();
		
		/* Objetos do tipo cinema, sala, sess�o, comprador e compradorFan s�o criados. */
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		Sessao sessao = new Sessao();
		sessao.setHoraInicio(15);
		sessao.setHoraFim(17);
		
		Comprador comprador = new Comprador();
		comprador.setNome("Fulano de Tal");
		comprador.setEndereco(end);
		comprador.setTelefone("(75)3489-1263");
		comprador.setEmail("fulano@tal.com.br");
		comprador.setDocumento(1234);
		
		CompradorFan comprador2 = new CompradorFan();
		comprador2.setNome("Fulano de Tal 2");
		comprador2.setEndereco(end);
		comprador2.setTelefone("(75)3489-1263");
		comprador2.setEmail("fulano2@tal.com.br");
		comprador2.setDocumento(1236);
		comprador2.setRegistro(2098);
		
		CompradorFan comprador3 = new CompradorFan();
		comprador3.setNome("Fulano de Tal 3");
		comprador3.setEndereco(end);
		comprador3.setTelefone("(75)3489-1263");
		comprador3.setEmail("fulano3@tal.com.br");
		comprador3.setDocumento(1238);
		comprador3.setRegistro(2099);
		
		
		/* Os objetos s�o cadastrados no sistema. */
		
		try {
			cine = controllerAdministrador.cadastrarCinema(cine);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarSala(cine,sala);
		} catch (SalaNulaException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarSessao(cine,sala,sessao);
		} catch (CinemaNuloException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SessaoNulaException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (IntervaloMinimoInsuficienteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (HorarioImproprioException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador);
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
		
		
		int qtdIngressos = 3;
		
		/* Compras com os objetos anteriormente cadastrados s�o realizadas, certificando-se de que n�o h�
		 * nenhum erro nas opera��es.
		 */
		
		try {
			controllerComprador.comprarIngresso(comprador.getDocumento(),cine.getId(),1,15,qtdIngressos,60.00);
		} catch (CompradorNaoEncontradoException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (SessaoNaoEncontradaException e) {
			fail();
		} catch (LimiteIngressosExcedidoException e) {
			fail();
		}
		
		try {
			controllerComprador.comprarIngresso(comprador2.getDocumento(),cine.getId(),1,15,qtdIngressos,60.00);
		} catch (CompradorNaoEncontradoException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (SessaoNaoEncontradaException e) {
			fail();
		} catch (LimiteIngressosExcedidoException e) {
			fail();
		}
		
		try {
			controllerComprador.comprarIngresso(comprador3.getDocumento(),cine.getId(),1,15,qtdIngressos, 60.00);
		} catch (CompradorNaoEncontradoException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (SessaoNaoEncontradaException e) {
			fail();
		} catch (LimiteIngressosExcedidoException e) {
			fail();
		}
		
		/* Verifica se o n�mero de f�s habilitados condiz com a quantidade de f�s que realizaram compras. */
		
        try {
			assertEquals(2,controllerAdministrador.recuperarFansHabilitados().obterTamanho());
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
		
		Iterador i = null;
		
		try {
			i = controllerAdministrador.recuperarFansHabilitados().iterador(); //tenta obter o iterador para a fila de f�s habilitados
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
				
		/* Verifica se os dados obtidos da fila de f�s habilitados condiz com as vendas realizadas. */
		
		assertEquals(true,i.temProximo());
		CompradorFan compradorTeste = (CompradorFan)i.obterProximo();
		assertEquals(2098,compradorTeste.getRegistro());
		
		assertEquals(true,i.temProximo());
		compradorTeste = (CompradorFan)i.obterProximo();
		assertEquals(2099,compradorTeste.getRegistro());
		
		assertEquals(false,i.temProximo());
		
		/* Clausulas catch para a exce��o FanHabilitadoInexistenteException foram adicionadas aos blocos
		 * try/catch que cont�m chamada ao m�todo distribuirCamisas.
		 */
		
		/* Verifica se a opera��o de distribuir camisa para um f� ocorre corretamente. */
		
		try {
			controllerAdministrador.distribuirCamisas(1);
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
		
        try {
			i = controllerAdministrador.recuperarFansHabilitados().iterador(); //obt�m o iterador para a fila ap�s a distribui��o
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
		
        /* Verifica se o f� que resta na fila � o segundo que realizou a compra. */
        
		assertEquals(true,i.temProximo());
		compradorTeste = (CompradorFan)i.obterProximo();
		assertEquals(2099,compradorTeste.getRegistro());
		
	}
	
	@Test
	public void testDistribuirMaisCamisasDoQueDisponivel() {
		Endereco end = CriarObjetos.criarEndereco();
		
		/* Objetos do tipo cinema, sala, sess�o, comprador e compradorFan s�o criados. */

		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		Sessao sessao = new Sessao();
		sessao.setHoraInicio(15);
		sessao.setHoraFim(17);
		
		Comprador comprador = new Comprador();
		comprador.setNome("Fulano de Tal");
		comprador.setEndereco(end);
		comprador.setTelefone("(75)3489-1263");
		comprador.setEmail("fulano@tal.com.br");
		comprador.setDocumento(1234);
		
		CompradorFan comprador2 = new CompradorFan();
		comprador2.setNome("Fulano de Tal 2");
		comprador2.setEndereco(end);
		comprador2.setTelefone("(75)3489-1263");
		comprador2.setEmail("fulano2@tal.com.br");
		comprador2.setDocumento(1236);
		comprador2.setRegistro(2098);
		
		CompradorFan comprador3 = new CompradorFan();
		comprador3.setNome("Fulano de Tal 3");
		comprador3.setEndereco(end);
		comprador3.setTelefone("(75)3489-1263");
		comprador3.setEmail("fulano3@tal.com.br");
		comprador3.setDocumento(1238);
		comprador3.setRegistro(2099);
		
		/* Os objetos s�o cadastrados no sistema. */
		
		try {
			cine = controllerAdministrador.cadastrarCinema(cine);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarSala(cine,sala);
		} catch (SalaNulaException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarSessao(cine,sala,sessao);
		} catch (CinemaNuloException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SessaoNulaException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (IntervaloMinimoInsuficienteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (HorarioImproprioException e) {
			fail();
		}
		
		try {
			controllerAdministrador.cadastrarComprador(comprador);
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
		
		/* Compras com os objetos anteriormente cadastrados s�o realizadas, certificando-se de que n�o h�
		 * nenhum erro nas opera��es.
		 */
		
		int qtdIngressos = 3;
		
		try {
			controllerComprador.comprarIngresso(comprador.getDocumento(),cine.getId(),1,15,qtdIngressos,60.00);
		} catch (CompradorNaoEncontradoException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (SessaoNaoEncontradaException e) {
			fail();
		} catch (LimiteIngressosExcedidoException e) {
			fail();
		}
		
		try {
			controllerComprador.comprarIngresso(comprador2.getDocumento(),cine.getId(),1,15,qtdIngressos,60.00);
		} catch (CompradorNaoEncontradoException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (SessaoNaoEncontradaException e) {
			fail();
		} catch (LimiteIngressosExcedidoException e) {
			fail();
		}
		
		try {
			controllerComprador.comprarIngresso(comprador3.getDocumento(),cine.getId(),1,15,qtdIngressos, 60.00);
		} catch (CompradorNaoEncontradoException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (SessaoNaoEncontradaException e) {
			fail();
		} catch (LimiteIngressosExcedidoException e) {
			fail();
		}
		
		Iterador i = null;
		
		try {
			i = controllerAdministrador.recuperarFansHabilitados().iterador(); //obt�m o iterador para a fila de f�s habilitados ap�s as compras
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
		
		/* Verifica se os f�s que est�o na fila condizem com as informa��es das compras. */
		
		assertEquals(true,i.temProximo());
		CompradorFan compradorTeste = (CompradorFan)i.obterProximo();
		assertEquals(2098,compradorTeste.getRegistro());
		
		assertEquals(true,i.temProximo());
		compradorTeste = (CompradorFan)i.obterProximo();
		assertEquals(2099,compradorTeste.getRegistro());
		
		assertEquals(false,i.temProximo());
		
		/* Distribui camisa para um f�. */
		
		try {
			controllerAdministrador.distribuirCamisas(1);
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
		
		
		try {
			i = controllerAdministrador.recuperarFansHabilitados().iterador(); //obt�m o iterador da fila ap�s a distribui��o de camisa para um f�
		} catch (FanHabilitadoInexistenteException e) {
			fail();
		}
		
		/* Verifica se o f� que resta na fila � o segundo que realizou a compra. */
		assertEquals(true,i.temProximo());
		
		compradorTeste = (CompradorFan)i.obterProximo();
		assertEquals(2099,compradorTeste.getRegistro());
		
		assertEquals(false,i.temProximo());
		
		/* Tenta distribuir camisas para mais f�s do que a quantidade dispon�vel na fila de f�s habilitados. */
		try {
	        controllerAdministrador.distribuirCamisas(3);
		} catch (FanHabilitadoInexistenteException e) {
			assertTrue(true);
		}
		
		/* Tenta obter o iterador para a fila de f�s habilitados vazia. */
		try {
			i = controllerAdministrador.recuperarFansHabilitados().iterador();
		} catch (FanHabilitadoInexistenteException e) {
			assertTrue(true);
		}		
	}

}