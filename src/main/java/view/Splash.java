package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


public class Splash extends JWindow{

	private static final long serialVersionUID = 1L;
	private int duration;
	    
	    public Splash(int d) {
	        duration = d;
	    }
	  

	    public void showSplash() {        
	        JPanel content = (JPanel)getContentPane();
	        content.setBackground(Color.white);
	        
	     
	        int width = 500;
	        int height = 400;
	        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	        int x = (screen.width-width)/2;
	        int y = (screen.height-height)/2;
	        setBounds(x,y,width,height);
	        
	 
	        JLabel label = new JLabel(new ImageIcon("src/imagens/load3.gif"));
	        JLabel copyrt = new JLabel("Carregando Aplicação...", JLabel.CENTER);
	        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
	        content.add(label, BorderLayout.CENTER);
	        content.add(copyrt, BorderLayout.SOUTH);
	        Color oraRed = new Color(156, 93, 99,  255);
	        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));	    
	        setVisible(true);
	        
	        try { Thread.sleep(duration); } catch (Exception e) {}        
	        setVisible(false);  
	        
	    }
	    
	    public void showSplashAndExit() {        
	        showSplash();
	            
	    }
	    	
	    
	    
	    
	}
	
	


