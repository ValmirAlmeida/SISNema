package br.uefs.ecomp.sisNema.model;

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

/**
 * Classe respons�vel por moldar um endere�o no sistema. Possui m�todos para obten��o e configura��o dos atributos desse
 * endere�o.
 * 
 * @author Valmir Vinicius
 * @see java.lang.String
 */

public class Endereco {

	/** Nome da rua. */
	private String rua;
	
	/** N�mero da casa. */
	private int numero;
	
	/** Nome do bairro. */
	private String bairro;
	
	/** CEP da localidade. */
	private String cep;
	
	/** Nome da cidade. */
	private String cidade;
	
	/** Nome do estado. */
	private String estado;
	
	/** Informa��o complementar do endere�o. */
	private String complemento;
	

	/**
	 * M�todo para obten��o do nome da rua que faz parte do endere�o.
	 *
	 * @return nome da rua
	 */
	public String getRua() {
		return rua; //retorna a refer�ncia do atributo "rua"
	}
	
	/**
	 * Configura a rua do endere�o. 
	 *
	 * @param rua nome da rua
	 */
	public void setRua(String rua){
		this.rua = rua; //atribui a refer�ncia recebida por par�metro ao atributo "rua"
	}

	/**
	 * M�todo para obten��o do n�mero que faz parte do endere�o.
	 *
	 * @return n�mero do endere�o
	 */
	public int getNumero() {
		return numero; //retorna o inteiro correspondenete ao atributo "numero"
	}
	
	/**
	 * Configura o n�mero do endere�o.
	 *
	 * @param numero n�mero do endere�o
	 */
	public void setNumero(int numero){
		this.numero = numero; //atribui o inteiro recebido por par�metro ao atributo "numero"
	}

	/**
	 * M�todo para obten��o do nome do bairro que faz parte do endere�o.
	 *
	 * @return nome do bairro
	 */
	public String getBairro() {
		return bairro; //retorna a refer�ncia do atributo "bairro"
	}
	
	/**
	 * Configura o nome bairro do endere�o.
	 *
	 * @param bairro nome do bairro
	 */
	public void setBairro(String bairro){
		this.bairro = bairro; //atribui a refer�ncia recebida por par�metro ao atributo "bairro"
	}

	/**
	 * M�todo para obten��o do CEP que faz parte do endere�o.
	 *
	 * @return CEP do endere�o
	 */
	public String getCep() {
		return cep; //retorna a refer�ncia do atributo "cep"
	}
	
	/**
	 * Configura o CEP do endere�o.
	 *
	 * @param cep cep do endere�o
	 */
	public void setCep(String cep){
		this.cep = cep; //atribui a refer�ncia recebida por par�metro ao atributo "cep"
	}

	/**
	 * M�todo para obten��o do nome da cidade que faz parte do endere�o.
	 *
	 * @return nome da cidade
	 */
	public String getCidade() {
		return cidade; //retorna a refer�ncia do atributo "cidade"
	}
	
	/**
	 * Configura o nome da cidade do endere�o.
	 *
	 * @param cidade nome da cidade
	 */
	public void setCidade(String cidade){
		this.cidade = cidade; //atribui a refer�ncia recebida por par�metro ao atributo "cep"
	}

	/**
	 * M�todo para obten��o do nome do estado que faz parte do endere�o.
	 *
	 * @return nome do estado
	 */
	public String getEstado() {
		return estado; //retorna a refer�ncia do atributo "estado"
	}
	
	/**
	 * Configura o nome do estado do endere�o.
	 *
	 * @param estado nome do estado
	 */
	public void setEstado(String estado){
		this.estado = estado; //atribui a refer�ncia recebida por par�metro ao atributo "estado"
	}

	/**
	 * Retorna a informa��o complementar do endere�o.
	 *
	 * @return informa��o complementar do endere�o
	 */
	public String getComplemento() {
		return complemento; //retorna a refer�ncia atributo "complemento"
	}
	
	/**
	 * Configura a informa��o complementar do endere�o.
	 *
	 * @param complemento informa��o complementar do endere�o
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento; //atribui a refer�ncia recebida por par�metro ao atributo "complemento"
	} 


}
