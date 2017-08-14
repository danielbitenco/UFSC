package br.com.livro.model;

import java.util.List;

import javax.swing.JTable;

public class LivroTable extends JTable {

	private static final long serialVersionUID = 1L;
	private LivroTableModel modelo;
	
	public LivroTable() {
		modelo = new LivroTableModel();
		setModel(modelo);
	}
	
	public Livro getLivroSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getLivroAt(i);
	}
	
	public void reload(List<Livro> livros) {
		modelo.reload(livros);
	}
}