package br.uefs.ecomp.sisNema.model;

import br.uefs.ecomp.sisNema.util.ListaEncadeada;

/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: Valmir Vinicius de Almeida Santos
 * Data:  07/03/2016
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

/**
 * Classe respons�vel por moldar uma sala de cinema no sistema. Possui m�todos para obten��o e configura��o
 * dos atributos de uma sala.
 * 
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.util.ListaEncadeada
 * 
 */
public class Sala {
	
	/** N�mero da sala. */
	private int numeroSala;
	
	/** Quantidade de cadeiras dispon�veis na sala. */
	private int qtdCadeiras;
	
	/** Lista encadeada contendo as sess�es que ocorrem na sala. */
	private ListaEncadeada sessoes;
	
	/**
	 * Cria uma nova inst�ncia de Sala.
	 */
	public Sala() {
		sessoes = new ListaEncadeada(); //inicializa o atributo "sessoes" com uma nova inst�ncia de lista encadeada
	}
	
	/**
	 * Retorna o n�mero da sala.
	 *
	 * @return n�mero da sala
	 */
	public int getNumeroSala() {
		return numeroSala; //retorna o atributo "numero"
	}
	
	/**
	 * Configura um novo n�mero para a sala.
	 *
	 * @param numeroSala novo n�mero da sala.
	 */
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala; //atribui o n�mero recebido ao atributo "numero"
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
	 * Retorna a lista encadeada contendo as sess�es que ocorrem na sala.
	 *
	 * @return lista encadeada de sess�es da sala
	 */
	public ListaEncadeada getSessoes() {
		return sessoes; //retorna o atributo "listaSessoes"
	}
	
}
