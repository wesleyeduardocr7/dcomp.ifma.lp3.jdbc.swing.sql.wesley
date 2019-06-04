package view.Aluno;

import controle.ControleAluno;
import dao.AlunoDAO;
import infra.Database;
import modelo.Aluno;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class PainelCadastrarAlunos extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

        ControleAluno controleAluno;
        AlunoDAO alunoDAO;
        Connection connection;
        JTextField areaNomeNome = new JTextField();
        JTextField areaNomeEndereco = new JTextField();
        JTextField areaNomeRg = new JTextField();
        JTextField areaNomeCpf = new JTextField();
        JTextField areaNomeTelefone = new JTextField();

	public void cria() {
		
		this.setVisible(true);
		this.setLayout(null);

		    areaNomeNome.setText("");
            areaNomeEndereco.setText("");
            areaNomeRg.setText("");
            areaNomeCpf.setText("");
            areaNomeTelefone.setText("");


        JLabel nomeAluno = new JLabel();
        this.add(nomeAluno);       
        nomeAluno.setText("Cadastro de Alunos");
        nomeAluno.setBounds(560, 90, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeAluno.setFont(f0);
        nomeAluno.setForeground(Color.black);

        JLabel nomeNome = new JLabel();
        this.add(nomeNome);       
        nomeNome.setText("Nome:");
        nomeNome.setBounds(400, 180, 300, 50);
        Font f2 = new Font("SansSerif", Font.BOLD, 25);
        nomeNome.setFont(f2);
        nomeNome.setForeground(Color.black);
        
        JLabel nomeEndereco = new JLabel();
        this.add(nomeEndereco);       
        nomeEndereco.setText("Endereço:");
        nomeEndereco.setBounds(400, 240, 300, 50);
        Font f3 = new Font("SansSerif", Font.BOLD, 25);
        nomeEndereco.setFont(f3);
        nomeEndereco.setForeground(Color.black);
        
        JLabel nomeRg = new JLabel();
        this.add(nomeRg);       
        nomeRg.setText("Rg:");
        nomeRg.setBounds(400, 300, 300, 50);
        Font f4 = new Font("SansSerif", Font.BOLD, 25);
        nomeRg.setFont(f4);
        nomeRg.setForeground(Color.black);
        
        JLabel nomeCpf = new JLabel();
        this.add(nomeCpf);       
        nomeCpf.setText("Cpf:");
        nomeCpf.setBounds(400, 360, 300, 50);
        Font f5 = new Font("SansSerif", Font.BOLD, 25);
        nomeCpf.setFont(f5);
        nomeCpf.setForeground(Color.black);
        
        JLabel nomeTelefone = new JLabel();
        this.add(nomeTelefone);       
        nomeTelefone.setText("Telefone:");
        nomeTelefone.setBounds(400, 420, 300, 50);
        Font f6 = new Font("SansSerif", Font.BOLD, 25);
        nomeTelefone.setFont(f6);
        nomeTelefone.setForeground(Color.black);
        
        
        JButton botaoCadastrarAluno = new JButton();
        botaoCadastrarAluno.addActionListener(new botaoCadastraAluno());
        this.add(botaoCadastrarAluno);       
        botaoCadastrarAluno.setText("Cadastrar");
        botaoCadastrarAluno.setBounds(600, 525, 180, 35);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoCadastrarAluno.setFont(f7);
        botaoCadastrarAluno.setForeground(Color.black);

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
        

        this.add(areaNomeRg);       
        areaNomeRg.setText("");
        areaNomeRg.setBounds(550, 313, 300, 25);
        Font f12= new Font("SansSerif", Font.BOLD, 25);
        areaNomeRg.setFont(f12);
        areaNomeRg.setForeground(Color.black);

        this.add(areaNomeCpf);       
        areaNomeCpf.setText("");
        areaNomeCpf.setBounds(550, 373, 300, 25);
        Font f13= new Font("SansSerif", Font.BOLD, 25);
        areaNomeCpf.setFont(f13);
        areaNomeCpf.setForeground(Color.black);
        

        this.add(areaNomeTelefone);       
        areaNomeTelefone.setText("");
        areaNomeTelefone.setBounds(550, 433, 300, 25);
        Font f14= new Font("SansSerif", Font.BOLD, 25);
        areaNomeTelefone.setFont(f14);
        areaNomeTelefone.setForeground(Color.black);

        iniciaConexao();
        inicialControle();
		
	}


        public void iniciaConexao(){

            connection = Database.getConnection();
            alunoDAO = new AlunoDAO(connection);

        }


        public void inicialControle(){

	        controleAluno = new ControleAluno(alunoDAO);

        }

        private class botaoCadastraAluno implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                        if(  !areaNomeNome.getText().equals("")  && !areaNomeEndereco.getText().equals("")  &&!areaNomeRg.getText().equals("")

                                &&!areaNomeCpf.getText().equals("")

                        && !areaNomeTelefone.getText().equals("")){


                                String nome = areaNomeNome.getText();
                                String endereco = areaNomeEndereco.getText();
                                String rg = areaNomeRg.getText();
                                String cpf = areaNomeCpf.getText();
                                String telefone = areaNomeTelefone.getText();

                                try {
                                        controleAluno.insere(nome,endereco,rg,cpf,telefone);
                                } catch (SQLException e) {
                                        System.out.println(e);
                                }

                                JOptionPane.showMessageDialog(null,"Aluno Inserido com Sucesso");

                                 areaNomeNome.setText("");
                                 areaNomeEndereco.setText("");
                                 areaNomeRg.setText("");
                                 areaNomeCpf.setText("");
                                 areaNomeTelefone.setText("");


                        }else{

                                JOptionPane.showMessageDialog(null,"Existem Campos Vazios");

                        }


                }
        }


}
