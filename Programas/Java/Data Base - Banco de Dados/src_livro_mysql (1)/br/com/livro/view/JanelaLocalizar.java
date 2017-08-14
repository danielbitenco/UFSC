package br.com.livro.view;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.livro.dao.LivroDao;
import br.com.livro.exception.PersistenceException;
import br.com.livro.model.Livro;
import br.com.livro.model.LivroTable;

public class JanelaLocalizar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LivroTable tabela;
	private JScrollPane scrollPane;
	
	private JanelaLivro janelaLivro;

	public JanelaLocalizar(JanelaLivro formLivro) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Imagens\\Data-3.png"));
		setTitle("Localizar Livro");		
		setBounds(100, 100, 641, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		janelaLivro = formLivro;
		tabela = new LivroTable();
		tabela.addMouseListener(new MostrarLivroListener());
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);		
		scrollPane.setBounds(20, 20, 585, 350);
		add(scrollPane);
		
		setLocationRelativeTo(null);
	}
	
	private class MostrarLivroListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getClickCount() == 2) {
				Livro l = tabela.getLivroSelected();
				if (l != null) {
					LivroDao dao = new LivroDao();
					l = dao.findById(l.getId());
					janelaLivro.setLivro(l);
					setVisible(false);
				}
			}
		}
	}	
		
	public Runnable newAtualizaLivrosAction() {
		return new Runnable() {
			public void run() {
				try {
					LivroDao dao = new LivroDao();
					tabela.reload(dao.list());
				} catch (PersistenceException ex) {
					JOptionPane.showMessageDialog(JanelaLocalizar.this,
							ex.getMessage(), "Erro ao consultar Livro(s)", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}	
}
