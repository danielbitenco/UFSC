package br.com.livro.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import br.com.livro.model.Livro;
import br.com.livro.util.ConnectionFactory;

public class LivroDao {

	public boolean insertLivro(Livro livro) {
		
		boolean ok = true;
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "INSERT INTO livro (id, titulo, autor, publicacao, isbn, paginas, editora, idioma, imagem) " + 
						 "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, livro.getTitulo());
			comando.setString(2, livro.getAutor());
			comando.setInt(3, livro.getPublicacao());
			comando.setString(4, livro.getIsbn());
			comando.setInt(5, livro.getPaginas());
			comando.setString(6, livro.getEditora());
			comando.setString(7, livro.getIdioma());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			if (livro.getImagem() != null) { 
				ImageIO.write(livro.getImagem(), "jpg", baos);
				baos.flush();			
				comando.setBytes(8, baos.toByteArray());
				baos.close();
			} else {
				comando.setBytes(8, null);
			}
			comando.execute();
			conexao.close();		
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
	
	public boolean updateLivro(Livro livro) {
		
		boolean ok = true;
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "UPDATE livro SET titulo = ?, autor = ?, publicacao = ?, isbn = ?, paginas = ?, editora = ?, idioma = ? , imagem = ?" + 
						 "WHERE id = ?;";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, livro.getTitulo());
			comando.setString(2, livro.getAutor());
			comando.setInt(3, livro.getPublicacao());
			comando.setString(4, livro.getIsbn());
			comando.setInt(5, livro.getPaginas());
			comando.setString(6, livro.getEditora());
			comando.setString(7, livro.getIdioma());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			if (livro.getImagem() != null) { 
				ImageIO.write(livro.getImagem(), "jpg", baos);
				baos.flush();			
				comando.setBytes(8, baos.toByteArray());
				baos.close();
			} else {
				comando.setBytes(8, null);
			}			
			comando.setInt(9, livro.getId());
			
			comando.execute();
			conexao.close();		
		} catch (Exception e) {
			ok = false;
		}
		return ok;
	}	
	
	public boolean deleteLivro(Livro livro) {
		
		boolean ok = true;
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "DELETE FROM livro WHERE id = ?;";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setInt(1, livro.getId());
			
			comando.execute();
			conexao.close();		
		} catch (Exception e) {
			ok = false;
		}
		return ok;
	}	
	
    public List<Livro> list() {
		ResultSet resultado = null;
		BufferedImage imagem = null;
		List<Livro> lista = new LinkedList<Livro>();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM livro ORDER BY titulo;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			resultado = comando.executeQuery();
			try {
				while (resultado.next()) {
					if (resultado.getBytes("imagem") != null) {
						InputStream in = new ByteArrayInputStream(resultado.getBytes("imagem"));
						imagem = ImageIO.read(in);
					}
					
					lista.add(new Livro(resultado.getInt("id"), resultado.getString("titulo"),
										resultado.getString("autor"), resultado.getInt("publicacao"),
										resultado.getString("isbn"), resultado.getInt("paginas"),
										resultado.getString("editora"), resultado.getString("idioma"), 
										imagem));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}					
			conexao.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}        
        return lista;
    }	
    
    public Livro findById(int id) {
		ResultSet resultado = null;
		BufferedImage imagem = null;
		Livro l = new Livro();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM livro WHERE id = ?;";

			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, id);
			resultado = comando.executeQuery();
			try {
				if (resultado.next()) {
					if (resultado.getBytes("imagem") != null) {
						InputStream in = new ByteArrayInputStream(resultado.getBytes("imagem"));
						imagem = ImageIO.read(in);
					}
					
					l.setId(resultado.getInt("id"));
					l.setTitulo(resultado.getString("titulo"));
					l.setAutor(resultado.getString("autor"));
					l.setPublicacao(resultado.getInt("publicacao"));
					l.setIsbn(resultado.getString("isbn"));
					l.setPaginas(resultado.getInt("paginas"));
					l.setEditora(resultado.getString("editora"));
					l.setIdioma(resultado.getString("idioma"));
					l.setImagem(imagem);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}					
			conexao.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}        
        return l;
    }
    
    public Livro findByTitulo(String titulo) {
		ResultSet resultado = null;
		BufferedImage imagem = null;
		Livro l = new Livro();
		try {
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM livro WHERE titulo = ?;";

			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, titulo);
			resultado = comando.executeQuery();
			try {
				if (resultado.next()) {
					if (resultado.getBytes("imagem") != null) {
						InputStream in = new ByteArrayInputStream(resultado.getBytes("imagem"));
						imagem = ImageIO.read(in);
					}
					
					l.setId(resultado.getInt("id"));
					l.setTitulo(resultado.getString("titulo"));
					l.setAutor(resultado.getString("autor"));
					l.setPublicacao(resultado.getInt("publicacao"));
					l.setIsbn(resultado.getString("isbn"));
					l.setPaginas(resultado.getInt("paginas"));
					l.setEditora(resultado.getString("editora"));
					l.setIdioma(resultado.getString("idioma"));
					l.setImagem(imagem);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}					
			conexao.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}        
        return l;
    }	
}