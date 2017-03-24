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
 * Exce��o lan�ada quando uma sess�o j� estiver esgotada e for realizada uma tentativa de compra de ingresso.
 * 
 * @author Valmir Vinicius
 */
public class LimiteIngressosExcedidoException extends Exception  {

	private static final long serialVersionUID = -599714857510917208L;

	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida.
	 */
	public LimiteIngressosExcedidoException() {
		super("Imposs�vel comprar ingressos para a sess�o desejada, pois a lota��o m�xima foi antigida.");
	}

	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida e uma exce��o que a causou.
	 * @param causa causa da exce��o
	 */
	public LimiteIngressosExcedidoException(Throwable causa) {
		super("Imposs�vel comprar ingressos para a sess�o desejada, pois a lota��o m�xima foi antigida.", causa);

	}

}
