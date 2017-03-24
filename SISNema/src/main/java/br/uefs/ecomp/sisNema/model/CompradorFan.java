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

package br.uefs.ecomp.sisNema.model;


/**
 * Classe respons�vel por moldar um comprador do tipo f� no sistema. � uma subclasse de "Comprador".
 * @see br.uefs.ecomp.sisNema.model.Comprador
 * @author Valmir Vinicius
 */

public class CompradorFan extends Comprador {
	/** N�mero de cadastro do f� no clube. */
	private int registro;


	/**
	 * Retorna o n�mero de cadastro do f� no clube.
	 *
	 * @return n�mero de cadastro do f� no clube
	 */
	public int getRegistro() {
		return registro; //retorna o atributo "registro"
	}

	/**
	 * Configura um novo n�mero de cadastro no clube para o f�.
	 *
	 * @param registro novo n�mero de cadastro no clube do f�
	 */
	public void setRegistro(int registro) {
		this.registro = registro; //atribui o n�mero de cadastro recebido ao atributo "registro"
	}
}
