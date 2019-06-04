package view.Disciplina;


import controle.ControleAluno;
import controle.ControleDisciplina;
import dao.AlunoDAO;
import dao.DisciplinaDAO;
import infra.Database;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class PainelCadastroDisciplina extends JPanel{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ControleDisciplina controleDisciplina;
	DisciplinaDAO DisciplinaDAO;
	Connection connection;
	JTextField areaNomeNome = new JTextField();
	JTextField areaNomeEndereco = new JTextField();
	JTextField areaNomeCh = new JTextField();

	public void cria() {
		
		
		this.setVisible(true);
		this.setLayout(null);
		
		
	    JLabel nomeDisciplina = new JLabel();
	    this.add(nomeDisciplina);       
	    nomeDisciplina.setText("Cadastro de Disciplina");
	    nomeDisciplina.setBounds(570, 80, 300, 50);
	    Font f0 = new Font("SansSerif", Font.BOLD, 25);
	    nomeDisciplina.setFont(f0);
	    nomeDisciplina.setForeground(Color.black);

	    
	    JLabel nomeNome = new JLabel();
	    this.add(nomeNome);       
	    nomeNome.setText("Disciplina:");
	    nomeNome.setBounds(400, 180, 300, 50);
	    Font f2 = new Font("SansSerif", Font.BOLD, 25);
	    nomeNome.setFont(f2);
	    nomeNome.setForeground(Color.black);
	    
	    JLabel nomeEndereco = new JLabel();
	    this.add(nomeEndereco);       
	    nomeEndereco.setText("Ementa:");
	    nomeEndereco.setBounds(400, 240, 300, 50);
	    Font f3 = new Font("SansSerif", Font.BOLD, 25);
	    nomeEndereco.setFont(f3);
	    nomeEndereco.setForeground(Color.black);
	    
	    JLabel nomeCH = new JLabel();
	    this.add(nomeCH);       
	    nomeCH.setText("Carga Hr:");
	    nomeCH.setBounds(400, 300, 300, 50);
	    Font f4 = new Font("SansSerif", Font.BOLD, 25);
	    nomeCH.setFont(f4);
	    nomeCH.setForeground(Color.black);
	    

	    this.add(areaNomeNome);       
	    areaNomeNome.setText("");
	    areaNomeNome.setBounds(550, 193, 300, 25);
	    Font f9= new Font("SansSerif", Font.BOLD, 25);
	    areaNomeNome.setFont(f9);
	    areaNomeNome.setForeground(Color.black);
	    

	    this.add(areaNomeEndereco);       
	    areaNomeEndereco.setText("");
	    areaNomeEndereco.setBounds(550, 253, 300, 25);
	    Font f11= new Font("SansSerif", Font.BOLD, 25);
	    areaNomeEndereco.setFont(f11);
	    areaNomeEndereco.setForeground(Color.black);
	    

	    this.add(areaNomeCh);       
	    areaNomeCh.setText("");
	    areaNomeCh.setBounds(550, 313, 300, 25);
	    Font f12= new Font("SansSerif", Font.BOLD, 25);
	    areaNomeCh.setFont(f12);
	    areaNomeCh.setForeground(Color.black);
	    
	    
	    JButton botaoCadastrarDisciplina = new JButton();
	    this.add(botaoCadastrarDisciplina);
	    botaoCadastrarDisciplina.addActionListener(new botaoCadastraDisciplina());
	    botaoCadastrarDisciplina.setText("Cadastrar");
	    botaoCadastrarDisciplina.setBounds(600, 390, 180, 35);
	    Font f7 = new Font("SansSerif", Font.BOLD, 25);
	    botaoCadastrarDisciplina.setFont(f7);
	    botaoCadastrarDisciplina.setForeground(Color.black);

		iniciaConexao();
		inicialControle();

	}


	public void iniciaConexao(){

		connection = Database.getConnection();
		DisciplinaDAO = new DisciplinaDAO(connection);

	}


	public void inicialControle(){

		controleDisciplina = new ControleDisciplina(DisciplinaDAO);

	}

	private class botaoCadastraDisciplina implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			if(  !areaNomeNome.getText().equals("")  && !areaNomeEndereco.getText().equals("")  &&!areaNomeCh.getText().equals("")){


				String nome = areaNomeNome.getText();
				String ementa = areaNomeEndereco.getText();
				String carhahr = areaNomeCh.getText();

				try {
					controleDisciplina.insere(nome,ementa,carhahr);
				} catch (SQLException e) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,"Disciplina Inserido com Sucesso");

				areaNomeNome.setText("");
				areaNomeEndereco.setText("");
				areaNomeCh.setText("");



			}else{

				JOptionPane.showMessageDialog(null,"Existem Campos Vazios");

			}


		}
	}



}
