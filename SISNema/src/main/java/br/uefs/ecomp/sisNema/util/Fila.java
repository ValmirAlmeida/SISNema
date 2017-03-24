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
 * Implementa uma fila utilizando uma lista encadeada como TAD (Tipo Abstrato de Dados).
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.util.ListaEncadeada
 */
public class Fila implements IFila {
	
	/** Lista encadeada utilizada para implementar a fila */
	ListaEncadeada lista;
	
	/**
	 * Cria uma nova instância de fila.
	 */
	public Fila() {
		lista = new ListaEncadeada(); //obtém a instância de lista
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int obterTamanho() {
		return lista.obterTamanho();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inserirFinal(Object o) {
		lista.inserirFinal(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object removerInicio() {
		return lista.removerInicio();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object recuperarInicio() {
		return lista.recuperar(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterador iterador() {
		return lista.iterador();
	}

}
