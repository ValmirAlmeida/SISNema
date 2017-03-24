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
 * Classe que implementa uma lista encadeada. Permite que operações de inserção, remoção, obtenção, ordenação e
 * acompanhamento do estado da lista (obter o tamanho e verificar se está vazia).
 * 
 * @author Valmir Vinicius
 */

public class ListaEncadeada implements ILista {

	/** Referência para o primeiro nó da lista. */
	private No primeiro;
	
	/** Tamanho da lista encadeada. */
	private int tamanho;
	
	/* Na medida do possível, as especificações em JAVADOC aqui contidas buscam focar mais no modo de implementação utilizando, visando 
	 * fornecer maiores detalhes para quem acessar a documentação do sistema e evitar repetições do que foi antes explicitado no JAVADOC
	 * da interface implementada por essa classe.
	 */
	
	/**
	 * Verifica se a lista encadeada está vazia.
	 * 
	 * @return <code>true</code>, se o primeiro nó da lista for uma referência <code>null</code>; <code>false</code>, caso contrário
	 */
	@Override
	public boolean estaVazia() {
		return this.primeiro == null; //verifica se o primeiro nó da lista possui uma referência null e retorna o resultado booleano da comparação
	}


	/**
	 * Retorna a quantidade de nós da lista encadeada.
	 * 
	 * @return número de nós da lista encadeada
	 */
	@Override
	public int obterTamanho() {
		return this.tamanho; //retorna o atributo correspondente ao tamanho da lista
	}

	/**
	 * Cria um novo nó com o objeto recebido e o define como primeiro da lista.
	 * 
	 * @param obj referência para o objeto que se deseja alocar no primeiro nó da lista
	 */
	@Override
	public void inserirInicio(Object obj) {
		No novoNo = null; //referência para o novo nó da lista
		
		if(this.estaVazia() == true){ //verifica se a lista está vazia
			novoNo = new No(obj, null); //se a lista estiver vazia o novo nó é criado tendo uma referência null para próximo nó
		}else{
			novoNo = new No(obj, this.primeiro); //caso já existam nós na lista o novo nó é criado tendo a referência para o primeiro nó atual como próximo
		}
		
		this.primeiro = novoNo; //faz com que o atributo que especifica o primeiro nó da lista referencie o novo nó
		
		this.tamanho++; //incrementa um no tamanho da lista
	}


	/**
	 * Cria um novo nó com o objeto recebido e o define como último da lista encadeada
	 * 
	 * @param obj referência para o objeto que se deseja alocar no último nó da lista
	 */
	@Override
	public void inserirFinal(Object obj) {
		No novoNo = null; //conterá a referência para o novo nó que será criado
		No auxiliarNo = null; //nó auxiliar para percorrer a lista
		
		novoNo = new No(obj, null); //instancia um novo nó com o objeto recebido e definindo o próximo como null
			
		if(this.estaVazia() == true){ //verifica se a lista está vazia
			this.primeiro = novoNo; //caso a lista esteja vazia o novo nó criado é definido como o primeiro
		}else{
			auxiliarNo = this.primeiro; //atribui a referência do primeiro nó à variável que será utilizada no processo de percorrer a lista
		
			/* No laço de repetição abaixo a lista é percorrida enquanto o último nó dela não é encontrado, de forma a obter
			 * a referência para este último nó e utilizá-la no processso de inserir no final. */
			while(auxiliarNo.getProximo() != null){ //verifica se o nó atual contém uma referência não null para próximo nó, isto é, se o nó atual não é o último da lista
				auxiliarNo = auxiliarNo.getProximo(); //faz com que o nó auxiliar referencie para o próximo nó
			}
				
			auxiliarNo.setProximo(novoNo); //faz com que a referência de próximo do nó atual seja o novo nó
		}
			
		this.tamanho++; //incrementa um no tamanho da lista
	}


	/**
	 * Remove o primeiro nó da lista encadeada, se a lista não estiver vazia, retornando a referência para o objeto contido 
	 * no nó removido.
	 * @return referência para o objeto contido no primeiro nó da lista; <code>null</code>, caso a lista esteja vazia
	 */
	@Override
	public Object removerInicio() {
		Object objRemovido = null; //auxiliar que conterá a referência para o objeto contido no nó removido
		
		if(this.estaVazia() == true){ //verifica se a lista está vazia
			return null; //caso a lista esteja vazia retorna uma referência null
		}
		
		objRemovido = this.primeiro.getObj(); //obtém a referência do objeto contido no primeiro nó da lista
		
		this.primeiro = this.primeiro.getProximo(); //faz o primeiro nó apontar para o segundo nó da lista, de forma que a referência deste primeiro nó é perdida
		
		this.tamanho--; //diminui em um o tamanho da lista
		
		return objRemovido; //retorna o objeto contido no nó removido
	}


