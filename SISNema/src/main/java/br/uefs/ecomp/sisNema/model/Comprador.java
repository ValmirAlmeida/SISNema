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

package br.uefs.ecomp.sisNema.model;

import br.uefs.ecomp.sisNema.util.Comparavel;

/**
 * Classe responsável por moldar um comprador no sistema. Possui métodos para obtenção e configuração
 * dos atributos de um comprador.
 * 
 * @author Valmir Vinicius
 * @see java.lang.String
 * @see br.uefs.ecomp.sisNema.model.Endereco
 */

public class Comprador implements Comparavel {
	
	/** Nome do comprador. */
	private String nome;
	
	/** Endereço do comprador. */
	private Endereco endereco;
	
	/** Telefone do comprador. */
	private String telefone;
	
	/** Email do comprador. */
	private String email;
	
	/** Número de um documento do comprador para identificação. */
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
	 * Retorna o endereço de um comprador.
	 *
	 * @return endereço do comprador
	 */
	public Endereco getEndereco() {
		return endereco; //retorna o atributo "endereco"
	}
	
	/**
	 * Configura o endereço do comprador.
	 *
	 * @param endereco novo endereço do comprador
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco; //atribui o endereço recebido ao atributo "endereco"
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
	 * Retorna o número do documento do comprador.
	 *
	 * @return numero do documento
	 */
	public int getDocumento() {
		return documento; //retorna o atributo "numDocumento"
	}
	
	/**
	 * Configura um novo número de documento ao comprador.
	 *
	 * @param documento novo numero de documento do comprador
	 */
	public void setDocumento(int documento) {
		this.documento = documento; //atributo o número de documento recebido ao atributo "numDocumento"
	}

	/**
	 * Compara alfabeticamente o nome desse comprador com o de um comprador recebido por
	 * parâmetro.
	 * 
	 * @return 1, -1 ou 0, se o nome do comprador desse comprador for alfabeticamente maior, menor ou
	 * igual ao nome do comprador recebido por parâmetro.
	 */
	@Override
	public int comparacao(Object obj) {
		Comprador auxiliarComprador = (Comprador) obj;
		
		if(this.getNome().compareToIgnoreCase(auxiliarComprador.getNome()) < 0) { //verifica se o nome desse comprador é alfabeticamente menor que o nome do comprador recebido por parâmetro 
			return -1; 
		} else if(this.getNome().compareToIgnoreCase(auxiliarComprador.getNome()) > 0) {//verifica se o nome desse comprador é alfabeticamente maior que o nome do comprador recebido por parâmetro 
			return 1;
		} else {
			return 0; //retorna 0 indicando que nenhuma condição anterior foi satisfeita e que, portanto, os nome são alfabeticamente iguais
		}
	}
}
