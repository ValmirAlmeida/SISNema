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


package br.uefs.ecomp.sisNema.exceptions;

/**
 * Exceção lançada ao tentar cadastrar ou alterar uma entidade com um campo obrigatório não preenchido
 * ou preenchido de forma incorreta.
 * 
 * @author Valmir Vinicius
 */
public class CampoObrigatorioInexistenteException extends Exception {

	private static final long serialVersionUID = 1937335346603657260L;
	
	/**
	 * Cria uma nova instância da exceção com uma mensagem predefinida.
	 */
	public CampoObrigatorioInexistenteException() {
		super("Uma informação obrigatória não foi informada ou foi informada em formato inválido.");
	}
	
	/**
	 * Cria uma nova instância da exceção com uma mensagem predefinida e uma exceção que a causou.
	 * @param causa causa da exceção
	 */
	public CampoObrigatorioInexistenteException(Throwable causa) {
		super("Uma informação obrigatória não foi informada ou foi informada em formato inválido.", causa);
	}
	

}
