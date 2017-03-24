/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Valmir Vinicius de Almeida Santos
 * Data: 07/03/2016
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


package br.uefs.ecomp.sisNema.controller;

/**
 * Classe responsável por controlar e intermediar a entrada de informações no programa e o armazenamento dessas
 * informações.
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
	
	/** Instância única (singleton)da classe. */
	private static AdministradorController instanciaUnica;
	
	/**Lista encadeada para armazenamento de compradores. */
	private static ListaEncadeada listaCompradores;
	
	/**Lista encadeada para armazenamento de cinemas. */
	private static ListaEncadeada listaCinemas;
	
	/**Lista encadeada para armazenamento de vendas. */
	private static ListaEncadeada listaVendas;
	
	/**Fila para armazenamento de fãs habilitados a ganhar camisa.*/
	private static Fila fansHabilitados;
	
	/**
	 * Cria uma nova instância da classe.
	 */
	private AdministradorController() {
		/* Cria uma nova instância de cada um dos atributos da classe. */
		listaCompradores = new ListaEncadeada();
		listaCinemas = new ListaEncadeada(); 
		listaVendas = new ListaEncadeada();
		fansHabilitados = new Fila();
	}

	/**
	 * Permite a obtenção da referência para a instância única da classe.
	 * @return referência para instância única da classe
	 */
	public static AdministradorController getInstance() {
		if(instanciaUnica == null) { //verifica se a instância única atual é nula
			instanciaUnica = new AdministradorController();  //cria uma nova instância única da classe
		}
		
		return instanciaUnica; //retorna a referência para a instância única
	}

	/** 
	 * Reinicia a instância única da classe, de forma que todas as informações armazenadas são
	 * zeradas.
	 */
	public static void zerarSingleton() {
		instanciaUnica = null;
	}
	
	/**
	 * Realiza o cadastro de um cinema no sistema.
	 * @param cinema cinema que será cadastrado
	 * @return referência do cinema cadastrado
	 * @throws CampoObrigatorioInexistenteException se alguma informação do cadastro não estiver preenchida ou estiver preenchida inadequadamente
	 * @throws CinemaNuloException se o cinema informado for nulo
	 */
	public Cinema cadastrarCinema(Cinema cinema) throws CampoObrigatorioInexistenteException, CinemaNuloException{
		if(cinema == null) { //verifica se a referência pro cinema é nula
			throw new CinemaNuloException(); //lança exceção correspondente caso a condição anterior seja satisfeita
		} else if(cinema.getId() <= 0 || cinema.getNome() == null || cinema.getNome().trim().isEmpty() || cinema.getQtdSalas() <= 0 || cinema.getEndereco() == null) { //verifica se os dados do cinema estão preenchidos de maneira adequada
			throw new CampoObrigatorioInexistenteException();  //lança exceção correspondente caso a condição anterior seja satisfeita
		} 
				
		listaCinemas.inserirFinal(cinema); //insere o novo cinema na lista de cinemas
		
		return cinema; //retorna a referência pro cinema cadastrado
	}
	
	/**
	 * Realiza alteração dos dados de um cinema previamente cadastrado no sistema.
	 * @param idCinema número único de identificação do cinema cujas informações serão alteradas
	 * @param novoNome nome que o cinema terá após a alteração
	 * @param novaQtdSalas quantidade de salas do cinema após a alteração
	 * @param novoEndereco endereço do cinema após a alteração
	 * @throws CampoObrigatorioInexistenteException se algum dos novos dados não estiver preenchido ou estiver preenchido inadequadamente
	 * @throws CinemaNaoEncontradoException se não for encontrado cadastro no sistema do cinema cujo ID foi informado
	 */
	public void alterarCinema(int idCinema, String novoNome, int novaQtdSalas, Endereco novoEndereco) throws CampoObrigatorioInexistenteException, CinemaNaoEncontradoException  {
		Cinema cinemaAuxiliar = null; //referencia auxiliar para o processo de alteração
		
		if(idCinema <= 0 || novoNome == null || novoNome.trim().isEmpty() || novaQtdSalas <= 0 || novoEndereco == null) { //verifica se os dados estão preenchidos de maneira adequada
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso a condição anterior seja satisfeita
		} else {
			try {
				cinemaAuxiliar = recuperarCinema(idCinema); //tenta recuperar o cadastro do cinema a ser modificado
			} catch (CinemaNaoEncontradoException e) {
				throw e; //relança a exceção correspondente
			}
		}
			
		/* As informações do cinema são substituidas pela novas, exceto o ID, pois esse é gerado pelo sistema e inalterável. */
		cinemaAuxiliar.setNome(novoNome); 
		cinemaAuxiliar.setEndereco(novoEndereco);
		cinemaAuxiliar.setQtdSalas(novaQtdSalas);
		
	}
	
	/**
	 * Remove o cadastro de um cinema do sistema, caso não tenham sido vendidos ingressos para o cinema em questão.
	 * @param idCinema número único de identificação do cinema que será removido
	 * @return referência para o cinema removido
	 * @throws CinemaNaoEncontradoException se não for encontrado cadastro no sistema do cinema cujo ID foi informado
	 * @throws RemocaoNaoPermitidaException se não foi possível realizar a remoção, pois já foi efetuada uma compra pro cinema em questão
	 */
	public Cinema removerCinema(int idCinema) throws CinemaNaoEncontradoException, RemocaoNaoPermitidaException {
		Cinema cinemaAuxiliar = null;  //referencia auxiliar para o processo de remoção
		
		 try {
			 cinemaAuxiliar = recuperarCinema(idCinema); //tenta recuperar o cadastro do cinema a ser removido
		 } catch (CinemaNaoEncontradoException e) {
			throw e; //relança a exceção correspondente caso o cadastro do cinema não seja encontrado
		}
		 
		 Iterador iterador = listaVendas.iterador(); //obtém o iterador para a lista de vendas
		 Venda auxiliarVenda = null; //referência auxiliar para uma venda
		 
		 while(iterador.temProximo()) { //verifica se há um próximo elemento na lista
			 auxiliarVenda = (Venda) iterador.obterProximo(); //obtém uma venda
			 
			 if(auxiliarVenda.getIngresso().getCinema().getId() == idCinema) { //verifica se o cinema contido no ingresso da venda é o que se deseja remover
				 throw new RemocaoNaoPermitidaException(); //lança exceção correspondente se a condição for satisfeita, pois não pode ser removido um cinema para o qual já foram comprados ingressos
			 }
		 }
		
		int indexCinema = listaCinemas.obterIndex(cinemaAuxiliar); //obtém o index na lista encadeada do cinema a ser removido
		
		
		return (Cinema) listaCinemas.remover(indexCinema); //remove o cinema em questão da lista encadeada e retorna a sua referência
	}
	
	/**
	 * Recupera o cadastro de um cinema no sistema, retornando a sua referência.
	 * @param idCinema número único de identificação do cinema a ser obtido
	 * @return referência para o cinema desejado, caso exista um cadastro prévio
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro do cinema
	 */
	public Cinema recuperarCinema(int idCinema) throws CinemaNaoEncontradoException {
		Iterador iterador = listaCinemas.iterador(); //obtém o iterador para a lista de cinemas
		Cinema cinemaAuxiliar = null; //referencia auxiliar para o processo de recuperação

		while(iterador.temProximo()) { //verifica se há um próximo cadastro de cinema na lista encadeada
			cinemaAuxiliar = (Cinema) iterador.obterProximo(); //obtém o cadastro de um cinema
			
			if(cinemaAuxiliar.getId() == idCinema) { //verifica se o ID do cinema obtido é igual ao do que se deseja recuperar
				return cinemaAuxiliar; //retorna a referência para o cinema desejado caso a condição seja satisfeita
			}
		}
		
		throw new CinemaNaoEncontradoException(); //lança exceção correspondente caso o cadastro do cinema não seja encontrado
	}
	
	/***
	 * Permite a listagem de todos os cinemas cadastrados no sistema.
	 * @return iterador para cadastro de todos os cinemas do sistema
	 */
	public Iterador listarCinemas() {
		return listaCinemas.iterador(); //retorna o iterador da lista encadeada que contém os cinemas cadastrados 
	}
	
	/**
	 * Realiza o cadastro de uma sala em um cinema anteriormente cadastrado no sistema.
	 * @param cinema referência para o cinema que terá uma nova sala cadastrada
	 * @param novaSala referência para a nova sala
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro do cinema informado
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CampoObrigatorioInexistenteException se alguma informação do cadastro não estiver preenchida ou estiver preenchida inadequadamente
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws LimiteSalasExcedidoException se o número máximo de salas do cinema tiver sido atingido
	 */
	public void cadastrarSala(Cinema cinema, Sala novaSala) throws CinemaNaoEncontradoException, CinemaNuloException, CampoObrigatorioInexistenteException, SalaNulaException, LimiteSalasExcedidoException {
		if(cinema == null) { //verifica se a referência pro cinema é nula
			throw new CinemaNuloException();  //lança exceção correspondente caso a condição anterior seja satisfeita
		} else {
			try {
				recuperarCinema(cinema.getId()); //tenta recuperar um cinema que possua o mesmo id do cinema informado
			} catch (CinemaNaoEncontradoException causa) { 
				throw causa; //relança exceção correspondente caso não exista cadastro
			}
		}
		
		if(novaSala == null) { //verifica se a referência para sala é nula
			throw new SalaNulaException();  //lança exceção correspondente caso a condição anterior seja satisfeita
		} else if(novaSala.getNumeroSala() <= 0 || novaSala.getQtdCadeiras() <= 0) { //verifica se os dados da nova sala são válidos
			throw new CampoObrigatorioInexistenteException();  //lança exceção correspondente caso a condição anterior seja satisfeita
		}
		
		
		if(cinema.getSalas().obterTamanho() == cinema.getQtdSalas()) { //verifica se o número máximo de salas permitidas foi atingido
			throw new LimiteSalasExcedidoException(); //lança exceção correspondente caso a condição anterior seja satisfeita
		} 
		
		
		cinema.getSalas().inserirFinal(novaSala); //insere a nova sala na lista encadeada de salas do cinema corrrespondente
	}
	
	/**
	 * Realiza alteração dos dados de uma sala previamente cadastrada no sistema.
	 * @param cinema referência para o cinema cuja sala a ser alterada está contida
	 * @param numeroAntigoSala número antigo da sala
	 * @param novoNumeroSala novo número da sala
	 * @param novaQtdCadeiras nova quantidade de cadeiras da sala
	 * @throws CampoObrigatorioInexistenteException se algum dos novos dados não estiver preenchido ou estiver preenchido inadequadamente
	 * @throws SalaNaoEncontradaException se não for encontrado um cadastro da sala cujo número foi informado
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro prévio do cinema informado
	 */
	public void alterarSala(Cinema cinema, int numeroAntigoSala, int novoNumeroSala, int novaQtdCadeiras) throws CampoObrigatorioInexistenteException, SalaNaoEncontradaException, CinemaNuloException, CinemaNaoEncontradoException {
		if(cinema == null) { //verifica se a referência para o cinema informado é nula
			throw new CinemaNuloException(); //lança exceção correspondente caso a referência para o cinema seja nula
		} else { 
			
			try {
				recuperarCinema(cinema.getId()); //tenta recuperar um cinema que possua o mesmo id do cinema informado
			} catch (CinemaNaoEncontradoException causa) {
				throw causa; //relança exceção correspondente caso não exista cadastro
			}
		}
		
		
		if(novoNumeroSala <= 0 || novaQtdCadeiras <= 0) { //verifica se os novos dados são válidos
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso algum dos dados seja inválido
		} 

		Sala alterar = null; //referência para a sala cujas informações serão alteradas
		
		try {
			alterar = recuperarSala(cinema, numeroAntigoSala); //tenta recuperar a referência da sala que será alterada
		} catch (SalaNaoEncontradaException causa) {
			throw causa; //relança exceção correspondente caso não seja encontrado registro da sala desejada
		}
		
		/* Modifica o registro da sala em questão com os novos dados informados. */
		alterar.setNumeroSala(novoNumeroSala);
		alterar.setQtdCadeiras(novaQtdCadeiras);
	}
	
	/**
	 * Recupera a referência para uma sala contida em um cinema anteriormente cadastrado no sistema.
	 * @param cinema referência para o cinema que contém a sala
	 * @param numeroSala número da sala que se deseja obter referência
	 * @return referência para a sala cujos dados foram informados, caso exista um cadastro prévio
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro prévio do cinema informado
	 * @throws SalaNaoEncontradaException se não for encontrado um cadastro da sala cujo número foi informado
	 */
	public Sala recuperarSala(Cinema cinema, int numeroSala) throws CinemaNuloException, CinemaNaoEncontradoException, SalaNaoEncontradaException {
		if(cinema == null) { //verifica se a referência para o cinema informado é nula
			throw new CinemaNuloException(); //lança exceção correspondente caso a referência para o cinema seja nula
		} else {
			
			try {
				recuperarCinema(cinema.getId()); //tenta recuperar um cinema que possua o mesmo id do cinema informado
			} catch (CinemaNaoEncontradoException causa) {
				throw causa; //relança exceção correspondente caso não exista cadastro
			}
		}
		
		Iterador iterador = cinema.getSalas().iterador(); //obtém o iterador para a lista encadeada de salas do cinema em questão
		Sala auxiliarSala = null; //referência auxiliar para uma sala
		
		while(iterador.temProximo()) { //verifica se há uma próxima sala na lista
			auxiliarSala = (Sala) iterador.obterProximo();  //obtém a referência para a sala
			
			if(auxiliarSala.getNumeroSala() == numeroSala) { //verifica se o número da sala obtida na iteração é igual ao número da sala que se deseja obter
				return auxiliarSala; //retorna a referência para a sala caso a condição seja verdadeira
			}
		}
		
		throw new SalaNaoEncontradaException(); //lança exceção correspondente caso a sala não seja encontrada
	}
	
	/**
	 * Permite a listagem de todas as salas de um cinema anteriormente cadastrado no sistema.
	 * @param cinema referência para o cinema cujas salas serão listadas
	 * @return iterador para uma lista encadeada de salas
	 */
	public Iterador listarSalas(Cinema cinema) {
		return cinema.getSalas().iterador(); //retorna o iterador para a lista de salas contida no cinema
	}

	/**
	 * Realiza o cadastro de uma nova sessão em cinema e sala anteriormente cadastrados no sistema.
	 * @param cinema referência para o cinema no qual ocorrerá a sessão
	 * @param sala referência para a sala onde acontecerá a sessão
	 * @param novaSessao referência para a nova sessão 
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws SalaNaoEncontradaException se não for encontrado um cadastro da sala cujo número foi informado
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro prévio do cinema informado
	 * @throws SessaoNulaException se a sessão informada for nula
	 * @throws CampoObrigatorioInexistenteException se algum dos dados não estiver preenchido ou estiver preenchido inadequadamente
	 * @throws IntervaloMinimoInsuficienteException se o intervalo de tempo entre o novo horário de início e o horário de início de alguma das sessões já cadastradas for menor do que três horas
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws HorarioImproprioException se o horário de início ou fim da sessão informado está fora dos padrões considerados como um dia válido no contexto do programa
	 */
	public void cadastrarSessao(Cinema cinema, Sala sala, Sessao novaSessao) throws CinemaNuloException, SalaNaoEncontradaException, CinemaNaoEncontradoException, SessaoNulaException, CampoObrigatorioInexistenteException, IntervaloMinimoInsuficienteException, SalaNulaException, HorarioImproprioException{
		if(novaSessao == null) { //verifica se a referência da nova sessão é nula
			throw new SessaoNulaException(); //lança exceção correspondente caso a nova sessão seja nula
		} else if(novaSessao.getHoraInicio() == 0 || novaSessao.getHoraFim() == 0 || novaSessao.getHoraFim() - novaSessao.getHoraInicio() <= 0 || novaSessao.getHoraFim() - novaSessao.getHoraInicio() >= 3) { //verifica se os dados relativos a hora de início e termino da sessão foram preenchidos
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso algum dos horários sejam inválidos
		} else if(novaSessao.getHoraFim() < 0 || novaSessao.getHoraInicio() < 0 || novaSessao.getHoraFim() >= 24 || novaSessao.getHoraInicio() >= 24) { //verifica se a hora de inicio e fim da sessão foi preenchida conforme os padrões do que se considerou como um dia no contexto do programa
			throw new HorarioImproprioException(); //lança exceção correspondente caso algum dos horários sejam inválidos
		}
		
		if(sala == null) { //verifica se a referência para sessão informada é nula
			throw new SalaNulaException(); //lança exceção correspondente caso a referência para sala seja nula
		} else {
			try {
				recuperarSala(cinema, sala.getNumeroSala()); //tenta recuperar o registro da sala que conterá a nova sessão
			} catch (CinemaNuloException causa) {
				throw causa; //relança exceção caso o cinema informado seja nulo
			} catch (CinemaNaoEncontradoException causa) {
				throw causa; //relança exceção caso o cinema informado não esteja cadastrado no sistema
			} catch (SalaNaoEncontradaException causa) {
				throw causa; //relança exceção caso a sala informada não esteja cadastrada no sistema
			}
		}
		
		if(sala.getSessoes().obterTamanho() > 0) { //verifica se há alguma sessão anteriormente cadastrada na sala em questão
			try {
				verificaIntervaloSessoes(sala, novaSessao.getHoraInicio()); //verifica se o horário de início da nova sessão se encontra em uma faixa livre de horários
			} catch (IntervaloMinimoInsuficienteException causa) {
				throw causa; //relança a exceção correspondente caso a sessão não possa ser cadastrada por conta da indisponibilidade de horário
			}
		}

		sala.getSessoes().inserirFinal(novaSessao); //insere a nova sessão na lista encadeada de sessões da sala correspondente
	}

	/**
	 * Realiza a alteração dos dados de uma sessão anteriormente cadastrada no sistema.
	 * @param cinema referência para o cinema no qual a sessão cujos dados serão alterados ocorre
	 * @param sala referência para a sala na qual a sessão cujos dados serão alterados ocorre
	 * @param horaInicioAntiga hora de início antigo da sessão cujos dados serão alterados
	 * @param horaFimAntiga hora de finalização antiga da sessão cujos dados serão alterados
	 * @param horaInicioNova nova hora de início da sessão
	 * @param horaFimNova nova hora de finalização da sessão
	 * @throws SessaoNaoEncontradaException se não for encontrado cadastro prévio da sessão informada
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro prévio do cinema informado
	 * @throws IntervaloMinimoInsuficienteException se o intervalo de tempo entre o novo horário de início e o horário de início de alguma das sessões já cadastradas for menor do que três horas
	 * @throws SalaNaoEncontradaException se não for encontrado um cadastro da sala cujo número foi informado
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws CampoObrigatorioInexistenteException se algum dos novos dados não estiver preenchido ou estiver preenchido inadequadamente
	 * @throws HorarioImproprioException se o horário de início ou fim da sessão informado está fora dos padrões considerados como um dia válido no contexto do programa
	 */
	public void alterarSessao(Cinema cinema, Sala sala, int horaInicioAntiga, int horaFimAntiga, int horaInicioNova, int horaFimNova) throws SessaoNaoEncontradaException, CinemaNaoEncontradoException, IntervaloMinimoInsuficienteException, SalaNaoEncontradaException, CinemaNuloException, SalaNulaException, CampoObrigatorioInexistenteException, HorarioImproprioException {
		Sessao sessaoAuxiliar = null; //referência para a sessão cujas informações serão alteradas
		
		if(horaInicioAntiga == 0 || horaFimAntiga == 0 || horaFimAntiga - horaInicioAntiga <= 0 || horaFimAntiga - horaInicioAntiga >= 3 || horaInicioNova == 0 || horaFimNova == 0 || horaFimNova - horaInicioNova <= 0 || horaFimNova - horaInicioNova >= 3) {
			throw new CampoObrigatorioInexistenteException();
		} else 	if(horaInicioAntiga < 0 || horaFimAntiga < 0 || horaInicioAntiga >= 24 || horaFimAntiga >= 24 || horaInicioNova < 0 || horaFimNova < 0 || horaInicioNova >= 24 || horaFimNova >= 24) { //verifica se a hora de inicio e fim da sessão foi preenchida conforme os padrões do que se considerou como um dia no contexto do programa
			throw new HorarioImproprioException(); //lança exceção correspondente caso algum dos horários sejam inválidos
		}

		
		try {
			sessaoAuxiliar = recuperarSessao(cinema, sala, horaInicioAntiga); //tenta recuperar a referência para a sessão
		} catch (CinemaNuloException causa) {
			throw causa; //relança exceção caso o cinema informado seja nulo
		} catch (CinemaNaoEncontradoException causa) {
			throw causa; //relança exceção caso o cinema informado não esteja cadastrado no sistema
		} catch (SalaNaoEncontradaException causa) {
			throw causa; //relança exceção caso a sala informada não esteja cadastrada no sistema
		} catch (SessaoNaoEncontradaException causa) {
			throw causa; //relança exceção caso a sessão informada não esteja cadastrada no sistema
		}
		
		if(sala.getSessoes().obterTamanho() > 1) { //verifica se há outra sessão (além da que será alterada) na sala em questão
			try {
				verificaIntervaloSessoes(sala, horaInicioNova); //verifica se o novo horário de início da sessão se encontra em uma faixa livre de horários
			} catch (IntervaloMinimoInsuficienteException causa) {
				throw causa; //relança a exceção correspondente caso a sessão não possa ser alterada por conta da indisponibilidade de horário
			}
		}

		/* Modifica o registro da sessão em questão com os novos dados informados. */
		sessaoAuxiliar.setHoraInicio(horaInicioNova);
		sessaoAuxiliar.setHoraFim(horaFimNova);
		
	}


	/**
	 * Recupera a referência para uma sessão em cinema e sala previamente cadastrados no sistema.
	 * @param cinema referência para o cinema no qual a sessão que será recuperada ocorre
	 * @param sala referência para a cinema na qual a sessão que será recuperada ocorre
	 * @param horaInicio hora de início da sessão que será recuperada
	 * @return referência para a sala cujos dados foram informados, caso exista um cadastro prévio
	 * @throws CinemaNuloException se o cinema informado for nulo
	 * @throws CinemaNaoEncontradoException se não for encontrado um cadastro prévio do cinema informado
	 * @throws SalaNulaException se a sala informada for nula
	 * @throws SalaNaoEncontradaException se não for encontrado um cadastro da sala cujo número foi informado
	 * @throws SessaoNaoEncontradaException se não for encontrado cadastro prévio da sessão informada
	 */
	public Sessao recuperarSessao(Cinema cinema, Sala sala, int horaInicio) throws CinemaNuloException, CinemaNaoEncontradoException, SalaNulaException, SalaNaoEncontradaException, SessaoNaoEncontradaException{
		if(sala == null) { //verifica se a referência da sala informada é nula
			throw new SalaNulaException(); //lança exceção correspondente indicando que a sala informada é nula
		} 
		
		try {
			recuperarSala(cinema, sala.getNumeroSala()); //tenta buscar no sistema o registro da sala em que ocorre a sessão
		} catch (CinemaNuloException causa) {
			throw causa; //relança exceção caso o cinema informado seja nulo
		} catch (CinemaNaoEncontradoException causa) {
			throw causa; //relança exceção caso o cinema informado não esteja cadastrado no sistema
		} catch (SalaNaoEncontradaException causa) {
			throw causa; //relança exceção caso a sala informada não esteja cadastrada no sistema
		}
		
		Iterador iterador = sala.getSessoes().iterador(); //obtém iterador para a lista de sessões contida na sala em questão
		Sessao sessaoAuxiliar = null; //referência auxiliar para sessão
		
		while(iterador.temProximo()) { //verifica se há um próximo cadastro de sessão
			sessaoAuxiliar = (Sessao) iterador.obterProximo(); //obtém a referência para uma sessão cadastrada
			
			if(sessaoAuxiliar.getHoraInicio() == horaInicio) { //verifica se a hora de início da sessão obtida é igual a hora de início da sessão que se deseja recuperar
				return sessaoAuxiliar; //retorna a referência para a sessão encontrada
			}
		}
		
		throw new SessaoNaoEncontradaException(); //lança exceção correspondente caso não seja encontrado registro da sessão desejada
		
	}
	
	/**
	 * Verifica se o intervalo de tempo entre uma hora de início informada e alguma das sessões de uma sala informada
	 * é menor do que 3 horas.
	 * @param sala referência para sala cujos horários de início das sessões serão verificados
	 * @param horaInicioNova novo horário de início que será comparado com os existentes 
	 * @throws IntervaloMinimoInsuficienteException se o intervalo de tempo entre o novo horário de início e o horário de início de alguma das sessões já cadastradas for menor do que três horas
	 */
	private void verificaIntervaloSessoes(Sala sala, int horaInicioNova) throws IntervaloMinimoInsuficienteException  {
		Iterador iterador = sala.getSessoes().iterador(); //obtém iterador para a lista encadeada de sessões contida na sala em questão
		int diferencaHorarios = 0; //diferença do horário de início de duas sessões
		Sessao sessaoAuxiliar = null; //referência auxiliar para uma sessão
		
		/* O novo horário de início de uma sessão não deve estar dentro do intervalo aberto de 3 horas seguintes a uma sessão
		 * que começa antes dele e não deve estar dentro do intervalo aberto de 3 horas anteriores a uma sessão que começa depois
		 * dele. Portanto, o valor absoluto (módulo) da diferença de hora de início da nova sessão e de cada sessão que já
		 * está cadastrada deve ser maior ou igual a 3.
		 */
		while(iterador.temProximo()) { //verifica se há um próximo registro de sessão
			sessaoAuxiliar = (Sessao) iterador.obterProximo(); //obtém a referência para uma sessão cadastrada
			diferencaHorarios = Math.abs(horaInicioNova - sessaoAuxiliar.getHoraInicio()); //obtém o valor absoluto da diferença entre a hora de início da nova sessão e de uma sessão já cadastrada
			
			if(diferencaHorarios < 3) { //verifica se a diferença é menor 3
				throw new IntervaloMinimoInsuficienteException(); //se a condição for satisfeita a exceção correspondente é lançada
			}
		}
		
	}
	
	/**
	 * Permite a listagem de todas as sessões que ocorrem em uma sala previamente cadastrada.
	 * @param sala referência para sala cujas sessões serão listadas
	 * @return iterador para a lista de sessões de uma sala
	 */
	public Iterador listarSessoes(Sala sala) {
		return sala.getSessoes().iterador(); //retorna o iterador para a lista encadeada de sessões contida na sala
	}
	
	/**
	 * Realiza o cadastro de um comprador no sistema.
	 * @param comprador referência para o comprador que será cadastrado
	 * @throws CompradorNuloException se o comprador informado for nulo
	 * @throws CampoObrigatorioInexistenteException se algum dos dados não estiver preenchido ou estiver preenchido inadequadamente
	 */
	public void cadastrarComprador(Comprador comprador) throws CompradorNuloException, CampoObrigatorioInexistenteException {
		if(comprador == null) { //verifica se a referência de comprador é nula
			throw new CompradorNuloException(); //lança exceção correspondente caso a referência seja nula
		} else if(comprador.getNome() == null || comprador.getEndereco() == null || comprador.getTelefone() == null || comprador.getEmail() == null ) { //verifica se algum dos atributos do comprador é nulo
			throw new CampoObrigatorioInexistenteException(); //lança exceção corresponde caso um ou mais dos atributos seja nulo
		} else if(comprador.getNome().trim().isEmpty() || comprador.getTelefone().trim().isEmpty() || comprador.getEmail().trim().isEmpty() || comprador.getDocumento() <= 0) { //verifica se alguma das informações está preenchida de forma incorrenta
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso algum dos dados esteja preenchido incorretamente
		} else if(comprador instanceof CompradorFan) { //verifica se o comprador a ser cadastrado é um "CompradorFan"
			CompradorFan fan = (CompradorFan) comprador; 
			
			if(fan.getRegistro() <= 0) { //verifica se o registro foi preenchido adequadamente
				throw new CampoObrigatorioInexistenteException(); //lança exceção corresponde caso o registro esteja preenchido de forma inadequada
			}
			
		}
		
		listaCompradores.inserirFinal(comprador); //insere o novo comprador no final da lista encadeada de compradores
		
	}
	
	/**
	 * Realiza a alteração dos dados de um comprador anteriormente cadastrado no sistema.
	 * @param antigoDocumento número antigo do documento do comprador
	 * @param novoNome novo nome do comprador
	 * @param novoEndereco novo endereço do comprador
	 * @param novoTelefone novo telefone do comprador
	 * @param novoEmail novo email do comprador
	 * @param novoDocumento novo número de documento do comprador
	 * @throws CampoObrigatorioInexistenteException se algum dos dados não estiver preenchido ou estiver preenchido inadequadamente
	 * @throws CompradorNaoEncontradoException se não foi encontrado cadastro do comprador no sistema
	 */
	public void alterarComprador(int antigoDocumento, String novoNome, Endereco novoEndereco, String novoTelefone, String novoEmail, int novoDocumento) throws CampoObrigatorioInexistenteException, CompradorNaoEncontradoException {
		if(antigoDocumento <= 0 || novoNome == null || novoEndereco == null || novoTelefone == null || novoEmail == null || novoDocumento <= 0) { //verifica se alguma das informações recebidas é nula ou inválida
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso alguma das informações não estiver preenchida
		} else if(novoNome.trim().isEmpty() || novoTelefone.trim().isEmpty() || novoEmail.trim().isEmpty()) { //verifica se alguma das informações foi preenchida inadequadamente 
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso alguma das informações esteja preenchida de maneira incorrenta
		} 
		
		Comprador compradorAlterar = null; //referência auxiliar para comprador

		try {
			compradorAlterar = recuperarComprador(antigoDocumento); //tenta recuperar o cadastro de um comprador no sistema
		} catch (CompradorNaoEncontradoException causa) { 
			throw causa; //relança exceção caso não seja encontrado cadastro
		}
		
		/* As informações antigas do comprador são substituidas pelas novas informações. */
		compradorAlterar.setNome(novoNome);
		compradorAlterar.setEndereco(novoEndereco);
		compradorAlterar.setTelefone(novoTelefone);
		compradorAlterar.setEmail(novoEmail);
		compradorAlterar.setDocumento(novoDocumento);
		
	}
	
	/**
	 * Realiza a alteração dos dados de um compradorFan anteriormente cadastrado no sistema.
	 * @param antigoDocumento número de documento do comprador antes da alteração
	 * @param novoNome novo nome do comprador fã
	 * @param novoEndereco novo endereço do comprador fã
	 * @param novoTelefone novo telefone do comprador fã
	 * @param novoEmail novo email do comprador fã
	 * @param novoDocumento novo número de documento do comprador fã
	 * @param novoRegistro novo número de registro do comprador fã no fã clube
	 * @throws CampoObrigatorioInexistenteException se algum dos dados não estiver preenchido ou estiver preenchido inadequadamente
	 * @throws CompradorNaoEncontradoException se não foi encontrado cadastro do comprador no sistema
	 */
	public void alterarComprador(int antigoDocumento, String novoNome, Endereco novoEndereco, String novoTelefone, String novoEmail, int novoDocumento, int novoRegistro) throws CampoObrigatorioInexistenteException, CompradorNaoEncontradoException {
		if(antigoDocumento <= 0 || novoNome == null || novoEndereco == null || novoTelefone == null || novoEmail == null || novoDocumento <= 0 || novoRegistro <= 0) { //verifica se alguma das informações recebidas é nula ou inválida
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso alguma das informações não estiver preenchida
		} else if(novoNome.trim().isEmpty() || novoTelefone.trim().isEmpty() || novoEmail.trim().isEmpty()) { //verifica se alguma das informações foi preenchida inadequadamente 
			throw new CampoObrigatorioInexistenteException(); //lança exceção correspondente caso alguma das informações esteja preenchida de maneira incorrenta
		} 
		
		CompradorFan fanAlterar = null; //referência auxiliar para compradorFan
		
		try {
			fanAlterar = (CompradorFan) recuperarComprador(antigoDocumento); //tenta recuperar o cadastro de um compradorFan no sistema
		} catch (CompradorNaoEncontradoException causa) {
			throw causa; //relança exceção caso não seja encontrado cadastro
		}
		
		/* As informações antigas do compradorFan são substituidas pelas novas informações. */
		fanAlterar.setNome(novoNome);
		fanAlterar.setEndereco(novoEndereco);
		fanAlterar.setTelefone(novoTelefone);
		fanAlterar.setEmail(novoEmail);
		fanAlterar.setDocumento(novoDocumento);
		fanAlterar.setRegistro(novoRegistro);
		
	}
	
	/**
	 * Remove o cadastro de um comprador do sistema, caso ele não tenha realizado compra de ingressos.
	 * @param documento número de documento do comprador que será removido
	 * @return referência para o cadastro de comprador removido
	 * @throws CompradorNaoEncontradoException se não foi encontrado cadastro do comprador no sistema
	 * @throws RemocaoNaoPermitidaException se o comprador já realizou compras e o cadastro não pode ser removido
	 */
	public Comprador removerComprador(int documento) throws CompradorNaoEncontradoException, RemocaoNaoPermitidaException{
		Comprador compradorRemover = null; //referência para o comprador que será removido
		
		try {
			compradorRemover = recuperarComprador(documento); //tenta obter o cadastro do comprador
		} catch (CompradorNaoEncontradoException causa) {
			throw causa; //relança exceção caso não tenha sido encontrado cadastro do comprador
		}
		
		Iterador iterador = listaVendas.iterador(); //obtém o iterador para a lista de vendas
		Comprador auxiliarComprador = null; //referência auxiliar para comprador
		
		while(iterador.temProximo()) { //verifica se há uma próxima venda
			auxiliarComprador = ((Venda) iterador.obterProximo()).getComprador(); //obtém o cadastro do comprador que realizou a venda
			
			if(auxiliarComprador.getDocumento() == documento) { //verifica se o documento do comprador obtido é o mesmo do que se deseja remover
				throw new RemocaoNaoPermitidaException(); //lança exceção apropriada caso o comprador já tenha realizado compras
			}
		}
		
		return (Comprador) listaCompradores.remover(listaCompradores.obterIndex(compradorRemover)); //obtém o index do comprador na lista encadeada e efetua a remoção, retornando a referência para o comprador removido
	}

	/**
	 * Recupera a referência para um comprador previamente cadastrado no sistema.
	 * @param documento número de documento do comprador que se deseja recuperar
	 * @return referência para um comprador, caso exista cadastro prévio
	 * @throws CompradorNaoEncontradoException se não foi encontrado cadastro do comprador no sistema
	 */
	public Comprador recuperarComprador(int documento) throws CompradorNaoEncontradoException {
		Iterador iterador = listaCompradores.iterador(); //obtém o iterador para a lista encadeada de compradores
		Comprador compradorAuxiliar = null; //referência auxiliar para um comprador
		
		while(iterador.temProximo()) { //verifica se há um próximo cadastro de comprador na lista
			compradorAuxiliar = (Comprador) iterador.obterProximo(); //obtém um comprador
			
			if(compradorAuxiliar.getDocumento() == documento) { //verifica se o número de documento do comprador obtido é igual ao do que deseja recuperar
				return compradorAuxiliar; //retorna a referência para o comprador encontrado
			}
		}
		
		throw new CompradorNaoEncontradoException(); //lança exceção caso não seja encontrado cadastro de um comprador
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
	 * Obtém a referência para a lista encadeada de compradores.
	 * @return referência para a lista de compradores
	 */
	public ListaEncadeada getListaCompradores() {
		/* A criação desse método foi fundamental para a realização dos testes do MergeSort, pois a obtenção
		 * apenas do iterador não iria possibilitar utilizar cada método da ordenação separadamente.
		 */
		return listaCompradores;//retorna a referência para a lista de compradores
	}
	
	/**
	 * Realiza a distribuição de camisas para compradores fãs que já realizaram compras, caso haja fãs habilitados.
	 * @param quantidade número de camisas que serão distribuidas
	 * @throws FanHabilitadoInexistenteException se não houver fã habilitado para receber camisas ou não houver fãs habilitados para o número de camisas desejado
	 */
	public void distribuirCamisas(int quantidade) throws FanHabilitadoInexistenteException {
		int cont = 0; //contador auxiliar
		Iterador iterador = fansHabilitados.iterador(); //obtém o iterador para a fila de fãs que realizaram compras
		
		while(cont < quantidade && iterador.temProximo()) { //verifica se o contador não atingiu o número de camisas desejado e se há um próximo comprador na fila
			fansHabilitados.removerInicio(); //retira um comprador do início da fila
			cont++; //incrementa 1 no contador
			
			if(!iterador.temProximo()) { //verifica se não há um próximo compradorFan na fila, isto é, se a fila ficou vazia após a remoção anterior
				throw new FanHabilitadoInexistenteException(); //lança exceção correspondente indicando que não há mais fãs habilitados a receber a camisa
			}
		}
	}
	
	/**
	 * Registra uma nova venda no sistema.
	 * @param novaVenda referência para a venda que será cadastrada
	 */
	public void registrarVendas(Venda novaVenda) {
		listaVendas.inserirFinal(novaVenda); //insere a nova venda no final da lista encadeada de vendas
		
		if(novaVenda.getComprador() instanceof CompradorFan) { //verifica se o comprador da nova venda é um compradorFan
			fansHabilitados.inserirFinal((CompradorFan) novaVenda.getComprador()); //insere o compradorFan na fila de fãs habilitados a ganhar camisa
		}
		
	}
	
	/**
	 * Recupera a fila de fãs que estão aptos a ganhar camisa.
	 * @return referência para a fila de fãs habilitados
	 * @throws FanHabilitadoInexistenteException se não houver fãs habilitados a ganhar camisa no momento
	 */
	public Fila recuperarFansHabilitados() throws FanHabilitadoInexistenteException {
		if(fansHabilitados.estaVazia()) { //verifica se a fila de fãs habilitados está vazia
			throw new FanHabilitadoInexistenteException(); //lança exceção correspondente caso não existam fãs habilitados no momento
		}
		
		return fansHabilitados; //retorna referência para a fila de fãs habilitados a receber a camisa

	}
	
	/**
	 * Permite a listagem de todas as vendas realizadas
	 * @return iterador para a lista encadeada de vendas
	 */
	public Iterador listarVendas() {
		return listaVendas.iterador(); //obtém e retorna a referência para o iterador da lista encadeada de vendas
	}
}
