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
 * Classe respons�vel por moldar uma sess�o de cinema no sistema. Possui m�todos para obten��o e configura��o
 * dos atributos de uma sess�o.
 * 
 * @author Valmir Vinicius
 */

public class Sessao {
	
	
	/** Hora de in�cio da sess�o. */
	private int horaInicio;
	
	/** Hora que termina a sess�o. */
	private int horaFim;
	

	/**
	 * Retorna a hora de in�cio da sess�o.
	 *
	 * @return hora de in�cio da sess�o
	 */
	public int getHoraInicio() {
		return horaInicio; //retorna o valor do atributo "horaInicio"
	}

	/**
	 * Configura a hora de in�cio da ses�o.
	 *
	 * @param horaInicio valor da hora de in�cio que conter� na sess�o
	 */
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio; //atribui o valor recebido ao atributo "horaInicio"
	}

	/**
	 * Retorna a hora de t�rmino da sess�o.
	 *
	 * @return hora de t�rmino da sess�o
	 */
	public int getHoraFim() {
		return horaFim; //retorna o valor do atributo "horaFim"
	}

	/**
	 * Configura a hora de t�rmino da sess�o.
	 *
	 * @param horaFim valor da hora de t�rmino que conter� na sess�o
	 */
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim; //atribui o valor recebido ao atributo "horaFim"
	}

}
