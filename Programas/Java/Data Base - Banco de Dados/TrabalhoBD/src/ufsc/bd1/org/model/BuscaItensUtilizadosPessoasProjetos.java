package ufsc.bd1.org.model;

import java.math.BigInteger;

public class BuscaItensUtilizadosPessoasProjetos {
	private String quemUsa = "";
	private BigInteger qtdComponente;
	private String tipo = "";
	
	
	public String getQuemUsa() {
		return quemUsa;
	}
	public void setQuemUsa(String quemUsa) {
		this.quemUsa = quemUsa;
	}
	public BigInteger getQtdComponente() {
		return qtdComponente;
	}
	public void setQtdComponente(BigInteger qtdComponente) {
		this.qtdComponente = qtdComponente;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
