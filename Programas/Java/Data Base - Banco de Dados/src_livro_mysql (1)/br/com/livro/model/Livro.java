package br.com.livro.model;

import java.awt.image.BufferedImage;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private int publicacao;
	private String isbn;
	private int paginas;	
	private String editora;
	private String idioma;
	private BufferedImage imagem;
		
	public Livro(int id, String titulo, String autor, int publicacao, String isbn, int paginas, String editora, String idioma, BufferedImage imagem) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.publicacao = publicacao;
		this.isbn = isbn;
		this.paginas = paginas;
		this.editora = editora;
		this.idioma = idioma;
		this.imagem = imagem; 
	}
	
	public Livro() {
		this(0, "", "", 0, "", 0, "", "", null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(int publicacao) {
		this.publicacao = publicacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}

	public void clear() {
		this.id = 0;
		this.titulo = "";
		this.autor = "";
		this.publicacao = 0;
		this.isbn = "";
		this.paginas = 0;
		this.editora = "";
		this.idioma = "";
		this.imagem = null;
	}	
	
	@Override
	public String toString() {
		return "Livro [id=" + this.id + ", titulo=" + this.titulo
				+ ", autor=" + this.autor + ", publicacao=" + this.publicacao
				+ ", isbn=" + this.isbn + ", paginas=" + this.paginas
				+ ", editora=" + this.editora + ", idioma=" + this.idioma + "]";
	}
}