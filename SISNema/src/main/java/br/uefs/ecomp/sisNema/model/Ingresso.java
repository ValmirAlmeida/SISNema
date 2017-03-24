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
 * Classe respons�vel por modelar um ingresso no sistema. Possui m�todos para obten��o e configura��o
 * dos atributos de um ingresso.
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.model.Cinema
 * @see br.uefs.ecomp.sisNema.model.Sala
 * @see br.uefs.ecomp.sisNema.model.Sessao
 */
public class Ingresso {
	
	/** Cinema no qual ocorrer� a exibi��o. */
	private Cinema cinema;
	
	/** Sala no qual ocorrer� a exibi��o. */
	private Sala sala;
	
	/** Sessao no qual ocorrer� a exibi��o. */
	private Sessao sessao;
	
	/**
	 * Retorna a refer�ncia do cinema contido no ingresso.
	 * @return refer�ncia para o cinema
	 */
	public Cinema getCinema() {
		return cinema; //retorna o atributo "cinema"
	}
	
	/**
	 * Configura o cinema do ingresso.
	 * @param cinema refer�ncia para o cinema que estar� no ingresso
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema; //atribui a refer�ncia de cinema recebida por par�metro ao atributo "cinema"
	}
	
	/**
	 * Retorna a refer�ncia da sala contida no ingresso.
	 * @return refer�ncia para a sala do ingresso
	 */
	public Sala getSala() {
		return sala; //retorna o atributo "sala"
	}
	
	/**
	 * Configura a sala do ingresso.
	 * @param sala refer�ncia para a sala que estar� no ingresso
	 */
	public void setSala(Sala sala) {
		this.sala = sala; //atribui a refer�ncia de sala recebida por par�metro ao atributo "sala"
	}
	

	/** Retorna a refer�ncia de sess�o contida no ingresso. 
	 * 
	 * @return refer�ncia da sess�o do ingresso
	 */
	public Sessao getSessao() {
		return sessao; //retorna o atributo "sessao"
	}
	
	/**
	 * Configura a sess�o do ingresso.
	 * @param sessao refer�ncia para a sess�o que estar� no ingresso
	 */
	public void setSessao(Sessao sessao) {
		this.sessao = sessao; //atribui a refer�ncia de sess�o recebida por par�metro ao atributo "sess�o"
	}
	

}
