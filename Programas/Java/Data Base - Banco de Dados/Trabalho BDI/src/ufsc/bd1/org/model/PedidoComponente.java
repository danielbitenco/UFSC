// default package
// Generated Jun 18, 2016 6:51:54 PM by Hibernate Tools 4.0.0.Final
package ufsc.bd1.org.model;

/**
 * PedidoComponente generated by hbm2java
 */
public class PedidoComponente implements java.io.Serializable {

	private int idSequencia;
	private Pedido pedido;
	private Item item;

	public PedidoComponente() {
	}

	public PedidoComponente(int idSequencia) {
		this.idSequencia = idSequencia;
	}

	public PedidoComponente(int idSequencia, Pedido pedido, Item item) {
		this.idSequencia = idSequencia;
		this.pedido = pedido;
		this.item = item;
	}

	public int getIdSequencia() {
		return this.idSequencia;
	}

	public void setIdSequencia(int idSequencia) {
		this.idSequencia = idSequencia;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
