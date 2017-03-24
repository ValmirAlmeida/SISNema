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
 * Define os métodos que deverão estar na implementação de uma fila.
 */
public interface IFila {
  
    /**
     * Verificia se a fila está vazia.
     *
     * @return <code>true</code>, se a lista estiver vazia; <code>false</code>, caso contrário.
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
     * @param o referência para o objeto que será inserido na fila
     */
    public void inserirFinal(Object o);

    /**
     * Remove um objeto do início da fila.
     *
     * @return referência para o objeto removido
     */
    public Object removerInicio();

    /**
     * Retorna a referência do primeiro objeto da fila.
     *
     * @return referência para o primeiro objeto da fila
     */
    public Object recuperarInicio();   
    
    /**
     * Retorna um iterador para percorrer a fila.
     *
     * @return the iterador
     */
    public Iterador iterador();
}
