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

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "solicita")

public class Solicita {

	@Id
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_solicitacao")
	private Solicitacao solicitacao;
	
	@Column(name = "data")
	private Timestamp data;
	
	@ManyToOne
	@JoinColumn(name = "ID_projeto")
	private Projeto projeto;
	
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	public Solicita(){}
	
	public Solicita(int id, Solicitacao solicitacao, Date data, Projeto projeto, Pessoa pessoa)
	{
		this.setId(id);
		this.setSolicitacao(solicitacao);
		this.setData(new Timestamp(data.getTime()));
		this.setProjeto(projeto);
		this.setPessoa(pessoa);
	}
	
	public Solicita(Solicitacao solicitacao, Date data, Projeto projeto, Pessoa pessoa)
	{
		this.setSolicitacao(solicitacao);
		this.setData(new Timestamp(data.getTime()));
		this.setProjeto(projeto);
		this.setPessoa(pessoa);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
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
	public Date getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
}
