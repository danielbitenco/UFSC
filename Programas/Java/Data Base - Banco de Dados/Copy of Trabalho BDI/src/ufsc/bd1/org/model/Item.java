package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Item")

public class Item {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Item_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_componente", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "descricao")
	private char descricao;
	
	@Column(name = "modelo")
	private char modelo;
	
	@Column(name = "tipo")
	private char tipo;
	
	@Column(name = "valor")
	private double valor;
	
	public Item(){}
	
	public Item(int id, char descricao, char modelo, char tipo, double valor)
	{
		this.setId(id);
		this.setDescricao(descricao);
		this.setModelo(modelo);
		this.setTipo(tipo);
		this.setValor(valor);
	}
	
	public Item(char descricao, char modelo, char tipo, double valor)
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
	public char getDescricao() {
		return descricao;
	}
	public void setDescricao(char descricao) {
		this.descricao = descricao;
	}
	public char getModelo() {
		return modelo;
	}
	public void setModelo(char modelo) {
		this.modelo = modelo;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
