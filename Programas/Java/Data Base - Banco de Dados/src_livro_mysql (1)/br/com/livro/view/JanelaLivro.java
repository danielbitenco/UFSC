package br.com.livro.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import br.com.livro.dao.LivroDao;
import br.com.livro.model.Livro;

public class JanelaLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtId;
	private JTextField edtTitulo;
	private JTextField edtAutor;
	private JTextField edtAno;
	private JTextField edtIsbn;
	private JTextField edtPaginas;
	private JTextField edtEditora;
	private JTextField edtIdioma;
	private JanelaLocalizar formLocalizar;

	private JPanel pnImagem;
	private BufferedImage imagem;
	private AreaImagem areaImagem;	

	public JanelaLivro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Imagens\\Data-3.png"));
		setTitle("Cadastro de Livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(20, 11, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblTtulo = new JLabel("* T\u00EDtulo");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTtulo.setBounds(119, 11, 54, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutor.setBounds(20, 61, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblNewLabel = new JLabel("Ano publica\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(503, 61, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIsbn.setBounds(20, 111, 46, 14);
		contentPane.add(lblIsbn);
		
		JLabel lblNPginas = new JLabel("N\u00BA P\u00E1ginas");
		lblNPginas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNPginas.setBounds(196, 111, 63, 14);
		contentPane.add(lblNPginas);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEditora.setBounds(20, 161, 46, 14);
		contentPane.add(lblEditora);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdioma.setBounds(292, 111, 46, 14);
		contentPane.add(lblIdioma);
		
		edtId = new JTextField();
		edtId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtId.setEditable(false);
		edtId.setEnabled(false);
		edtId.setBounds(20, 30, 86, 20);
		contentPane.add(edtId);
		edtId.setColumns(10);
		
		edtTitulo = new JTextField();
		edtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtTitulo.setBounds(119, 30, 502, 20);
		contentPane.add(edtTitulo);
		edtTitulo.setColumns(10);
		
		edtAutor = new JTextField();
		edtAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtAutor.setBounds(20, 80, 473, 20);
		contentPane.add(edtAutor);
		edtAutor.setColumns(10);
		
		edtAno = new JTextField();
		edtAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtAno.setBounds(503, 80, 118, 20);
		contentPane.add(edtAno);
		edtAno.setColumns(10);
		
		edtIsbn = new JTextField();
		edtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtIsbn.setBounds(20, 130, 166, 20);
		contentPane.add(edtIsbn);
		edtIsbn.setColumns(10);
		
		edtPaginas = new JTextField();
		edtPaginas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtPaginas.setBounds(196, 130, 86, 20);
		contentPane.add(edtPaginas);
		edtPaginas.setColumns(10);
		
		edtEditora = new JTextField();
		edtEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtEditora.setBounds(20, 180, 601, 20);
		contentPane.add(edtEditora);
		edtEditora.setColumns(10);
		
		edtIdioma = new JTextField();
		edtIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtIdioma.setBounds(292, 130, 329, 20);
		contentPane.add(edtIdioma);
		edtIdioma.setColumns(10);
		
		JButton btLocalizar = new JButton("Localizar");
		btLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formLocalizar.setVisible(true);
				SwingUtilities.invokeLater(formLocalizar.newAtualizaLivrosAction());
			}
		});
		btLocalizar.setIcon(new ImageIcon("C:\\Imagens\\Eye.png"));
		btLocalizar.setMnemonic('L');
		btLocalizar.setBounds(383, 220, 129, 47);
		contentPane.add(btLocalizar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("C:\\Imagens\\Download-1.png"));
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (edtTitulo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nome do livro é obrigatório!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				} else {
					boolean erro = false;
					try {
						Integer.parseInt(edtAno.getText());
					} catch (NumberFormatException excecao) {
						erro = true;
						edtAno.requestFocus();
						JOptionPane.showMessageDialog(null, "Número inválido!");
					}				
					
					try {
						Integer.parseInt(edtPaginas.getText());
					} catch (NumberFormatException excecao) {
						erro = true;
						edtPaginas.requestFocus();
						JOptionPane.showMessageDialog(null, "Número inválido!");
					}
					
					if (!erro) {
						Livro l = new Livro();	
						l = preencheLivro(l);
						
						LivroDao dao = new LivroDao();
						if (edtId.getText().equals("")) {
							if (dao.insertLivro(l)) {
								limpaCampos();
								JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Erro ao cadastrar o livro!", "Mensagem", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							if (dao.updateLivro(l)) {
								limpaCampos();
								JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro do livro!", "Mensagem", JOptionPane.ERROR_MESSAGE);
							}
						}					
					}
				}
			}
		});
		btnSalvar.setBounds(141, 220, 118, 47);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("C:\\Imagens\\New.png"));
		btnNovo.setMnemonic('N');
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCampos();
			}
		});
		btnNovo.setBounds(20, 220, 118, 47);
		contentPane.add(btnNovo);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("C:\\Imagens\\Trash.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!edtId.getText().equals("")) {
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o livro?", "Confirmação", JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {					
						Livro l = new Livro();
						l = preencheLivro(l);
						
						LivroDao dao = new LivroDao();
						if (dao.deleteLivro(l)) {	
							limpaCampos();
							JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao excluir o livro!", "Mensagem", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado na tela!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnExcluir.setMnemonic('E');
		btnExcluir.setBounds(262, 220, 118, 47);
		contentPane.add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("C:\\Imagens\\On-off.png"));
		btnSair.setMnemonic('S');
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(515, 220, 106, 47);
		contentPane.add(btnSair);
		
		areaImagem = new AreaImagem();
		pnImagem = new JPanel();
		pnImagem.setLayout(new BorderLayout());
		pnImagem.add(areaImagem, BorderLayout.CENTER);
		pnImagem.setBounds(660, 30, 158, 191);
		contentPane.add(pnImagem);		
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();

		        int res = fc.showOpenDialog(null);
		        if(res == JFileChooser.APPROVE_OPTION){
		        	File arquivo = fc.getSelectedFile();  
		          
		            imagem = null;
		          
		            try {
		            	imagem = ImageIO.read(arquivo);
		            } catch(IOException exc) {
		            	JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem: " + exc.getMessage());
		            }

		            if (imagem != null) {
		            	imagem = getScaledImage(imagem, pnImagem.getBounds().width, pnImagem.getBounds().height);
		            	areaImagem.imagem = imagem;
		            	areaImagem.repaint();  
		            }		            		            
		        }    
			}
		});
		btnCarregar.setBounds(698, 232, 89, 23);
		contentPane.add(btnCarregar);
				
		formLocalizar = new JanelaLocalizar(this);
		
		setLocationRelativeTo(null);
	}
	
	private void limpaCampos() {
		edtId.setText("");
		edtTitulo.setText("");
		edtAutor.setText("");
		edtAno.setText("");
		edtIsbn.setText("");
		edtPaginas.setText("");
		edtIdioma.setText("");
		edtEditora.setText("");
		areaImagem.imagem = null;
		areaImagem.repaint();
		edtTitulo.requestFocus();		
	}
	
	private Livro preencheLivro(Livro l) {
		if (edtId.getText().equals("")) 
			l.setId(0);
		else
			l.setId(Integer.parseInt(edtId.getText()));
		l.setTitulo(edtTitulo.getText());
		l.setAutor(edtAutor.getText());
		l.setPublicacao(Integer.parseInt(edtAno.getText()));
		l.setIsbn(edtIsbn.getText());
		l.setPaginas(Integer.parseInt(edtPaginas.getText()));
		l.setIdioma(edtIdioma.getText());
		l.setEditora(edtEditora.getText());
		l.setImagem(imagem);
		return l;
	}
	
	public void setLivro(Livro l) {
		edtId.setText(String.valueOf(l.getId()));
		edtTitulo.setText(l.getTitulo());
		edtAutor.setText(l.getAutor());
		edtAno.setText(String.valueOf(l.getPublicacao()));
		edtIsbn.setText(l.getIsbn());
		edtPaginas.setText(String.valueOf(l.getPaginas()));
		edtIdioma.setText(l.getIdioma());
		edtEditora.setText(l.getEditora());
		areaImagem.imagem = l.getImagem();
		areaImagem.repaint();		
		edtTitulo.requestFocus();		
	}
	
	private BufferedImage getScaledImage(BufferedImage src, int w, int h) {
	    int finalw = w;
	    int finalh = h;
	    double factor = 1.0d;
	    if(src.getWidth() > src.getHeight()) {
	        factor = ((double)src.getHeight()/(double)src.getWidth());
	        finalh = (int)(finalw * factor);                
	    } else {
	        factor = ((double)src.getWidth()/(double)src.getHeight());
	        finalw = (int)(finalh * factor);
	    }   

	    BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(src, 0, 0, finalw, finalh, null);
	    g2.dispose();
	    return resizedImg;
	}	
}
