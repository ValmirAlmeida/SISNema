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
 * Interface para definições da implementação da lista encadeada.
 */
public interface ILista {

    /**
     * Verifica se a lista encadeada está vazia, retornando <code>true</code> apenas se não há nós na lista.
     *
     * @return <code>true</code>, se a lista não contém nós; <code>false</code>, caso contrário.
     */
    public boolean estaVazia();

    /**
     * Retorna a quantidade de elementos da lista encadeada.
     *
     * @return número de elemento da lista
     */
    public int obterTamanho();

    /**
     * Insere o objeto especificado no início da lista encadeada.
     *
     * @param o objeto que será inserido no começo da lista
     */
    public void inserirInicio(Object o);

    /**
     * Insere o objeto especificado no final da lista encadeada.
     *
     * @param o objeto que será inserido no final da lista
     */
    public void inserirFinal(Object o);

    /**
     * Remove o primeiro objeto da lista encadeada, caso a lista não esteja vazia, retornando a referência para o 
     * objeto removido.
     *
     * @return referência para o objeto removido, se a lista não estiver vazia; <code>null</code>, caso contrário
     */
    public Object removerInicio();

    /**
     * Remove o último objeto da lista encadeada, caso a lista não esteja vazia, retornando a referência para o objeto 
     * removido.
     *
     * @return referência para o objeto removido, se a lista não estiver vazia; <code>null</code>, caso contrário
     */
    public Object removerFinal();

    /**
     * Remove o objeto contido na lista na posição especificada, retornando a referência para o objeto removido.
     *
     * @param index posição do objeto a ser removido
     * @return referência para o objeto removido
     */
    public Object remover(int index);
    
    /**
     * Retorna a referência para o objeto contido na posição especificada da lista encadeada, se a posição informada
     * for válida.
     *
     * @param index posição do objeto a ser recuperado
     * @return referência para o objeto, se o index for válido; <code>null</code>, caso contrário.
     */
    public Object recuperar(int index);

    /**
     * Retorna um iterador para percorrer a lista encadeada em sequência.
     *
     * @return iterador da lista
     */
    public Iterador iterador();
}
