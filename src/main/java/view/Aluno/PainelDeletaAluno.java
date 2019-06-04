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

public class PainelDeletaAluno extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    JTable jTable1;
    JScrollPane jScrollPane1;
    ControleAluno controleAluno;
    AlunoDAO alunoDAO;
    Connection connection;
    JTextField id = new JTextField();;

	public void cria(){


	    id.setText("");

		this.setVisible(true);
		this.setLayout(null);

        JLabel nomeAluno = new JLabel();
        this.add(nomeAluno);
        nomeAluno.setText("Deletar Aluno");
        nomeAluno.setBounds(570, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeAluno.setFont(f0);
        nomeAluno.setForeground(Color.black);

        JLabel digiteId = new JLabel();
        this.add(digiteId);
        digiteId.setText("Digite o Código:");
        digiteId.setBounds(370, 150, 300, 25);
        Font f44 = new Font("SansSerif", Font.BOLD, 20);
        digiteId.setFont(f44);
        digiteId.setForeground(Color.black);


        this.add(id);
        id.setText("");
        id.setBounds(550, 150, 300, 25);
        Font f9= new Font("SansSerif", Font.BOLD, 20);
        id.setFont(f9);
        id.setForeground(Color.black);


        JLabel id = new JLabel();
        this.add(id);
        id.setText("ID");
        id.setBounds(130, 250, 100, 50);
        Font f20 = new Font("SansSerif", Font.BOLD, 15);
        id.setFont(f20);
        id.setForeground(Color.black);

        JLabel nome = new JLabel();
        this.add(nome);
        nome.setText("Nome");
        nome.setBounds(330, 250, 100, 50);
        Font f21 = new Font("SansSerif", Font.BOLD, 15);
        nome.setFont(f21);
        nome.setForeground(Color.black);

        JLabel endereco = new JLabel();
        this.add(endereco);
        endereco.setText("Endereço");
        endereco.setBounds(530, 250, 100, 50);
        Font f22 = new Font("SansSerif", Font.BOLD, 15);
        endereco.setFont(f22);
        endereco.setForeground(Color.black);

        JLabel rg = new JLabel();
        this.add(rg);
        rg.setText("RG");
        rg.setBounds(730, 250, 100, 50);
        Font f23 = new Font("SansSerif", Font.BOLD, 15);
        rg.setFont(f23);
        rg.setForeground(Color.black);

        JLabel cpf = new JLabel();
        this.add(cpf);
        cpf.setText("CPF");
        cpf.setBounds(930, 250, 100, 50);
        Font f24 = new Font("SansSerif", Font.BOLD, 15);
        cpf.setFont(f24);
        cpf.setForeground(Color.black);

        JLabel telefone = new JLabel();
        this.add(telefone);
        telefone.setText("Telefone");
        telefone.setBounds(1130, 250, 100, 50);
        Font f25 = new Font("SansSerif", Font.BOLD, 15);
        telefone.setFont(f25);
        telefone.setForeground(Color.black);


        JButton botaoBuscarAluno = new JButton();
        botaoBuscarAluno.addActionListener(new botaoBuscarAluno());
        this.add(botaoBuscarAluno);
        botaoBuscarAluno.setText("Buscar");
        botaoBuscarAluno.setBounds(900, 150, 180, 30);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoBuscarAluno.setFont(f7);
        botaoBuscarAluno.setForeground(Color.black);


        JButton botaoDeletar = new JButton();
        botaoDeletar.addActionListener(new botaoDeletarLista());
        this.add(botaoDeletar);
        botaoDeletar.setText("Deletar");
        botaoDeletar.setBounds(600, 570, 180, 35);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        botaoDeletar.setFont(f8);
        botaoDeletar.setForeground(Color.black);



        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();


       jTable1.setModel(new DefaultTableModel(
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



           },
           new String [] {
               "ID", "Nome","Endereco","RG","CPF","Telefone"
           }
       ));

       jScrollPane1.setViewportView(jTable1);


       this.add(jTable1);
       this.add(jScrollPane1);

       jTable1.setBounds(60,290,1200,250);

	}


    private class botaoBuscarAluno implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            if(id.getText().equals("")){

                JOptionPane.showMessageDialog(null,"Digite um Código:");
                id.setText("");
                id.requestFocus();

                jTable1.setModel(new DefaultTableModel(
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



                        },
                        new String [] {
                                "ID", "Nome","Endereco","RG","CPF","Telefone"
                        }
                ));

            }else{



            int codigo = Integer.parseInt(id.getText());
            boolean achou = false;

            iniciaConexao();
            inicialControle();

            try {

                ArrayList<Aluno>  listaAlunos = (ArrayList<Aluno>) controleAluno.listarAlunos();

                for (Aluno aluno : listaAlunos ){


                    if(aluno.getId()==codigo){

                        achou = true;

                        dtm.addRow(new String[]{Integer.toString(aluno.getId()),aluno.getNome(),aluno.getEndereco(), aluno.getRg(),aluno.getCpf(),aluno.getTelefone()});

                        return;

                    }

                }

                if(!achou){

                    JOptionPane.showMessageDialog(null,"Aluno Nao Encontrado");
                    id.setText("");
                    id.requestFocus();

                    jTable1.setModel(new DefaultTableModel(
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



                            },
                            new String [] {
                                    "ID", "Nome","Endereco","RG","CPF","Telefone"
                            }
                    ));
                }


            } catch (SQLException e) {
                System.out.println(e);
            }

        }

        }
    }


    private class botaoDeletarLista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            try {


                controleAluno.deleta(Integer.parseInt(id.getText()));

                JOptionPane.showMessageDialog(null,"Aluno Deletado com Sucesso");


            } catch (SQLException e) {
                System.out.println(e);
            }

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            id.setText("");

            jTable1.setModel(new DefaultTableModel(
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

	