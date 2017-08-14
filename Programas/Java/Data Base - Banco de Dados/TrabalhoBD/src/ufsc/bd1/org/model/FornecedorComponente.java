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
@Table(name = "fornecedorComponente")

public class FornecedorComponente {
	@Id
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "ID_item")
	private Item item;
	
	public FornecedorComponente(){}
	
	public FornecedorComponente(int id, Fornecedor fornecedor, Item item)
	{
		this.setId(id);
		this.setFornecedor(fornecedor);
		this.setItem(item);
	}
	
	public FornecedorComponente(Fornecedor fornecedor, Item item)
	{
		this.setFornecedor(fornecedor);
		this.setItem(item);
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
}
