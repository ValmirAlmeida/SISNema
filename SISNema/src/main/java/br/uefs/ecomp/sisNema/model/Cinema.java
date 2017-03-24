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
 * Classe responsável por moldar um cinema no sistema. Possui métodos para obtenção, configuração
 * e geração (no caso do ID) dos atributos de um cinema.
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
	
	/** Endereço do cinema. */
	private Endereco endereco;

	
	/** Lista encadeada para armazemaneto das salas do cinema. */
	private ListaEncadeada salas;
	
	/** Número de cinemas já cadastrados no sistema, utilizado para geração do ID. */
	private static int numCinemas = 0;
	
	/**
	 * Cria uma nova instância de Cinema.
	 */
	public Cinema() {
		geraId(); //gera o id do cinema
		salas = new ListaEncadeada(); //obtém uma nova instância de lista encadeada
	}

	/**
	 * Gera um ID único para identificação do cinema no sistema.
	 */
	private void geraId() {
		id = ++numCinemas; //incrementa em 1 o atributo estático "numCinemas" e inicializa o atributo "id" com o valor de "numCinemas"; 
	}
	
	/**
	 * Retorna o ID único do cinema no sistema.
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
	 * Retorna o endereço do cinema.
	 * 
	 * @return endereço do cinema
	 */
	public Endereco getEndereco() {
		return endereco; //retorna o atributo "endereco"
	}

	/**
	 * Configura o endereço do cinema.
	 *
	 * @param endereco novo endereço do cinema
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco; //atribui a referência de "Endereco" recebida ao atributo "endereco"
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