	/**
	 * Remove o último nó da lista encadeada, se a lista não estiver vazia, retornando a referência para o objeto contido no 
	 * nó removido.
	 * @return referência para o objeto contido no último nó da lista; <code>null</code>, caso a lista esteja vazia
	 */
	@Override
	public Object removerFinal() {
		No atual = null; //referência para um nó atual afim de auxiliar no percorrimento da lista
		No anterior = null; //referência para um nó anterior para auxiliar no percorrimento da lista
		
		atual = this.primeiro; //obtém a referência do primeiro nó
		
		if(this.estaVazia() == true){ //verifica se a lista está vazia
			return null; //caso a lista esteja vazia retorna uma referência null
		}
		
		/* No laço de repetição abaixo a lista é percorrida enquanto o último nó dela não é encontrado, de forma a obter
		 * a referência para este último nó e utilizá-la no processso de remover no final da lista. */
		while(atual.getProximo() != null){ //verifica se o nó atual contém uma referência não null para próximo nó, isto é, se o nó atual não é o último da lista
			anterior = atual; //obtém a referência do nó anterior ao atual
			atual = atual.getProximo(); //obtém a referência para o nó que sucede o atual na lista
		}	
		
		anterior.setProximo(null); //configura como null a referência de próximo do nó anterior ao último
		
		this.tamanho--; //diminui em um o tamanho da lista
		
		return atual.getObj(); //retorna o objeto contido no nó removido da lista
	}


	/**
	 * Remove um nó qualquer da lista por meio do index especificado, retornando a referência do objeto contido no 
	 * nó removido.
	 * 
	 * @param index do nó que será removido
	 * @return referência do objeto contido no nó removido
	 */
	@Override
	public Object remover(int index) {
		int contador = 0; //contador para auxiliar na busca do objeto cujo index foi fornecido
		No atual = null; //referência para um nó atual afim de auxiliar no percorrimento da lista
		No anterior = null; //referência para um nó anterior para auxiliar no percorrimento da lista
		
		atual = this.primeiro; //obtém a referência do primeiro nó da lista
		
		if(this.estaVazia() == true || index > this.obterTamanho()-1 || index < 0){ //verifica se a lista está vazia e se o index fornecido é válido (não é menor que 0 ou maior do que esperado)
			return null; //retorna null caso o index seja inválido ou se a lista estiver vazia
		}else if(index == 0){ //verifica se o index fornecido é 0, isto é, se o nó que será removido é o primeiro
			return this.removerInicio(); //chama o método de remover no início, retornando o objeto contido no nó removido
		}else if(index == this.obterTamanho()-1){ //verifica se o index fornecido corresponde ao último index válido da lista, isto é, se o nó que será removido é o último da lista
			return removerFinal(); //chama o método de remover do final, retornando o objeto contido no nó removido
		}
		
		/* No laço de repetição abaixo a lista é percorrida enquanto o valor do contador não se iguala ao index, isto é, 
		 * enquanto não foi encontrado o nó correspondente ao index fornecido. */
		while(index != contador){ //verifica se o valor do index é diferente do contador
			anterior = atual; //guarda a referência para o nó anterior
			atual = atual.getProximo(); //obtém a referência do próximo nó
			contador++; //incrementa o contador com um
		}
		
		anterior.setProximo(atual.getProximo()); //configura o atributo proximo do nó anterior ao removido com a referência do nó seguinte ao removido
		
		this.tamanho--; //diminui em um o tamanho da lista
		
		return atual.getObj(); //retorna a referência para o objeto contido no nó removido
	}

