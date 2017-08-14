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
import java.util.Date;

@Entity
@Table(name = "Pedido")

public class Pedido {

	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Pedido_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_pedido", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "descricao")
	private char descricao;
	
	@ManyToOne
	@JoinColumn(name = "ID_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	public Pedido(){}
	
	public Pedido(int id, Date data, char descricao, Fornecedor fornecedor, Pessoa pessoa)
	{
		this.setId(id);
		this.setFornecedor(fornecedor);
		this.setPessoa(pessoa);
		this.setData(data);
		this.setDescricao(descricao);
	}
	
	public Pedido(Date data, char descricao, Fornecedor fornecedor, Pessoa pessoa)
	{
		this.setFornecedor(fornecedor);
		this.setPessoa(pessoa);
		this.setData(data);
		this.setDescricao(descricao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public char getDescricao() {
		return descricao;
	}
	public void setDescricao(char descricao) {
		this.descricao = descricao;
	}
}
