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
@Table(name = "tipoPessoa")

public class TipoPessoa {
	@Id
	@Column(name="ID_tipo_pessoa", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "tipo")
	private String tipo;
	
	public TipoPessoa(){}
	
	public TipoPessoa(int id, Pessoa pessoa, String tipo)
	{
		this.setId(id);
		this.setPessoa(pessoa);
		this.setTipo(tipo);
	}
	
	public TipoPessoa(Pessoa pessoa, String tipo)
	{
		this.setPessoa(pessoa);
		this.setTipo(tipo);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
