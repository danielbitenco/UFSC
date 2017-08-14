package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")

public class Fornecedor {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Fornecedor_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id_fornecedor", unique=true, nullable=false)
	private Integer id_fornecedor;
	
//	id_fornecedor = GenerationType.AUTO;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "website")
	private String website;
	
	public Fornecedor(){}
	
	public Fornecedor(int id_fornecedor, String nome, String endereco, String website)
	{
		this.setId(id_fornecedor);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setWebsite(website);
	}
	
	public Fornecedor(String nome, String endereco, String website)
	{
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setWebsite(website);
	}
	
	public int getId() {
		return id_fornecedor;
	}
	public void setId(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}
