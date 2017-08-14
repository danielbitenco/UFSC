package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Projeto")

public class Projeto {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Projeto_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_projeto", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "descricao")
	private char descricao;
	
	@Column(name = "recursos")
	private double recursos;
	
	@Column(name = "data_inicial")
	private Date data_inicial;
	
	@Column(name = "data_final")
	private Date data_final;
	
	public Projeto(){}
	
	public Projeto(int id, char descricao, double recursos, Date data_inicial, Date data_final)
	{
		this.setId(id);
		this.setDescricao(descricao);
		this.setRecursos(recursos);
		this.setDataInicial(data_inicial);
		this.setDataFinal(data_final);
	}
	
	public Projeto(char descricao, double recursos, Date data_inicial, Date data_final)
	{
		this.setDescricao(descricao);
		this.setRecursos(recursos);
		this.setDataInicial(data_inicial);
		this.setDataFinal(data_final);
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
	public double getRecursos() {
		return recursos;
	}
	public void setRecursos(double recursos) {
		this.recursos = recursos;
	}
	public Date getDataInicial() {
		return data_inicial;
	}
	public void setDataInicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getDataFinal() {
		return data_final;
	}
	public void setDataFinal(Date data_final) {
		this.data_final = data_final;
	}
}
