// default package
// Generated Jun 18, 2016 6:51:54 PM by Hibernate Tools 4.0.0.Final
package ufsc.bd1.org.model;

/**
 * PessoaProjeto generated by hbm2java
 */
public class PessoaProjeto implements java.io.Serializable {

	private int idSequencia;
	private Pessoa pessoa;
	private Projeto projeto;

	public PessoaProjeto() {
	}

	public PessoaProjeto(int idSequencia) {
		this.idSequencia = idSequencia;
	}

	public PessoaProjeto(int idSequencia, Pessoa pessoa, Projeto projeto) {
		this.idSequencia = idSequencia;
		this.pessoa = pessoa;
		this.projeto = projeto;
	}

	public int getIdSequencia() {
		return this.idSequencia;
	}

	public void setIdSequencia(int idSequencia) {
		this.idSequencia = idSequencia;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
