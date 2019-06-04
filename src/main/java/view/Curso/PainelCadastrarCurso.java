package view.Curso;

import controle.ControleAluno;
import controle.ControleCurso;
import dao.AlunoDAO;
import dao.CursoDAO;
import infra.Database;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

public class PainelCadastrarCurso extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

        ControleCurso controleCurso;
        CursoDAO cursoDAO;
        Connection connection;
	    JTextField areaNomeCodigo = new JTextField();

	public void cria() {
				
		this.setVisible(true);
		this.setLayout(null);
				
        JLabel nomeCurso = new JLabel();
        this.add(nomeCurso);       
        nomeCurso.setText("Cadastro de Cursos");
        nomeCurso.setBounds(590, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeCurso.setFont(f0);
        nomeCurso.setForeground(Color.black);
        
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
        

        
        JButton botaoCadastrarCurso = new JButton();
        botaoCadastrarCurso.addActionListener(new botaoCadastraCurso());
        this.add(botaoCadastrarCurso);       
        botaoCadastrarCurso.setText("Cadastrar");
        botaoCadastrarCurso.setBounds(600, 260, 180, 35);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoCadastrarCurso.setFont(f7);
        botaoCadastrarCurso.setForeground(Color.black);

        iniciaConexao();
        inicialControle();
       
		
	}


        public void iniciaConexao(){

                connection = Database.getConnection();
               cursoDAO = new CursoDAO(connection);

        }


        public void inicialControle(){

                controleCurso = new ControleCurso(cursoDAO);

        }

        private class botaoCadastraCurso implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                        if(  !areaNomeCodigo.getText().equals("")){

                                String nome = areaNomeCodigo.getText();

                                try {
                                        controleCurso.insere(nome);
                                } catch (SQLException e) {
                                        System.out.println(e);
                                }

                                JOptionPane.showMessageDialog(null,"Curso Inserido com Sucesso");

                                areaNomeCodigo.setText("");



                        }else{

                                JOptionPane.showMessageDialog(null,"Existem Campos Vazios");

                        }


                }
        }
	
	
}
