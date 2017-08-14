package ufsc.bd1.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Utiliza")

public class Utiliza {
	@Id
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Utiliza_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="ID_sequencia", unique=true, nullable=false)
	private Integer id;
	
	//verificar declaração de chave PK FK
	@Id
	@ManyToOne
    @SequenceGenerator(name="pk_sequence",sequenceName="seq_Utiliza_pk", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@PrimaryKeyJoinColumn(name="ID_exemplar")
	private Exemplar exemplar;
	
	@Column(name = "data_emprestimo")
	private Date data_emprestimo;
	
	@Column(name = "data_devolucao")
	private Date data_devolucao;
	
	@ManyToOne
	@JoinColumn(name = "ID_projeto")
	private Projeto projeto;
	
	@ManyToOne
	@JoinColumn(name = "ID_pessoa")
	private Pessoa pessoa;
	
	public Utiliza(){}
	
	public Utiliza(int id, Exemplar exemplar, Date data_emprestimo, Date data_devolucao, Projeto projeto, Pessoa pessoa)
	{
		this.setId(id);
		this.setExemplar(exemplar);
		this.setDataEmprestimo(data_emprestimo);
		this.setDataDevolucao(data_devolucao);
		this.setProjeto(projeto);
		this.setPessoa(pessoa);
	}
	
	public Utiliza(Exemplar exemplar, Date data_emprestimo, Date data_devolucao, Projeto projeto, Pessoa pessoa)
	{
		this.setExemplar(exemplar);
		this.setDataEmprestimo(data_emprestimo);
		this.setDataDevolucao(data_devolucao);
		this.setProjeto(projeto);
		this.setPessoa(pessoa);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exemplar getExemplar() {
		return exemplar;
	}
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public Date getDataEmprestimo() {
		return data_emprestimo;
	}
	public void setDataEmprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	public Date getDataDevolucao() {
		return data_devolucao;
	}
	public void setDataDevolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

}
