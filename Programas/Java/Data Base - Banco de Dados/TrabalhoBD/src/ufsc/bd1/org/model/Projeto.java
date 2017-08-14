package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "projeto")

public class Projeto {
	@Id
	@Column(name="ID_projeto", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "recursos")
	private double recursos;
	
	@Column(name = "data_inicial")
	private Timestamp data_inicial;
	
	@Column(name = "data_final")
	private Timestamp data_final;
	
	public Projeto(){}
	
	public Projeto(int id, String descricao, double recursos, Date data_inicial, Date data_final)
	{
		this.setId(id);
		this.setDescricao(descricao);
		this.setRecursos(recursos);
		this.setDataInicial(new Timestamp(data_inicial.getTime()));
		this.setDataFinal(new Timestamp(data_final.getTime()));
	}
	
	public Projeto(String descricao, double recursos, Date data_inicial, Date data_final)
	{
		this.setDescricao(descricao);
		this.setRecursos(recursos);
		this.setDataInicial(new Timestamp(data_inicial.getTime()));
		this.setDataFinal(new Timestamp(data_final.getTime()));
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
	public double getRecursos() {
		return recursos;
	}
	public void setRecursos(double recursos) {
		this.recursos = recursos;
	}
	public Date getDataInicial() {
		return data_inicial;
	}
	public void setDataInicial(Timestamp data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getDataFinal() {
		return data_final;
	}
	public void setDataFinal(Timestamp data_final) {
		this.data_final = data_final;
	}
}
