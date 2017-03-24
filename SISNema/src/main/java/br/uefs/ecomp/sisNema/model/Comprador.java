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

package br.uefs.ecomp.sisNema.model;

import br.uefs.ecomp.sisNema.util.Comparavel;

/**
 * Classe respons�vel por moldar um comprador no sistema. Possui m�todos para obten��o e configura��o
 * dos atributos de um comprador.
 * 
 * @author Valmir Vinicius
 * @see java.lang.String
 * @see br.uefs.ecomp.sisNema.model.Endereco
 */

public class Comprador implements Comparavel {
	
	/** Nome do comprador. */
	private String nome;
	
	/** Endere�o do comprador. */
	private Endereco endereco;
	
	/** Telefone do comprador. */
	private String telefone;
	
	/** Email do comprador. */
	private String email;
	
	/** N�mero de um documento do comprador para identifica��o. */
	private int documento;
	
	
	/**
	 * Retorna o nome do comprador
	 *
	 * @return nome do comprador
	 */
	public String getNome() {
		return nome; //retorna o atributo "nome"
	}
	
	/**
	 * Configura o nome do comprador.
	 *
	 * @param nome novo nome do comprador
	 */
	public void setNome(String nome) {
		this.nome = nome; //atribui o nome recebido ao atributo "nome"
	}
	
	/**
	 * Retorna o endere�o de um comprador.
	 *
	 * @return endere�o do comprador
	 */
	public Endereco getEndereco() {
		return endereco; //retorna o atributo "endereco"
	}
	
	/**
	 * Configura o endere�o do comprador.
	 *
	 * @param endereco novo endere�o do comprador
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco; //atribui o endere�o recebido ao atributo "endereco"
	}
	
	/**
	 * Retorna o telefone do comprador.
	 *
	 * @return telefone do comprador
	 */
	public String getTelefone() {
		return telefone; //retorna o atributo "telefone"
	}
	
	/**
	 * Configura um novo telefone para o comprador.
	 *
	 * @param telefone novo telefone do comprador
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone; //atribui o telefone recebido ao atributo "telefone"
	}
	
	/**
	 * Retorna o email do comprador.
	 *
	 * @return email do comprador.
	 */
	public String getEmail() {
		return email; //retorna o atributo "email"
	}
	
	/**
	 * Configura o novo email do comprador.
	 *
	 * @param email novo email do comprador
	 */
	public void setEmail(String email) {
		this.email = email; //atribui o email recebido ao atributo "email"
	}
	
	/**
	 * Retorna o n�mero do documento do comprador.
	 *
	 * @return numero do documento
	 */
	public int getDocumento() {
		return documento; //retorna o atributo "numDocumento"
	}
	
	/**
	 * Configura um novo n�mero de documento ao comprador.
	 *
	 * @param documento novo numero de documento do comprador
	 */
	public void setDocumento(int documento) {
		this.documento = documento; //atributo o n�mero de documento recebido ao atributo "numDocumento"
	}

	/**
	 * Compara alfabeticamente o nome desse comprador com o de um comprador recebido por
	 * par�metro.
	 * 
	 * @return 1, -1 ou 0, se o nome do comprador desse comprador for alfabeticamente maior, menor ou
	 * igual ao nome do comprador recebido por par�metro.
	 */
	@Override
	public int comparacao(Object obj) {
		Comprador auxiliarComprador = (Comprador) obj;
		
		if(this.getNome().compareToIgnoreCase(auxiliarComprador.getNome()) < 0) { //verifica se o nome desse comprador � alfabeticamente menor que o nome do comprador recebido por par�metro 
			return -1; 
		} else if(this.getNome().compareToIgnoreCase(auxiliarComprador.getNome()) > 0) {//verifica se o nome desse comprador � alfabeticamente maior que o nome do comprador recebido por par�metro 
			return 1;
		} else {
			return 0; //retorna 0 indicando que nenhuma condi��o anterior foi satisfeita e que, portanto, os nome s�o alfabeticamente iguais
		}
	}
}
