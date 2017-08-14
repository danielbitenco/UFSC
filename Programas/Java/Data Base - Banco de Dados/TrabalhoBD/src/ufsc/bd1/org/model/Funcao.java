package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "funcao")

public class Funcao {
	
	@Id
	@Column(name="ID_funcao", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "funcao")
	private String funcao;
	
	public Funcao(){}
	
	public Funcao(int id, Pessoa pessoa, String funcao)
	{
		this.setId(id);
		this.setPessoa(pessoa);
		this.setFuncao(funcao);
	}
	
	public Funcao(Pessoa pessoa, String funcao)
	{
		this.setPessoa(pessoa);
		this.setFuncao(funcao);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
