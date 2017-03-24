/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Valmir Vinicius de Almeida Santos
 * Data: 07/03/2016
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */


package br.uefs.ecomp.sisNema.controller;

/**
 * Classe responsável por gerenciar as operações realizadas por um comprador no sistema. Através dela será efetivado
 * o processo de compra de ingressos, além de permitir a recuperação de todos os ingressos comprados por um cliente.
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
	/** Instância única da classe. */
	private static CompradorController instanciaUnica;
	
	/**
	 * Construtor vazio da classe.
	 */
	private CompradorController() {
		/* Esse construtor foi criado apenas para impedir o instanciamento da classe fora dela. */
	}
	
	/**
	 * Obtém referência para a instância única (Singleton) da classe. 
	 * @return referência para a instância única
	 */
	public static CompradorController getInstance() {
		if(instanciaUnica == null) { //verifica se a instância única atual é nula
			instanciaUnica = new CompradorController(); //cria uma nova instância única se a condição for verdadeira
		}
				
		return instanciaUnica; //retorna referência para instância única
	}
	
	/**
	 * Realiza a compra de um ingresso para um cinema informado, caso as informações passadas sejam válidas.
	 * @param documento número de documento do comprador
	 * @param idCinema número de identificação única do cinema para o qual será comprado ingresso
	 * @param numeroSala número da sala em que ocorrerá a sessão
	 * @param horaInicio hora de início da sessão desejada
	 * @param qtdIngressos quantidade de ingressos a ser comprada
	 * @param valorTotal valor total da compra
	 * @throws CompradorNaoEncontradoException se não foi encontrado cadastro do comprador no sistema
	 * @throws CinemaNaoEncontradoException se não for encontrado cadastro no sistema do cinema cujo ID foi informado
	 * @throws SalaNaoEncontradaException se não for encontrado um cadastro da sala cujo número foi informado
	 * @throws SessaoNaoEncontradaException se não for encontrado cadastro prévio da sessão informada
	 * @throws LimiteIngressosExcedidoException se a quantidade de ingressos vendidos para a sessão for igual ao número de cadeiras disponíveis na sala
	 */
	public void comprarIngresso(int documento, int idCinema, int numeroSala, int horaInicio, int qtdIngressos, double valorTotal) throws CompradorNaoEncontradoException, CinemaNaoEncontradoException, SalaNaoEncontradaException, SessaoNaoEncontradaException, LimiteIngressosExcedidoException {
		AdministradorController controllerAdministrador = AdministradorController.getInstance(); //obtém referência para a instância única do AdministradorController

		/* Referencias auxiliares que serão utilizadas no processo da compra. */
		Comprador comprador = null;
		Cinema cinema = null;
		Sala sala = null;
		Sessao sessao = null;
		
		try {
			comprador = controllerAdministrador.recuperarComprador(documento); //tenta recuperar o cadastro de um comprador
		} catch (CompradorNaoEncontradoException e) {
			throw e; //relança exceção caso o cadastro não seja encontrado
		}
		
		try {
			cinema = controllerAdministrador.recuperarCinema(idCinema); //tenta recuperar o cadastro de um cinema
		} catch (CinemaNaoEncontradoException e) {
			throw e; //relança exceção caso o cadastro do cinema não seja encontrado
		}
		
		try {
			sala = controllerAdministrador.recuperarSala(cinema, numeroSala); //tenta recuperar o cadastro de uma sala em um cinema informado
		} catch (SalaNaoEncontradaException e) {
			throw e; //relança exceção caso o cadastro da sala não seja encontrado
		} catch (CinemaNuloException e) {
			throw new SalaNaoEncontradaException(e); //lança exceção encadeada de sala não encontrada com a sua respectiva causa
		} 
		
		try {
			sessao = controllerAdministrador.recuperarSessao(cinema, sala, horaInicio); //tenta recuperar o cadastro de uma sessão em uma sala de um cinema
		} catch (SessaoNaoEncontradaException e) {
			throw e; //relança exceção caso o cadastro da sessão não seja encontrado
		} catch (CinemaNuloException | SalaNulaException e){
			throw new SessaoNaoEncontradaException(e); //lança exceção encadeada de sessão não encontrada com a sua respectiva causa
		}
		
		/* É válido evidenciar que os blocos referentes a CinemaNuloException e SalaNulaException nas duas últimas
		 * instruções try acima nunca vão ocorrer, pois já foi garantido nas duas primeiras instruções catch que 
		 * tanto cinema quando sala não serão nulos. Entretanto, foi necessário criar um bloco catch para capturar
		 * essas exceções, caso contrário um erro de compilação seria gerado.
		 */
		
		int ingressosVendidos = 0; //variável auxiliar para armazenar o número de ingressos que já foi vendido para a sessão em questão
		Iterador iterador = controllerAdministrador.listarVendas(); //obtém o iterador para a lista de Vendas
		Venda auxiliarVenda = null; //referência auxiliar para uma venda
		
		while(iterador.temProximo()) { //verifica se há um próximo registro de venda
			auxiliarVenda =  (Venda) iterador.obterProximo(); //obtém referência para um registro de venda
			
			/* Na condição abaixo ocorrem as verificações para certificar que os dados da venda obtida na iteração 
			 * correspondem aos dados da venda que se deseja realizar. De forma que, se a condição for verdadeira
			 * a variável utilizada para contabilizar o número de ingressos vendidos é incrementada com 1.
			 */
			if(auxiliarVenda.getIngresso().getCinema().getId() == idCinema && auxiliarVenda.getIngresso().getSala().getNumeroSala() == numeroSala && auxiliarVenda.getIngresso().getSessao().getHoraInicio() == horaInicio) {
				ingressosVendidos += auxiliarVenda.getQtdIngressos();
			}
		}
		
		if(ingressosVendidos >= sala.getQtdCadeiras()) { //verifica se o número e ingressos vendidos é maior ou igual à quantidade de cadeiras disponíveis na sala
			throw new LimiteIngressosExcedidoException(); //lança exceção correspondente caso o número máximo de ingressos para a sala tenha sido atingido
		}
		
		Ingresso novoIngresso = new Ingresso(); //cria uma nova instância de ingresso
	
		/* As informações adequadas são armazenadas no ingresso. */
		novoIngresso.setCinema(cinema);
		novoIngresso.setSala(sala);
		novoIngresso.setSessao(sessao);
		
		Venda novaVenda = new Venda(); //cria uma nova instância de venda
		
		/* As informações adequadas são armazenadas na venda. */
		novaVenda.setIngresso(novoIngresso); 
		novaVenda.setComprador(comprador);
		novaVenda.setQtdIngressos(qtdIngressos);
		novaVenda.setValorTotal(valorTotal);
		
		controllerAdministrador.registrarVendas(novaVenda); //registra a nova venda na lista encadeada adequada
	}

	/**
	 * Fornece a referência para uma lista encadeada de ingressos comprados por um comprador, caso a referência
	 * de comprador informada seja válida.
	 * @param comprador referência para um comprador
	 * @return referência para uma lista de ingressos vendidos ao comprador informado
	 * @throws CompradorNuloException se o comprador informado for nulo
	 * @throws CompradorNaoEncontradoException se não foi encontrado cadastro do comprador no sistema
	 */
	public ListaEncadeada recuperarIngressos(Comprador comprador) throws CompradorNuloException, CompradorNaoEncontradoException {
		AdministradorController controllerAdministrador = AdministradorController.getInstance(); //obtém referência para a instância única do AdministradorController
		
		if(comprador == null) { //verifica se a referência de comprador informada é nula
			throw new CompradorNuloException(); //lança exceção correspondente caso a referência de comprador seja nula
		} else {
			try {
				controllerAdministrador.recuperarComprador(comprador.getDocumento()); //tenta encontrar o cadastro do comprador em questão
			} catch (CompradorNaoEncontradoException e) {
				throw e; //relança exceção indicando que não existe cadastro do comprador informado
			}
		}

		
		Iterador iterador = controllerAdministrador.listarVendas(); //obtém iterador para a lista encadeada de vendas
		Venda auxiliarVenda = null; //referência auxiliar para uma venda
		int contador = 0; //contador para gerenciar a inserção da quantidade adequada de ingressos na lista
		ListaEncadeada listaIngressos = new ListaEncadeada(); //cria uma nova instância de lista encadeada
		
		
		while(iterador.temProximo()) { //verifica se há uma próxima venda
			auxiliarVenda = (Venda) iterador.obterProximo(); //obtém a referência para uma venda
			
			if(auxiliarVenda.getComprador().getDocumento() == comprador.getDocumento()) { //verifica se o comprador obtido é o desejado
				while(contador < auxiliarVenda.getQtdIngressos()) { //enquanto todos os ingressos da venda não tiverem sido inseridos na lista
					listaIngressos.inserirFinal(auxiliarVenda.getIngresso()); //insere um ingresso na lista
					contador++; //incrementa um no contador
				}
			}
			
			contador = 0; //zera o contador
		}
		
		return listaIngressos; //retorna a lista com todos os ingressos vendidos ao comprador em questão
	}
}
