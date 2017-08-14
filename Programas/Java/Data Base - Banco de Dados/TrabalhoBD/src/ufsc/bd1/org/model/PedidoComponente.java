package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "pedidoComponente")

public class PedidoComponente {
	@Id
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "ID_componente")
	private Item item;
	
	public PedidoComponente(){}
	
	public PedidoComponente(int id, Pedido pedido, Item item)
	{
		this.setId(id);
		this.setPedido(pedido);
		this.setComponente(item);
	}
	
	public PedidoComponente(Pedido pedido, Item item)
	{
		this.setPedido(pedido);
		this.setComponente(item);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Item getComponente() {
		return item;
	}
	public void setComponente(Item item) {
		this.item = item;
	}

}
