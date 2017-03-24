/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: Valmir Vinicius de Almeida Santos
 * Data: 07/03/2016
 *
 * Declaro que este c�digo foi elaborado por mim de forma individual e
 * n�o cont�m nenhum trecho de c�digo de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e p�ginas ou documentos 
 * eletr�nicos da Internet. Qualquer trecho de c�digo de outra autoria que
 * uma cita��o para o  n�o a minha est� destacado com  autor e a fonte do
 * c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins
 * de avalia��o. Alguns trechos do c�digo podem coincidir com de outros
 * colegas pois estes foram discutidos em sess�es tutorias.
 */


package br.uefs.ecomp.sisNema.controller;

/**
 * Classe respons�vel por gerenciar as opera��es realizadas por um comprador no sistema. Atrav�s dela ser� efetivado
 * o processo de compra de ingressos, al�m de permitir a recupera��o de todos os ingressos comprados por um cliente.
 * 
 * @author Valmir Vinicius
 */

import br.uefs.ecomp.sisNema.exceptions.CinemaNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNuloException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNuloException;
import br.uefs.ecomp.sisNema.exceptions.LimiteIngressosExcedidoException;
import br.uefs.ecomp.sisNema.exceptions.SalaNaoEncontradaException;
import br.uefs.ecomp.sisNema.exceptions.SalaNulaException;
import br.uefs.ecomp.sisNema.exceptions.SessaoNaoEncontradaException;
import br.uefs.ecomp.sisNema.model.Cinema;
import br.uefs.ecomp.sisNema.model.Comprador;
import br.uefs.ecomp.sisNema.model.Ingresso;
import br.uefs.ecomp.sisNema.model.Sala;
import br.uefs.ecomp.sisNema.model.Sessao;
import br.uefs.ecomp.sisNema.model.Venda;
import br.uefs.ecomp.sisNema.util.Iterador;
import br.uefs.ecomp.sisNema.util.ListaEncadeada;

public class CompradorController {
	/** Inst�ncia �nica da classe. */
	private static CompradorController instanciaUnica;
	
	/**
	 * Construtor vazio da classe.
	 */
	private CompradorController() {
		/* Esse construtor foi criado apenas para impedir o instanciamento da classe fora dela. */
	}
	
	/**
	 * Obt�m refer�ncia para a inst�ncia �nica (Singleton) da classe. 
	 * @return refer�ncia para a inst�ncia �nica
	 */
	public static CompradorController getInstance() {
		if(instanciaUnica == null) { //verifica se a inst�ncia �nica atual � nula
			instanciaUnica = new CompradorController(); //cria uma nova inst�ncia �nica se a condi��o for verdadeira
		}
				
		return instanciaUnica; //retorna refer�ncia para inst�ncia �nica
	}
	
