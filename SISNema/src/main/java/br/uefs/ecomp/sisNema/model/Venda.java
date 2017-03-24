package br.uefs.ecomp.sisNema.model;

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
 * Classe respons�vel por moldar uma Venda no sistema. Possui m�todos para obten��o e configura��o
 * dos atributos de uma venda.
 * 
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.model.Comprador
 * @see br.uefs.ecomp.sisNema.model.Ingresso
 */
public class Venda {
	
	/** Comprador que realizou a compra do venda. */
	private Comprador comprador;
	
	/** Ingresso que foi comprado. */
	private Ingresso ingresso;
	
	/** Quantidade de ingressos comprados. */
	private int qtdIngressos;
	
	/** Valor total da compra. */
	private double valorTotal;
	
	
	/**
	 * Retorna a refer�ncia para o comprador.
	 *
	 * @return refer�ncia para comprador
	 */
	public Comprador getComprador() {
		return comprador; //retorna o atributo "comprador"
	}
	
	/**
	 * Configura o comprador da venda.
	 *
	 * @param comprador refer�ncia para o comprador
	 */
	public void setComprador(Comprador comprador) {
		this.comprador = comprador; //atribui o a refer�ncia de comprador recebida ao atributo "comprador"
	}
	
	/**
	 * Retorna a refer�ncia do ingresso da venda.
	 *
	 * @return refer�ncia para o ingresso
	 */
	public Ingresso getIngresso() {
		return ingresso; //retorna o atributo "ingresso"
	}

	/**
	 * Configura o ingresso da venda.
	 *
	 * @param ingresso refer�ncia para o ingresso
	 */
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;  //atribui o a refer�ncia de ingresso recebida ao atributo "ingresso"
	}
	
	/**
	 * Retorna a quantidade de ingressos vendidos.
	 *
	 * @return quantidade de ingressos vendidos
	 */
	public int getQtdIngressos() {
		return qtdIngressos; //retorna o atributo "qtdIngressos"
	}
	
	/**
	 * Configura a quantidade de ingressos vendidos.
	 *
	 * @param qtdIngressos quantidade de ingressos vendidos
	 */
	public void setQtdIngressos(int qtdIngressos) {
		this.qtdIngressos = qtdIngressos;  //atribui a quantidade de ingressos recebida ao atributo "qtdIngressos"
	}
	
	/**
	 * Retorna o valor total da venda.
	 *
	 * @return valor total da venda
	 */
	public double getValorTotal() {
		return valorTotal; //retorna o atributo "valorTotal"
	}
	
	/**
	 * Configura o valor total da venda.
	 *
	 * @param valorTotal valor total da venda
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal; //atribui o valor total da compra recebido ao atributo "valorTotal"
	}



}
