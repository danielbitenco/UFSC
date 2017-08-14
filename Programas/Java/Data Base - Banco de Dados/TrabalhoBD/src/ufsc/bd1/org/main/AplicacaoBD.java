package ufsc.bd1.org.main;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ufsc.bd1.org.control.ModelController;
import ufsc.bd1.org.control.ResultSetControllerBPP;
import ufsc.bd1.org.control.ResultSetControllerBEQCUT;
import ufsc.bd1.org.control.ResultSetControllerBIUPP;
import ufsc.bd1.org.model.BuscaExemplaresQtdCustoUnTotal;
import ufsc.bd1.org.model.BuscaItensUtilizadosPessoasProjetos;
import ufsc.bd1.org.model.BuscaPessoaProjeto;
import ufsc.bd1.org.model.Exemplar;
import ufsc.bd1.org.model.Fornecedor;
import ufsc.bd1.org.model.FornecedorComponente;
import ufsc.bd1.org.model.Funcao;
import ufsc.bd1.org.model.Item;
import ufsc.bd1.org.model.Pedido;
import ufsc.bd1.org.model.PedidoComponente;
import ufsc.bd1.org.model.Pessoa;
import ufsc.bd1.org.model.PessoaProjeto;
import ufsc.bd1.org.model.Projeto;
import ufsc.bd1.org.model.Recebe;
import ufsc.bd1.org.model.Solicita;
import ufsc.bd1.org.model.Solicitacao;
import ufsc.bd1.org.model.TipoPessoa;
import ufsc.bd1.org.model.Utiliza;



public class AplicacaoBD {

	private ModelController modelCtr = new ModelController();
	
	public static void main(String[] args) {
		
		AplicacaoBD ap = new AplicacaoBD();
		
		ap.clean();
		ap.inserts();
		ap.print();
		ap.update();
		ap.printSerchUpdated();
		ap.delete();
		ap.printSerchUpdated();
		
		ap.close();
		
	}
	
	public void delete(){
		ResultSetControllerBEQCUT rsCtr2 = new ResultSetControllerBEQCUT();

		String sql = "delete from exemplar as e"
				+ " where e.id_exemplar = 28 ";
		
		rsCtr2.deleteFromTab(sql);
		System.out.println("DELETA 1 resistor de 200k");

	}
	
	public void update(){
		ResultSetControllerBEQCUT rsCtr2 = new ResultSetControllerBEQCUT();
		
		String sql = "update item "
				+ " set valor = valor*1.5 ";
	
		rsCtr2.updateTab(sql);
		System.out.println("UPDATE na tabela item, os valores sao acrescidos 50%");

	}
	
	public void printSerchUpdated(){
		
		ResultSetControllerBEQCUT rsCtr2 = new ResultSetControllerBEQCUT();

		System.out.println("\n-- BUSCA TODOS OS ITENS, A QUANTIDADE, O VALOR UNITARIO E O VALOR TOTAL DS ITENS --\n");
		
		String sql = "select i.descricao, i.modelo, count(i.modelo) as quantidade, i.valor as valor_uni, sum(valor) as valorTotal"
				+ " from item as i, exemplar as e "
				+ " where i.id_componente = e.id_componente "
				+ " group by i.descricao, i.modelo, i.valor "
				+ " order by valorTotal ";
		
		
		List<BuscaExemplaresQtdCustoUnTotal> listTCPPBEQCUT = rsCtr2.queryTCPP(sql);
				
		for (BuscaExemplaresQtdCustoUnTotal tcpp : listTCPPBEQCUT) {
			System.out.println("O item "+tcpp.getDescricao().toUpperCase()+
					" de modelo "+tcpp.getModelo()+
					" tem a quantidade de "+tcpp.getQuantidade()+
					" com valor unitario de "+(float)tcpp.getValorUnitario()+
					" e valor total de "+(float)tcpp.getValorTotal());
		}
	}
	
