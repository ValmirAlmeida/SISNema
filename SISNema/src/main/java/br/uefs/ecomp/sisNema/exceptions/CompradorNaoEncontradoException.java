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
 * Exce��o lan�ada quando n�o for encontrado um cadastro de comprador.
 * 
 * @author Valmir Vinicius
 */
public class CompradorNaoEncontradoException extends Exception  {

	private static final long serialVersionUID = -1912659436917410898L;

	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida.
	 */
	public CompradorNaoEncontradoException() {
		super("N�o foi encontrado registro do comprador informado.");
	}

	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida e uma exce��o que a causou.
	 * @param causa causa da exce��o
	 */
	public CompradorNaoEncontradoException(Throwable causa) {
		super("N�o foi encontrado registro do comprador informado.", causa);
		// TODO Auto-generated constructor stub
	}

}
