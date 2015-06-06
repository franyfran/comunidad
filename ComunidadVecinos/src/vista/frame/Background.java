package vista.frame;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 326442893370250810L;
	private Image bg;


	/**
	 * Create the application.
	 */
	public Background() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		try {
			bg = ImageIO.read(Background.class.getResource("/resources/comunidad1.jpg"));
		} catch (IOException e) {
			System.out.println("Error obteniendo imagen");
			System.out.println(e.getMessage());
			bg = null;
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponents(g);
		if(bg != null){
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
    }

}
