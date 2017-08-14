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
@Table(name = "Recebe")

public class Recebe {
	@Id
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
		
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "ID_solicaitacao")
	private Solicitacao solicitacao;
	
	public Recebe(){}
	
	public Recebe(int id, Pessoa pessoa, Solicitacao solicitacao)
	{
		this.setId(id);
		this.setPessoa(pessoa);
		this.setSolicitacao(solicitacao);
	}
	
	public Recebe(Pessoa pessoa, Solicitacao solicitacao)
	{
		this.setPessoa(pessoa);
		this.setSolicitacao(solicitacao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Item getItem() {
//		return item;
//	}
//	public void setItem(Item item) {
//		this.item = item;
//	}
	public Pessoa getPessoa(){
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	public Solicitacao getSolicitacao(){
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao){
		this.solicitacao = solicitacao;
	}
}
