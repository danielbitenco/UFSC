package br.com.livro.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LivroTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Livro> livros;
	
	private String[] colNomes = {"Codigo", "Título", "Autor", "Ano Pub."};
	private Class<?>[] colTipos = {Integer.class, String.class, String.class, Integer.class};
	
	public LivroTableModel() {
	}
	
	public void reload(List<Livro> livros) {
		this.livros = livros;
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return colTipos[coluna];
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int coluna) {
		return colNomes[coluna];
	}

	@Override
	public int getRowCount() {
		if (livros == null){
			return 0;
		}
		return livros.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Livro l = livros.get(linha);
		switch (coluna) {
		case 0:
			return l.getId();
		case 1:
			return l.getTitulo();
		case 2:
			return l.getAutor();
		case 3:
			return l.getPublicacao();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Livro getLivroAt(int index) {
		return livros.get(index);
	}
}