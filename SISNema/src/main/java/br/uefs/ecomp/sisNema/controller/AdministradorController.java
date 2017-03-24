/**
 * Componente Curricular: M�dulo Integrado de Programa��o
 * Autor: Valmir Vinicius de Almeida Santos
 * Data: 07/03/2016
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


package br.uefs.ecomp.sisNema.controller;

/**
 * Classe respons�vel por controlar e intermediar a entrada de informa��es no programa e o armazenamento dessas
 * informa��es.
 * 
 * @author Valmir Vinicius
 * @see br.uefs.ecomp.sisNema.model.Cinema;
 * @see br.uefs.ecomp.sisNema.model.Comprador;
 * @see br.uefs.ecomp.sisNema.model.CompradorFan;
 * @see br.uefs.ecomp.sisNema.model.Endereco;
 * @see br.uefs.ecomp.sisNema.model.Sala;
 * @see br.uefs.ecomp.sisNema.model.Sessao;
 * @see br.uefs.ecomp.sisNema.model.Venda;
 * @see br.uefs.ecomp.sisNema.util.Fila;
 * @see br.uefs.ecomp.sisNema.util.Iterador;
 * @see br.uefs.ecomp.sisNema.util.ListaEncadeada;
 */

import br.uefs.ecomp.sisNema.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CinemaNuloException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNaoEncontradoException;
import br.uefs.ecomp.sisNema.exceptions.CompradorNuloException;
import br.uefs.ecomp.sisNema.exceptions.FanHabilitadoInexistenteException;
import br.uefs.ecomp.sisNema.exceptions.HorarioImproprioException;
import br.uefs.ecomp.sisNema.exceptions.IntervaloMinimoInsuficienteException;
import br.uefs.ecomp.sisNema.exceptions.LimiteSalasExcedidoException;
import br.uefs.ecomp.sisNema.exceptions.RemocaoNaoPermitidaException;
import br.uefs.ecomp.sisNema.exceptions.SalaNaoEncontradaException;
import br.uefs.ecomp.sisNema.exceptions.SalaNulaException;
import br.uefs.ecomp.sisNema.exceptions.SessaoNaoEncontradaException;
import br.uefs.ecomp.sisNema.exceptions.SessaoNulaException;
import br.uefs.ecomp.sisNema.model.Cinema;
import br.uefs.ecomp.sisNema.model.Comprador;
import br.uefs.ecomp.sisNema.model.CompradorFan;
import br.uefs.ecomp.sisNema.model.Endereco;
import br.uefs.ecomp.sisNema.model.Sala;
import br.uefs.ecomp.sisNema.model.Sessao;
import br.uefs.ecomp.sisNema.model.Venda;
import br.uefs.ecomp.sisNema.util.Fila;
import br.uefs.ecomp.sisNema.util.Iterador;
import br.uefs.ecomp.sisNema.util.ListaEncadeada;

public class AdministradorController {
	
	/** Inst�ncia �nica (singleton)da classe. */
	private static AdministradorController instanciaUnica;
	
	/**Lista encadeada para armazenamento de compradores. */
	private static ListaEncadeada listaCompradores;
	
	/**Lista encadeada para armazenamento de cinemas. */
	private static ListaEncadeada listaCinemas;
	
	/**Lista encadeada para armazenamento de vendas. */
	private static ListaEncadeada listaVendas;
	
	/**Fila para armazenamento de f�s habilitados a ganhar camisa.*/
	private static Fila fansHabilitados;
	
	/**
	 * Cria uma nova inst�ncia da classe.
	 */
	private AdministradorController() {
		/* Cria uma nova inst�ncia de cada um dos atributos da classe. */
		listaCompradores = new ListaEncadeada();
		listaCinemas = new ListaEncadeada(); 
		listaVendas = new ListaEncadeada();
		fansHabilitados = new Fila();
	}

	/**
	 * Permite a obten��o da refer�ncia para a inst�ncia �nica da classe.
	 * @return refer�ncia para inst�ncia �nica da classe
	 */
	public static AdministradorController getInstance() {
		if(instanciaUnica == null) { //verifica se a inst�ncia �nica atual � nula
			instanciaUnica = new AdministradorController();  //cria uma nova inst�ncia �nica da classe
		}
		
		return instanciaUnica; //retorna a refer�ncia para a inst�ncia �nica
	}

	/** 
	 * Reinicia a inst�ncia �nica da classe, de forma que todas as informa��es armazenadas s�o
	 * zeradas.
	 */
	public static void zerarSingleton() {
		instanciaUnica = null;
	}
	
