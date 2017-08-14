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
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Recebe_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_componente")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "ID_solicaitacao")
	private Solicitacao solicitacao;
	
	public Recebe(){}
	
	public Recebe(int id, Item item, Pessoa pessoa, Solicitacao solicitacao)
	{
		this.setId(id);
		this.setItem(item);
		this.setPessoa(pessoa);
		this.setSolicitacao(solicitacao);
	}
	
	public Recebe(Item item, Pessoa pessoa, Solicitacao solicitacao)
	{
		this.setItem(item);
		this.setPessoa(pessoa);
		this.setSolicitacao(solicitacao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
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
