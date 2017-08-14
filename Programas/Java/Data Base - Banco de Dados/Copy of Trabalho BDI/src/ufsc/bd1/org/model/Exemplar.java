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
@Table(name = "Exemplar")

public class Exemplar {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Exemplar_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_exemplar", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "corredor")
	private char corredor;
	
	@Column(name = "box")
	private char box;
	
	@Column(name = "prateleira")
	private char prateleira;
	
	@ManyToOne
	@JoinColumn(name = "ID_componente")
	private Item item;
	
	public Exemplar(){}
	
	public Exemplar(int id, char corredor, char box, char prateleira, Item item)
	{
		this.setId(id);
		this.setItem(item);
		this.setCorredor(corredor);
		this.setBox(box);
		this.setPrateleira(prateleira);
	}
	
	public Exemplar(char corredor, char box, char prateleira, Item item)
	{
		this.setItem(item);
		this.setCorredor(corredor);
		this.setBox(box);
		this.setPrateleira(prateleira);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public char getCorredor() {
		return corredor;
	}
	public void setCorredor(char corredor) {
		this.corredor = corredor;
	}
	public char getBox() {
		return box;
	}
	public void setBox(char box) {
		this.box = box;
	}
	public char getPrateleira() {
		return prateleira;
	}
	public void setPrateleira(char prateleira) {
		this.prateleira = prateleira;
	}
}
