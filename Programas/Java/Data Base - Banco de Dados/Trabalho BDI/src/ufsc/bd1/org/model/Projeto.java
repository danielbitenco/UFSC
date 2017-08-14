// default package
// Generated Jun 18, 2016 6:51:54 PM by Hibernate Tools 4.0.0.Final
package ufsc.bd1.org.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Projeto generated by hbm2java
 */
public class Projeto implements java.io.Serializable {

	private int idProjeto;
	private String descricao;
	private Float recursos;
	private Date dataInicial;
	private Date dataFinal;
	private Set utilizas = new HashSet(0);
	private Set pessoaProjetos = new HashSet(0);
	private Set solicitas = new HashSet(0);

	public Projeto() {
	}

	public Projeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Projeto(int idProjeto, String descricao, Float recursos, Date dataInicial, Date dataFinal, Set utilizas, Set pessoaProjetos, Set solicitas) {
       this.idProjeto = idProjeto;
       this.descricao = descricao;
       this.recursos = recursos;
       this.dataInicial = dataInicial;
       this.dataFinal = dataFinal;
       this.utilizas = utilizas;
       this.pessoaProjetos = pessoaProjetos;
       this.solicitas = solicitas;
    }

	public int getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getDescricao() {
        return this.descricao;
    }

	public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public Float getRecursos() {
		return this.recursos;
	}

	public void setRecursos(Float recursos) {
		this.recursos = recursos;
	}

	public Date getDataInicial() {
		return this.dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return this.dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Set getUtilizas() {
		return this.utilizas;
	}

	public void setUtilizas(Set utilizas) {
		this.utilizas = utilizas;
	}

	public Set getPessoaProjetos() {
		return this.pessoaProjetos;
	}

	public void setPessoaProjetos(Set pessoaProjetos) {
		this.pessoaProjetos = pessoaProjetos;
	}

	public Set getSolicitas() {
		return this.solicitas;
	}

	public void setSolicitas(Set solicitas) {
		this.solicitas = solicitas;
	}

}
