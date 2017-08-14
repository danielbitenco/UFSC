package ufsc.bd1.org.model;

import java.math.BigInteger;

public class BuscaExemplaresQtdCustoUnTotal {
	
	private String descricao = "";
	private String modelo = "";
	private BigInteger quantidade;
	private double valorUnitario;
	private double valorTotal;
	
	
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
	public BigInteger getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigInteger quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	

}
