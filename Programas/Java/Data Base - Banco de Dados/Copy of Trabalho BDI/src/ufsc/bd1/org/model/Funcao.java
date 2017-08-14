package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Funcao")

public class Funcao {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Funcao_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_funcao", unique=true, nullable=false)
	private Integer id;
	
	//verificar declaração de chave PK FK
	@Id
	@ManyToOne
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Funcao_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@PrimaryKeyJoinColumn(name="ID_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "funcao")
	private char funcao;
	
	public Funcao(){}
	
	public Funcao(int id, Pessoa pessoa, char funcao)
	{
		this.setId(id);
		this.setPessoa(pessoa);
		this.setFuncao(funcao);
	}
	
	public Funcao(Pessoa pessoa, char funcao)
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
	public char getFuncao() {
		return funcao;
	}
	public void setFuncao(char funcao) {
		this.funcao = funcao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