	/**
	 * Realiza a compra de um ingresso para um cinema informado, caso as informa��es passadas sejam v�lidas.
	 * @param documento n�mero de documento do comprador
	 * @param idCinema n�mero de identifica��o �nica do cinema para o qual ser� comprado ingresso
	 * @param numeroSala n�mero da sala em que ocorrer� a sess�o
	 * @param horaInicio hora de in�cio da sess�o desejada
	 * @param qtdIngressos quantidade de ingressos a ser comprada
	 * @param valorTotal valor total da compra
	 * @throws CompradorNaoEncontradoException se n�o foi encontrado cadastro do comprador no sistema
	 * @throws CinemaNaoEncontradoException se n�o for encontrado cadastro no sistema do cinema cujo ID foi informado
	 * @throws SalaNaoEncontradaException se n�o for encontrado um cadastro da sala cujo n�mero foi informado
	 * @throws SessaoNaoEncontradaException se n�o for encontrado cadastro pr�vio da sess�o informada
	 * @throws LimiteIngressosExcedidoException se a quantidade de ingressos vendidos para a sess�o for igual ao n�mero de cadeiras dispon�veis na sala
	 */
	public void comprarIngresso(int documento, int idCinema, int numeroSala, int horaInicio, int qtdIngressos, double valorTotal) throws CompradorNaoEncontradoException, CinemaNaoEncontradoException, SalaNaoEncontradaException, SessaoNaoEncontradaException, LimiteIngressosExcedidoException {
		AdministradorController controllerAdministrador = AdministradorController.getInstance(); //obt�m refer�ncia para a inst�ncia �nica do AdministradorController

		/* Referencias auxiliares que ser�o utilizadas no processo da compra. */
		Comprador comprador = null;
		Cinema cinema = null;
		Sala sala = null;
		Sessao sessao = null;
		
		try {
			comprador = controllerAdministrador.recuperarComprador(documento); //tenta recuperar o cadastro de um comprador
		} catch (CompradorNaoEncontradoException e) {
			throw e; //relan�a exce��o caso o cadastro n�o seja encontrado
		}
		
		try {
			cinema = controllerAdministrador.recuperarCinema(idCinema); //tenta recuperar o cadastro de um cinema
		} catch (CinemaNaoEncontradoException e) {
			throw e; //relan�a exce��o caso o cadastro do cinema n�o seja encontrado
		}
		
		try {
			sala = controllerAdministrador.recuperarSala(cinema, numeroSala); //tenta recuperar o cadastro de uma sala em um cinema informado
		} catch (SalaNaoEncontradaException e) {
			throw e; //relan�a exce��o caso o cadastro da sala n�o seja encontrado
		} catch (CinemaNuloException e) {
			throw new SalaNaoEncontradaException(e); //lan�a exce��o encadeada de sala n�o encontrada com a sua respectiva causa
		} 
		
		try {
			sessao = controllerAdministrador.recuperarSessao(cinema, sala, horaInicio); //tenta recuperar o cadastro de uma sess�o em uma sala de um cinema
		} catch (SessaoNaoEncontradaException e) {
			throw e; //relan�a exce��o caso o cadastro da sess�o n�o seja encontrado
		} catch (CinemaNuloException | SalaNulaException e){
			throw new SessaoNaoEncontradaException(e); //lan�a exce��o encadeada de sess�o n�o encontrada com a sua respectiva causa
		}
		
		/* � v�lido evidenciar que os blocos referentes a CinemaNuloException e SalaNulaException nas duas �ltimas
		 * instru��es try acima nunca v�o ocorrer, pois j� foi garantido nas duas primeiras instru��es catch que 
		 * tanto cinema quando sala n�o ser�o nulos. Entretanto, foi necess�rio criar um bloco catch para capturar
		 * essas exce��es, caso contr�rio um erro de compila��o seria gerado.
		 */
		
		int ingressosVendidos = 0; //vari�vel auxiliar para armazenar o n�mero de ingressos que j� foi vendido para a sess�o em quest�o
		Iterador iterador = controllerAdministrador.listarVendas(); //obt�m o iterador para a lista de Vendas
		Venda auxiliarVenda = null; //refer�ncia auxiliar para uma venda
		
		while(iterador.temProximo()) { //verifica se h� um pr�ximo registro de venda
			auxiliarVenda =  (Venda) iterador.obterProximo(); //obt�m refer�ncia para um registro de venda
			
			/* Na condi��o abaixo ocorrem as verifica��es para certificar que os dados da venda obtida na itera��o 
			 * correspondem aos dados da venda que se deseja realizar. De forma que, se a condi��o for verdadeira
			 * a vari�vel utilizada para contabilizar o n�mero de ingressos vendidos � incrementada com 1.
			 */
			if(auxiliarVenda.getIngresso().getCinema().getId() == idCinema && auxiliarVenda.getIngresso().getSala().getNumeroSala() == numeroSala && auxiliarVenda.getIngresso().getSessao().getHoraInicio() == horaInicio) {
				ingressosVendidos += auxiliarVenda.getQtdIngressos();
			}
		}
		
		if(ingressosVendidos >= sala.getQtdCadeiras()) { //verifica se o n�mero e ingressos vendidos � maior ou igual � quantidade de cadeiras dispon�veis na sala
			throw new LimiteIngressosExcedidoException(); //lan�a exce��o correspondente caso o n�mero m�ximo de ingressos para a sala tenha sido atingido
		}
		
		Ingresso novoIngresso = new Ingresso(); //cria uma nova inst�ncia de ingresso
	
		/* As informa��es adequadas s�o armazenadas no ingresso. */
		novoIngresso.setCinema(cinema);
		novoIngresso.setSala(sala);
		novoIngresso.setSessao(sessao);
		
		Venda novaVenda = new Venda(); //cria uma nova inst�ncia de venda
		
		/* As informa��es adequadas s�o armazenadas na venda. */
		novaVenda.setIngresso(novoIngresso); 
		novaVenda.setComprador(comprador);
		novaVenda.setQtdIngressos(qtdIngressos);
		novaVenda.setValorTotal(valorTotal);
		
		controllerAdministrador.registrarVendas(novaVenda); //registra a nova venda na lista encadeada adequada
	}

	/**
	 * Fornece a refer�ncia para uma lista encadeada de ingressos comprados por um comprador, caso a refer�ncia
	 * de comprador informada seja v�lida.
	 * @param comprador refer�ncia para um comprador
	 * @return refer�ncia para uma lista de ingressos vendidos ao comprador informado
	 * @throws CompradorNuloException se o comprador informado for nulo
	 * @throws CompradorNaoEncontradoException se n�o foi encontrado cadastro do comprador no sistema
	 */
	public ListaEncadeada recuperarIngressos(Comprador comprador) throws CompradorNuloException, CompradorNaoEncontradoException {
		AdministradorController controllerAdministrador = AdministradorController.getInstance(); //obt�m refer�ncia para a inst�ncia �nica do AdministradorController
		
		if(comprador == null) { //verifica se a refer�ncia de comprador informada � nula
			throw new CompradorNuloException(); //lan�a exce��o correspondente caso a refer�ncia de comprador seja nula
		} else {
			try {
				controllerAdministrador.recuperarComprador(comprador.getDocumento()); //tenta encontrar o cadastro do comprador em quest�o
			} catch (CompradorNaoEncontradoException e) {
				throw e; //relan�a exce��o indicando que n�o existe cadastro do comprador informado
			}
		}

		
		Iterador iterador = controllerAdministrador.listarVendas(); //obt�m iterador para a lista encadeada de vendas
		Venda auxiliarVenda = null; //refer�ncia auxiliar para uma venda
		int contador = 0; //contador para gerenciar a inser��o da quantidade adequada de ingressos na lista
		ListaEncadeada listaIngressos = new ListaEncadeada(); //cria uma nova inst�ncia de lista encadeada
		
		
		while(iterador.temProximo()) { //verifica se h� uma pr�xima venda
			auxiliarVenda = (Venda) iterador.obterProximo(); //obt�m a refer�ncia para uma venda
			
			if(auxiliarVenda.getComprador().getDocumento() == comprador.getDocumento()) { //verifica se o comprador obtido � o desejado
				while(contador < auxiliarVenda.getQtdIngressos()) { //enquanto todos os ingressos da venda n�o tiverem sido inseridos na lista
					listaIngressos.inserirFinal(auxiliarVenda.getIngresso()); //insere um ingresso na lista
					contador++; //incrementa um no contador
				}
			}
			
			contador = 0; //zera o contador
		}
		
		return listaIngressos; //retorna a lista com todos os ingressos vendidos ao comprador em quest�o
	}
}