	public void print(){
		
		ResultSetControllerBPP rsCtr1 = new ResultSetControllerBPP();
		
		String sql = "select pro.descricao, count(pro.descricao) as quantidade_pessoas"
				+ " from pessoa as p, pessoaprojeto as pp, projeto as pro "
				+ " where p.id_pessoa = pp.id_pessoa and pp.id_projeto = pro.id_projeto "
				+ " group by pro.descricao "
				+ " order by quantidade_pessoas asc ";
		
		
		List<BuscaPessoaProjeto> listTCPP = rsCtr1.queryTCPP(sql);
	
		/**********************************************************************************/
		
		ResultSetControllerBEQCUT rsCtr2 = new ResultSetControllerBEQCUT();

		sql = "select i.descricao, i.modelo, count(i.modelo) as quantidade, i.valor as valor_uni, sum(valor) as valorTotal"
				+ " from item as i, exemplar as e "
				+ " where i.id_componente = e.id_componente "
				+ " group by i.descricao, i.modelo, i.valor "
				+ " order by valorTotal ";
		
		
		List<BuscaExemplaresQtdCustoUnTotal> listTCPPBEQCUT = rsCtr2.queryTCPP(sql);
		
		/**********************************************************************************/
		
		ResultSetControllerBIUPP rsCtr3 = new ResultSetControllerBIUPP();

		sql = "	select p.descricao as quem_pediu, count(p.descricao) as qtd_componentes, 'projeto' as tipo"
				+ " from projeto as p, utiliza as u "
				+ " where	p.id_projeto = u.id_projeto "
				+ " group by p.descricao "
				+ " union "
				+ " select p.nome as quem_pediu, count (p.nome) as qtd_componentes, 'pessoa' as tipo "
				+ " from pessoa as p, utiliza as u "
				+ " where p.id_pessoa = u.id_pessoa  "
				+ " group by p.nome "
				+ " order by qtd_componentes desc ";
		 
		List<BuscaItensUtilizadosPessoasProjetos> listTCPPBIUPP = rsCtr3.queryTCPP(sql);
		
		/**********************************************************************************/
		
		System.out.println("\n\n-- BUSCA TOTAL DE ITENS UTILIZADOS E CLASSIFICA POR PESSOAS OU PROJETOS --\n");
		for (BuscaItensUtilizadosPessoasProjetos tcpp : listTCPPBIUPP) {
			System.out.println(tcpp.getTipo()+" "+ tcpp.getQuemUsa().toUpperCase()+
					" esta usando "+tcpp.getQtdComponente()+" itens");
		
		}
		
		System.out.println("\n\n-- BUSCA O NUMERO DE MEMBROS ENVOLVIDOS EM PROJETOS --\n");
		for (BuscaPessoaProjeto tcpp : listTCPP) {
			System.out.println("O projeto "+tcpp.getNome().toUpperCase()+
					" tem "+tcpp.getQuantidadePessoas()+" membros envolvidos");
		}
		
		System.out.println("\n\n-- BUSCA TODOS OS ITENS, A QUANTIDADE, O VALOR UNITARIO E O VALOR TOTAL DS ITENS --\n");
		for (BuscaExemplaresQtdCustoUnTotal tcpp : listTCPPBEQCUT) {
			System.out.println("O item "+tcpp.getDescricao().toUpperCase()+
					" de modelo "+tcpp.getModelo()+
					" tem a quantidade de "+tcpp.getQuantidade()+
					" com valor unitario de "+tcpp.getValorUnitario()+
					" e valor total de "+(float)tcpp.getValorTotal());
		}
	}
	
	public void close() {
		modelCtr.close();
	}
	
	public void clean() {
		modelCtr.deleteAll();
	}

