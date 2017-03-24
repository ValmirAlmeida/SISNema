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
 * Define os m�todos que dever�o estar na implementa��o de uma fila.
 */
public interface IFila {
  
    /**
     * Verificia se a fila est� vazia.
     *
     * @return <code>true</code>, se a lista estiver vazia; <code>false</code>, caso contr�rio.
     */
    public boolean estaVazia();

    /**
     * Retorna o tamanho atual da fila.
     *
     * @return valor correspondente ao tamanho atual da fila
     */
    public int obterTamanho();

    /**
     * Insere um novo objeto ao final da fila.
     *
     * @param o refer�ncia para o objeto que ser� inserido na fila
     */
    public void inserirFinal(Object o);

    /**
     * Remove um objeto do in�cio da fila.
     *
     * @return refer�ncia para o objeto removido
     */
    public Object removerInicio();

    /**
     * Retorna a refer�ncia do primeiro objeto da fila.
     *
     * @return refer�ncia para o primeiro objeto da fila
     */
    public Object recuperarInicio();   
    
    /**
     * Retorna um iterador para percorrer a fila.
     *
     * @return the iterador
     */
    public Iterador iterador();
}
