package view.Professor;

import controle.ControleProfessor;
import dao.ProfessorDAO;
import infra.Database;
import modelo.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class PainelBuscarProfessor extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    JTable jTable1;
    JScrollPane jScrollPane1;
    ControleProfessor controleProfessor;
    ProfessorDAO ProfessorDAO;
    Connection connection;
    JTextField id  = new JTextField();;

	public void cria(){

	    id.setText("");

		this.setVisible(true);
		this.setLayout(null);

        JLabel nomeProfessor = new JLabel();
        this.add(nomeProfessor);
        nomeProfessor.setText("Buscar Professor");
        nomeProfessor.setBounds(590, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeProfessor.setFont(f0);
        nomeProfessor.setForeground(Color.black);

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
        id.setBounds(610, 250, 100, 50);
        Font f20 = new Font("SansSerif", Font.BOLD, 15);
        id.setFont(f20);
        id.setForeground(Color.black);

        JLabel nome = new JLabel();
        this.add(nome);
        nome.setText("Nome");
        nome.setBounds(740, 250, 100, 50);
        Font f21 = new Font("SansSerif", Font.BOLD, 15);
        nome.setFont(f21);
        nome.setForeground(Color.black);



        JButton botaoBuscarProfessor = new JButton();
        botaoBuscarProfessor.addActionListener(new botaoBuscarProfessor());
        this.add(botaoBuscarProfessor);
        botaoBuscarProfessor.setText("Buscar");
        botaoBuscarProfessor.setBounds(900, 150, 180, 30);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoBuscarProfessor.setFont(f7);
        botaoBuscarProfessor.setForeground(Color.black);


        JButton botaoLimpar = new JButton();
        botaoLimpar.addActionListener(new botaolimparLista());
        this.add(botaoLimpar);
        botaoLimpar.setText("Limpar");
        botaoLimpar.setBounds(600, 570, 180, 35);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        botaoLimpar.setFont(f8);
        botaoLimpar.setForeground(Color.black);



        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();


       jTable1.setModel(new DefaultTableModel(
           new Object [][] {

                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},
                   {null,null},



           },
           new String [] {
               "ID", "Nome",
           }
       ));

       jScrollPane1.setViewportView(jTable1);


       this.add(jTable1);
       this.add(jScrollPane1);

       jTable1.setBounds(550,290,300,220);

	}


    private class botaoBuscarProfessor implements ActionListener {

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
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},
                                {null,null},



                        },
                        new String [] {
                                "ID", "Nome",
                        }
                ));

            }else{


            int codigo = Integer.parseInt(id.getText());
            boolean achou = false;

            iniciaConexao();
            inicialControle();

                try {

                    Professor Professor = controleProfessor.buscaProfessor(codigo);

                    if(Professor!=null){

                        achou = true;

                        dtm.addRow(new String[]{Integer.toString(Professor.getId()),Professor.getNome()});

                    }else{
                        JOptionPane.showMessageDialog(null,"Professor Nao Encontrado");
                        id.setText("");
                        id.requestFocus();

                        jTable1.setModel(new DefaultTableModel(
                                new Object [][] {

                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},
                                    {null,null},



                                },
                                new String [] {
                                        "ID", "Nome",
                                }
                        ));
                    }

                } catch (SQLException e) {
                    System.out.println(e);
                }


        }

        }
    }


    private class botaolimparLista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            id.setText("");

            jTable1.setModel(new DefaultTableModel(
                    new Object [][] {

                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},
                        {null,null},



                    },
                    new String [] {
                            "ID", "Nome",
                    }
            ));


        }
    }


    public void iniciaConexao(){

        connection = Database.getConnection();
        ProfessorDAO = new ProfessorDAO(connection);

    }


    public void inicialControle(){

        controleProfessor = new ControleProfessor(ProfessorDAO);

    }

}

	