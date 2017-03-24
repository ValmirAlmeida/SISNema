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
 * Classe que implementa uma lista encadeada. Permite que opera��es de inser��o, remo��o, obten��o, ordena��o e
 * acompanhamento do estado da lista (obter o tamanho e verificar se est� vazia).
 * 
 * @author Valmir Vinicius
 */

public class ListaEncadeada implements ILista {

	/** Refer�ncia para o primeiro n� da lista. */
	private No primeiro;
	
	/** Tamanho da lista encadeada. */
	private int tamanho;
	
	/* Na medida do poss�vel, as especifica��es em JAVADOC aqui contidas buscam focar mais no modo de implementa��o utilizando, visando 
	 * fornecer maiores detalhes para quem acessar a documenta��o do sistema e evitar repeti��es do que foi antes explicitado no JAVADOC
	 * da interface implementada por essa classe.
	 */
	
	/**
	 * Verifica se a lista encadeada est� vazia.
	 * 
	 * @return <code>true</code>, se o primeiro n� da lista for uma refer�ncia <code>null</code>; <code>false</code>, caso contr�rio
	 */
	@Override
	public boolean estaVazia() {
		return this.primeiro == null; //verifica se o primeiro n� da lista possui uma refer�ncia null e retorna o resultado booleano da compara��o
	}


	/**
	 * Retorna a quantidade de n�s da lista encadeada.
	 * 
	 * @return n�mero de n�s da lista encadeada
	 */
	@Override
	public int obterTamanho() {
		return this.tamanho; //retorna o atributo correspondente ao tamanho da lista
	}

	/**
	 * Cria um novo n� com o objeto recebido e o define como primeiro da lista.
	 * 
	 * @param obj refer�ncia para o objeto que se deseja alocar no primeiro n� da lista
	 */
	@Override
	public void inserirInicio(Object obj) {
		No novoNo = null; //refer�ncia para o novo n� da lista
		
		if(this.estaVazia() == true){ //verifica se a lista est� vazia
			novoNo = new No(obj, null); //se a lista estiver vazia o novo n� � criado tendo uma refer�ncia null para pr�ximo n�
		}else{
			novoNo = new No(obj, this.primeiro); //caso j� existam n�s na lista o novo n� � criado tendo a refer�ncia para o primeiro n� atual como pr�ximo
		}
		
		this.primeiro = novoNo; //faz com que o atributo que especifica o primeiro n� da lista referencie o novo n�
		
		this.tamanho++; //incrementa um no tamanho da lista
	}


	/**
	 * Cria um novo n� com o objeto recebido e o define como �ltimo da lista encadeada
	 * 
	 * @param obj refer�ncia para o objeto que se deseja alocar no �ltimo n� da lista
	 */
	@Override
	public void inserirFinal(Object obj) {
		No novoNo = null; //conter� a refer�ncia para o novo n� que ser� criado
		No auxiliarNo = null; //n� auxiliar para percorrer a lista
		
		novoNo = new No(obj, null); //instancia um novo n� com o objeto recebido e definindo o pr�ximo como null
			
		if(this.estaVazia() == true){ //verifica se a lista est� vazia
			this.primeiro = novoNo; //caso a lista esteja vazia o novo n� criado � definido como o primeiro
		}else{
			auxiliarNo = this.primeiro; //atribui a refer�ncia do primeiro n� � vari�vel que ser� utilizada no processo de percorrer a lista
		
			/* No la�o de repeti��o abaixo a lista � percorrida enquanto o �ltimo n� dela n�o � encontrado, de forma a obter
			 * a refer�ncia para este �ltimo n� e utiliz�-la no processso de inserir no final. */
			while(auxiliarNo.getProximo() != null){ //verifica se o n� atual cont�m uma refer�ncia n�o null para pr�ximo n�, isto �, se o n� atual n�o � o �ltimo da lista
				auxiliarNo = auxiliarNo.getProximo(); //faz com que o n� auxiliar referencie para o pr�ximo n�
			}
				
			auxiliarNo.setProximo(novoNo); //faz com que a refer�ncia de pr�ximo do n� atual seja o novo n�
		}
			
		this.tamanho++; //incrementa um no tamanho da lista
	}


