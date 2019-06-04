package view.Professor;

import controle.ControleProfessor;
import dao.ProfessorDAO;
import infra.Database;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class PainelCadastraProfessor extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	ControleProfessor controleProfessor;
	ProfessorDAO ProfessorDAO;
	Connection connection;
	JTextField areaNomeCodigo = new JTextField();

	public void cria() {

		this.setVisible(true);
		this.setLayout(null);

		JLabel nomeProfessor = new JLabel();
		this.add(nomeProfessor);
		nomeProfessor.setText("Cadastro de Professor");
		nomeProfessor.setBounds(550, 50, 300, 50);
		Font f0 = new Font("SansSerif", Font.BOLD, 25);
		nomeProfessor.setFont(f0);
		nomeProfessor.setForeground(Color.black);

		JLabel nomeCodigo = new JLabel();
		this.add(nomeCodigo);
		nomeCodigo.setText("Nome:");
		nomeCodigo.setBounds(400, 120, 300, 50);
		Font f1 = new Font("SansSerif", Font.BOLD, 25);
		nomeCodigo.setFont(f1);
		nomeCodigo.setForeground(Color.black);



		this.add(areaNomeCodigo);
		areaNomeCodigo.setText("");
		areaNomeCodigo.setBounds(550, 133, 300, 25);
		Font f8 = new Font("SansSerif", Font.BOLD, 25);
		areaNomeCodigo.setFont(f8);
		areaNomeCodigo.setForeground(Color.black);



		JButton botaoCadastrarProfessor = new JButton();
		botaoCadastrarProfessor.addActionListener(new botaoCadastraProfessor());
		this.add(botaoCadastrarProfessor);
		botaoCadastrarProfessor.setText("Cadastrar");
		botaoCadastrarProfessor.setBounds(600, 260, 180, 35);
		Font f7 = new Font("SansSerif", Font.BOLD, 25);
		botaoCadastrarProfessor.setFont(f7);
		botaoCadastrarProfessor.setForeground(Color.black);

		iniciaConexao();
		inicialControle();


	}


	public void iniciaConexao(){

		connection = Database.getConnection();
		ProfessorDAO = new ProfessorDAO(connection);

	}


	public void inicialControle(){

		controleProfessor = new ControleProfessor(ProfessorDAO);

	}

	private class botaoCadastraProfessor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			if(  !areaNomeCodigo.getText().equals("")){

				String nome = areaNomeCodigo.getText();

				try {
					controleProfessor.insere(nome);
				} catch (SQLException e) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,"Professor Inserido com Sucesso");

				areaNomeCodigo.setText("");



			}else{

				JOptionPane.showMessageDialog(null,"Existem Campos Vazios");

			}


		}
	}


}