	public void inserts() {

		/**********************************************************************************/
		//insere fornecedores
		Fornecedor forn1 = new Fornecedor(1,"farnell","sao paulo","www.farnell.com");
		Fornecedor forn2 = new Fornecedor(2,"lab de garagem","sao paulo","labdegaragem.com");
		Fornecedor forn3 = new Fornecedor(3,"zeziho componentes","floripa","zezinhocomp.com.br");
		Fornecedor forn4 = new Fornecedor(4,"luizinho microeletronica","porto alegre","microeletronicaluiz.com.br");
		Fornecedor forn5 = new Fornecedor(5,"joao dos componentes","fortaleza","joncomponentes.com");
		Fornecedor forn6 = new Fornecedor(6,"carlos do diodo","bahia","carlosdiodo.com");
		Fornecedor forn7 = new Fornecedor(7,"renato resistor","joinville","resistoresrenato.com");
		Fornecedor forn8 = new Fornecedor(8,"rele joao","tubarao","relejoao.net");
		Fornecedor forn9 = new Fornecedor(9,"tectronix","sao paulo","tectronix.com");
		
		modelCtr.insert(forn1);
		modelCtr.insert(forn2);
		modelCtr.insert(forn3);
		modelCtr.insert(forn4);
		modelCtr.insert(forn5);
		modelCtr.insert(forn6);
		modelCtr.insert(forn7);
		modelCtr.insert(forn8);
		modelCtr.insert(forn9);
		
		/**********************************************************************************/
		//insere itens
		
		Item item1 = new Item(1,"diodo","1n4001","diodo normal",1.2);
		Item item2 = new Item(2,"resistor","100k","resistor normal",1.3);
		Item item3 = new Item(3,"resistor","10k","resistor normal",1.5);
		Item item4 = new Item(4,"resistor","1k","resistor normal",1.4);
		Item item5 = new Item(5,"resistor","200k","resistor normal",1.3);
		Item item6 = new Item(6,"resistor","300k","resistor normal",1.4);
		Item item7 = new Item(7,"transistor","tip120","npn",2.1);
		Item item8 = new Item(8,"transistor","tip121","pnp",2.2);
		Item item9 = new Item(9,"transistor","tip1","npn",1.2);
		Item item10 = new Item(10,"transistor","tip120","npn",1.2);
		Item item11= new Item(11,"osciloscopio","osc3000","osciloscopio com 4 ch",15789.99);
		Item item12 = new Item(12,"alicate","corte bico curto","tramontina",49.99);
		Item item13 = new Item(13,"chave philips","0.5 in","philipis normal",21.2);
		Item item14 = new Item(14,"chave de fenda","0.5 in","chave de fenda normal",31.2);
		Item item15 = new Item(15,"capacitor","10uf","eletrolitico",1.2);
		Item item16 = new Item(16,"capacitor","10nf","poliester",1.2);
//		Item item17 = new Item(17,"mouse","microsoft","optico sem fio",200);

	

		modelCtr.insert(item1);
		modelCtr.insert(item2);
		modelCtr.insert(item3);
		modelCtr.insert(item4);
		modelCtr.insert(item5);
		modelCtr.insert(item6);
		modelCtr.insert(item7);
		modelCtr.insert(item8);
		modelCtr.insert(item9);
		modelCtr.insert(item10);
		modelCtr.insert(item11);
		modelCtr.insert(item12);
		modelCtr.insert(item13);
		modelCtr.insert(item14);
		modelCtr.insert(item15);
		modelCtr.insert(item16);
//		modelCtr.insert(item17);	
		
		/**********************************************************************************/
		//insere relacao fornecedor-item  (infelizmente nos esquecemos de trocar o nome componente por item
		FornecedorComponente forComp1 = new FornecedorComponente(1,forn1,item1);
		FornecedorComponente forComp2 = new FornecedorComponente(2,forn1,item2);
		FornecedorComponente forComp3 = new FornecedorComponente(3,forn1,item3);
		FornecedorComponente forComp4 = new FornecedorComponente(4,forn2,item4);
		FornecedorComponente forComp5 = new FornecedorComponente(5,forn6,item5);
		FornecedorComponente forComp6 = new FornecedorComponente(6,forn3,item6);
		FornecedorComponente forComp7 = new FornecedorComponente(7,forn3,item7);
		FornecedorComponente forComp8 = new FornecedorComponente(8,forn4,item8);
		FornecedorComponente forComp9 = new FornecedorComponente(9,forn4,item9);
		FornecedorComponente forComp10 = new FornecedorComponente(10,forn6,item10);
		FornecedorComponente forComp11 = new FornecedorComponente(11,forn9,item11);
		FornecedorComponente forComp12 = new FornecedorComponente(12,forn7,item12);
		FornecedorComponente forComp13 = new FornecedorComponente(13,forn7,item13);
		FornecedorComponente forComp14 = new FornecedorComponente(14,forn7,item14);
		FornecedorComponente forComp15 = new FornecedorComponente(15,forn7,item15);
		FornecedorComponente forComp16 = new FornecedorComponente(16,forn4,item16);


		modelCtr.insert(forComp1);
		modelCtr.insert(forComp2);
		modelCtr.insert(forComp3);
		modelCtr.insert(forComp4);
		modelCtr.insert(forComp5);
		modelCtr.insert(forComp6);
		modelCtr.insert(forComp7);
		modelCtr.insert(forComp8);
		modelCtr.insert(forComp9);
		modelCtr.insert(forComp10);
		modelCtr.insert(forComp11);
		modelCtr.insert(forComp12);
		modelCtr.insert(forComp13);
		modelCtr.insert(forComp14);
		modelCtr.insert(forComp15);
		modelCtr.insert(forComp16);
		
		/**********************************************************************************/
		//insere exemplares de itens
		Exemplar exe1 = new Exemplar(1,"corredor 1","box 2","prateleira 2",item1);
		Exemplar exe2 = new Exemplar(2,"corredor 1","box 2","prateleira 2",item1);
		Exemplar exe3 = new Exemplar(3,"corredor 1","box 2","prateleira 2",item2);
		Exemplar exe4 = new Exemplar(4,"corredor 1","box 2","prateleira 2",item2);
		Exemplar exe5 = new Exemplar(5,"corredor 1","box 2","prateleira 2",item3);
		Exemplar exe6 = new Exemplar(6,"corredor 1","box 2","prateleira 2",item3);
		Exemplar exe7 = new Exemplar(7,"corredor 1","box 2","prateleira 2",item4);
		Exemplar exe8 = new Exemplar(8,"corredor 1","box 2","prateleira 2",item4);
		Exemplar exe9 = new Exemplar(9,"corredor 1","box 2","prateleira 2",item5);
		Exemplar exe10 = new Exemplar(10,"corredor 1","box 2","prateleira 2",item5);
		Exemplar exe11 = new Exemplar(11,"corredor 1","box 2","prateleira 2",item6);
		Exemplar exe12 = new Exemplar(12,"corredor 1","box 2","prateleira 2",item6);
		Exemplar exe13 = new Exemplar(13,"corredor 1","box 2","prateleira 2",item7);
		Exemplar exe14 = new Exemplar(14,"corredor 1","box 2","prateleira 2",item7);
		Exemplar exe15 = new Exemplar(15,"corredor 1","box 2","prateleira 2",item8);
		Exemplar exe16 = new Exemplar(16,"corredor 1","box 2","prateleira 2",item9);
		Exemplar exe17 = new Exemplar(17,"corredor 1","box 2","prateleira 2",item10);
		Exemplar exe18 = new Exemplar(18,"corredor 1","box 2","prateleira 2",item11);
		Exemplar exe19 = new Exemplar(19,"corredor 1","box 2","prateleira 2",item11);
		Exemplar exe20 = new Exemplar(20,"corredor 1","box 2","prateleira 2",item11);
		Exemplar exe21 = new Exemplar(21,"corredor 1","box 2","prateleira 2",item12);
		Exemplar exe22 = new Exemplar(22,"corredor 1","box 2","prateleira 2",item12);
		Exemplar exe23 = new Exemplar(23,"corredor 1","box 2","prateleira 2",item13);
		Exemplar exe24 = new Exemplar(24,"corredor 1","box 2","prateleira 2",item13);
		Exemplar exe25 = new Exemplar(25,"corredor 1","box 2","prateleira 2",item14);
		Exemplar exe26 = new Exemplar(26,"corredor 1","box 2","prateleira 2",item15);
		Exemplar exe27 = new Exemplar(27,"corredor 1","box 2","prateleira 2",item16);
		Exemplar exe28 = new Exemplar(28,"corredor 1","box 2","prateleira 2",item5);
		Exemplar exe29 = new Exemplar(29,"corredor 1","box 2","prateleira 2",item6);
		Exemplar exe30 = new Exemplar(30,"corredor 1","box 2","prateleira 2",item3);

		
		modelCtr.insert(exe1);
		modelCtr.insert(exe2);
		modelCtr.insert(exe3);
		modelCtr.insert(exe4);
		modelCtr.insert(exe5);
		modelCtr.insert(exe6);
		modelCtr.insert(exe7);
		modelCtr.insert(exe8);
		modelCtr.insert(exe9);
		modelCtr.insert(exe10);
		modelCtr.insert(exe11);
		modelCtr.insert(exe12);
		modelCtr.insert(exe13);
		modelCtr.insert(exe14);
		modelCtr.insert(exe15);
		modelCtr.insert(exe16);
		modelCtr.insert(exe17);
		modelCtr.insert(exe18);
		modelCtr.insert(exe19);
		modelCtr.insert(exe20);
		modelCtr.insert(exe21);
		modelCtr.insert(exe22);
		modelCtr.insert(exe23);
		modelCtr.insert(exe24);
		modelCtr.insert(exe25);
		modelCtr.insert(exe26);
		modelCtr.insert(exe27);
		modelCtr.insert(exe28);
		modelCtr.insert(exe29);
		modelCtr.insert(exe30);
		
		
		/**********************************************************************************/
		//insere projetos
		Calendar dni1 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dnf1 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar dni2 = new GregorianCalendar(2016,Calendar.FEBRUARY,1);
		Calendar dnf2 = new GregorianCalendar(2018,Calendar.DECEMBER,12);
		Calendar dni3 = new GregorianCalendar(2013,Calendar.JANUARY,17);
		Calendar dnf3 = new GregorianCalendar(2016,Calendar.MAY,7);
		Calendar dni4 = new GregorianCalendar(2015,Calendar.JULY,4);
		Calendar dnf4 = new GregorianCalendar(2017,Calendar.JUNE,4);
		Calendar dni5 = new GregorianCalendar(2016,Calendar.APRIL,1);
		Calendar dnf5 = new GregorianCalendar(2020,Calendar.OCTOBER,1);
		
		
		Projeto proj1 = new Projeto(1,"Robos autonomos",25000.00,dni1.getTime(),dnf1.getTime());
		Projeto proj2 = new Projeto(2,"Sistemas operacionais",30000.00,dni2.getTime(),dnf2.getTime());
		Projeto proj3 = new Projeto(3,"sistema embarcados em tempo real",15000.00,dni3.getTime(),dnf3.getTime());
		Projeto proj4 = new Projeto(4,"inteligencia artificial",55000.00,dni4.getTime(),dnf4.getTime());
		Projeto proj5 = new Projeto(5,"Robos malucos",1000.00,dni5.getTime(),dnf5.getTime());
		
		modelCtr.insert(proj1);
		modelCtr.insert(proj2);
		modelCtr.insert(proj3);
		modelCtr.insert(proj4);
		modelCtr.insert(proj5);
		
		
		/**********************************************************************************/
		//insere pessoa
		
		Calendar dataAdmi1 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar dataAdmi2 = new GregorianCalendar(2016,Calendar.FEBRUARY,1);
		Calendar dataAdmi3 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar dataAdmi4 = new GregorianCalendar(2015,Calendar.NOVEMBER,1);
		Calendar dataAdmi5 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar dataAdmi6 = new GregorianCalendar(2016,Calendar.MAY,1);
		Calendar dataAdmi7 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar dataAdmi8 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar dataAdmi9 = new GregorianCalendar(2016,Calendar.FEBRUARY,1);
		Calendar dataAdmi10 = new GregorianCalendar(2016,Calendar.MAY,1);
		Calendar dataAdmi11 = new GregorianCalendar(2016,Calendar.MARCH,1);
		
		Pessoa pes1 = new Pessoa(1,"daniel","ufsc", "graduando","eng comp","av getulio vargas","email", 1000, dataAdmi1.getTime());
		Pessoa pes2 = new Pessoa(2,"edmar","ufsc", "graduado","eng comp","av getulio vargas","email", 10000, dataAdmi2.getTime());
		Pessoa pes3 = new Pessoa(3,"luiz","ufsc", "graduando","eng comp","av getulio vargas","email", 1000, dataAdmi3.getTime());
		Pessoa pes4 = new Pessoa(4,"aderson","ufsc", "doutor","sis informacao","av getulio vargas","email", 20000, dataAdmi4.getTime());
		Pessoa pes5 = new Pessoa(5,"elder","ufsc", "mestrado","eng comp","av getulio vargas","email", 15000, dataAdmi5.getTime());
		Pessoa pes6 = new Pessoa(6,"cristiano","ufsc", "graduando","eng comp","av getulio vargas","email", 1000, dataAdmi6.getTime());
		Pessoa pes7 = new Pessoa(7,"zeca","usp", "doutor","eng comp","av getulio vargas","email", 1000, dataAdmi7.getTime());
		Pessoa pes8 = new Pessoa(8,"zezinho","ufsc", "graduando","eng comp","av getulio vargas","email", 1000, dataAdmi8.getTime());
		Pessoa pes9 = new Pessoa(9,"puntel","ufsm", "mestrando","eng comp","av getulio vargas","email", 1000, dataAdmi9.getTime());
		Pessoa pes10 = new Pessoa(10,"fulano","harvard", "doutor","eng comp","av getulio vargas","email", 55000, dataAdmi10.getTime());
		Pessoa pes11 = new Pessoa(11,"ciclano","ufsc", "graduado","eng comp","av getulio vargas","email", 10000, dataAdmi11.getTime());

		modelCtr.insert(pes1);
		modelCtr.insert(pes2);
		modelCtr.insert(pes3);
		modelCtr.insert(pes4);
		modelCtr.insert(pes5);
		modelCtr.insert(pes6);
		modelCtr.insert(pes7);
		modelCtr.insert(pes8);
		modelCtr.insert(pes9);
		modelCtr.insert(pes10);
		modelCtr.insert(pes11);
		
		/**********************************************************************************/
		//insere funcao
		
		Funcao fun1 = new Funcao(1,pes1,"Pesquisador");
		Funcao fun2 = new Funcao(2,pes2,"Pesquisador");
		Funcao fun3 = new Funcao(3,pes3,"Pesquisador");
		Funcao fun4 = new Funcao(4,pes4,"Diretor");
		Funcao fun5 = new Funcao(5,pes5,"Pesquisador");
		Funcao fun6 = new Funcao(6,pes6,"Pesquisador");
		Funcao fun7 = new Funcao(7,pes7,"Pesquisador");
		Funcao fun8 = new Funcao(8,pes8,"Pesquisador");
		Funcao fun9 = new Funcao(9,pes9,"Pesquisador");
		Funcao fun10 = new Funcao(10,pes10,"Pesquisador");
		Funcao fun11 = new Funcao(11,pes11,"Pesquisador");
		
		modelCtr.insert(fun1);
		modelCtr.insert(fun2);
		modelCtr.insert(fun3);
		modelCtr.insert(fun4);
		modelCtr.insert(fun5);
		modelCtr.insert(fun6);
		modelCtr.insert(fun7);
		modelCtr.insert(fun8);
		modelCtr.insert(fun9);
		modelCtr.insert(fun10);
		modelCtr.insert(fun11);

		/**********************************************************************************/
		//insere tipoPessoa
		
		TipoPessoa tipoPes1 = new TipoPessoa(1,pes1,"Aluno");
		TipoPessoa tipoPes2 = new TipoPessoa(2,pes2,"Convidado");
		TipoPessoa tipoPes3 = new TipoPessoa(3,pes3,"Aluno");
		TipoPessoa tipoPes4 = new TipoPessoa(4,pes4,"Professor");
		TipoPessoa tipoPes5 = new TipoPessoa(5,pes5,"Aluno");
		TipoPessoa tipoPes6 = new TipoPessoa(6,pes6,"Aluno");
		TipoPessoa tipoPes7 = new TipoPessoa(7,pes7,"Professor");
		TipoPessoa tipoPes8 = new TipoPessoa(8,pes8,"Aluno");
		TipoPessoa tipoPes9 = new TipoPessoa(9,pes9,"Professor");
		TipoPessoa tipoPes10 = new TipoPessoa(10,pes10,"Professor");
		TipoPessoa tipoPes11 = new TipoPessoa(11,pes11,"Aluno");
				
		modelCtr.insert(tipoPes1);
		modelCtr.insert(tipoPes2);
		modelCtr.insert(tipoPes3);
		modelCtr.insert(tipoPes4);
		modelCtr.insert(tipoPes5);
		modelCtr.insert(tipoPes6);
		modelCtr.insert(tipoPes7);
		modelCtr.insert(tipoPes8);
		modelCtr.insert(tipoPes9);
		modelCtr.insert(tipoPes10);
		modelCtr.insert(tipoPes11);
	
		/**********************************************************************************/
		//insere relacao pessoa projeto
		
		PessoaProjeto pesProj1 = new PessoaProjeto (1,pes1,proj2);
		PessoaProjeto pesProj2 = new PessoaProjeto (2,pes2,proj1);
		PessoaProjeto pesProj3 = new PessoaProjeto (3,pes3,proj3);
		PessoaProjeto pesProj4 = new PessoaProjeto (4,pes4,proj3);
		PessoaProjeto pesProj5 = new PessoaProjeto (5,pes5,proj1);
		PessoaProjeto pesProj6 = new PessoaProjeto (6,pes6,proj4);
		PessoaProjeto pesProj7 = new PessoaProjeto (7,pes7,proj5);
		PessoaProjeto pesProj8 = new PessoaProjeto (8,pes8,proj5);
		PessoaProjeto pesProj9 = new PessoaProjeto (9,pes9,proj4);
		PessoaProjeto pesProj10 = new PessoaProjeto (10,pes10,proj3);
		PessoaProjeto pesProj11 = new PessoaProjeto (11,pes11,proj2);
		
		modelCtr.insert(pesProj1);
		modelCtr.insert(pesProj2);
		modelCtr.insert(pesProj3);
		modelCtr.insert(pesProj4);
		modelCtr.insert(pesProj5);
		modelCtr.insert(pesProj6);
		modelCtr.insert(pesProj7);
		modelCtr.insert(pesProj8);
		modelCtr.insert(pesProj9);
		modelCtr.insert(pesProj10);
		modelCtr.insert(pesProj11);

		/**********************************************************************************/
		//insere relacao utiliza
		Calendar dataEmpres1 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc1 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres2 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc2 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres3 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc3 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres4 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc4 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres5 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc5 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres6 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc6 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres7 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc7 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres8 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc8 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres9 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc9 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres10 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc10 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres11 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc11 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres12 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc12 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres13 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc13 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres14 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc14 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataEmpres15 = new GregorianCalendar(2014,Calendar.MARCH,1);
		Calendar dataDevouc15 = new GregorianCalendar(2014,Calendar.MARCH,1);
		


		Utiliza uti1 = new Utiliza(1,exe1,dataEmpres1.getTime(),dataDevouc1.getTime(),proj1,null);
		Utiliza uti2 = new Utiliza(2,exe2,dataEmpres1.getTime(),dataDevouc1.getTime(),proj1,null);
		Utiliza uti3 = new Utiliza(3,exe3,dataEmpres2.getTime(),dataDevouc2.getTime(),proj2,null);
		Utiliza uti4 = new Utiliza(4,exe4,dataEmpres2.getTime(),dataDevouc2.getTime(),proj2,null);
		Utiliza uti5 = new Utiliza(5,exe5,dataEmpres3.getTime(),dataDevouc3.getTime(),proj2,null);
		Utiliza uti6 = new Utiliza(6,exe6,dataEmpres3.getTime(),dataDevouc3.getTime(),proj2,null);
		Utiliza uti7 = new Utiliza(7,exe7,dataEmpres3.getTime(),dataDevouc3.getTime(),proj3,null);
		Utiliza uti8 = new Utiliza(8,exe8,dataEmpres3.getTime(),dataDevouc3.getTime(),proj3,null);
		Utiliza uti9 = new Utiliza(9,exe9,dataEmpres4.getTime(),dataDevouc4.getTime(),proj4,null);
		Utiliza uti10 = new Utiliza(10,exe10,dataEmpres4.getTime(),dataDevouc4.getTime(),proj4,null);
		Utiliza uti11 = new Utiliza(11,exe11,dataEmpres5.getTime(),dataDevouc5.getTime(),proj4,null);
		Utiliza uti12 = new Utiliza(12,exe12,dataEmpres5.getTime(),dataDevouc5.getTime(),proj4,null);
		Utiliza uti13 = new Utiliza(13,exe13,dataEmpres6.getTime(),dataDevouc6.getTime(),proj4,null);
		Utiliza uti14 = new Utiliza(14,exe14,dataEmpres6.getTime(),dataDevouc6.getTime(),proj1,null);
		Utiliza uti15 = new Utiliza(15,exe18,dataEmpres7.getTime(),dataDevouc7.getTime(),proj5,null);
		Utiliza uti16 = new Utiliza(16,exe19,dataEmpres7.getTime(),dataDevouc7.getTime(),proj5,null);
		Utiliza uti17 = new Utiliza(17,exe20,dataEmpres8.getTime(),dataDevouc8.getTime(),proj5,null);
		Utiliza uti18 = new Utiliza(18,exe21,dataEmpres9.getTime(),dataDevouc9.getTime(),proj5,null);
		Utiliza uti19 = new Utiliza(19,exe22,dataEmpres10.getTime(),dataDevouc10.getTime(),proj5,null);
		Utiliza uti20 = new Utiliza(20,exe23,dataEmpres11.getTime(),dataDevouc11.getTime(),null,pes1);
		Utiliza uti21 = new Utiliza(21,exe24,dataEmpres12.getTime(),dataDevouc12.getTime(),null,pes1);
		Utiliza uti22 = new Utiliza(22,exe25,dataEmpres13.getTime(),dataDevouc13.getTime(),null,pes4);
		Utiliza uti23 = new Utiliza(23,exe26,dataEmpres14.getTime(),dataDevouc14.getTime(),null,pes4);
		Utiliza uti24 = new Utiliza(24,exe27,dataEmpres15.getTime(),dataDevouc15.getTime(),null,pes8);
		Utiliza uti25 = new Utiliza(25,exe27,dataEmpres15.getTime(),dataDevouc15.getTime(),null,pes8);
		Utiliza uti26 = new Utiliza(26,exe1,dataEmpres15.getTime(),dataDevouc15.getTime(),null,pes11);

		
		
		modelCtr.insert(uti1);
		modelCtr.insert(uti2);
		modelCtr.insert(uti3);
		modelCtr.insert(uti4);
		modelCtr.insert(uti5);
		modelCtr.insert(uti6);
		modelCtr.insert(uti7);
		modelCtr.insert(uti8);
		modelCtr.insert(uti9);
		modelCtr.insert(uti10);
		modelCtr.insert(uti11);
		modelCtr.insert(uti12);
		modelCtr.insert(uti13);
		modelCtr.insert(uti14);
		modelCtr.insert(uti15);
		modelCtr.insert(uti16);
		modelCtr.insert(uti17);
		modelCtr.insert(uti18);
		modelCtr.insert(uti19);
		modelCtr.insert(uti20);
		modelCtr.insert(uti21);
		modelCtr.insert(uti22);
		modelCtr.insert(uti23);
		modelCtr.insert(uti24);
		modelCtr.insert(uti25);
		modelCtr.insert(uti26);

		/**********************************************************************************/
		//insere solicitacao
		
		Solicitacao soli1 = new Solicitacao(1,"resistor","2 100k");
		Solicitacao soli2 = new Solicitacao(2,"resistor","10 10k");
		Solicitacao soli3 = new Solicitacao(3,"resistor","10 10k");
		Solicitacao soli4 = new Solicitacao(4,"resistor","1 1k");
		Solicitacao soli5 = new Solicitacao(5,"capacitor","20 10uf");
		Solicitacao soli6 = new Solicitacao(6,"capacitor","10 10nf");
		Solicitacao soli7 = new Solicitacao(7,"transistor","40 tip120");
		Solicitacao soli8 = new Solicitacao(8,"diodo","10 1n4001");
		Solicitacao soli9 = new Solicitacao(9,"diodo","30 1n4001");
		Solicitacao soli10 = new Solicitacao(10,"diodo","25 1n4001");
		
		modelCtr.insert(soli1);
		modelCtr.insert(soli2);
		modelCtr.insert(soli3);
		modelCtr.insert(soli4);
		modelCtr.insert(soli5);
		modelCtr.insert(soli6);
		modelCtr.insert(soli7);
		modelCtr.insert(soli8);
		modelCtr.insert(soli9);
		modelCtr.insert(soli10);

		
		/**********************************************************************************/
		//insere relacao solicita
		
		Calendar solicita1 = new GregorianCalendar(2016,Calendar.FEBRUARY,16);
		Calendar solicita2 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar solicita3 = new GregorianCalendar(2015,Calendar.DECEMBER,1);
		Calendar solicita4 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar solicita5 = new GregorianCalendar(2015,Calendar.DECEMBER,1);
		Calendar solicita6 = new GregorianCalendar(2015,Calendar.DECEMBER,1);
		Calendar solicita7 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar solicita8 = new GregorianCalendar(2015,Calendar.DECEMBER,1);
		Calendar solicita9 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar solicita10 = new GregorianCalendar(2016,Calendar.FEBRUARY,1);

		Solicita sol1 = new Solicita (1,soli1,solicita1.getTime(),null,pes2);
		Solicita sol2 = new Solicita (2,soli2,solicita2.getTime(),proj3,null);
		Solicita sol3 = new Solicita (3,soli3,solicita3.getTime(),null,pes1);
		Solicita sol4 = new Solicita (4,soli4,solicita4.getTime(),null,pes5);
		Solicita sol5 = new Solicita (5,soli5,solicita5.getTime(),proj4,null);
		Solicita sol6 = new Solicita (6,soli6,solicita6.getTime(),proj1,null);
		Solicita sol7 = new Solicita (7,soli7,solicita7.getTime(),proj5,null);
		Solicita sol8 = new Solicita (8,soli8,solicita8.getTime(),null,pes9);
		Solicita sol9 = new Solicita (9,soli9,solicita9.getTime(),null,pes10);
		Solicita sol10 = new Solicita (10,soli10,solicita10.getTime(),proj2,null);

		
		modelCtr.insert(sol1);
		modelCtr.insert(sol2);
		modelCtr.insert(sol3);
		modelCtr.insert(sol4);
		modelCtr.insert(sol5);
		modelCtr.insert(sol6);
		modelCtr.insert(sol7);
		modelCtr.insert(sol8);
		modelCtr.insert(sol9);
		modelCtr.insert(sol10);

		/**********************************************************************************/
		//insere  relacao recebe
		
		Recebe rec1 = new Recebe(1,pes4,soli1);
		Recebe rec2 = new Recebe(2,pes4,soli2);
		Recebe rec3 = new Recebe(3,pes4,soli3);
		Recebe rec4 = new Recebe(4,pes4,soli4);
		Recebe rec5 = new Recebe(5,pes4,soli5);
		Recebe rec6 = new Recebe(6,pes4,soli6);
		Recebe rec7 = new Recebe(7,pes4,soli7);
		Recebe rec8 = new Recebe(8,pes4,soli8);
		Recebe rec9 = new Recebe(9,pes4,soli9);
		Recebe rec10 = new Recebe(10,pes4,soli10);

		
		modelCtr.insert(rec1);
		modelCtr.insert(rec2);
		modelCtr.insert(rec3);
		modelCtr.insert(rec4);
		modelCtr.insert(rec5);
		modelCtr.insert(rec6);
		modelCtr.insert(rec7);
		modelCtr.insert(rec8);
		modelCtr.insert(rec9);
		modelCtr.insert(rec10);
		
		
		/**********************************************************************************/
		//insere  pedidos
		Calendar pedData1 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar pedData2 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar pedData3 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar pedData4 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar pedData5 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar pedData6 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar pedData7 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar pedData8 = new GregorianCalendar(2016,Calendar.JANUARY,1);
		Calendar pedData9 = new GregorianCalendar(2016,Calendar.MARCH,1);
		Calendar pedData10 = new GregorianCalendar(2016,Calendar.JANUARY,1);


		Pedido ped1 = new Pedido(1,pedData1.getTime(),"pedido",forn3,pes4);
		Pedido ped2 = new Pedido(2,pedData2.getTime(),"pedido",forn1,pes4);
		Pedido ped3 = new Pedido(3,pedData3.getTime(),"pedido",forn2,pes4);
		Pedido ped4 = new Pedido(4,pedData4.getTime(),"pedido",forn6,pes4);
		Pedido ped5 = new Pedido(5,pedData5.getTime(),"pedido",forn1,pes4);
		Pedido ped6 = new Pedido(6,pedData6.getTime(),"pedido",forn7,pes4);
		Pedido ped7 = new Pedido(7,pedData7.getTime(),"pedido",forn8,pes4);
		Pedido ped8 = new Pedido(8,pedData8.getTime(),"pedido",forn9,pes4);
		Pedido ped9 = new Pedido(9,pedData9.getTime(),"pedido",forn1,pes4);
		Pedido ped10 = new Pedido(10,pedData10.getTime(),"pedido",forn5,pes4);
		
		modelCtr.insert(ped1);
		modelCtr.insert(ped2);
		modelCtr.insert(ped3);
		modelCtr.insert(ped4);
		modelCtr.insert(ped5);
		modelCtr.insert(ped6);
		modelCtr.insert(ped7);
		modelCtr.insert(ped8);
		modelCtr.insert(ped9);
		modelCtr.insert(ped10);
		
		
		/**********************************************************************************/
		//insere  relacao pedido componente
		
		PedidoComponente pedComp1 = new PedidoComponente(1,ped1,item2);
		PedidoComponente pedComp2 = new PedidoComponente(1,ped2,item3);
		PedidoComponente pedComp3 = new PedidoComponente(1,ped3,item3);
		PedidoComponente pedComp4 = new PedidoComponente(1,ped4,item4);
		PedidoComponente pedComp5 = new PedidoComponente(1,ped5,item15);
		PedidoComponente pedComp6 = new PedidoComponente(1,ped6,item16);
		PedidoComponente pedComp7 = new PedidoComponente(1,ped7,item7);
		PedidoComponente pedComp8 = new PedidoComponente(1,ped8,item1);
		PedidoComponente pedComp9 = new PedidoComponente(1,ped9,item1);
		PedidoComponente pedComp10 = new PedidoComponente(1,ped10,item1);

		modelCtr.insert(pedComp1);
		modelCtr.insert(pedComp2);
		modelCtr.insert(pedComp3);
		modelCtr.insert(pedComp4);
		modelCtr.insert(pedComp5);
		modelCtr.insert(pedComp6);
		modelCtr.insert(pedComp7);
		modelCtr.insert(pedComp8);
		modelCtr.insert(pedComp9);
		modelCtr.insert(pedComp10);


		
		System.out.println("Inser realizazadas com sucesso!!!");

	}

}
