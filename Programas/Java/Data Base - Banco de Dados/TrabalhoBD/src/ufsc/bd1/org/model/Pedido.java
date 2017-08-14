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

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "pedido")

public class Pedido {

	@Id
	@Column(name="ID_pedido", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "data")
	private Timestamp data;
	
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "ID_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	public Pedido(){}
	
	public Pedido(int id, Date data, String descricao, Fornecedor fornecedor, Pessoa pessoa)
	{
		this.setId(id);
		this.setFornecedor(fornecedor);
		this.setPessoa(pessoa);
		this.setData(new Timestamp (data.getTime()));
		this.setDescricao(descricao);
	}
	
	public Pedido(Date data, String descricao, Fornecedor fornecedor, Pessoa pessoa)
	{
		this.setFornecedor(fornecedor);
		this.setPessoa(pessoa);
		this.setData(new Timestamp (data.getTime()));
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
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
