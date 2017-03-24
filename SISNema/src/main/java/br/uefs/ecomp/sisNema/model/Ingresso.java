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
 * Classe responsável por modelar um ingresso no sistema. Possui métodos para obtenção e configuração
 * dos atributos de um ingresso.
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.model.Cinema
 * @see br.uefs.ecomp.sisNema.model.Sala
 * @see br.uefs.ecomp.sisNema.model.Sessao
 */
public class Ingresso {
	
	/** Cinema no qual ocorrerá a exibição. */
	private Cinema cinema;
	
	/** Sala no qual ocorrerá a exibição. */
	private Sala sala;
	
	/** Sessao no qual ocorrerá a exibição. */
	private Sessao sessao;
	
	/**
	 * Retorna a referência do cinema contido no ingresso.
	 * @return referência para o cinema
	 */
	public Cinema getCinema() {
		return cinema; //retorna o atributo "cinema"
	}
	
	/**
	 * Configura o cinema do ingresso.
	 * @param cinema referência para o cinema que estará no ingresso
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema; //atribui a referência de cinema recebida por parâmetro ao atributo "cinema"
	}
	
	/**
	 * Retorna a referência da sala contida no ingresso.
	 * @return referência para a sala do ingresso
	 */
	public Sala getSala() {
		return sala; //retorna o atributo "sala"
	}
	
	/**
	 * Configura a sala do ingresso.
	 * @param sala referência para a sala que estará no ingresso
	 */
	public void setSala(Sala sala) {
		this.sala = sala; //atribui a referência de sala recebida por parâmetro ao atributo "sala"
	}
	

	/** Retorna a referência de sessão contida no ingresso. 
	 * 
	 * @return referência da sessão do ingresso
	 */
	public Sessao getSessao() {
		return sessao; //retorna o atributo "sessao"
	}
	
	/**
	 * Configura a sessão do ingresso.
	 * @param sessao referência para a sessão que estará no ingresso
	 */
	public void setSessao(Sessao sessao) {
		this.sessao = sessao; //atribui a referência de sessão recebida por parâmetro ao atributo "sessão"
	}
	

}
