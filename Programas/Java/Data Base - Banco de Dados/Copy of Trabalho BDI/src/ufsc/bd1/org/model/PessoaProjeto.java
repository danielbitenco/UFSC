package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "PessoaProjeto")

public class PessoaProjeto {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_PessoaProjeto_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "ID_projeto")
	private Projeto projeto;
	
	public PessoaProjeto(){}
	
	public PessoaProjeto(int id, Pessoa pessoa, Projeto projeto)
	{
		this.setId(id);
		this.setPessoa(pessoa);
		this.setProjeto(projeto);
	}
	
	public PessoaProjeto(Pessoa pessoa, Projeto projeto)
	{
		this.setPessoa(pessoa);
		this.setProjeto(projeto);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
