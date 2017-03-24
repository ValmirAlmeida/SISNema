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
 * Exce��o lan�ada ao tentar cadastrar ou alterar uma entidade com um campo obrigat�rio n�o preenchido
 * ou preenchido de forma incorreta.
 * 
 * @author Valmir Vinicius
 */
public class CampoObrigatorioInexistenteException extends Exception {

	private static final long serialVersionUID = 1937335346603657260L;
	
	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida.
	 */
	public CampoObrigatorioInexistenteException() {
		super("Uma informa��o obrigat�ria n�o foi informada ou foi informada em formato inv�lido.");
	}
	
	/**
	 * Cria uma nova inst�ncia da exce��o com uma mensagem predefinida e uma exce��o que a causou.
	 * @param causa causa da exce��o
	 */
	public CampoObrigatorioInexistenteException(Throwable causa) {
		super("Uma informa��o obrigat�ria n�o foi informada ou foi informada em formato inv�lido.", causa);
	}
	

}
