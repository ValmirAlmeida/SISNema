package br.uefs.ecomp.sisNema.model;

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
 * Classe responsável por moldar uma Venda no sistema. Possui métodos para obtenção e configuração
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
	 * Retorna a referência para o comprador.
	 *
	 * @return referência para comprador
	 */
	public Comprador getComprador() {
		return comprador; //retorna o atributo "comprador"
	}
	
	/**
	 * Configura o comprador da venda.
	 *
	 * @param comprador referência para o comprador
	 */
	public void setComprador(Comprador comprador) {
		this.comprador = comprador; //atribui o a referência de comprador recebida ao atributo "comprador"
	}
	
	/**
	 * Retorna a referência do ingresso da venda.
	 *
	 * @return referência para o ingresso
	 */
	public Ingresso getIngresso() {
		return ingresso; //retorna o atributo "ingresso"
	}

	/**
	 * Configura o ingresso da venda.
	 *
	 * @param ingresso referência para o ingresso
	 */
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;  //atribui o a referência de ingresso recebida ao atributo "ingresso"
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
