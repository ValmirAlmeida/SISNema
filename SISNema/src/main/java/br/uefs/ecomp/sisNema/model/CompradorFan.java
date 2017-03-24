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

package br.uefs.ecomp.sisNema.model;


/**
 * Classe responsável por moldar um comprador do tipo fã no sistema. É uma subclasse de "Comprador".
 * @see br.uefs.ecomp.sisNema.model.Comprador
 * @author Valmir Vinicius
 */

public class CompradorFan extends Comprador {
	/** Número de cadastro do fã no clube. */
	private int registro;


	/**
	 * Retorna o número de cadastro do fã no clube.
	 *
	 * @return número de cadastro do fã no clube
	 */
	public int getRegistro() {
		return registro; //retorna o atributo "registro"
	}

	/**
	 * Configura um novo número de cadastro no clube para o fã.
	 *
	 * @param registro novo número de cadastro no clube do fã
	 */
	public void setRegistro(int registro) {
		this.registro = registro; //atribui o número de cadastro recebido ao atributo "registro"
	}
}
