package view.Aluno;

import controle.ControleAluno;
import dao.AlunoDAO;
import infra.Database;
import modelo.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PainelListarAlunos extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    JTable jTable1;
    JScrollPane jScrollPane1;
    ControleAluno controleAluno;
    AlunoDAO alunoDAO;
    Connection connection;

	public void cria(){



		this.setVisible(true);
		this.setLayout(null);

        JLabel nomeAluno = new JLabel();
        this.add(nomeAluno);
        nomeAluno.setText("Listar Alunos");
        nomeAluno.setBounds(570, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeAluno.setFont(f0);
        nomeAluno.setForeground(Color.black);

        JLabel id = new JLabel();
        this.add(id);
        id.setText("ID");
        id.setBounds(130, 105, 100, 50);
        Font f20 = new Font("SansSerif", Font.BOLD, 15);
        id.setFont(f20);
        id.setForeground(Color.black);

        JLabel nome = new JLabel();
        this.add(nome);
        nome.setText("Nome");
        nome.setBounds(330, 105, 100, 50);
        Font f21 = new Font("SansSerif", Font.BOLD, 15);
        nome.setFont(f21);
        nome.setForeground(Color.black);

        JLabel endereco = new JLabel();
        this.add(endereco);
        endereco.setText("Endereço");
        endereco.setBounds(530, 105, 100, 50);
        Font f22 = new Font("SansSerif", Font.BOLD, 15);
        endereco.setFont(f22);
        endereco.setForeground(Color.black);

        JLabel rg = new JLabel();
        this.add(rg);
        rg.setText("RG");
        rg.setBounds(730, 105, 100, 50);
        Font f23 = new Font("SansSerif", Font.BOLD, 15);
        rg.setFont(f23);
        rg.setForeground(Color.black);

        JLabel cpf = new JLabel();
        this.add(cpf);
        cpf.setText("CPF");
        cpf.setBounds(930, 105, 100, 50);
        Font f24 = new Font("SansSerif", Font.BOLD, 15);
        cpf.setFont(f24);
        cpf.setForeground(Color.black);

        JLabel telefone = new JLabel();
        this.add(telefone);
        telefone.setText("Telefone");
        telefone.setBounds(1130, 105, 100, 50);
        Font f25 = new Font("SansSerif", Font.BOLD, 15);
        telefone.setFont(f25);
        telefone.setForeground(Color.black);


        JButton botaoListarAlunos = new JButton();
        botaoListarAlunos.addActionListener(new botaoListarAlunos());
        this.add(botaoListarAlunos);
        botaoListarAlunos.setText("Atualizar");
        botaoListarAlunos.setBounds(450, 570, 180, 35);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoListarAlunos.setFont(f7);
        botaoListarAlunos.setForeground(Color.black);


        JButton botaoLimparLista = new JButton();
        botaoLimparLista.addActionListener(new botaolimparLista());
        this.add(botaoLimparLista);
        botaoLimparLista.setText("Limpar");
        botaoLimparLista.setBounds(650, 570, 180, 35);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        botaoLimparLista.setFont(f8);
        botaoLimparLista.setForeground(Color.black);


        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();


       jTable1.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {
               {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},
                   {null,null,null,null,null,null},


              
           },
           new String [] {
               "ID", "Nome","Endereco","RG","CPF","Telefone"
           }
       ));

       jScrollPane1.setViewportView(jTable1);
       
       
       this.add(jTable1);
       this.add(jScrollPane1);
       
       jTable1.setBounds(60,145,1200,400);
       
       
       JLabel nomeCurso = new JLabel();
       this.add(nomeCurso);       
       nomeCurso.setText("Aluno");
       nomeCurso.setBounds(590, 250, 200, 50);
       Font f4 = new Font("SansSerif", Font.BOLD, 15);
       nomeCurso.setFont(f4);
       nomeCurso.setForeground(Color.black);
       
       JLabel nomeCh = new JLabel();
       this.add(nomeCh);       
       nomeCh.setText("Curso");
       nomeCh.setBounds(735, 250, 200, 50);
       Font f5 = new Font("SansSerif", Font.BOLD, 15);
       nomeCh.setFont(f5);
       nomeCh.setForeground(Color.black);

		
	}


    private class botaoListarAlunos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            iniciaConexao();
            inicialControle();

            try {

                ArrayList<Aluno>  listaAlunos = (ArrayList<Aluno>) controleAluno.listarAlunos();

                for (Aluno aluno : listaAlunos ){

                    dtm.addRow(new String[]{Integer.toString(aluno.getId()),aluno.getNome(),aluno.getEndereco(),
                     aluno.getRg(),aluno.getCpf(),aluno.getTelefone()});

                }


            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }


    private class botaolimparLista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);


            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},
                            {null,null,null,null,null,null},



                    },
                    new String [] {
                            "ID", "Nome","Endereco","RG","CPF","Telefone"
                    }
            ));


        }
    }


    public void iniciaConexao(){

        connection = Database.getConnection();
        alunoDAO = new AlunoDAO(connection);

    }


    public void inicialControle(){

        controleAluno = new ControleAluno(alunoDAO);

    }

}

	