	/**
	 * Remove o primeiro n� da lista encadeada, se a lista n�o estiver vazia, retornando a refer�ncia para o objeto contido 
	 * no n� removido.
	 * @return refer�ncia para o objeto contido no primeiro n� da lista; <code>null</code>, caso a lista esteja vazia
	 */
	@Override
	public Object removerInicio() {
		Object objRemovido = null; //auxiliar que conter� a refer�ncia para o objeto contido no n� removido
		
		if(this.estaVazia() == true){ //verifica se a lista est� vazia
			return null; //caso a lista esteja vazia retorna uma refer�ncia null
		}
		
		objRemovido = this.primeiro.getObj(); //obt�m a refer�ncia do objeto contido no primeiro n� da lista
		
		this.primeiro = this.primeiro.getProximo(); //faz o primeiro n� apontar para o segundo n� da lista, de forma que a refer�ncia deste primeiro n� � perdida
		
		this.tamanho--; //diminui em um o tamanho da lista
		
		return objRemovido; //retorna o objeto contido no n� removido
	}


	/**
	 * Remove o �ltimo n� da lista encadeada, se a lista n�o estiver vazia, retornando a refer�ncia para o objeto contido no 
	 * n� removido.
	 * @return refer�ncia para o objeto contido no �ltimo n� da lista; <code>null</code>, caso a lista esteja vazia
	 */
	@Override
	public Object removerFinal() {
		No atual = null; //refer�ncia para um n� atual afim de auxiliar no percorrimento da lista
		No anterior = null; //refer�ncia para um n� anterior para auxiliar no percorrimento da lista
		
		atual = this.primeiro; //obt�m a refer�ncia do primeiro n�
		
		if(this.estaVazia() == true){ //verifica se a lista est� vazia
			return null; //caso a lista esteja vazia retorna uma refer�ncia null
		}
		
		/* No la�o de repeti��o abaixo a lista � percorrida enquanto o �ltimo n� dela n�o � encontrado, de forma a obter
		 * a refer�ncia para este �ltimo n� e utiliz�-la no processso de remover no final da lista. */
		while(atual.getProximo() != null){ //verifica se o n� atual cont�m uma refer�ncia n�o null para pr�ximo n�, isto �, se o n� atual n�o � o �ltimo da lista
			anterior = atual; //obt�m a refer�ncia do n� anterior ao atual
			atual = atual.getProximo(); //obt�m a refer�ncia para o n� que sucede o atual na lista
		}	
		
		anterior.setProximo(null); //configura como null a refer�ncia de pr�ximo do n� anterior ao �ltimo
		
		this.tamanho--; //diminui em um o tamanho da lista
		
		return atual.getObj(); //retorna o objeto contido no n� removido da lista
	}


