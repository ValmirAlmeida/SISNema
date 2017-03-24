package br.uefs.ecomp.sisNema.model;

import br.uefs.ecomp.sisNema.util.ListaEncadeada;

/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Valmir Vinicius de Almeida Santos
 * Data:  07/03/2016
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

/**
 * Classe responsável por moldar uma sala de cinema no sistema. Possui métodos para obtenção e configuração
 * dos atributos de uma sala.
 * 
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.util.ListaEncadeada
 * 
 */
public class Sala {
	
	/** Número da sala. */
	private int numeroSala;
	
	/** Quantidade de cadeiras disponíveis na sala. */
	private int qtdCadeiras;
	
	/** Lista encadeada contendo as sessões que ocorrem na sala. */
	private ListaEncadeada sessoes;
	
	/**
	 * Cria uma nova instância de Sala.
	 */
	public Sala() {
		sessoes = new ListaEncadeada(); //inicializa o atributo "sessoes" com uma nova instância de lista encadeada
	}
	
	/**
	 * Retorna o número da sala.
	 *
	 * @return número da sala
	 */
	public int getNumeroSala() {
		return numeroSala; //retorna o atributo "numero"
	}
	
	/**
	 * Configura um novo número para a sala.
	 *
	 * @param numeroSala novo número da sala.
	 */
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala; //atribui o número recebido ao atributo "numero"
	}
	
	/**
	 * Retorna a quantidade de cadeiras da sala.
	 *
	 * @return quantidade de cadeiras da sala
	 */
	public int getQtdCadeiras() {
		return qtdCadeiras; //retorna o atributo "qtdCadeiras"
	}
	
	/**
	 * Configura uma nova quantidade de cadeiras para a sala.
	 *
	 * @param qtdCadeiras nova quantidade de cadeiras da sala
	 */
	public void setQtdCadeiras(int qtdCadeiras) {
		this.qtdCadeiras = qtdCadeiras; //atribui a quantidade recebida ao atributo "qtdCadeiras"
	}
	
	/**
	 * Retorna a lista encadeada contendo as sessões que ocorrem na sala.
	 *
	 * @return lista encadeada de sessões da sala
	 */
	public ListaEncadeada getSessoes() {
		return sessoes; //retorna o atributo "listaSessoes"
	}
	
}
