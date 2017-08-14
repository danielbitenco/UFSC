package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item")

public class Item {
	@Id
	@Column(name="ID_componente", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "valor")
	private double valor;
	
	public Item(){}
	
	public Item(int id, String descricao, String modelo, String tipo, double valor)
	{
		this.setId(id);
		this.setDescricao(descricao);
		this.setModelo(modelo);
		this.setTipo(tipo);
		this.setValor(valor);
	}
	
	public Item(String descricao, String modelo, String tipo, double valor)
	{
		this.setDescricao(descricao);
		this.setModelo(modelo);
		this.setTipo(tipo);
		this.setValor(valor);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