	/**
	 * Remove um n� qualquer da lista por meio do index especificado, retornando a refer�ncia do objeto contido no 
	 * n� removido.
	 * 
	 * @param index do n� que ser� removido
	 * @return refer�ncia do objeto contido no n� removido
	 */
	@Override
	public Object remover(int index) {
		int contador = 0; //contador para auxiliar na busca do objeto cujo index foi fornecido
		No atual = null; //refer�ncia para um n� atual afim de auxiliar no percorrimento da lista
		No anterior = null; //refer�ncia para um n� anterior para auxiliar no percorrimento da lista
		
		atual = this.primeiro; //obt�m a refer�ncia do primeiro n� da lista
		
		if(this.estaVazia() == true || index > this.obterTamanho()-1 || index < 0){ //verifica se a lista est� vazia e se o index fornecido � v�lido (n�o � menor que 0 ou maior do que esperado)
			return null; //retorna null caso o index seja inv�lido ou se a lista estiver vazia
		}else if(index == 0){ //verifica se o index fornecido � 0, isto �, se o n� que ser� removido � o primeiro
			return this.removerInicio(); //chama o m�todo de remover no in�cio, retornando o objeto contido no n� removido
		}else if(index == this.obterTamanho()-1){ //verifica se o index fornecido corresponde ao �ltimo index v�lido da lista, isto �, se o n� que ser� removido � o �ltimo da lista
			return removerFinal(); //chama o m�todo de remover do final, retornando o objeto contido no n� removido
		}
		
		/* No la�o de repeti��o abaixo a lista � percorrida enquanto o valor do contador n�o se iguala ao index, isto �, 
		 * enquanto n�o foi encontrado o n� correspondente ao index fornecido. */
		while(index != contador){ //verifica se o valor do index � diferente do contador
			anterior = atual; //guarda a refer�ncia para o n� anterior
			atual = atual.getProximo(); //obt�m a refer�ncia do pr�ximo n�
			contador++; //incrementa o contador com um
		}
		
		anterior.setProximo(atual.getProximo()); //configura o atributo proximo do n� anterior ao removido com a refer�ncia do n� seguinte ao removido
		
		this.tamanho--; //diminui em um o tamanho da lista
		
		return atual.getObj(); //retorna a refer�ncia para o objeto contido no n� removido
	}

	/** Recupera a refer�ncia para o objeto contido no n� cujo index foi especificado, se a lsta n�o estiver vazia e o valor de index informado for v�lido.
	 * 
	 *  @param index posi��o do n� que cont�m o objeto desejado
	 * 	@return refer�ncia para objeto contido no n� cujo index foi especificado, se o index for v�lido; <code>null</code>, caso contr�rio.
	 */
	@Override
	public Object recuperar(int index) {
		int contador = 0; //contador para auxiliar na busca do objeto cujo index foi fornecido
		No auxiliarNo = null; //n� auxiliar 
		
		if(this.estaVazia() == true || index > this.obterTamanho()-1 || index < 0){ //verifica se a lista est� vazia e se o index fornecido � v�lido (n�o � menor que 0 ou maior do que esperado)
			return null; //retorna null caso o index seja inv�lido ou se a lista estiver vazia
		}
		
		auxiliarNo = this.primeiro; //obt�m o primeiro n� da lista

		/* No la�o de repeti��o abaixo a lista � percorrida enquanto o valor do contador n�o se iguala ao index, isto �, 
		 * enquanto n�o foi encontrado o n� correspondente ao index fornecido. */
		while(index != contador){ //verifica se o valor do index � diferente do contador
			auxiliarNo = auxiliarNo.getProximo(); //obt�m o pr�ximo n�
			contador++; //incrementa um no contador
		}
		
		return auxiliarNo.getObj(); //retorna o objeto contido no n� encontrado
	}
	
	/**
	 * Recupera a refer�ncia para um n� da lista tendo como par�metro de busca o index do n�.
	 *
	 * @param index �ndice do n� na lista encadeada
	 * @return refer�ncia para um n�, se o index for v�lido; <code>null</code>, caso contr�rio.
	 */
	/* A cria��o do m�todo abaixo foi fundamental para o processo de trocar objetos entre dois n�s, um dos m�todos 
	 * necess�rios na ordena��o implementada. */
	public No recuperarNo(int index){
		No noAuxiliar = null; //n� para auxiliar no processo de busca
		int cont = 0; //contador auxiliar
		
		if(this.estaVazia() == true || index > this.obterTamanho()-1 || index < 0){ //verifica se a lista est� vazia e se o index fornecido � v�lido (n�o � menor que 0 ou maior do que esperado)
			return null; //retorna null caso o index seja inv�lido ou se a lista estiver vazia
		}

		noAuxiliar = this.primeiro; //obt�m a refer�ncia para o primeiro n� da lista
		
		/* No la�o de repeti��o abaixo � buscado o n� que est� no index indicado. A cada itera��o o contador � incrementado
		 * de 1. 
		 */
		while(noAuxiliar != null && cont != index){ //enquanto n�o for encontrado localizado o n� contido no index informado o la�o de repeti��o prossegue
			cont++; //incrementa 1 no contador
			noAuxiliar = noAuxiliar.getProximo(); //obt�m a refer�ncia para o pr�ximo n�
		}
		
		return noAuxiliar; //retorna a refer�ncia para o n� desejado
	}
	
