package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelAcoes extends JPanel{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void cria() {
		
		
		this.setVisible(true);
		this.setLayout(null);
		   
        
        JLabel nomeAgendaContatos = new JLabel();        
        this.add(nomeAgendaContatos);       
        nomeAgendaContatos.setText("Sistema de Informação Escolar");
        nomeAgendaContatos.setBounds(430, 450 , 550, 35);
        Font f = new Font("SansSerif", Font.BOLD, 35);
        nomeAgendaContatos.setFont(f);
        nomeAgendaContatos.setForeground(Color.black);
        
        JLabel label = new JLabel(new ImageIcon("src/imagens/escola.png"));
        label.setBounds(520, 80, 300, 300);
        this.add(label, BorderLayout.CENTER);
		
	}

	//wesley

}
