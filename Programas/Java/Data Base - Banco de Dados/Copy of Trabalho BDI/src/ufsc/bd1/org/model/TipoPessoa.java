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
@Table(name = "TipoPessoa")

public class TipoPessoa {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_TipoPessoa_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_tipo_pessoa", unique=true, nullable=false)
	private Integer id;
	
	//verificar declaração de chave PK FK
	@Id
	@ManyToOne
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_TipoPessoa_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@PrimaryKeyJoinColumn(name="ID_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "tipo")
	private char tipo;
	
	public TipoPessoa(){}
	
	public TipoPessoa(int id, Pessoa pessoa, char tipo)
	{
		this.setId(id);
		this.setPessoa(pessoa);
		this.setTipo(tipo);
	}
	
	public TipoPessoa(Pessoa pessoa, char tipo)
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
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
