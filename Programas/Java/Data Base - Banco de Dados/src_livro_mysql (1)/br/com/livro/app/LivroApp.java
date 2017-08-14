package br.com.livro.app;

import br.com.livro.view.JanelaLivro;

public class LivroApp {

	public static void main(String[] args) {
		try {
			JanelaLivro frame = new JanelaLivro();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
