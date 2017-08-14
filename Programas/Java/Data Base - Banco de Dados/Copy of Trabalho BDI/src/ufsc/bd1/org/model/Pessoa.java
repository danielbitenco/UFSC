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
@Table(name = "Pessoa")

public class Pessoa {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Pessoa_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_pessoa", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "nome")
	private char nome;
	
	@Column(name = "universidade")
	private char universidade;
	
	@Column(name = "formacao")
	private char formacao;
	
	@Column(name = "curso")
	private char curso;
	
	@Column(name = "endereco")
	private char endereco;
	
	@Column(name = "email")
	private char email;
	
	@Column(name = "salario")
	private double salario;
	
	@Column(name = "data_admissao")
	private Date data_admissao;
	
	public Pessoa(){}
	
	public Pessoa(int id, char nome, char universidade, char formacao, char curso, char endereco, char email, char salario, Date data_admissao)
	{
		this.setId(id);
		this.setNome(nome);
		this.setUniversidade(universidade);
		this.setFormacao(formacao);
		this.setCurso(curso);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setSalario(salario);
		this.setDataAdmissao(data_admissao);
	}
	
	public Pessoa(char nome, char universidade, char formacao, char curso, char endereco, char email, char salario, Date data_admissao)
	{
		this.setNome(nome);
		this.setUniversidade(universidade);
		this.setFormacao(formacao);
		this.setCurso(curso);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setSalario(salario);
		this.setDataAdmissao(data_admissao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getNome() {
		return nome;
	}
	public void setNome(char nome) {
		this.nome = nome;
	}
	public char getUniversidade() {
		return universidade;
	}
	public void setUniversidade(char universidade) {
		this.universidade = universidade;
	}
	public char getFormacao() {
		return formacao;
	}
	public void setFormacao(char formacao) {
		this.formacao = formacao;
	}
	public char getCurso() {
		return curso;
	}
	public void setCurso(char curso) {
		this.curso = curso;
	}
	public char getEndereco() {
		return curso;
	}
	public void setEndereco(char endereco) {
		this.endereco = endereco;
	}
	public char getEmail() {
		return email;
	}
	public void setEmail(char email) {
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
	public void setDataAdmissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}
}
