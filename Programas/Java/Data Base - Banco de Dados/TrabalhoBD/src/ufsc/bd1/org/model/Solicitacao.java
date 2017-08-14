package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacao")

public class Solicitacao {
	@Id
	@Column(name="ID_solicitacao", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "descricao")
	private String descricao;
	
	public Solicitacao(){}
	
	public Solicitacao(int id, String item, String descricao)
	{
		this.setId(id);
		this.setItem(item);
		this.setDescricao(descricao);
	}
	
	public Solicitacao(String item, String descricao)
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