	/**
	 * Inicia o processo de ordena��o da lista.
	 */
	public void ordenar() {
		mergeSort(0, tamanho-1); //chama o m�todo de ordena��o MergeSort passando o primeiro index da lista e o �ltimo
	}
	
	/**
	 * Realiza a ordena��o por meio do m�todo MergeSort do conjunto de itens da lista contidos no intervalo fechado de �ndices 
	 * informados.
	 * @param indexFrente index na lista do primeiro elemento do conjunto que ser� ordenado
	 * @param indexFundo index na lista do �ltimo elemento do conjunto que ser� ordenado
	 */
	public void mergeSort(int indexFrente, int indexFundo) {
		if(indexFrente >= indexFundo) { //caso base da recurs�o, verifica se o index da frente � maior ou igual o do fundo, isto �, se a "sublista" selecionada tem apenas um elemento
			return;
		} else {
			int indexMeio = (indexFrente+indexFundo)/2; //calcula o index da posi��o ao meio
			mergeSort(indexFrente, indexMeio); //realiza a ordena��o da primeira parte da lista
			mergeSort(indexMeio+1, indexFundo); //realiza a ordena��o da segunda parte da lista
			merge(indexFrente, indexFundo); //funde ordenadamente as metades ordenadas
		}
	}
	