	/** Recupera a referência para o objeto contido no nó cujo index foi especificado, se a lsta não estiver vazia e o valor de index informado for válido.
	 * 
	 *  @param index posição do nó que contém o objeto desejado
	 * 	@return referência para objeto contido no nó cujo index foi especificado, se o index for válido; <code>null</code>, caso contrário.
	 */
	@Override
	public Object recuperar(int index) {
		int contador = 0; //contador para auxiliar na busca do objeto cujo index foi fornecido
		No auxiliarNo = null; //nó auxiliar 
		
		if(this.estaVazia() == true || index > this.obterTamanho()-1 || index < 0){ //verifica se a lista está vazia e se o index fornecido é válido (não é menor que 0 ou maior do que esperado)
			return null; //retorna null caso o index seja inválido ou se a lista estiver vazia
		}
		
		auxiliarNo = this.primeiro; //obtém o primeiro nó da lista

		/* No laço de repetição abaixo a lista é percorrida enquanto o valor do contador não se iguala ao index, isto é, 
		 * enquanto não foi encontrado o nó correspondente ao index fornecido. */
		while(index != contador){ //verifica se o valor do index é diferente do contador
			auxiliarNo = auxiliarNo.getProximo(); //obtém o próximo nó
			contador++; //incrementa um no contador
		}
		
		return auxiliarNo.getObj(); //retorna o objeto contido no nó encontrado
	}
	
	/**
	 * Recupera a referência para um nó da lista tendo como parâmetro de busca o index do nó.
	 *
	 * @param index índice do nó na lista encadeada
	 * @return referência para um nó, se o index for válido; <code>null</code>, caso contrário.
	 */
	/* A criação do método abaixo foi fundamental para o processo de trocar objetos entre dois nós, um dos métodos 
	 * necessários na ordenação implementada. */
	public No recuperarNo(int index){
		No noAuxiliar = null; //nó para auxiliar no processo de busca
		int cont = 0; //contador auxiliar
		
		if(this.estaVazia() == true || index > this.obterTamanho()-1 || index < 0){ //verifica se a lista está vazia e se o index fornecido é válido (não é menor que 0 ou maior do que esperado)
			return null; //retorna null caso o index seja inválido ou se a lista estiver vazia
		}

		noAuxiliar = this.primeiro; //obtém a referência para o primeiro nó da lista
		
		/* No laço de repetição abaixo é buscado o nó que está no index indicado. A cada iteração o contador é incrementado
		 * de 1. 
		 */
		while(noAuxiliar != null && cont != index){ //enquanto não for encontrado localizado o nó contido no index informado o laço de repetição prossegue
			cont++; //incrementa 1 no contador
			noAuxiliar = noAuxiliar.getProximo(); //obtém a referência para o próximo nó
		}
		
		return noAuxiliar; //retorna a referência para o nó desejado
	}
	
	/**
	 * Inicia o processo de ordenação da lista.
	 */
	public void ordenar() {
		mergeSort(0, tamanho-1); //chama o método de ordenação MergeSort passando o primeiro index da lista e o último
	}
	
	/**
	 * Realiza a ordenação por meio do método MergeSort do conjunto de itens da lista contidos no intervalo fechado de índices 
	 * informados.
	 * @param indexFrente index na lista do primeiro elemento do conjunto que será ordenado
	 * @param indexFundo index na lista do último elemento do conjunto que será ordenado
	 */
	public void mergeSort(int indexFrente, int indexFundo) {
		if(indexFrente >= indexFundo) { //caso base da recursão, verifica se o index da frente é maior ou igual o do fundo, isto é, se a "sublista" selecionada tem apenas um elemento
			return;
		} else {
			int indexMeio = (indexFrente+indexFundo)/2; //calcula o index da posição ao meio
			mergeSort(indexFrente, indexMeio); //realiza a ordenação da primeira parte da lista
			mergeSort(indexMeio+1, indexFundo); //realiza a ordenação da segunda parte da lista
			merge(indexFrente, indexFundo); //funde ordenadamente as metades ordenadas
		}
	}
	