	/**
	 * Realiza o cadastro de um cinema no sistema.
	 * @param cinema cinema que ser� cadastrado
	 * @return refer�ncia do cinema cadastrado
	 * @throws CampoObrigatorioInexistenteException se alguma informa��o do cadastro n�o estiver preenchida ou estiver preenchida inadequadamente
	 * @throws CinemaNuloException se o cinema informado for nulo
	 */
	public Cinema cadastrarCinema(Cinema cinema) throws CampoObrigatorioInexistenteException, CinemaNuloException{
		if(cinema == null) { //verifica se a refer�ncia pro cinema � nula
			throw new CinemaNuloException(); //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		} else if(cinema.getId() <= 0 || cinema.getNome() == null || cinema.getNome().trim().isEmpty() || cinema.getQtdSalas() <= 0 || cinema.getEndereco() == null) { //verifica se os dados do cinema est�o preenchidos de maneira adequada
			throw new CampoObrigatorioInexistenteException();  //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		} 
				
		listaCinemas.inserirFinal(cinema); //insere o novo cinema na lista de cinemas
		
		return cinema; //retorna a refer�ncia pro cinema cadastrado
	}
	
	/**
	 * Realiza altera��o dos dados de um cinema previamente cadastrado no sistema.
	 * @param idCinema n�mero �nico de identifica��o do cinema cujas informa��es ser�o alteradas
	 * @param novoNome nome que o cinema ter� ap�s a altera��o
	 * @param novaQtdSalas quantidade de salas do cinema ap�s a altera��o
	 * @param novoEndereco endere�o do cinema ap�s a altera��o
	 * @throws CampoObrigatorioInexistenteException se algum dos novos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 * @throws CinemaNaoEncontradoException se n�o for encontrado cadastro no sistema do cinema cujo ID foi informado
	 */
	public void alterarCinema(int idCinema, String novoNome, int novaQtdSalas, Endereco novoEndereco) throws CampoObrigatorioInexistenteException, CinemaNaoEncontradoException  {
		Cinema cinemaAuxiliar = null; //referencia auxiliar para o processo de altera��o
		
		if(idCinema <= 0 || novoNome == null || novoNome.trim().isEmpty() || novaQtdSalas <= 0 || novoEndereco == null) { //verifica se os dados est�o preenchidos de maneira adequada
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		} else {
			try {
				cinemaAuxiliar = recuperarCinema(idCinema); //tenta recuperar o cadastro do cinema a ser modificado
			} catch (CinemaNaoEncontradoException e) {
				throw e; //relan�a a exce��o correspondente
			}
		}
			
		/* As informa��es do cinema s�o substituidas pela novas, exceto o ID, pois esse � gerado pelo sistema e inalter�vel. */
		cinemaAuxiliar.setNome(novoNome); 
		cinemaAuxiliar.setEndereco(novoEndereco);
		cinemaAuxiliar.setQtdSalas(novaQtdSalas);
		
	}
	
	/**
	 * Remove o cadastro de um cinema do sistema, caso n�o tenham sido vendidos ingressos para o cinema em quest�o.
	 * @param idCinema n�mero �nico de identifica��o do cinema que ser� removido
	 * @return refer�ncia para o cinema removido
	 * @throws CinemaNaoEncontradoException se n�o for encontrado cadastro no sistema do cinema cujo ID foi informado
	 * @throws RemocaoNaoPermitidaException se n�o foi poss�vel realizar a remo��o, pois j� foi efetuada uma compra pro cinema em quest�o
	 */
	public Cinema removerCinema(int idCinema) throws CinemaNaoEncontradoException, RemocaoNaoPermitidaException {
		Cinema cinemaAuxiliar = null;  //referencia auxiliar para o processo de remo��o
		
		 try {
			 cinemaAuxiliar = recuperarCinema(idCinema); //tenta recuperar o cadastro do cinema a ser removido
		 } catch (CinemaNaoEncontradoException e) {
			throw e; //relan�a a exce��o correspondente caso o cadastro do cinema n�o seja encontrado
		}
		 
		 Iterador iterador = listaVendas.iterador(); //obt�m o iterador para a lista de vendas
		 Venda auxiliarVenda = null; //refer�ncia auxiliar para uma venda
		 
		 while(iterador.temProximo()) { //verifica se h� um pr�ximo elemento na lista
			 auxiliarVenda = (Venda) iterador.obterProximo(); //obt�m uma venda
			 
			 if(auxiliarVenda.getIngresso().getCinema().getId() == idCinema) { //verifica se o cinema contido no ingresso da venda � o que se deseja remover
				 throw new RemocaoNaoPermitidaException(); //lan�a exce��o correspondente se a condi��o for satisfeita, pois n�o pode ser removido um cinema para o qual j� foram comprados ingressos
			 }
		 }
		
		int indexCinema = listaCinemas.obterIndex(cinemaAuxiliar); //obt�m o index na lista encadeada do cinema a ser removido
		
		
		return (Cinema) listaCinemas.remover(indexCinema); //remove o cinema em quest�o da lista encadeada e retorna a sua refer�ncia
	}
	
	/**
	 * Recupera o cadastro de um cinema no sistema, retornando a sua refer�ncia.
	 * @param idCinema n�mero �nico de identifica��o do cinema a ser obtido
	 * @return refer�ncia para o cinema desejado, caso exista um cadastro pr�vio
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro do cinema
	 */
	public Cinema recuperarCinema(int idCinema) throws CinemaNaoEncontradoException {
		Iterador iterador = listaCinemas.iterador(); //obt�m o iterador para a lista de cinemas
		Cinema cinemaAuxiliar = null; //referencia auxiliar para o processo de recupera��o

		while(iterador.temProximo()) { //verifica se h� um pr�ximo cadastro de cinema na lista encadeada
			cinemaAuxiliar = (Cinema) iterador.obterProximo(); //obt�m o cadastro de um cinema
			
			if(cinemaAuxiliar.getId() == idCinema) { //verifica se o ID do cinema obtido � igual ao do que se deseja recuperar
				return cinemaAuxiliar; //retorna a refer�ncia para o cinema desejado caso a condi��o seja satisfeita
			}
		}
		
		throw new CinemaNaoEncontradoException(); //lan�a exce��o correspondente caso o cadastro do cinema n�o seja encontrado
	}
	
	/***
	 * Permite a listagem de todos os cinemas cadastrados no sistema.
	 * @return iterador para cadastro de todos os cinemas do sistema
	 */
	public Iterador listarCinemas() {
		return listaCinemas.iterador(); //retorna o iterador da lista encadeada que cont�m os cinemas cadastrados 
	}
	
	/**
	 * Realiza o cadastro de uma sala em um cinema anteriormente cadastrado no sistema.
	 * @param cinema refer�ncia para o cinema que ter� uma nova sala cadastrada
	 * @param novaSala refer�ncia para a nova sala
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro do cinema informado
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CampoObrigatorioInexistenteException se alguma informa��o do cadastro n�o estiver preenchida ou estiver preenchida inadequadamente
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws LimiteSalasExcedidoException se o n�mero m�ximo de salas do cinema tiver sido atingido
	 */
	public void cadastrarSala(Cinema cinema, Sala novaSala) throws CinemaNaoEncontradoException, CinemaNuloException, CampoObrigatorioInexistenteException, SalaNulaException, LimiteSalasExcedidoException {
		if(cinema == null) { //verifica se a refer�ncia pro cinema � nula
			throw new CinemaNuloException();  //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		} else {
			try {
				recuperarCinema(cinema.getId()); //tenta recuperar um cinema que possua o mesmo id do cinema informado
			} catch (CinemaNaoEncontradoException causa) { 
				throw causa; //relan�a exce��o correspondente caso n�o exista cadastro
			}
		}
		
		if(novaSala == null) { //verifica se a refer�ncia para sala � nula
			throw new SalaNulaException();  //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		} else if(novaSala.getNumeroSala() <= 0 || novaSala.getQtdCadeiras() <= 0) { //verifica se os dados da nova sala s�o v�lidos
			throw new CampoObrigatorioInexistenteException();  //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		}
		
		
		if(cinema.getSalas().obterTamanho() == cinema.getQtdSalas()) { //verifica se o n�mero m�ximo de salas permitidas foi atingido
			throw new LimiteSalasExcedidoException(); //lan�a exce��o correspondente caso a condi��o anterior seja satisfeita
		} 
		
		
		cinema.getSalas().inserirFinal(novaSala); //insere a nova sala na lista encadeada de salas do cinema corrrespondente
	}
	
	/**
	 * Realiza altera��o dos dados de uma sala previamente cadastrada no sistema.
	 * @param cinema refer�ncia para o cinema cuja sala a ser alterada est� contida
	 * @param numeroAntigoSala n�mero antigo da sala
	 * @param novoNumeroSala novo n�mero da sala
	 * @param novaQtdCadeiras nova quantidade de cadeiras da sala
	 * @throws CampoObrigatorioInexistenteException se algum dos novos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 * @throws SalaNaoEncontradaException se n�o for encontrado um cadastro da sala cujo n�mero foi informado
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro pr�vio do cinema informado
	 */
	public void alterarSala(Cinema cinema, int numeroAntigoSala, int novoNumeroSala, int novaQtdCadeiras) throws CampoObrigatorioInexistenteException, SalaNaoEncontradaException, CinemaNuloException, CinemaNaoEncontradoException {
		if(cinema == null) { //verifica se a refer�ncia para o cinema informado � nula
			throw new CinemaNuloException(); //lan�a exce��o correspondente caso a refer�ncia para o cinema seja nula
		} else { 
			
			try {
				recuperarCinema(cinema.getId()); //tenta recuperar um cinema que possua o mesmo id do cinema informado
			} catch (CinemaNaoEncontradoException causa) {
				throw causa; //relan�a exce��o correspondente caso n�o exista cadastro
			}
		}
		
		
		if(novoNumeroSala <= 0 || novaQtdCadeiras <= 0) { //verifica se os novos dados s�o v�lidos
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso algum dos dados seja inv�lido
		} 

		Sala alterar = null; //refer�ncia para a sala cujas informa��es ser�o alteradas
		
		try {
			alterar = recuperarSala(cinema, numeroAntigoSala); //tenta recuperar a refer�ncia da sala que ser� alterada
		} catch (SalaNaoEncontradaException causa) {
			throw causa; //relan�a exce��o correspondente caso n�o seja encontrado registro da sala desejada
		}
		
		/* Modifica o registro da sala em quest�o com os novos dados informados. */
		alterar.setNumeroSala(novoNumeroSala);
		alterar.setQtdCadeiras(novaQtdCadeiras);
	}
	
	/**
	 * Recupera a refer�ncia para uma sala contida em um cinema anteriormente cadastrado no sistema.
	 * @param cinema refer�ncia para o cinema que cont�m a sala
	 * @param numeroSala n�mero da sala que se deseja obter refer�ncia
	 * @return refer�ncia para a sala cujos dados foram informados, caso exista um cadastro pr�vio
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro pr�vio do cinema informado
	 * @throws SalaNaoEncontradaException se n�o for encontrado um cadastro da sala cujo n�mero foi informado
	 */
	public Sala recuperarSala(Cinema cinema, int numeroSala) throws CinemaNuloException, CinemaNaoEncontradoException, SalaNaoEncontradaException {
		if(cinema == null) { //verifica se a refer�ncia para o cinema informado � nula
			throw new CinemaNuloException(); //lan�a exce��o correspondente caso a refer�ncia para o cinema seja nula
		} else {
			
			try {
				recuperarCinema(cinema.getId()); //tenta recuperar um cinema que possua o mesmo id do cinema informado
			} catch (CinemaNaoEncontradoException causa) {
				throw causa; //relan�a exce��o correspondente caso n�o exista cadastro
			}
		}
		
		Iterador iterador = cinema.getSalas().iterador(); //obt�m o iterador para a lista encadeada de salas do cinema em quest�o
		Sala auxiliarSala = null; //refer�ncia auxiliar para uma sala
		
		while(iterador.temProximo()) { //verifica se h� uma pr�xima sala na lista
			auxiliarSala = (Sala) iterador.obterProximo();  //obt�m a refer�ncia para a sala
			
			if(auxiliarSala.getNumeroSala() == numeroSala) { //verifica se o n�mero da sala obtida na itera��o � igual ao n�mero da sala que se deseja obter
				return auxiliarSala; //retorna a refer�ncia para a sala caso a condi��o seja verdadeira
			}
		}
		
		throw new SalaNaoEncontradaException(); //lan�a exce��o correspondente caso a sala n�o seja encontrada
	}
	
	/**
	 * Permite a listagem de todas as salas de um cinema anteriormente cadastrado no sistema.
	 * @param cinema refer�ncia para o cinema cujas salas ser�o listadas
	 * @return iterador para uma lista encadeada de salas
	 */
	public Iterador listarSalas(Cinema cinema) {
		return cinema.getSalas().iterador(); //retorna o iterador para a lista de salas contida no cinema
	}

	/**
	 * Realiza o cadastro de uma nova sess�o em cinema e sala anteriormente cadastrados no sistema.
	 * @param cinema refer�ncia para o cinema no qual ocorrer� a sess�o
	 * @param sala refer�ncia para a sala onde acontecer� a sess�o
	 * @param novaSessao refer�ncia para a nova sess�o 
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws SalaNaoEncontradaException se n�o for encontrado um cadastro da sala cujo n�mero foi informado
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro pr�vio do cinema informado
	 * @throws SessaoNulaException se a sess�o informada for nula
	 * @throws CampoObrigatorioInexistenteException se algum dos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 * @throws IntervaloMinimoInsuficienteException se o intervalo de tempo entre o novo hor�rio de in�cio e o hor�rio de in�cio de alguma das sess�es j� cadastradas for menor do que tr�s horas
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws HorarioImproprioException se o hor�rio de in�cio ou fim da sess�o informado est� fora dos padr�es considerados como um dia v�lido no contexto do programa
	 */
	public void cadastrarSessao(Cinema cinema, Sala sala, Sessao novaSessao) throws CinemaNuloException, SalaNaoEncontradaException, CinemaNaoEncontradoException, SessaoNulaException, CampoObrigatorioInexistenteException, IntervaloMinimoInsuficienteException, SalaNulaException, HorarioImproprioException{
		if(novaSessao == null) { //verifica se a refer�ncia da nova sess�o � nula
			throw new SessaoNulaException(); //lan�a exce��o correspondente caso a nova sess�o seja nula
		} else if(novaSessao.getHoraInicio() == 0 || novaSessao.getHoraFim() == 0 || novaSessao.getHoraFim() - novaSessao.getHoraInicio() <= 0 || novaSessao.getHoraFim() - novaSessao.getHoraInicio() >= 3) { //verifica se os dados relativos a hora de in�cio e termino da sess�o foram preenchidos
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso algum dos hor�rios sejam inv�lidos
		} else if(novaSessao.getHoraFim() < 0 || novaSessao.getHoraInicio() < 0 || novaSessao.getHoraFim() >= 24 || novaSessao.getHoraInicio() >= 24) { //verifica se a hora de inicio e fim da sess�o foi preenchida conforme os padr�es do que se considerou como um dia no contexto do programa
			throw new HorarioImproprioException(); //lan�a exce��o correspondente caso algum dos hor�rios sejam inv�lidos
		}
		
		if(sala == null) { //verifica se a refer�ncia para sess�o informada � nula
			throw new SalaNulaException(); //lan�a exce��o correspondente caso a refer�ncia para sala seja nula
		} else {
			try {
				recuperarSala(cinema, sala.getNumeroSala()); //tenta recuperar o registro da sala que conter� a nova sess�o
			} catch (CinemaNuloException causa) {
				throw causa; //relan�a exce��o caso o cinema informado seja nulo
			} catch (CinemaNaoEncontradoException causa) {
				throw causa; //relan�a exce��o caso o cinema informado n�o esteja cadastrado no sistema
			} catch (SalaNaoEncontradaException causa) {
				throw causa; //relan�a exce��o caso a sala informada n�o esteja cadastrada no sistema
			}
		}
		
		if(sala.getSessoes().obterTamanho() > 0) { //verifica se h� alguma sess�o anteriormente cadastrada na sala em quest�o
			try {
				verificaIntervaloSessoes(sala, novaSessao.getHoraInicio()); //verifica se o hor�rio de in�cio da nova sess�o se encontra em uma faixa livre de hor�rios
			} catch (IntervaloMinimoInsuficienteException causa) {
				throw causa; //relan�a a exce��o correspondente caso a sess�o n�o possa ser cadastrada por conta da indisponibilidade de hor�rio
			}
		}

		sala.getSessoes().inserirFinal(novaSessao); //insere a nova sess�o na lista encadeada de sess�es da sala correspondente
	}

	/**
	 * Realiza a altera��o dos dados de uma sess�o anteriormente cadastrada no sistema.
	 * @param cinema refer�ncia para o cinema no qual a sess�o cujos dados ser�o alterados ocorre
	 * @param sala refer�ncia para a sala na qual a sess�o cujos dados ser�o alterados ocorre
	 * @param horaInicioAntiga hora de in�cio antigo da sess�o cujos dados ser�o alterados
	 * @param horaFimAntiga hora de finaliza��o antiga da sess�o cujos dados ser�o alterados
	 * @param horaInicioNova nova hora de in�cio da sess�o
	 * @param horaFimNova nova hora de finaliza��o da sess�o
	 * @throws SessaoNaoEncontradaException se n�o for encontrado cadastro pr�vio da sess�o informada
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro pr�vio do cinema informado
	 * @throws IntervaloMinimoInsuficienteException se o intervalo de tempo entre o novo hor�rio de in�cio e o hor�rio de in�cio de alguma das sess�es j� cadastradas for menor do que tr�s horas
	 * @throws SalaNaoEncontradaException se n�o for encontrado um cadastro da sala cujo n�mero foi informado
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws CampoObrigatorioInexistenteException se algum dos novos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 * @throws HorarioImproprioException se o hor�rio de in�cio ou fim da sess�o informado est� fora dos padr�es considerados como um dia v�lido no contexto do programa
	 */
	public void alterarSessao(Cinema cinema, Sala sala, int horaInicioAntiga, int horaFimAntiga, int horaInicioNova, int horaFimNova) throws SessaoNaoEncontradaException, CinemaNaoEncontradoException, IntervaloMinimoInsuficienteException, SalaNaoEncontradaException, CinemaNuloException, SalaNulaException, CampoObrigatorioInexistenteException, HorarioImproprioException {
		Sessao sessaoAuxiliar = null; //refer�ncia para a sess�o cujas informa��es ser�o alteradas
		
		if(horaInicioAntiga == 0 || horaFimAntiga == 0 || horaFimAntiga - horaInicioAntiga <= 0 || horaFimAntiga - horaInicioAntiga >= 3 || horaInicioNova == 0 || horaFimNova == 0 || horaFimNova - horaInicioNova <= 0 || horaFimNova - horaInicioNova >= 3) {
			throw new CampoObrigatorioInexistenteException();
		} else 	if(horaInicioAntiga < 0 || horaFimAntiga < 0 || horaInicioAntiga >= 24 || horaFimAntiga >= 24 || horaInicioNova < 0 || horaFimNova < 0 || horaInicioNova >= 24 || horaFimNova >= 24) { //verifica se a hora de inicio e fim da sess�o foi preenchida conforme os padr�es do que se considerou como um dia no contexto do programa
			throw new HorarioImproprioException(); //lan�a exce��o correspondente caso algum dos hor�rios sejam inv�lidos
		}

		
		try {
			sessaoAuxiliar = recuperarSessao(cinema, sala, horaInicioAntiga); //tenta recuperar a refer�ncia para a sess�o
		} catch (CinemaNuloException causa) {
			throw causa; //relan�a exce��o caso o cinema informado seja nulo
		} catch (CinemaNaoEncontradoException causa) {
			throw causa; //relan�a exce��o caso o cinema informado n�o esteja cadastrado no sistema
		} catch (SalaNaoEncontradaException causa) {
			throw causa; //relan�a exce��o caso a sala informada n�o esteja cadastrada no sistema
		} catch (SessaoNaoEncontradaException causa) {
			throw causa; //relan�a exce��o caso a sess�o informada n�o esteja cadastrada no sistema
		}
		
		if(sala.getSessoes().obterTamanho() > 1) { //verifica se h� outra sess�o (al�m da que ser� alterada) na sala em quest�o
			try {
				verificaIntervaloSessoes(sala, horaInicioNova); //verifica se o novo hor�rio de in�cio da sess�o se encontra em uma faixa livre de hor�rios
			} catch (IntervaloMinimoInsuficienteException causa) {
				throw causa; //relan�a a exce��o correspondente caso a sess�o n�o possa ser alterada por conta da indisponibilidade de hor�rio
			}
		}

		/* Modifica o registro da sess�o em quest�o com os novos dados informados. */
		sessaoAuxiliar.setHoraInicio(horaInicioNova);
		sessaoAuxiliar.setHoraFim(horaFimNova);
		
	}


	/**
	 * Recupera a refer�ncia para uma sess�o em cinema e sala previamente cadastrados no sistema.
	 * @param cinema refer�ncia para o cinema no qual a sess�o que ser� recuperada ocorre
	 * @param sala refer�ncia para a cinema na qual a sess�o que ser� recuperada ocorre
	 * @param horaInicio hora de in�cio da sess�o que ser� recuperada
	 * @return refer�ncia para a sala cujos dados foram informados, caso exista um cadastro pr�vio
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CinemaNaoEncontradoException se n�o for encontrado um cadastro pr�vio do cinema informado
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws SalaNaoEncontradaException se n�o for encontrado um cadastro da sala cujo n�mero foi informado
	 * @throws SessaoNaoEncontradaException se n�o for encontrado cadastro pr�vio da sess�o informada
	 */
	public Sessao recuperarSessao(Cinema cinema, Sala sala, int horaInicio) throws CinemaNuloException, CinemaNaoEncontradoException, SalaNulaException, SalaNaoEncontradaException, SessaoNaoEncontradaException{
		if(sala == null) { //verifica se a refer�ncia da sala informada � nula
			throw new SalaNulaException(); //lan�a exce��o correspondente indicando que a sala informada � nula
		} 
		
		try {
			recuperarSala(cinema, sala.getNumeroSala()); //tenta buscar no sistema o registro da sala em que ocorre a sess�o
		} catch (CinemaNuloException causa) {
			throw causa; //relan�a exce��o caso o cinema informado seja nulo
		} catch (CinemaNaoEncontradoException causa) {
			throw causa; //relan�a exce��o caso o cinema informado n�o esteja cadastrado no sistema
		} catch (SalaNaoEncontradaException causa) {
			throw causa; //relan�a exce��o caso a sala informada n�o esteja cadastrada no sistema
		}
		
		Iterador iterador = sala.getSessoes().iterador(); //obt�m iterador para a lista de sess�es contida na sala em quest�o
		Sessao sessaoAuxiliar = null; //refer�ncia auxiliar para sess�o
		
		while(iterador.temProximo()) { //verifica se h� um pr�ximo cadastro de sess�o
			sessaoAuxiliar = (Sessao) iterador.obterProximo(); //obt�m a refer�ncia para uma sess�o cadastrada
			
			if(sessaoAuxiliar.getHoraInicio() == horaInicio) { //verifica se a hora de in�cio da sess�o obtida � igual a hora de in�cio da sess�o que se deseja recuperar
				return sessaoAuxiliar; //retorna a refer�ncia para a sess�o encontrada
			}
		}
		
		throw new SessaoNaoEncontradaException(); //lan�a exce��o correspondente caso n�o seja encontrado registro da sess�o desejada
		
	}
	
	/**
	 * Verifica se o intervalo de tempo entre uma hora de in�cio informada e alguma das sess�es de uma sala informada
	 * � menor do que 3 horas.
	 * @param sala refer�ncia para sala cujos hor�rios de in�cio das sess�es ser�o verificados
	 * @param horaInicioNova novo hor�rio de in�cio que ser� comparado com os existentes 
	 * @throws IntervaloMinimoInsuficienteException se o intervalo de tempo entre o novo hor�rio de in�cio e o hor�rio de in�cio de alguma das sess�es j� cadastradas for menor do que tr�s horas
	 */
	private void verificaIntervaloSessoes(Sala sala, int horaInicioNova) throws IntervaloMinimoInsuficienteException  {
		Iterador iterador = sala.getSessoes().iterador(); //obt�m iterador para a lista encadeada de sess�es contida na sala em quest�o
		int diferencaHorarios = 0; //diferen�a do hor�rio de in�cio de duas sess�es
		Sessao sessaoAuxiliar = null; //refer�ncia auxiliar para uma sess�o
		
		/* O novo hor�rio de in�cio de uma sess�o n�o deve estar dentro do intervalo aberto de 3 horas seguintes a uma sess�o
		 * que come�a antes dele e n�o deve estar dentro do intervalo aberto de 3 horas anteriores a uma sess�o que come�a depois
		 * dele. Portanto, o valor absoluto (m�dulo) da diferen�a de hora de in�cio da nova sess�o e de cada sess�o que j�
		 * est� cadastrada deve ser maior ou igual a 3.
		 */
		while(iterador.temProximo()) { //verifica se h� um pr�ximo registro de sess�o
			sessaoAuxiliar = (Sessao) iterador.obterProximo(); //obt�m a refer�ncia para uma sess�o cadastrada
			diferencaHorarios = Math.abs(horaInicioNova - sessaoAuxiliar.getHoraInicio()); //obt�m o valor absoluto da diferen�a entre a hora de in�cio da nova sess�o e de uma sess�o j� cadastrada
			
			if(diferencaHorarios < 3) { //verifica se a diferen�a � menor 3
				throw new IntervaloMinimoInsuficienteException(); //se a condi��o for satisfeita a exce��o correspondente � lan�ada
			}
		}
		
	}
	
	/**
	 * Permite a listagem de todas as sess�es que ocorrem em uma sala previamente cadastrada.
	 * @param sala refer�ncia para sala cujas sess�es ser�o listadas
	 * @return iterador para a lista de sess�es de uma sala
	 */
	public Iterador listarSessoes(Sala sala) {
		return sala.getSessoes().iterador(); //retorna o iterador para a lista encadeada de sess�es contida na sala
	}
	
	/**
	 * Realiza o cadastro de um comprador no sistema.
	 * @param comprador refer�ncia para o comprador que ser� cadastrado
	 * @throws CompradorNuloException se o comprador informado for nulo
	 * @throws CampoObrigatorioInexistenteException se algum dos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 */
	public void cadastrarComprador(Comprador comprador) throws CompradorNuloException, CampoObrigatorioInexistenteException {
		if(comprador == null) { //verifica se a refer�ncia de comprador � nula
			throw new CompradorNuloException(); //lan�a exce��o correspondente caso a refer�ncia seja nula
		} else if(comprador.getNome() == null || comprador.getEndereco() == null || comprador.getTelefone() == null || comprador.getEmail() == null ) { //verifica se algum dos atributos do comprador � nulo
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o corresponde caso um ou mais dos atributos seja nulo
		} else if(comprador.getNome().trim().isEmpty() || comprador.getTelefone().trim().isEmpty() || comprador.getEmail().trim().isEmpty() || comprador.getDocumento() <= 0) { //verifica se alguma das informa��es est� preenchida de forma incorrenta
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso algum dos dados esteja preenchido incorretamente
		} else if(comprador instanceof CompradorFan) { //verifica se o comprador a ser cadastrado � um "CompradorFan"
			CompradorFan fan = (CompradorFan) comprador; 
			
			if(fan.getRegistro() <= 0) { //verifica se o registro foi preenchido adequadamente
				throw new CampoObrigatorioInexistenteException(); //lan�a exce��o corresponde caso o registro esteja preenchido de forma inadequada
			}
			
		}
		
		listaCompradores.inserirFinal(comprador); //insere o novo comprador no final da lista encadeada de compradores
		
	}
	
	/**
	 * Realiza a altera��o dos dados de um comprador anteriormente cadastrado no sistema.
	 * @param antigoDocumento n�mero antigo do documento do comprador
	 * @param novoNome novo nome do comprador
	 * @param novoEndereco novo endere�o do comprador
	 * @param novoTelefone novo telefone do comprador
	 * @param novoEmail novo email do comprador
	 * @param novoDocumento novo n�mero de documento do comprador
	 * @throws CampoObrigatorioInexistenteException se algum dos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 * @throws CompradorNaoEncontradoException se n�o foi encontrado cadastro do comprador no sistema
	 */
	public void alterarComprador(int antigoDocumento, String novoNome, Endereco novoEndereco, String novoTelefone, String novoEmail, int novoDocumento) throws CampoObrigatorioInexistenteException, CompradorNaoEncontradoException {
		if(antigoDocumento <= 0 || novoNome == null || novoEndereco == null || novoTelefone == null || novoEmail == null || novoDocumento <= 0) { //verifica se alguma das informa��es recebidas � nula ou inv�lida
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso alguma das informa��es n�o estiver preenchida
		} else if(novoNome.trim().isEmpty() || novoTelefone.trim().isEmpty() || novoEmail.trim().isEmpty()) { //verifica se alguma das informa��es foi preenchida inadequadamente 
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso alguma das informa��es esteja preenchida de maneira incorrenta
		} 
		
		Comprador compradorAlterar = null; //refer�ncia auxiliar para comprador

		try {
			compradorAlterar = recuperarComprador(antigoDocumento); //tenta recuperar o cadastro de um comprador no sistema
		} catch (CompradorNaoEncontradoException causa) { 
			throw causa; //relan�a exce��o caso n�o seja encontrado cadastro
		}
		
		/* As informa��es antigas do comprador s�o substituidas pelas novas informa��es. */
		compradorAlterar.setNome(novoNome);
		compradorAlterar.setEndereco(novoEndereco);
		compradorAlterar.setTelefone(novoTelefone);
		compradorAlterar.setEmail(novoEmail);
		compradorAlterar.setDocumento(novoDocumento);
		
	}
	
	/**
	 * Realiza a altera��o dos dados de um compradorFan anteriormente cadastrado no sistema.
	 * @param antigoDocumento n�mero de documento do comprador antes da altera��o
	 * @param novoNome novo nome do comprador f�
	 * @param novoEndereco novo endere�o do comprador f�
	 * @param novoTelefone novo telefone do comprador f�
	 * @param novoEmail novo email do comprador f�
	 * @param novoDocumento novo n�mero de documento do comprador f�
	 * @param novoRegistro novo n�mero de registro do comprador f� no f� clube
	 * @throws CampoObrigatorioInexistenteException se algum dos dados n�o estiver preenchido ou estiver preenchido inadequadamente
	 * @throws CompradorNaoEncontradoException se n�o foi encontrado cadastro do comprador no sistema
	 */
	public void alterarComprador(int antigoDocumento, String novoNome, Endereco novoEndereco, String novoTelefone, String novoEmail, int novoDocumento, int novoRegistro) throws CampoObrigatorioInexistenteException, CompradorNaoEncontradoException {
		if(antigoDocumento <= 0 || novoNome == null || novoEndereco == null || novoTelefone == null || novoEmail == null || novoDocumento <= 0 || novoRegistro <= 0) { //verifica se alguma das informa��es recebidas � nula ou inv�lida
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso alguma das informa��es n�o estiver preenchida
		} else if(novoNome.trim().isEmpty() || novoTelefone.trim().isEmpty() || novoEmail.trim().isEmpty()) { //verifica se alguma das informa��es foi preenchida inadequadamente 
			throw new CampoObrigatorioInexistenteException(); //lan�a exce��o correspondente caso alguma das informa��es esteja preenchida de maneira incorrenta
		} 
		
		CompradorFan fanAlterar = null; //refer�ncia auxiliar para compradorFan
		
		try {
			fanAlterar = (CompradorFan) recuperarComprador(antigoDocumento); //tenta recuperar o cadastro de um compradorFan no sistema
		} catch (CompradorNaoEncontradoException causa) {
			throw causa; //relan�a exce��o caso n�o seja encontrado cadastro
		}
		
		/* As informa��es antigas do compradorFan s�o substituidas pelas novas informa��es. */
		fanAlterar.setNome(novoNome);
		fanAlterar.setEndereco(novoEndereco);
		fanAlterar.setTelefone(novoTelefone);
		fanAlterar.setEmail(novoEmail);
		fanAlterar.setDocumento(novoDocumento);
		fanAlterar.setRegistro(novoRegistro);
		
	}
	
	/**
	 * Remove o cadastro de um comprador do sistema, caso ele n�o tenha realizado compra de ingressos.
	 * @param documento n�mero de documento do comprador que ser� removido
	 * @return refer�ncia para o cadastro de comprador removido
	 * @throws CompradorNaoEncontradoException se n�o foi encontrado cadastro do comprador no sistema
	 * @throws RemocaoNaoPermitidaException se o comprador j� realizou compras e o cadastro n�o pode ser removido
	 */
	public Comprador removerComprador(int documento) throws CompradorNaoEncontradoException, RemocaoNaoPermitidaException{
		Comprador compradorRemover = null; //refer�ncia para o comprador que ser� removido
		
		try {
			compradorRemover = recuperarComprador(documento); //tenta obter o cadastro do comprador
		} catch (CompradorNaoEncontradoException causa) {
			throw causa; //relan�a exce��o caso n�o tenha sido encontrado cadastro do comprador
		}
		
		Iterador iterador = listaVendas.iterador(); //obt�m o iterador para a lista de vendas
		Comprador auxiliarComprador = null; //refer�ncia auxiliar para comprador
		
		while(iterador.temProximo()) { //verifica se h� uma pr�xima venda
			auxiliarComprador = ((Venda) iterador.obterProximo()).getComprador(); //obt�m o cadastro do comprador que realizou a venda
			
			if(auxiliarComprador.getDocumento() == documento) { //verifica se o documento do comprador obtido � o mesmo do que se deseja remover
				throw new RemocaoNaoPermitidaException(); //lan�a exce��o apropriada caso o comprador j� tenha realizado compras
			}
		}
		
		return (Comprador) listaCompradores.remover(listaCompradores.obterIndex(compradorRemover)); //obt�m o index do comprador na lista encadeada e efetua a remo��o, retornando a refer�ncia para o comprador removido
	}

	/**
	 * Recupera a refer�ncia para um comprador previamente cadastrado no sistema.
	 * @param documento n�mero de documento do comprador que se deseja recuperar
	 * @return refer�ncia para um comprador, caso exista cadastro pr�vio
	 * @throws CompradorNaoEncontradoException se n�o foi encontrado cadastro do comprador no sistema
	 */
	public Comprador recuperarComprador(int documento) throws CompradorNaoEncontradoException {
		Iterador iterador = listaCompradores.iterador(); //obt�m o iterador para a lista encadeada de compradores
		Comprador compradorAuxiliar = null; //refer�ncia auxiliar para um comprador
		
		while(iterador.temProximo()) { //verifica se h� um pr�ximo cadastro de comprador na lista
			compradorAuxiliar = (Comprador) iterador.obterProximo(); //obt�m um comprador
			
			if(compradorAuxiliar.getDocumento() == documento) { //verifica se o n�mero de documento do comprador obtido � igual ao do que deseja recuperar
				return compradorAuxiliar; //retorna a refer�ncia para o comprador encontrado
			}
		}
		
		throw new CompradorNaoEncontradoException(); //lan�a exce��o caso n�o seja encontrado cadastro de um comprador
	}

	/**
	 * Permite a listagem ordenada de todos os compradores cadastrados no sistema.
	 * @return iterador para a lista de doadores
	 */
	public Iterador listarCompradores() {
		listaCompradores.ordenar(); //ordena a lista encadeada de compradores
		return listaCompradores.iterador(); //retorna o iterador para a lista encadeada
	}
	
	/**
	 * Obt�m a refer�ncia para a lista encadeada de compradores.
	 * @return refer�ncia para a lista de compradores
	 */
	public ListaEncadeada getListaCompradores() {
		/* A cria��o desse m�todo foi fundamental para a realiza��o dos testes do MergeSort, pois a obten��o
		 * apenas do iterador n�o iria possibilitar utilizar cada m�todo da ordena��o separadamente.
		 */
		return listaCompradores;//retorna a refer�ncia para a lista de compradores
	}
	
	/**
	 * Realiza a distribui��o de camisas para compradores f�s que j� realizaram compras, caso haja f�s habilitados.
	 * @param quantidade n�mero de camisas que ser�o distribuidas
	 * @throws FanHabilitadoInexistenteException se n�o houver f� habilitado para receber camisas ou n�o houver f�s habilitados para o n�mero de camisas desejado
	 */
	public void distribuirCamisas(int quantidade) throws FanHabilitadoInexistenteException {
		int cont = 0; //contador auxiliar
		Iterador iterador = fansHabilitados.iterador(); //obt�m o iterador para a fila de f�s que realizaram compras
		
		while(cont < quantidade && iterador.temProximo()) { //verifica se o contador n�o atingiu o n�mero de camisas desejado e se h� um pr�ximo comprador na fila
			fansHabilitados.removerInicio(); //retira um comprador do in�cio da fila
			cont++; //incrementa 1 no contador
			
			if(!iterador.temProximo()) { //verifica se n�o h� um pr�ximo compradorFan na fila, isto �, se a fila ficou vazia ap�s a remo��o anterior
				throw new FanHabilitadoInexistenteException(); //lan�a exce��o correspondente indicando que n�o h� mais f�s habilitados a receber a camisa
			}
		}
	}
	
	/**
	 * Registra uma nova venda no sistema.
	 * @param novaVenda refer�ncia para a venda que ser� cadastrada
	 */
	public void registrarVendas(Venda novaVenda) {
		listaVendas.inserirFinal(novaVenda); //insere a nova venda no final da lista encadeada de vendas
		
		if(novaVenda.getComprador() instanceof CompradorFan) { //verifica se o comprador da nova venda � um compradorFan
			fansHabilitados.inserirFinal((CompradorFan) novaVenda.getComprador()); //insere o compradorFan na fila de f�s habilitados a ganhar camisa
		}
		
	}
	
	/**
	 * Recupera a fila de f�s que est�o aptos a ganhar camisa.
	 * @return refer�ncia para a fila de f�s habilitados
	 * @throws FanHabilitadoInexistenteException se n�o houver f�s habilitados a ganhar camisa no momento
	 */
	public Fila recuperarFansHabilitados() throws FanHabilitadoInexistenteException {
		if(fansHabilitados.estaVazia()) { //verifica se a fila de f�s habilitados est� vazia
			throw new FanHabilitadoInexistenteException(); //lan�a exce��o correspondente caso n�o existam f�s habilitados no momento
		}
		
		return fansHabilitados; //retorna refer�ncia para a fila de f�s habilitados a receber a camisa

	}
	
	/**
	 * Permite a listagem de todas as vendas realizadas
	 * @return iterador para a lista encadeada de vendas
	 */
	public Iterador listarVendas() {
		return listaVendas.iterador(); //obt�m e retorna a refer�ncia para o iterador da lista encadeada de vendas
	}
}
