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
@Table(name = "exemplar")

public class Exemplar {
	@Id
	@Column(name="ID_exemplar", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "corredor")
	private String corredor;
	
	@Column(name = "box")
	private String box;
	
	@Column(name = "prateleira")
	private String prateleira;
	
	@ManyToOne
	@JoinColumn(name = "ID_componente")
	private Item item;
	
	public Exemplar(){}
	
	public Exemplar(int id, String corredor, String box, String prateleira, Item item)
	{
		this.setId(id);
		this.setItem(item);
		this.setCorredor(corredor);
		this.setBox(box);
		this.setPrateleira(prateleira);
	}
	
	public Exemplar(String corredor, String box, String prateleira, Item item)
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
	public String getCorredor() {
		return corredor;
	}
	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}
	public String getBox() {
		return box;
	}
	public void setBox(String box) {
		this.box = box;
	}
	public String getPrateleira() {
		return prateleira;
	}
	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}
}