	/**
	 * Separa ao meio e funde ordenadamente o conjunto de itens da lista contidos no intervalo fechado de �ndices
	 * informados.
	 * @param indexFrente index na lista do primeiro elemento do conjunto a ser fundido ordenadamente
	 * @param indexFundo index na lista do segundo elemento do conjunto a ser fundido ordenadamente
	 */
	public void merge(int indexFrente, int indexFundo) {
		ListaEncadeada listaTemporaria = new ListaEncadeada(); //lista para armazenamento tempor�rio dos elementos ordenados
		int indexMeio = (indexFrente+indexFundo)/2; //calcula o index da posi��o ao meio
		int ponteiroFrente = indexFrente; //cria um "ponteiro" que percorrer� a sublista a partir da frente
		int ponteiroMeio = indexMeio+1; //cria um "ponteiro" que percorrer� a lista a sublista a partir de um index ap�s o index do meio
		
		/* Nesse la�o de repeti��o a sublista ser� percorrida a partir do seu in�cio (pelo "pontiroFrente") e a partir do seu meio (pelo "ponteiroMeio"), de forma 
		 * que cada elemento selecionado pelo ponteiroFrente ser� comparado com cada elemento selecionado pelo "ponteiroMeio" e ocorrer� o armazenamento desses itens
		 * de forma ordenada na lista tempor�ria.
		 */
		while(ponteiroFrente <= indexMeio && ponteiroMeio <= indexFundo) { //verifica se o ponteiro da frente j� chegou na sua posi��o limite (ao meio da sublista) e se o ponteiro do meio j� chegou na sua posi��o limite (ao fim da sublista)
			Comparavel objetoComparavel1 = (Comparavel) this.recuperar(ponteiroFrente); //obt�m o objeto contido na posi��o do ponteiroFrente
			Comparavel objetoComparavel2 = (Comparavel) this.recuperar(ponteiroMeio); //obt�m o objeto contido na posi��o do ponteiroMeio
			
			if(objetoComparavel1.comparacao(objetoComparavel2) == -1) {//verifica se o objeto contido na posi��o do ponteiroFrente � menor do que o objeto contido na posi��o do ponteiroMeio
				listaTemporaria.inserirFinal(objetoComparavel1); //insere o objeto menor no final da lista tempor�ria
				ponteiroFrente++; //faz o ponteiro da frente andar, isto �, incrementa ele com 1
			} else { //caso a condi��o principal n�o seja satisfeita
				listaTemporaria.inserirFinal(objetoComparavel2); //insere o objeto menor no final da lista
				ponteiroMeio++; //faz o ponteiro do meio andar, isto �, incrementa ele com 1
			}
		}
		
		/* Verifica se h� algum elemento sobrando na primeira metade da sublista e, se houver, acrescenta eles no
		 * final da lista tempor�ria.
		 */
		while(ponteiroFrente <= indexMeio) {
			listaTemporaria.inserirFinal(this.recuperar(ponteiroFrente++));
		}
		
		/* Verifica se h� algum elemento sobrando na segunda metade da sublista e, se houver, acrescenta eles no
		 * final da lista tempor�ria.
		 */
		while(ponteiroMeio <= indexFundo) {
			listaTemporaria.inserirFinal(this.recuperar(ponteiroMeio++));
		}
			
		/* Transfere os elementos, j� ordenados, para as suas posi��es corretas na lista original. */
		for (int i=indexFrente, j=0; i<=indexFundo; i++, j++) {
			this.recuperarNo(i).setObj(listaTemporaria.recuperar(j));
			
		}
		
	}
	
	
	/**
	 * Retorna o index na lista encadeada de um dado objeto ou -1 caso n�o tenha sido poss�vel encontrar o objeto.
	 * @param obj refer�ncia para objeto que deseja-se obter index
	 * @return index do objeto na lista encadeada; -1 se n�o existir o objeto especificado.
	 */
	public int obterIndex(Object obj){
		int index = 0; //index que ser� retornado
		No noAtual = null; //refer�ncia para o n� atual enquanto percorre a lista
		boolean encontrou = false; //indica se j� foi encontrado o objeto procurado
		
		if(this.estaVazia() == true || obj == null){ //verifica se a lista est� vazia
			return -1; //retorna -1 caso a condi��o seja satisfeita
		}
		
		noAtual = this.primeiro; //o n� atual recebe a refer�ncia para o primeiro n� da lista
		
		/* Nesse la�o de repeti��o � feita uma busca em cada n� da lista encadeada pelo objeto especificado. Enquanto ele n�o � encontrado o valor
		 * do index � acrescido de 1.
		 */
		while(noAtual != null && encontrou == false){ //verifica se o fim da lista foi antigido e se o objeto buscado n�o foi encontrado antes de continuar a busc
			if(noAtual.getObj().equals(obj) == false){ //verifica se o objeto contido no n� atual possui a mesma refer�ncia que o objeto recebido por par�metro
				index++; //incrementa um no index
			} else{
				encontrou = true; //modifica o valor booleano da vari�vel indicando que o objeto foi encontrado
			}
			
			noAtual = noAtual.getProximo(); //faz o n� atual da itera��o receber a refer�ncia do pr�ximo n�
		}
		
		if(encontrou == true){ //verifica se o objeto buscado foi encontrado
			return index; //index do objeto buscado
		} else{
			return -1; //retorna -1 caso n�o tenha sido poss�vel encontrar o objeto
		}
	}
	

	/**
	 * Retorna um iterador para percorrer a lista encadeada em sequ�ncia.
	 * 
	 * @return iterador da lista encadeada
	 */
	@Override
	public Iterador iterador() {
		return new IteradorLista(primeiro); //cria uma nova instancia de iterador passando a refer�ncia para o primeiro n� da lista e o retorna
	}

}
