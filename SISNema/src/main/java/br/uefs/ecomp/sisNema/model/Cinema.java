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
 * Classe respons�vel por moldar um cinema no sistema. Possui m�todos para obten��o, configura��o
 * e gera��o (no caso do ID) dos atributos de um cinema.
 * 
 * @author Valmir Vinicius
 * @see java.lang.String
 * @see br.uefs.ecomp.sisNema.model.Endereco
 * @see br.uefs.ecomp.sisNema.model.Sala
 * @see br.uefs.ecomp.sisNema.util.ListaEncadeada
 */

public class Cinema {

	/** ID do cinema gerado automaticamente pelo sistema. */
	private int id;
	
	/** Nome do cinema. */
	private String nome;
	
	/** A quantidade de salas do cinema. */
	private int qtdSalas;
	
	/** Endere�o do cinema. */
	private Endereco endereco;

	
	/** Lista encadeada para armazemaneto das salas do cinema. */
	private ListaEncadeada salas;
	
	/** N�mero de cinemas j� cadastrados no sistema, utilizado para gera��o do ID. */
	private static int numCinemas = 0;
	
	/**
	 * Cria uma nova inst�ncia de Cinema.
	 */
	public Cinema() {
		geraId(); //gera o id do cinema
		salas = new ListaEncadeada(); //obt�m uma nova inst�ncia de lista encadeada
	}

	/**
	 * Gera um ID �nico para identifica��o do cinema no sistema.
	 */
	private void geraId() {
		id = ++numCinemas; //incrementa em 1 o atributo est�tico "numCinemas" e inicializa o atributo "id" com o valor de "numCinemas"; 
	}
	
	/**
	 * Retorna o ID �nico do cinema no sistema.
	 *
	 * @return id do cinema
	 */
	public int getId() {
		return id; //retorna o atributo "id"
	}

	/**
	 * Retorna o nome do cinema.
	 *
	 * @return nome do cinema
	 */
	public String getNome() {
		return nome; //retorna o atributo "nome"
	}

	/**
	 * Configura o nome do cinema.
	 *
	 * @param nome novo nome do cinema
	 */
	public void setNome(String nome) {
		this.nome = nome; //atribui o nome recebecido ao atributo "nome"
	}

	/**
	 * Retorna a quantidade de salas do cinema.
	 *
	 * @return quantidade de salas
	 */
	public int getQtdSalas() {
		return qtdSalas; //retorna o atributo "qtdSalas"
	}

	/**
	 * Configura a quantidade de salas do cinema.
	 *
	 * @param qtdSalas novo valor para a quantidade de salas
	 */
	public void setQtdSalas(int qtdSalas) {
		this.qtdSalas = qtdSalas; //atribui a quantidade de salas recebida ao atributo "qtdSalas"
	}

	/**	
	 * Retorna o endere�o do cinema.
	 * 
	 * @return endere�o do cinema
	 */
	public Endereco getEndereco() {
		return endereco; //retorna o atributo "endereco"
	}

	/**
	 * Configura o endere�o do cinema.
	 *
	 * @param endereco novo endere�o do cinema
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco; //atribui a refer�ncia de "Endereco" recebida ao atributo "endereco"
	} 
	
	/**
	 * Retorna uma lista encadeada contendo as salas do cinema.
	 * 
	 * @return lista encadeada de salas
	 */
	public ListaEncadeada getSalas() {
		return salas; //retorna o atributo "salas"
	}	
}
