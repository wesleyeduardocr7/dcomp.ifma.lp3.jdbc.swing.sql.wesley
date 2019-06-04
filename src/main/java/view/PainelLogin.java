package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PainelLogin extends JPanel implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField jTextField01;
	JPasswordField jPasswordField01 ;	
	JButton botaoLogin ;
	int totalTentativasLogin = 3;
	int loginErrados = 0;

	public void cria() {
		   	
		this.setVisible(true);
		this.setLayout(null);
	  			
		JLabel label01 = new JLabel();
		this.add(label01);		
		label01.setIcon(new ImageIcon("src/login0x.png"));
		label01.setBounds(120,30,250,80); 
		Font f0 = new Font("SansSerif", Font.BOLD, 25);
		label01.setFont(f0);
		label01.setForeground(Color.black);

		JLabel label02 = new JLabel();
		this.add(label02);		
		label02.setText("User: ");
		label02.setIcon(new ImageIcon("src/user.png"));
		label02.setBounds(120,60,200,200);
		Font f1 = new Font("SansSerif", Font.BOLD, 20);
		label02.setFont(f1);
		label02.setForeground(Color.black);
		
		jTextField01 = new JTextField();
		this.add(jTextField01);
		

		
		jTextField01.setText("");
		jTextField01.setBounds(210,150,160,25); 
		Font f2 = new Font("SansSerif", Font.BOLD, 20);
		jTextField01.setFont(f2);
		jTextField01.setForeground(Color.black);
		

		jPasswordField01 = new JPasswordField();
		this.add(jPasswordField01);		
		jPasswordField01.setText("");
		jPasswordField01.setBounds(210,217,160,25); 
		Font f4 = new Font("SansSerif", Font.BOLD, 20);
		jPasswordField01.setFont(f4);
		jPasswordField01.setForeground(Color.black);

		JLabel label03 = new JLabel();
		this.add(label03);		
		label03.setText("Pass: ");
		label03.setIcon(new ImageIcon("src/senha.png"));
		label03.setBounds(120,130,200,200); 
		Font f3 = new Font("SansSerif", Font.BOLD, 20);
		label03.setFont(f3);
		label03.setForeground(Color.black);
			


		botaoLogin = new JButton();
		botaoLogin.setIcon(new ImageIcon("src/login1.png"));
		this.add(botaoLogin);
		botaoLogin.setText("Acessar");
		botaoLogin.setBounds(120,290,250,37);
		Font f5 = new Font("SansSerif", Font.BOLD, 20);
		botaoLogin.setFont(f5);
		botaoLogin.setForeground(Color.black);


		botaoLogin.addActionListener(this);

		jTextField01.requestFocus();

		
	}
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {		
				
		
		 if(loginErrados > 2) {
				
				JOptionPane.showMessageDialog(null, "Falha de Autentica��o - Aplica��o ser� FECHADA");
				System.exit(0);
				
			}
		
		if(jTextField01.getText().equals("")) {			
			
			JOptionPane.showMessageDialog(null, "Campo Usu�rio Vazio! ");
			jTextField01.requestFocus();			
			
		}else if(jPasswordField01.getText().equals("")) {			
			
			JOptionPane.showMessageDialog(null, "Campo Senha Vazio! ");
			jPasswordField01.requestFocus();			
			
		}else if(!jTextField01.getText().equals("admin")) {			
									
			JOptionPane.showMessageDialog(null, "Usu�rio Incorreto ! ");
			jTextField01.requestFocus();	
			jTextField01.setText("");
			loginErrados++;
			JOptionPane.showMessageDialog(null, "Quantidade de Tentativas Restantes: " + (totalTentativasLogin - loginErrados));
			
		}else if(!jPasswordField01.getText().equals("admin")) {			
			
			JOptionPane.showMessageDialog(null, "Senha Incorreta ! ");
			jPasswordField01.requestFocus();	
			jPasswordField01.setText("");
			loginErrados++;
			
			JOptionPane.showMessageDialog(null, "Quantidade de Tentativas Restantes: " + (totalTentativasLogin - loginErrados));
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Login Realizado com Sucesso ! ");
			jTextField01.setText("");
			jPasswordField01.setText("");
			
			
			
					
			
		}
		
		
		
	}
	

}
