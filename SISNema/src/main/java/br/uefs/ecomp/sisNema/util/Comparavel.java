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


package br.uefs.ecomp.sisNema.util;

/**
 * Essa interface permite uma compara��o espec�fica entre dois objetos de uma classe que a implementa.
 * 
 * @author Valmir Vinicius 
 */
public interface Comparavel {
	
	/**
	 * Compara o objeto atual com um objeto especificado, de acordo com padr�o definido de compara��o. 
	 *
	 * @param obj refer�ncia para o objeto que ser� comparado ao objeto atual
	 * @return 1, caso o objeto passado seja maior que o atual, no contexto da implementa��o; -1, se for menor; 0 se forem iguais.
	 */
	public int comparacao(Object obj);
	
}
