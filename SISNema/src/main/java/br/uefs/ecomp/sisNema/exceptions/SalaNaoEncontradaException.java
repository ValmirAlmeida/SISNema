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


package br.uefs.ecomp.sisNema.exceptions;

/**
 * Exce��o lan�ada quando n�o for encontrado um cadastro de sala.
 * 
 * @author Valmir Vinicius
 */
public class SalaNaoEncontradaException extends Exception  {

	private static final long serialVersionUID = 7832434206172713390L;
	
	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida.
	 */
	public SalaNaoEncontradaException() {
		super("N�o foi encontrado registro da sala informada.");
	}
	
	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida e uma exce��o que a causou.
	 * @param causa causa da exce��o
	 */
	public SalaNaoEncontradaException(Throwable causa) {
		super("N�o foi encontrado registro da sala informada.", causa);

	}

	
}
