package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Solicitacao")

public class Solicitacao {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Solicitacao_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_solicitacao", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "item")
	private char item;
	
	@Column(name = "descricao")
	private char descricao;
	
	public Solicitacao(){}
	
	public Solicitacao(int id, char item, char descricao)
	{
		this.setId(id);
		this.setItem(item);
		this.setDescricao(descricao);
	}
	
	public Solicitacao(char item, char descricao)
	{
		this.setItem(item);
		this.setDescricao(descricao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getItem() {
		return item;
	}
	public void setItem(char item) {
		this.item = item;
	}
	public char getDescricao() {
		return descricao;
	}
	public void setDescricao(char descricao) {
		this.descricao = descricao;
	}

}
