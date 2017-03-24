package br.uefs.ecomp.sisNema.model;

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

/**
 * Classe responsável por moldar um endereço no sistema. Possui métodos para obtenção e configuração dos atributos desse
 * endereço.
 * 
 * @author Valmir Vinicius
 * @see java.lang.String
 */

public class Endereco {

	/** Nome da rua. */
	private String rua;
	
	/** Número da casa. */
	private int numero;
	
	/** Nome do bairro. */
	private String bairro;
	
	/** CEP da localidade. */
	private String cep;
	
	/** Nome da cidade. */
	private String cidade;
	
	/** Nome do estado. */
	private String estado;
	
	/** Informação complementar do endereço. */
	private String complemento;
	

	/**
	 * Método para obtenção do nome da rua que faz parte do endereço.
	 *
	 * @return nome da rua
	 */
	public String getRua() {
		return rua; //retorna a referência do atributo "rua"
	}
	
	/**
	 * Configura a rua do endereço. 
	 *
	 * @param rua nome da rua
	 */
	public void setRua(String rua){
		this.rua = rua; //atribui a referência recebida por parâmetro ao atributo "rua"
	}

	/**
	 * Método para obtenção do número que faz parte do endereço.
	 *
	 * @return número do endereço
	 */
	public int getNumero() {
		return numero; //retorna o inteiro correspondenete ao atributo "numero"
	}
	
	/**
	 * Configura o número do endereço.
	 *
	 * @param numero número do endereço
	 */
	public void setNumero(int numero){
		this.numero = numero; //atribui o inteiro recebido por parâmetro ao atributo "numero"
	}

	/**
	 * Método para obtenção do nome do bairro que faz parte do endereço.
	 *
	 * @return nome do bairro
	 */
	public String getBairro() {
		return bairro; //retorna a referência do atributo "bairro"
	}
	
	/**
	 * Configura o nome bairro do endereço.
	 *
	 * @param bairro nome do bairro
	 */
	public void setBairro(String bairro){
		this.bairro = bairro; //atribui a referência recebida por parâmetro ao atributo "bairro"
	}

	/**
	 * Método para obtenção do CEP que faz parte do endereço.
	 *
	 * @return CEP do endereço
	 */
	public String getCep() {
		return cep; //retorna a referência do atributo "cep"
	}
	
	/**
	 * Configura o CEP do endereço.
	 *
	 * @param cep cep do endereço
	 */
	public void setCep(String cep){
		this.cep = cep; //atribui a referência recebida por parâmetro ao atributo "cep"
	}

	/**
	 * Método para obtenção do nome da cidade que faz parte do endereço.
	 *
	 * @return nome da cidade
	 */
	public String getCidade() {
		return cidade; //retorna a referência do atributo "cidade"
	}
	
	/**
	 * Configura o nome da cidade do endereço.
	 *
	 * @param cidade nome da cidade
	 */
	public void setCidade(String cidade){
		this.cidade = cidade; //atribui a referência recebida por parâmetro ao atributo "cep"
	}

	/**
	 * Método para obtenção do nome do estado que faz parte do endereço.
	 *
	 * @return nome do estado
	 */
	public String getEstado() {
		return estado; //retorna a referência do atributo "estado"
	}
	
	/**
	 * Configura o nome do estado do endereço.
	 *
	 * @param estado nome do estado
	 */
	public void setEstado(String estado){
		this.estado = estado; //atribui a referência recebida por parâmetro ao atributo "estado"
	}

	/**
	 * Retorna a informação complementar do endereço.
	 *
	 * @return informação complementar do endereço
	 */
	public String getComplemento() {
		return complemento; //retorna a referência atributo "complemento"
	}
	
	/**
	 * Configura a informação complementar do endereço.
	 *
	 * @param complemento informação complementar do endereço
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento; //atribui a referência recebida por parâmetro ao atributo "complemento"
	} 


}
