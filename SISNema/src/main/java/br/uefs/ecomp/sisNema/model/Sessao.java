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
 * Classe responsável por moldar uma sessão de cinema no sistema. Possui métodos para obtenção e configuração
 * dos atributos de uma sessão.
 * 
 * @author Valmir Vinicius
 */

public class Sessao {
	
	
	/** Hora de início da sessão. */
	private int horaInicio;
	
	/** Hora que termina a sessão. */
	private int horaFim;
	

	/**
	 * Retorna a hora de início da sessão.
	 *
	 * @return hora de início da sessão
	 */
	public int getHoraInicio() {
		return horaInicio; //retorna o valor do atributo "horaInicio"
	}

	/**
	 * Configura a hora de início da sesão.
	 *
	 * @param horaInicio valor da hora de início que conterá na sessão
	 */
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio; //atribui o valor recebido ao atributo "horaInicio"
	}

	/**
	 * Retorna a hora de término da sessão.
	 *
	 * @return hora de término da sessão
	 */
	public int getHoraFim() {
		return horaFim; //retorna o valor do atributo "horaFim"
	}

	/**
	 * Configura a hora de término da sessão.
	 *
	 * @param horaFim valor da hora de término que conterá na sessão
	 */
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim; //atribui o valor recebido ao atributo "horaFim"
	}

}
