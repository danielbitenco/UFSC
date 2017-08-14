package ufsc.bd1.org.model;

import java.math.BigInteger;

//Busca para saber quantas pessoas há em cada projeto

//select pro.descricao, count(pro.descricao) as quantidade_pessoas
//from pessoa as p, pessoaprojeto as pp, projeto as pro
//where p.id_pessoa = pp.id_pessoa and pp.id_projeto = pro.id_projeto
//group by pro.descricao
//order by quantidade_pessoas asc


public class BuscaPessoaProjeto {
	
	private String nome = "";
	private  BigInteger quantidadePessoas;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigInteger getQuantidadePessoas() {
		return quantidadePessoas;
	}
	public void setQuantidadePessoas(BigInteger quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

}
