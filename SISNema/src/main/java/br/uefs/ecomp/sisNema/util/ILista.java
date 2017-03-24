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
 * Interface para defini��es da implementa��o da lista encadeada.
 */
public interface ILista {

    /**
     * Verifica se a lista encadeada est� vazia, retornando <code>true</code> apenas se n�o h� n�s na lista.
     *
     * @return <code>true</code>, se a lista n�o cont�m n�s; <code>false</code>, caso contr�rio.
     */
    public boolean estaVazia();

    /**
     * Retorna a quantidade de elementos da lista encadeada.
     *
     * @return n�mero de elemento da lista
     */
    public int obterTamanho();

    /**
     * Insere o objeto especificado no in�cio da lista encadeada.
     *
     * @param o objeto que ser� inserido no come�o da lista
     */
    public void inserirInicio(Object o);

    /**
     * Insere o objeto especificado no final da lista encadeada.
     *
     * @param o objeto que ser� inserido no final da lista
     */
    public void inserirFinal(Object o);

    /**
     * Remove o primeiro objeto da lista encadeada, caso a lista n�o esteja vazia, retornando a refer�ncia para o 
     * objeto removido.
     *
     * @return refer�ncia para o objeto removido, se a lista n�o estiver vazia; <code>null</code>, caso contr�rio
     */
    public Object removerInicio();

    /**
     * Remove o �ltimo objeto da lista encadeada, caso a lista n�o esteja vazia, retornando a refer�ncia para o objeto 
     * removido.
     *
     * @return refer�ncia para o objeto removido, se a lista n�o estiver vazia; <code>null</code>, caso contr�rio
     */
    public Object removerFinal();

    /**
     * Remove o objeto contido na lista na posi��o especificada, retornando a refer�ncia para o objeto removido.
     *
     * @param index posi��o do objeto a ser removido
     * @return refer�ncia para o objeto removido
     */
    public Object remover(int index);
    
    /**
     * Retorna a refer�ncia para o objeto contido na posi��o especificada da lista encadeada, se a posi��o informada
     * for v�lida.
     *
     * @param index posi��o do objeto a ser recuperado
     * @return refer�ncia para o objeto, se o index for v�lido; <code>null</code>, caso contr�rio.
     */
    public Object recuperar(int index);

    /**
     * Retorna um iterador para percorrer a lista encadeada em sequ�ncia.
     *
     * @return iterador da lista
     */
    public Iterador iterador();
}