	/**
	 * Separa ao meio e funde ordenadamente o conjunto de itens da lista contidos no intervalo fechado de índices
	 * informados.
	 * @param indexFrente index na lista do primeiro elemento do conjunto a ser fundido ordenadamente
	 * @param indexFundo index na lista do segundo elemento do conjunto a ser fundido ordenadamente
	 */
	public void merge(int indexFrente, int indexFundo) {
		ListaEncadeada listaTemporaria = new ListaEncadeada(); //lista para armazenamento temporário dos elementos ordenados
		int indexMeio = (indexFrente+indexFundo)/2; //calcula o index da posição ao meio
		int ponteiroFrente = indexFrente; //cria um "ponteiro" que percorrerá a sublista a partir da frente
		int ponteiroMeio = indexMeio+1; //cria um "ponteiro" que percorrerá a lista a sublista a partir de um index após o index do meio
		
		/* Nesse laço de repetição a sublista será percorrida a partir do seu início (pelo "pontiroFrente") e a partir do seu meio (pelo "ponteiroMeio"), de forma 
		 * que cada elemento selecionado pelo ponteiroFrente será comparado com cada elemento selecionado pelo "ponteiroMeio" e ocorrerá o armazenamento desses itens
		 * de forma ordenada na lista temporária.
		 */
		while(ponteiroFrente <= indexMeio && ponteiroMeio <= indexFundo) { //verifica se o ponteiro da frente já chegou na sua posição limite (ao meio da sublista) e se o ponteiro do meio já chegou na sua posição limite (ao fim da sublista)
			Comparavel objetoComparavel1 = (Comparavel) this.recuperar(ponteiroFrente); //obtém o objeto contido na posição do ponteiroFrente
			Comparavel objetoComparavel2 = (Comparavel) this.recuperar(ponteiroMeio); //obtém o objeto contido na posição do ponteiroMeio
			
			if(objetoComparavel1.comparacao(objetoComparavel2) == -1) {//verifica se o objeto contido na posição do ponteiroFrente é menor do que o objeto contido na posição do ponteiroMeio
				listaTemporaria.inserirFinal(objetoComparavel1); //insere o objeto menor no final da lista temporária
				ponteiroFrente++; //faz o ponteiro da frente andar, isto é, incrementa ele com 1
			} else { //caso a condição principal não seja satisfeita
				listaTemporaria.inserirFinal(objetoComparavel2); //insere o objeto menor no final da lista
				ponteiroMeio++; //faz o ponteiro do meio andar, isto é, incrementa ele com 1
			}
		}
		
		/* Verifica se há algum elemento sobrando na primeira metade da sublista e, se houver, acrescenta eles no
		 * final da lista temporária.
		 */
		while(ponteiroFrente <= indexMeio) {
			listaTemporaria.inserirFinal(this.recuperar(ponteiroFrente++));
		}
		
		/* Verifica se há algum elemento sobrando na segunda metade da sublista e, se houver, acrescenta eles no
		 * final da lista temporária.
		 */
		while(ponteiroMeio <= indexFundo) {
			listaTemporaria.inserirFinal(this.recuperar(ponteiroMeio++));
		}
			
		/* Transfere os elementos, já ordenados, para as suas posições corretas na lista original. */
		for (int i=indexFrente, j=0; i<=indexFundo; i++, j++) {
			this.recuperarNo(i).setObj(listaTemporaria.recuperar(j));
			
		}
		
	}
	
	
	/**
	 * Retorna o index na lista encadeada de um dado objeto ou -1 caso não tenha sido possível encontrar o objeto.
	 * @param obj referência para objeto que deseja-se obter index
	 * @return index do objeto na lista encadeada; -1 se não existir o objeto especificado.
	 */
	public int obterIndex(Object obj){
		int index = 0; //index que será retornado
		No noAtual = null; //referência para o nó atual enquanto percorre a lista
		boolean encontrou = false; //indica se já foi encontrado o objeto procurado
		
		if(this.estaVazia() == true || obj == null){ //verifica se a lista está vazia
			return -1; //retorna -1 caso a condição seja satisfeita
		}
		
		noAtual = this.primeiro; //o nó atual recebe a referência para o primeiro nó da lista
		
		/* Nesse laço de repetição é feita uma busca em cada nó da lista encadeada pelo objeto especificado. Enquanto ele não é encontrado o valor
		 * do index é acrescido de 1.
		 */
		while(noAtual != null && encontrou == false){ //verifica se o fim da lista foi antigido e se o objeto buscado não foi encontrado antes de continuar a busc
			if(noAtual.getObj().equals(obj) == false){ //verifica se o objeto contido no nó atual possui a mesma referência que o objeto recebido por parâmetro
				index++; //incrementa um no index
			} else{
				encontrou = true; //modifica o valor booleano da variável indicando que o objeto foi encontrado
			}
			
			noAtual = noAtual.getProximo(); //faz o nó atual da iteração receber a referência do próximo nó
		}
		
		if(encontrou == true){ //verifica se o objeto buscado foi encontrado
			return index; //index do objeto buscado
		} else{
			return -1; //retorna -1 caso não tenha sido possível encontrar o objeto
		}
	}
	

	/**
	 * Retorna um iterador para percorrer a lista encadeada em sequência.
	 * 
	 * @return iterador da lista encadeada
	 */
	@Override
	public Iterador iterador() {
		return new IteradorLista(primeiro); //cria uma nova instancia de iterador passando a referência para o primeiro nó da lista e o retorna
	}

}
