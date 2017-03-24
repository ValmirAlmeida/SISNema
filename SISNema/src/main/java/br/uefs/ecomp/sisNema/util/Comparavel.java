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


package br.uefs.ecomp.sisNema.util;

/**
 * Essa interface permite uma comparação específica entre dois objetos de uma classe que a implementa.
 * 
 * @author Valmir Vinicius 
 */
public interface Comparavel {
	
	/**
	 * Compara o objeto atual com um objeto especificado, de acordo com padrão definido de comparação. 
	 *
	 * @param obj referência para o objeto que será comparado ao objeto atual
	 * @return 1, caso o objeto passado seja maior que o atual, no contexto da implementação; -1, se for menor; 0 se forem iguais.
	 */
	public int comparacao(Object obj);
	
}
