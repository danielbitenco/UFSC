package br.com.livro.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class AreaImagem extends JPanel {

	private static final long serialVersionUID = 1L;
	public BufferedImage imagem;

	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
	    
		g.drawImage(imagem, 0, 0, this);
	} 
}
