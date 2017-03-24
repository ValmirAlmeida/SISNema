package br.uefs.ecomp.sisNema.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import br.uefs.ecomp.sisNema.controller.AdministradorController;
import br.uefs.ecomp.sisNema.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNuloException;
import br.uefs.ecomp.sisNema.exceptions.LimiteSalasExcedidoException;
import br.uefs.ecomp.sisNema.exceptions.SalaNaoEncontradaException;
import br.uefs.ecomp.sisNema.exceptions.SalaNulaException;
import br.uefs.ecomp.sisNema.util.CriarObjetos;
import br.uefs.ecomp.sisNema.util.Iterador;

public class SalaTest {

	private AdministradorController controllerAdministrador;
	
	@Before
	public void setUp() throws Exception {
		AdministradorController.zerarSingleton();
		controllerAdministrador = AdministradorController.getInstance();
	}
	
	@Test
	public void testListarSalasSucesso() {
		int id = 0;
		
		try {
			id = CriarObjetos.criarCinema(controllerAdministrador);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		Cinema cine = null;
		try {
			cine = controllerAdministrador.recuperarCinema(id);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}

		try {
			CriarObjetos.criarSala(cine, controllerAdministrador);
		} catch (CinemaNaoEncontradoException e1) {
			fail();
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
		/* A lista � percorrida a partir do iterador obtido e atrav�s do contador � poss�vel certificar se
		 * a quantidade de salas encontradas condiz com a quantidade anteriormente cadastrada e se 
		 * os dados s�o iguais.
		 */
		
		int cont = 0;
		Iterador i = controllerAdministrador.listarSalas(cine);
		
		while(i.temProximo()) {
			i.obterProximo();
			cont++;
		}
		
		assertEquals(1, cont);
	}
	
	@Test
	public void testCadastrarSalaSucesso() {
		
		int id = 0;
		
		try {
			id = CriarObjetos.criarCinema(controllerAdministrador);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		Cinema cine = null;
		try {
			cine = controllerAdministrador.recuperarCinema(id);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}

		try {
			CriarObjetos.criarSala(cine, controllerAdministrador);
		} catch (CinemaNaoEncontradoException e1) {
			fail();
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
		assertEquals(1,cine.getSalas().obterTamanho());
		
		Sala salaTeste = null;
		Iterador i = cine.getSalas().iterador();
		while(i.temProximo()){
			salaTeste = (Sala)i.obterProximo();
		}
		assertEquals(1,salaTeste.getNumeroSala());
		assertEquals(300,salaTeste.getQtdCadeiras());
	}
	
	@Test
	public void testCadastrarSalaEmCinemaNaoCadastrado() {
		Endereco end = CriarObjetos.criarEndereco(); 
		
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.cadastrarSala(cine,sala);
			fail();
		}catch(CinemaNaoEncontradoException cause){
			assertTrue(true);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
	}
	
	@Test
	public void testCadastrarSalaEmCinemaNulo() {
		
		Cinema cine = null;
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.cadastrarSala(cine,sala);
			fail();
		}catch(CinemaNuloException cause){
			assertTrue(true);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
	}
	
	@Test
	public void testCadastrarSalaSemNumero() {
		
		Endereco end = CriarObjetos.criarEndereco();
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		try {
			cine = controllerAdministrador.cadastrarCinema(cine);
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e1) {
			fail();
		}
		
		Sala sala = new Sala();
		sala.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.cadastrarSala(cine,sala);
			fail();
		}catch(CampoObrigatorioInexistenteException cause){
			assertTrue(true);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
	}
	
	@Test
	public void testCadastrarSalaSemQtdCadeiras() {
		
		Endereco end = CriarObjetos.criarEndereco();
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		try {
			cine = controllerAdministrador.cadastrarCinema(cine);
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e1) {
			fail();
		}
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		
		try{
			controllerAdministrador.cadastrarSala(cine,sala);
			fail();
		}catch(CampoObrigatorioInexistenteException cause){
			assertTrue(true);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
	}
	
	@Test
	public void testCadastrarSalaNula() {
		
		Endereco end = CriarObjetos.criarEndereco();
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		try {
			cine = controllerAdministrador.cadastrarCinema(cine);
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e1) {
			fail();
		}
		
		Sala sala = null;
		
		try{
			controllerAdministrador.cadastrarSala(cine,sala);
			fail();
		}catch(SalaNulaException cause){
			assertTrue(true);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
	}
	
	@Test
	public void testCadastrarMaisSalasQueOPermitido() {
		
		Endereco end = CriarObjetos.criarEndereco();
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(1);
		cine.setEndereco(end);
		
		try {
			cine = controllerAdministrador.cadastrarCinema(cine);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}

		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
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
		
		Sala sala2 = new Sala();
		sala2.setNumeroSala(2);
		sala2.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.cadastrarSala(cine,sala2);
			fail();
		}catch(LimiteSalasExcedidoException cause){
			assertTrue(true);
		} catch (SalaNulaException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
	}
	
	@Test
	public void testAlterarSalaSucesso() {
		
		int id = 0;
		
		try {
			id = CriarObjetos.criarCinema(controllerAdministrador);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		Cinema cine = null;
		try {
			cine = controllerAdministrador.recuperarCinema(id);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}

		try {
			CriarObjetos.criarSala(cine, controllerAdministrador);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
		assertEquals(1,cine.getSalas().obterTamanho());
		
		Sala salaTeste = null;;
		Iterador i = cine.getSalas().iterador();
		while(i.temProximo()){
			salaTeste = (Sala)i.obterProximo();
		}
		assertEquals(1,salaTeste.getNumeroSala());
		assertEquals(300,salaTeste.getQtdCadeiras());
		
		salaTeste.setQtdCadeiras(200);
		
		try {
			controllerAdministrador.alterarSala(cine,salaTeste.getNumeroSala(), salaTeste.getNumeroSala(), salaTeste.getQtdCadeiras());
		} catch (CampoObrigatorioInexistenteException e1) {
			fail();
		} catch (SalaNaoEncontradaException e1) {
			fail();
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CinemaNaoEncontradoException e1) {
			fail();
		}
		
		
        try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
		assertEquals(1,cine.getSalas().obterTamanho());
		
		Iterador i2 = cine.getSalas().iterador();
		while(i2.temProximo()){
			salaTeste = (Sala)i2.obterProximo();
		}
		assertEquals(1,salaTeste.getNumeroSala());
		assertEquals(200,salaTeste.getQtdCadeiras());
	}
	
	@Test
	public void testAlterarSalaEmCinemaNaoCadastrado() {
		
		Endereco end = CriarObjetos.criarEndereco();
		
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.alterarSala(cine,sala.getNumeroSala(), sala.getNumeroSala(), sala.getQtdCadeiras());
			fail();
		}catch(CinemaNaoEncontradoException cause){
			assertTrue(true);
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		}
		
		
	}
	
	@Test
	public void testAlterarSalaEmCinemaNulo() {
		
		Cinema cine = null;
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.alterarSala(cine,sala.getNumeroSala(), sala.getNumeroSala(), sala.getQtdCadeiras());
			fail();
		}catch(CinemaNuloException cause){
			assertTrue(true);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNaoEncontradaException e) {
			fail();
		}
		
	}
	
	@Test
	public void testAlterarSalaInexistente() {
		
		int id = 0;
		
		try {
			id = CriarObjetos.criarCinema(controllerAdministrador);
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e1) {
			fail();
		}
		
		Cinema cine = null;
		
		try {
			cine = controllerAdministrador.recuperarCinema(id);
		} catch (CinemaNaoEncontradoException e1) {
			fail();
		}

		try {
			CriarObjetos.criarSala(cine, controllerAdministrador);
		} catch (CinemaNaoEncontradoException e1) {
			fail();
		} catch (CinemaNuloException e1) {
			fail();
		} catch (CampoObrigatorioInexistenteException e1) {
			fail();
		} catch (SalaNulaException e1) {
			fail();
		} catch (LimiteSalasExcedidoException e1) {
			fail();
		}
		
		try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e1) {
			fail();
		}
		
		assertEquals(1,cine.getSalas().obterTamanho());
		
		Sala salaTeste = null;
		Iterador i = cine.getSalas().iterador();
		while(i.temProximo()){
			salaTeste = (Sala)i.obterProximo();
		}
		assertEquals(1,salaTeste.getNumeroSala());
		assertEquals(300,salaTeste.getQtdCadeiras());
		
		
		Sala sala = new Sala();
		sala.setNumeroSala(2);
		sala.setQtdCadeiras(300);
		
		try{
			controllerAdministrador.alterarSala(cine,sala.getNumeroSala(), sala.getNumeroSala(), sala.getQtdCadeiras());
			fail();
		}catch(SalaNaoEncontradaException cause){
			assertTrue(true);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} 
		

	}
	
	@Test
	public void testAlterarSalaSemNumero() {
		
		int id = 0;
		
		try {
			id = CriarObjetos.criarCinema(controllerAdministrador);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		Cinema cine = null;
		try {
			cine = controllerAdministrador.recuperarCinema(id);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}

		try {
			CriarObjetos.criarSala(cine, controllerAdministrador);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
		assertEquals(1,cine.getSalas().obterTamanho());
		
		Sala salaTeste = null;
		Iterador i = cine.getSalas().iterador();
		while(i.temProximo()){
			salaTeste = (Sala)i.obterProximo();
		}
		assertEquals(1,salaTeste.getNumeroSala());
		assertEquals(300,salaTeste.getQtdCadeiras());
		
		salaTeste.setNumeroSala(0);
		int novaQtdCadeiras = 200;

		try{
			controllerAdministrador.alterarSala(cine,salaTeste.getNumeroSala(), salaTeste.getNumeroSala(), novaQtdCadeiras);
			fail();
		}catch(CampoObrigatorioInexistenteException cause){
			assertTrue(true);
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
	}
	
	@Test
	public void testAlterarSalaSemQtdCadeiras() {
		
		int id = 0;
		
		try {
			id = CriarObjetos.criarCinema(controllerAdministrador);
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		Cinema cine = null;
		
		try {
			cine = controllerAdministrador.recuperarCinema(id);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}

		try {
			CriarObjetos.criarSala(cine, controllerAdministrador);
		} catch (CinemaNaoEncontradoException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (SalaNulaException e) {
			fail();
		} catch (LimiteSalasExcedidoException e) {
			fail();
		}
		
		try {
			cine = controllerAdministrador.recuperarCinema(cine.getId());
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
		
		assertEquals(1,cine.getSalas().obterTamanho());
		
		Sala salaTeste = null;
		Iterador i = cine.getSalas().iterador();
		while(i.temProximo()){
			salaTeste = (Sala)i.obterProximo();
		}
		assertEquals(1,salaTeste.getNumeroSala());
		assertEquals(300,salaTeste.getQtdCadeiras());
		
		int novaQtdCadeiras = 0;
				
		try{
			controllerAdministrador.alterarSala(cine, salaTeste.getNumeroSala(), salaTeste.getNumeroSala(), novaQtdCadeiras);
			fail();
		}catch(CampoObrigatorioInexistenteException cause){
			assertTrue(true);
		} catch (SalaNaoEncontradaException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
	}
	
	@Test
	public void testAlterarSalaNaoCadastrada() {
		Endereco end = CriarObjetos.criarEndereco(); //cria um objeto endereco

		/* Cria objetos cinema e sala. */
		Cinema cine = new Cinema();
		cine.setNome("ORIENT Cineplace Boulevard Shopping");
		cine.setQtdSalas(9);
		cine.setEndereco(end);
		
		Sala sala = new Sala();
		sala.setNumeroSala(1);
		sala.setQtdCadeiras(300);
		
		/* Cadastra o cinema. */
		try{
			controllerAdministrador.cadastrarCinema(cine);
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		}
		
		int novoNumeroSala = 2;
	
		/* Certifica-se que ao tentar realizar a altera��o do cadastro de uma sala n�o cadastrada a exce��o SalaNaoEncontradaException
		 * � lan�ada.
		 */
		try {
			controllerAdministrador.alterarSala(cine,sala.getNumeroSala(), novoNumeroSala, sala.getQtdCadeiras());
		} catch (SalaNaoEncontradaException e) {
			assertTrue(true);
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		} catch (CinemaNuloException e) {
			fail();
		} catch (CinemaNaoEncontradoException e) {
			fail();
		}
	}
}