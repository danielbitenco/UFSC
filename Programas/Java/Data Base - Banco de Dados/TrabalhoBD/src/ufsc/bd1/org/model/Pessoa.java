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
//@Table(name = "pessoa")

public class Pessoa {
	@Id
	@Column(name="ID_pessoa", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "universidade")
	private String universidade;
	
	@Column(name = "formacao")
	private String formacao;
	
	@Column(name = "curso")
	private String curso;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "salario")
	private double salario;
	
	@Column(name = "data_admissao")
	private Timestamp data_admissao;
	
	public Pessoa(){}
	
	public Pessoa(int id, String nome, String universidade, String formacao, String curso, String endereco, String email, double salario, Date data_admissao)
	{
		this.setId(id);
		this.setNome(nome);
		this.setUniversidade(universidade);
		this.setFormacao(formacao);
		this.setCurso(curso);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setSalario(salario);
		this.setDataAdmissao(new Timestamp(data_admissao.getTime()));
	}
	
	public Pessoa(String nome, String universidade, String formacao, String curso, String endereco, String email, double salario, Date data_admissao)
	{
		this.setNome(nome);
		this.setUniversidade(universidade);
		this.setFormacao(formacao);
		this.setCurso(curso);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setSalario(salario);
		this.setDataAdmissao(new Timestamp(data_admissao.getTime()));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUniversidade() {
		return universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEndereco() {
		return curso;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Date getDataAdmissao() {
		return data_admissao;
	}
	public void setDataAdmissao(Timestamp data_admissao) {
		this.data_admissao = data_admissao;
	}
}
