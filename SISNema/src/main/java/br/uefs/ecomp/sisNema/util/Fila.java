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
 * Implementa uma fila utilizando uma lista encadeada como TAD (Tipo Abstrato de Dados).
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.util.ListaEncadeada
 */
public class Fila implements IFila {
	
	/** Lista encadeada utilizada para implementar a fila */
	ListaEncadeada lista;
	
	/**
	 * Cria uma nova inst�ncia de fila.
	 */
	public Fila() {
		lista = new ListaEncadeada(); //obt�m a inst�ncia de lista
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
